package com.klientrack.backend.controller;

import com.klientrack.backend.dto.KlienRequestDTO;
import com.klientrack.backend.service.KlienService;
import com.klientrack.backend.repository.KlienRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/klien")
public class KlienController {

    @Autowired
    private KlienService klienService;

    @Autowired
    private KlienRepository klienRepository; // Ditambahkan agar bisa GET data

    // Proses 3: Tambah Klien
    @PostMapping
    public ResponseEntity<?> tambahKlien(@Valid @RequestBody KlienRequestDTO dto) {
        return new ResponseEntity<>(klienService.tambahKlienBaru(dto), HttpStatus.CREATED);
    }

    // List Semua Klien
    @GetMapping
    public ResponseEntity<?> getSemuaKlien() {
        return ResponseEntity.ok(klienRepository.findAll());
    }

    // Detail Klien by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getDetailKlien(@PathVariable Integer id) {
        return klienRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Proses 3: Edit Klien
    @PutMapping("/{id}")
    public ResponseEntity<?> editKlien(@PathVariable Integer id, @Valid @RequestBody KlienRequestDTO dto) {
        return ResponseEntity.ok(klienService.perbaruiKlien(id, dto));
    }

    // Proses 3: Hapus Klien
    @DeleteMapping("/{id}")
    public ResponseEntity<?> hapusKlien(@PathVariable Integer id) {
        klienService.hapusKlien(id);
        return ResponseEntity.ok("Klien berhasil dinonaktifkan");
    }
}