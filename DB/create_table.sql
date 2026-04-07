CREATE TABLE `role` (
    `role_id` INT AUTO_INCREMENT PRIMARY KEY,
    `nama_role` VARCHAR(20) NOT NULL UNIQUE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE `tipe_modem` (
    `tipe_modem_id` INT AUTO_INCREMENT PRIMARY KEY,
    `nama_tipe` VARCHAR(20) NOT NULL UNIQUE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE `status_paket` (
    `status_paket_id` INT AUTO_INCREMENT PRIMARY KEY,
    `nama_status` VARCHAR(20) NOT NULL UNIQUE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE `status_kontrak` (
    `status_kontrak_id` INT AUTO_INCREMENT PRIMARY KEY,
    `nama_status` VARCHAR(20) NOT NULL UNIQUE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE `jenis_komunikasi` (
    `jenis_komunikasi_id` INT AUTO_INCREMENT PRIMARY KEY,
    `nama_jenis` VARCHAR(30) NOT NULL UNIQUE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE `user` (
    `user_id` INT AUTO_INCREMENT PRIMARY KEY,
    `username` VARCHAR(50) NOT NULL UNIQUE,
    `password` VARCHAR(255) NOT NULL,
    `nama` VARCHAR(100) NOT NULL,
    `role_id` INT NOT NULL,
    `is_active` BOOLEAN NOT NULL DEFAULT TRUE,
    `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT `fk_user_role` FOREIGN KEY (`role_id`) REFERENCES `role`(`role_id`) ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE `paket` (
    `paket_id` INT AUTO_INCREMENT PRIMARY KEY,
    `nama_paket` VARCHAR(50) NOT NULL UNIQUE,
    `deskripsi` TEXT,
    `kecepatan_mbps` INT UNSIGNED NOT NULL,
    `harga` DECIMAL(12,2) NOT NULL,
    `tipe_modem_id` INT NOT NULL,
    `status_paket_id` INT NOT NULL,
    `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT `fk_paket_tipe` FOREIGN KEY (`tipe_modem_id`) REFERENCES `tipe_modem`(`tipe_modem_id`) ON UPDATE CASCADE ON DELETE RESTRICT,
    CONSTRAINT `fk_paket_status` FOREIGN KEY (`status_paket_id`) REFERENCES `status_paket`(`status_paket_id`) ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE `klien` (
    `klien_id` INT AUTO_INCREMENT PRIMARY KEY,
    `created_by` INT NOT NULL,
    `nama_klien` VARCHAR(100) NOT NULL,
    `alamat` VARCHAR(255) NOT NULL, 
    `no_telepon` VARCHAR(20) NOT NULL,
    `email` VARCHAR(100) UNIQUE,
    `tanggal_daftar` DATE NOT NULL,
    `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT `fk_klien_user` FOREIGN KEY (`created_by`) REFERENCES `user`(`user_id`) ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE `kontrak` (
    `kontrak_id` INT AUTO_INCREMENT PRIMARY KEY,
    `klien_id` INT NOT NULL,
    `paket_id` INT NOT NULL,
    `created_by` INT NOT NULL,
    `tanggal_mulai` DATE NOT NULL,
    `tanggal_selesai` DATE NOT NULL,
    `harga_kontrak` DECIMAL(12,2) NOT NULL,
    `tipe_modem_id` INT NOT NULL,
    `status_kontrak_id` INT NOT NULL,
    `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    INDEX `idx_kontrak_selesai` (`tanggal_selesai`),
    CONSTRAINT `fk_kontrak_klien` FOREIGN KEY (`klien_id`) REFERENCES `klien`(`klien_id`) ON UPDATE CASCADE ON DELETE RESTRICT,
    CONSTRAINT `fk_kontrak_paket` FOREIGN KEY (`paket_id`) REFERENCES `paket`(`paket_id`) ON UPDATE CASCADE ON DELETE RESTRICT,
    CONSTRAINT `fk_kontrak_user` FOREIGN KEY (`created_by`) REFERENCES `user`(`user_id`) ON UPDATE CASCADE ON DELETE RESTRICT,
    CONSTRAINT `fk_kontrak_tipe` FOREIGN KEY (`tipe_modem_id`) REFERENCES `tipe_modem`(`tipe_modem_id`) ON UPDATE CASCADE ON DELETE RESTRICT,
    CONSTRAINT `fk_kontrak_status` FOREIGN KEY (`status_kontrak_id`) REFERENCES `status_kontrak`(`status_kontrak_id`) ON UPDATE CASCADE ON DELETE RESTRICT,
    CONSTRAINT `chk_kontrak_tanggal` CHECK (`tanggal_selesai` > `tanggal_mulai`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE `komunikasi` (
    `komunikasi_id` INT AUTO_INCREMENT PRIMARY KEY,
    `user_id` INT NOT NULL,
    `klien_id` INT NOT NULL,
    `tanggal_interaksi` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `jenis_komunikasi_id` INT NOT NULL,
    `catatan` TEXT NOT NULL,
    `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    INDEX `idx_komunikasi_klien_tgl` (`klien_id`, `tanggal_interaksi`),
    CONSTRAINT `fk_komunikasi_user` FOREIGN KEY (`user_id`) REFERENCES `user`(`user_id`) ON UPDATE CASCADE ON DELETE RESTRICT,
    CONSTRAINT `fk_komunikasi_klien` FOREIGN KEY (`klien_id`) REFERENCES `klien`(`klien_id`) ON UPDATE CASCADE ON DELETE RESTRICT,
    CONSTRAINT `fk_komunikasi_jenis` FOREIGN KEY (`jenis_komunikasi_id`) REFERENCES `jenis_komunikasi`(`jenis_komunikasi_id`) ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;