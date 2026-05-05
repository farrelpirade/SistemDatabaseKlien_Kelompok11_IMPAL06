package com.klientrack.backend.service;

import com.klientrack.backend.dto.KontrakRequestDTO;
import com.klientrack.backend.entity.Kontrak;
import com.klientrack.backend.repository.KontrakRepository;
import com.klientrack.backend.repository.KlienRepository;
import com.klientrack.backend.repository.PaketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KontrakService {

    @Autowired
    private KontrakRepository kontrakRepository;

    @Autowired
    private KlienRepository klienRepository;

    @Autowired
    private PaketRepository paketRepository;

    public Kontrak simpanKontrakBaru(KontrakRequestDTO dto) {
        // GUARD CLAUSE 1: Validasi keberadaan Klien dan Paket (Integritas Relasi)
        if (!klienRepository.existsById(dto.klienId())) {
            throw new IllegalArgumentException("Gagal: ID Klien tidak terdaftar!");
        }
        if (!paketRepository.existsById(dto.paketId())) {
            throw new IllegalArgumentException("Gagal: ID Paket tidak ditemukan!");
        }

        // GUARD CLAUSE 2: Validasi Logika Tanggal (Defensive Programming)
        if (dto.tanggalSelesai().isBefore(dto.tanggalMulai())) {
            throw new IllegalArgumentException("Gagal: Tanggal selesai tidak boleh sebelum tanggal mulai!");
        }

        // Mapping DTO ke Entity
        Kontrak kontrak = new Kontrak();
        kontrak.setKlienId(dto.klienId());
        kontrak.setPaketId(dto.paketId());
        kontrak.setCreatedBy(dto.createdBy());
        kontrak.setTanggalMulai(dto.tanggalMulai());
        kontrak.setTanggalSelesai(dto.tanggalSelesai());
        kontrak.setHargaKontrak(dto.hargaKontrak());
        kontrak.setTipeModemId(dto.tipeModemId());

        // Default status 1 (Aktif) jika tidak ditentukan
        kontrak.setStatusKontrakId(dto.statusKontrakId() != null ? dto.statusKontrakId() : 1);

        return kontrakRepository.save(kontrak);
    }
}