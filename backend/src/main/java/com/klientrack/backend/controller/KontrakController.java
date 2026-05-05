package com.klientrack.backend.controller;

import com.klientrack.backend.dto.KontrakRequestDTO;
import com.klientrack.backend.service.KontrakService;
import com.klientrack.backend.repository.KontrakRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/kontrak")
public class KontrakController {

    @Autowired
    private KontrakService kontrakService;

    @Autowired
    private KontrakRepository kontrakRepository;

    @PostMapping
    public ResponseEntity<?> buatKontrakBaru(@Valid @RequestBody KontrakRequestDTO dto) {
        try {
            return new ResponseEntity<>(kontrakService.simpanKontrakBaru(dto), HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    // PROSES 5: Radar Expired (URL Disesuaikan dengan Tabel Postman)
    @GetMapping("/hampir-habis")
    public ResponseEntity<?> getKontrakExpiredSoon() {
        return ResponseEntity.ok(kontrakRepository.getKontrakExpiredSoon());
    }

    // PROSES 6: Update Status Kontrak (Endpoint Baru)
    @PatchMapping("/{id}/status")
    public ResponseEntity<?> updateStatusKontrak(@PathVariable Integer id, @RequestBody Map<String, Integer> request) {
        return kontrakRepository.findById(id).map(kontrak -> {
            kontrak.setStatusKontrakId(request.get("statusKontrakId"));
            kontrakRepository.save(kontrak);
            return ResponseEntity.ok("Status kontrak berhasil diperbarui");
        }).orElse(ResponseEntity.notFound().build());
    }
}