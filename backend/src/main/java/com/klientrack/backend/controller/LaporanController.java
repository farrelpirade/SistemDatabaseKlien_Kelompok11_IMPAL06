package com.klientrack.backend.controller;

import com.klientrack.backend.repository.KontrakRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/laporan")
public class LaporanController {

    @Autowired
    private KontrakRepository kontrakRepository;

    // Menangani Proses 8: Pembuatan Laporan
    @GetMapping
    public ResponseEntity<?> getLaporan(
            @RequestParam(required = false) String startDate,
            @RequestParam(required = false) String endDate) {

        // Sementara kita tampilkan statistik dashboard sebagai laporan
        // Nantinya query bisa dipertajam menggunakan startDate & endDate
        return ResponseEntity.ok(kontrakRepository.getStatistikDashboard());
    }
}