package com.klientrack.backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "paket")
public class Paket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "paket_id")
    private Integer paketId;

    @Column(name = "nama_paket", unique = true)
    private String namaPaket;

    private String deskripsi;

    @Column(name = "kecepatan_mbps")
    private Integer kecepatanMbps;

    private BigDecimal harga;

    @Column(name = "tipe_modem_id")
    private Integer tipeModemId;

    @Column(name = "status_paket_id")
    private Integer statusPaketId;

    @Column(name = "created_at", insertable = false, updatable = false)
    private LocalDateTime createdAt;
}
