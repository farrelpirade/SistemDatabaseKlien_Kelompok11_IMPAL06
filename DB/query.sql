-- ==============================================================================
-- PROSES 1.0: AUTENTIKASI (LOGIN)
-- ==============================================================================
SELECT 
    u.`user_id`, u.`username`, u.`nama`, r.`nama_role` 
FROM `user` u
JOIN `role` r ON u.`role_id` = r.`role_id`
WHERE u.`username` = 'admin.alim' 
  AND u.`is_active` = TRUE;

-- ==============================================================================
-- PROSES 2.0: OLAH DATA MASTER (INPUT KLIEN & PAKET BARU)
-- ==============================================================================
-- Admin menambah paket layanan baru (tipe_modem_id 1 = sewa, status_paket_id 1 = aktif)
INSERT INTO `paket` (`nama_paket`, `deskripsi`, `kecepatan_mbps`, `harga`, `tipe_modem_id`, `status_paket_id`) 
VALUES ('HOME 20M Sewa', 'Paket menengah hemat', 20, 220000.00, 1, 1);

-- Admin mendaftarkan klien baru
INSERT INTO `klien` (`created_by`, `nama_klien`, `alamat`, `no_telepon`, `email`, `tanggal_daftar`) 
VALUES (1, 'Bapak Ridwan', 'Jl. Diponegoro No. 22, Bandung', '081999888777', 'ridwan@email.com', CURRENT_DATE);

-- Update alamat klien jika salah input
UPDATE `klien` 
SET `alamat` = 'Jl. Diponegoro No. 22A, Gedung Sate, Bandung' 
WHERE `klien_id` = 11;

-- ==============================================================================
-- PROSES 3.0: MANAJEMEN KONTRAK (MEMANTAU & UPDATE)
-- ==============================================================================
-- Simpan Kontrak Baru
INSERT INTO `kontrak` (`klien_id`, `paket_id`, `created_by`, `tanggal_mulai`, `tanggal_selesai`, `harga_kontrak`, `tipe_modem_id`, `status_kontrak_id`) 
VALUES (10, 10, 1, CURRENT_DATE, DATE_ADD(CURRENT_DATE, INTERVAL 6 MONTH), 1320000.00, 1, 1);

-- Update Status Kontrak (Membatalkan kontrak ID 3)
UPDATE `kontrak` 
SET `status_kontrak_id` = 3 
WHERE `kontrak_id` = 3;

-- Notifikasi Kontrak Expired 
SELECT 
    k.`kontrak_id`, kl.`nama_klien`, p.`nama_paket`, k.`tanggal_selesai`,
    DATEDIFF(k.`tanggal_selesai`, CURRENT_DATE) AS sisa_hari
FROM `kontrak` k
JOIN `klien` kl ON k.`klien_id` = kl.`klien_id`
JOIN `paket` p ON k.`paket_id` = p.`paket_id`
WHERE k.`status_kontrak_id` = 1 
  AND k.`tanggal_selesai` BETWEEN CURRENT_DATE AND DATE_ADD(CURRENT_DATE, INTERVAL 60 DAY);

-- ==============================================================================
-- PROSES 4.0: PENCATATAN INTERAKSI KOMUNIKASI
-- ==============================================================================
-- Input riwayat komunikasi baru (Menggunakan klien_id = 10)
INSERT INTO `komunikasi` (`user_id`, `klien_id`, `tanggal_interaksi`, `jenis_komunikasi_id`, `catatan`) 
VALUES (1, 10, CURRENT_TIMESTAMP, 2, 'Mengirimkan detail kontrak baru via WhatsApp.');

-- Tampilkan Daftar Riwayat Interaksi per Klien 
SELECT 
    c.`tanggal_interaksi`, j.`nama_jenis`, c.`catatan`, u.`nama` AS petugas_pencatat
FROM `komunikasi` c
JOIN `jenis_komunikasi` j ON c.`jenis_komunikasi_id` = j.`jenis_komunikasi_id`
JOIN `user` u ON c.`user_id` = u.`user_id`
WHERE c.`klien_id` = 10
ORDER BY c.`tanggal_interaksi` DESC;

-- ==============================================================================
-- PROSES 5.0: PELAPORAN & DASHBOARD (UNTUK MANAGER)
-- ==============================================================================
-- Grafik: Menghitung total kontrak berdasarkan statusnya
SELECT 
    s.`nama_status`, COUNT(k.`kontrak_id`) AS jumlah_kontrak
FROM `kontrak` k
JOIN `status_kontrak` s ON k.`status_kontrak_id` = s.`status_kontrak_id`
GROUP BY s.`nama_status`;

-- Filter Laporan Keuangan: Pendapatan bulan ini per paket yang aktif
SELECT 
    p.`nama_paket`, 
    COUNT(k.`kontrak_id`) AS pelanggan_aktif, 
    SUM(k.`harga_kontrak`) AS estimasi_pendapatan
FROM `kontrak` k
JOIN `paket` p ON k.`paket_id` = p.`paket_id`
WHERE k.`status_kontrak_id` = 1
GROUP BY p.`nama_paket`
ORDER BY estimasi_pendapatan DESC;
