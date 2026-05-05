package com.klientrack.backend.dto;

import jakarta.validation.constraints.*;

public record KlienRequestDTO(
        @NotBlank(message = "Nama klien tidak boleh kosong")
        String namaKlien,

        @NotBlank(message = "Alamat wajib diisi")
        String alamat,

        @NotBlank(message = "Nomor telepon wajib diisi")
        @Pattern(regexp = "^[0-9]{10,15}$", message = "Format nomor telepon tidak valid")
        String noTelepon,

        @Email(message = "Format email tidak valid")
        String email,

        @NotNull(message = "ID User (Created By) wajib disertakan")
        Integer createdBy
) {}