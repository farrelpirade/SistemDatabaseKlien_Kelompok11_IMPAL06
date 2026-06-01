package com.klientrack.backend.controller;

import com.klientrack.backend.dto.PaketRequestDTO;
import com.klientrack.backend.entity.Paket;
import com.klientrack.backend.repository.PaketRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/paket")
public class PaketController {

    @Autowired
    private PaketRepository paketRepository;

    @PostMapping
    public ResponseEntity<?> tambahPaket(@Valid @RequestBody PaketRequestDTO dto) {
        if (paketRepository.existsByNamaPaket(dto.namaPaket())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Nama paket sudah ada!");
        }
        Paket paket = new Paket();
        mapDtoToEntity(dto, paket);
        return new ResponseEntity<>(paketRepository.save(paket), HttpStatus.CREATED);
    }

    // Endpoint Baru: List Paket Layanan
    @GetMapping
    public ResponseEntity<?> getSemuaPaket() {
        return ResponseEntity.ok(paketRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDetailPaket(@PathVariable Integer id) {
        return paketRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editPaket(@PathVariable Integer id, @Valid @RequestBody PaketRequestDTO dto) {
        return paketRepository.findById(id)
                .map(paket -> {
                    mapDtoToEntity(dto, paket);
                    return ResponseEntity.ok(paketRepository.save(paket));
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> hapusPaket(@PathVariable Integer id) {
        if (!paketRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paket tidak ditemukan!");
        }
        paketRepository.deleteById(id);
        return ResponseEntity.ok("Paket berhasil dihapus");
    }

    private void mapDtoToEntity(PaketRequestDTO dto, Paket paket) {
        paket.setNamaPaket(dto.namaPaket());
        paket.setDeskripsi(dto.deskripsi());
        paket.setKecepatanMbps(dto.kecepatanMbps());
        paket.setHarga(dto.harga());
        paket.setTipeModemId(dto.tipeModemId());
        paket.setStatusPaketId(dto.statusPaketId());
    }
}