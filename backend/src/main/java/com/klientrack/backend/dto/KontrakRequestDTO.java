package com.klientrack.backend.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public record KontrakRequestDTO(
        @NotNull Integer klienId,
        @NotNull Integer paketId,
        @NotNull Integer createdBy,

        @NotNull(message = "Tanggal mulai wajib diisi")
        LocalDate tanggalMulai,

        @NotNull(message = "Tanggal selesai wajib diisi")
        LocalDate tanggalSelesai,

        @NotNull @Positive
        BigDecimal hargaKontrak,

        @NotNull Integer tipeModemId,
        @NotNull Integer statusKontrakId
) {}