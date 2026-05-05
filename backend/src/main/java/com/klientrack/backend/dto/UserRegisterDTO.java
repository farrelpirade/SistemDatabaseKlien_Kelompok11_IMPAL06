package com.klientrack.backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserRegisterDTO(
        @NotBlank(message = "Username tidak boleh kosong")
        @Size(min = 5, max = 50, message = "Username minimal 5 karakter")
        String username,

        @NotBlank(message = "Password tidak boleh kosong")
        @Size(min = 8, message = "Password minimal 8 karakter")
        String password,

        @NotBlank(message = "Nama lengkap wajib diisi")
        String nama,

        @NotNull(message = "Role ID wajib dipilih")
        Integer roleId
) {}