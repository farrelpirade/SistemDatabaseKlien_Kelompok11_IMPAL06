package com.klientrack.backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data // Anotasi Lombok untuk otomatis membuat Getter & Setter
@Entity
@Table(name = "klien")
public class Klien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "klien_id")
    private Integer klienId;

    @Column(name = "created_by")
    private Integer createdBy;

    @Column(name = "nama_klien")
    private String namaKlien;

    private String alamat;

    @Column(name = "no_telepon")
    private String noTelepon;

    private String email;

    @Column(name = "tanggal_daftar")
    private LocalDate tanggalDaftar;
}