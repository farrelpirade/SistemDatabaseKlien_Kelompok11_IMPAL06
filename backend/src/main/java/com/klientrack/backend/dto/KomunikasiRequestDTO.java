package com.klientrack.backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record KomunikasiRequestDTO(
        @NotNull(message = "ID Klien wajib diisi")
        Integer klienId,

        @NotNull(message = "ID User wajib diisi")
        Integer userId,

        @NotNull(message = "ID Jenis Komunikasi wajib diisi")
        Integer jenisKomunikasiId,

        @NotBlank(message = "Media komunikasi wajib dipilih")
        String mediaKomunikasi,

        @NotBlank(message = "Jenis komunikasi wajib dipilih")
        String jenisKomunikasi,

        @NotBlank(message = "Catatan interaksi tidak boleh kosong")
        String catatan
) {}