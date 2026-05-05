package com.klientrack.backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "kontrak")
public class Kontrak {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "kontrak_id")
    private Integer kontrakId;

    @Column(name = "klien_id")
    private Integer klienId;

    @Column(name = "paket_id")
    private Integer paketId;

    @Column(name = "created_by")
    private Integer createdBy;

    @Column(name = "tanggal_mulai")
    private LocalDate tanggalMulai;

    @Column(name = "tanggal_selesai")
    private LocalDate tanggalSelesai;

    @Column(name = "harga_kontrak")
    private BigDecimal hargaKontrak;

    @Column(name = "tipe_modem_id")
    private Integer tipeModemId;

    @Column(name = "status_kontrak_id")
    private Integer statusKontrakId;
}