package com.klientrack.backend.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public record PaketRequestDTO(
        @NotBlank(message = "Nama paket wajib diisi")
        @Size(max = 50)
        String namaPaket,

        String deskripsi,

        @NotNull(message = "Kecepatan wajib diisi")
        @Positive
        Integer kecepatanMbps,

        @NotNull(message = "Harga wajib diisi")
        @DecimalMin("0.0")
        BigDecimal harga,

        @NotNull(message = "Tipe modem wajib dipilih")
        Integer tipeModemId,

        @NotNull(message = "Status paket wajib ditentukan")
        Integer statusPaketId
) {}