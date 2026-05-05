package com.klientrack.backend.service;

import com.klientrack.backend.dto.KlienRequestDTO;
import com.klientrack.backend.entity.Klien;
import com.klientrack.backend.repository.KlienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

@Service
public class KlienService {

    @Autowired
    private KlienRepository klienRepository;

    // Aksi: Tambah (Sesuai Class Diagram)
    public Klien tambahKlienBaru(KlienRequestDTO dto) {
        if (klienRepository.findByEmail(dto.email()).isPresent()) {
            throw new IllegalArgumentException("Email sudah digunakan!");
        }

        Klien klien = new Klien();
        mapDtoToEntity(dto, klien);
        klien.setTanggalDaftar(LocalDate.now());
        klien.setCreatedBy(dto.createdBy());

        return klienRepository.save(klien);
    }

    // Aksi: Edit (Sesuai Class Diagram: editKlien)
    public Klien perbaruiKlien(Integer id, KlienRequestDTO dto) {
        Klien klien = klienRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Klien dengan ID " + id + " tidak ditemukan!"));

        mapDtoToEntity(dto, klien);
        // Kita tidak mengubah createdBy dan tanggalDaftar saat edit

        return klienRepository.save(klien);
    }

    // Aksi: Hapus (Sesuai Class Diagram: hapusKlien)
    public void hapusKlien(Integer id) {
        if (!klienRepository.existsById(id)) {
            throw new IllegalArgumentException("Gagal menghapus: Klien tidak ditemukan!");
        }
        klienRepository.deleteById(id);
    }

    // Helper untuk mapping agar kode tidak duplikat
    private void mapDtoToEntity(KlienRequestDTO dto, Klien klien) {
        klien.setNamaKlien(dto.namaKlien());
        klien.setAlamat(dto.alamat());
        klien.setNoTelepon(dto.noTelepon());
        klien.setEmail(dto.email());
    }
}