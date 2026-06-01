package com.klientrack.backend.controller;

import com.klientrack.backend.dto.KontrakRequestDTO;
import com.klientrack.backend.service.KontrakService;
import com.klientrack.backend.repository.KontrakRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

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

    @GetMapping
    public ResponseEntity<?> getSemuaKontrak() {
        return ResponseEntity.ok(kontrakRepository.findAll());
    }

    // Tambahkan endpoint GET by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getDetailKontrak(@PathVariable Integer id) {
        return kontrakRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Tambahkan endpoint PUT untuk Edit Kontrak
    @PutMapping("/{id}")
    public ResponseEntity<?> editKontrak(
            @PathVariable Integer id,
            @Valid @RequestBody KontrakRequestDTO dto) {

        return kontrakRepository.findById(id).map(kontrak -> {
            // Klien ID tidak diubah karena kontrak mengikat klien yang sama
            kontrak.setPaketId(dto.paketId());
            kontrak.setTanggalMulai(dto.tanggalMulai());
            kontrak.setTanggalSelesai(dto.tanggalSelesai());
            kontrak.setHargaKontrak(dto.hargaKontrak());
            kontrak.setTipeModemId(dto.tipeModemId());

            kontrakRepository.save(kontrak);
            return ResponseEntity.ok("Kontrak berhasil diperbarui");
        }).orElse(ResponseEntity.notFound().build());
    }
}