package com.klientrack.backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "komunikasi")
@Data
public class Komunikasi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer komunikasiId;

    private Integer klienId;
    private Integer userId;

    @Column(name = "jenis_komunikasi_id")
    private Integer jenisKomunikasiId;

    private String mediaKomunikasi; // (WhatsApp, Email, dll)
    private String jenisKomunikasi; // (Follow-up, Keluhan, dll)

    @Column(columnDefinition = "TEXT")
    private String catatan;

    private LocalDateTime createdAt;

    // Otomatis isi tanggal saat data dibuat
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}