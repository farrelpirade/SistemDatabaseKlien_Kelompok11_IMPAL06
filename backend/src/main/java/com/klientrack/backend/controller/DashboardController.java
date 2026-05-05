package com.klientrack.backend.controller;

import com.klientrack.backend.repository.UserRepository;
import com.klientrack.backend.repository.KontrakRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private KontrakRepository kontrakRepository;

    // Endpoint Proses 9: Statistik Pertumbuhan Pelanggan per Bulan
    @GetMapping("/statistik")
    public ResponseEntity<?> getGrafikPertumbuhan(
            @RequestHeader(value = "X-Requester-Id") Integer requesterId) {

        // 1. DEFENSIVE: Guard Clause untuk Otoritas Manager
        var requesterOpt = userRepository.findById(requesterId);
        if (requesterOpt.isEmpty() || requesterOpt.get().getRoleId() != 1) { // 1 = Manager
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body("Akses Ditolak: Statistik ini hanya dapat diakses oleh Manager.");
        }

        // 2. Mengambil data agregat (Jumlah Pelanggan per Bulan) dari Repository
        // === PERUBAHAN: DITAMBAHKAN BLOK TRY-CATCH ===
        try {
            return ResponseEntity.ok(kontrakRepository.countKlienPerBulan());
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            String cause = (e.getCause() != null) ? e.getCause().getMessage() : "Tidak ada detail penyebab";

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(" ERROR 500: Gagal eksekusi Query Statistik.\n" +
                            "Pesan: " + errorMessage + "\n" +
                            "Penyebab Asli: " + cause);
        }
    }
}