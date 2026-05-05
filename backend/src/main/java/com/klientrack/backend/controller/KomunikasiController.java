package com.klientrack.backend.controller;

import com.klientrack.backend.dto.KomunikasiRequestDTO;
import com.klientrack.backend.entity.Komunikasi;
import com.klientrack.backend.repository.KomunikasiRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/komunikasi")
public class KomunikasiController {

    @Autowired
    private KomunikasiRepository komunikasiRepository;

    // Sesuai Class Diagram: catatRiwayatKomunikasi
    @PostMapping
    public ResponseEntity<?> catatRiwayat(@Valid @RequestBody KomunikasiRequestDTO dto) {
        try {
            Komunikasi kom = new Komunikasi();
            kom.setKlienId(dto.klienId());
            kom.setUserId(dto.userId());

            kom.setJenisKomunikasiId(dto.jenisKomunikasiId());

            kom.setMediaKomunikasi(dto.mediaKomunikasi());
            kom.setJenisKomunikasi(dto.jenisKomunikasi());
            kom.setCatatan(dto.catatan());
            kom.setCreatedAt(LocalDateTime.now());

            return new ResponseEntity<>(komunikasiRepository.save(kom), HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Gagal menyimpan ke database. Penyebab: " + e.getMessage());
        }
    }

    // Sesuai Class Diagram: getRiwayatKomunikasi
    @GetMapping("/klien/{klienId}")
    public ResponseEntity<?> getRiwayatByKlien(@PathVariable Integer klienId) {
        return ResponseEntity.ok(komunikasiRepository.findByKlienIdOrderByCreatedAtDesc(klienId));
    }
}