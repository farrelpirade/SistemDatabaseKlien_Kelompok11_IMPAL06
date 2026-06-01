package com.klientrack.backend.controller;

import com.klientrack.backend.dto.UserRegisterDTO;
import com.klientrack.backend.entity.User;
import com.klientrack.backend.repository.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // DEFENSIVE: Key minimal 256-bit untuk HS256
    private final String SECRET_STRING = "rahasia_kelompok_11_impal_telkom_university_2026";
    private final SecretKey key = Keys.hmacShaKeyFor(SECRET_STRING.getBytes(StandardCharsets.UTF_8));

    @PostMapping("/register")
    public ResponseEntity<?> register(
            @RequestHeader(value = "X-Requester-Id") Integer requesterId,
            @Valid @RequestBody UserRegisterDTO dto) {

        Optional<User> managerOpt = userRepository.findById(requesterId);
        if (managerOpt.isEmpty() || managerOpt.get().getRoleId() != 1) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body("Akses Ditolak: Hanya Manager yang berhak mendaftarkan akun baru!");
        }

        if (userRepository.findByUsername(dto.username()).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Gagal: Username '" + dto.username() + "' sudah digunakan!");
        }

        User newUser = new User();
        newUser.setUsername(dto.username());
        newUser.setPassword(passwordEncoder.encode(dto.password()));
        newUser.setNama(dto.nama());
        newUser.setRoleId(dto.roleId());
        newUser.setIsActive(true);

        userRepository.save(newUser);
        return ResponseEntity.status(HttpStatus.CREATED).body("Berhasil mendaftarkan akun: " + dto.nama());
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginRequest) {
        String username = loginRequest.get("username");
        String password = loginRequest.get("password");

        Optional<User> userOpt = userRepository.findByUsername(username);

        if (userOpt.isEmpty() || !passwordEncoder.matches(password, userOpt.get().getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Username atau Password salah.");
        }

        User user = userOpt.get();

        // PERBAIKAN SINTAKS JJWT: Gunakan setSubject, setIssuedAt, dan setExpiration
        // agar kompatibel dengan JwtBuilder versi 0.11 ke atas yang stabil
        String token = Jwts.builder()
                .setSubject(username)
                .claim("roleId", user.getRoleId())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 3600000))
                .signWith(key)
                .compact();

        return ResponseEntity.ok(Map.of(
                "token", token,
                "nama", user.getNama(),
                "role", user.getRoleId() == 1 ? "Manager" : "Admin",
                "userId", user.getUserId()
        ));
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout() {
        return ResponseEntity.ok("Logout berhasil. Sesi di sisi server bersifat stateless.");
    }

    @PostMapping("/reset-by-manager")
    public ResponseEntity<?> resetByManager(
            @RequestHeader(value = "X-Requester-Id") Integer requesterId,
            @RequestBody Map<String, String> request) {

        String targetUsername = request.get("targetUsername");
        String newPassword = request.get("newPassword");

        Optional<User> requesterOpt = userRepository.findById(requesterId);
        if (requesterOpt.isEmpty() || requesterOpt.get().getRoleId() != 1) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body("Akses Ditolak: Hanya Manager yang dapat melakukan override password!");
        }

        Optional<User> targetUserOpt = userRepository.findByUsername(targetUsername);
        if (targetUserOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Gagal: Akun target tidak ditemukan.");
        }

        User targetUser = targetUserOpt.get();
        targetUser.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(targetUser);

        return ResponseEntity.ok("Berhasil: Password untuk '" + targetUsername +
                "' telah di-reset oleh Manager " + requesterOpt.get().getNama());
    }

    @GetMapping("/users")
    public ResponseEntity<?> getSemuaUser() {
        return ResponseEntity.ok(userRepository.findAll());
    }
}