INSERT INTO `role` (`nama_role`) VALUES 
('admin'), 
('manager');

INSERT INTO `tipe_modem` (`nama_tipe`) VALUES 
('sewa'), 
('beli');

INSERT INTO `status_paket` (`nama_status`) VALUES 
('aktif'), 
('nonaktif');

INSERT INTO `status_kontrak` (`nama_status`) VALUES 
('aktif'), 
('selesai'), 
('dibatalkan');

INSERT INTO `jenis_komunikasi` (`nama_jenis`) VALUES 
('telepon'), 
('whatsapp'), 
('email'), 
('kunjungan'), 
('catatan_internal');


INSERT INTO `user` (`username`, `password`, `nama`, `role_id`, `is_active`) VALUES
('admin.alim', '$2a$10$dummyhash1', 'Rahmatul Alim', 1, TRUE),
('manager.budi', '$2a$10$dummyhash2', 'Budi Prasetyo', 2, TRUE),
('admin.sari', '$2a$10$dummyhash3', 'Sari Dewi Kusuma', 1, TRUE),
('manager.andi', '$2a$10$dummyhash4', 'Andi Wijaya', 2, TRUE),
('admin.joko', '$2a$10$dummyhash5', 'Joko Susilo', 1, TRUE),
('admin.rina', '$2a$10$dummyhash6', 'Rina Marlina', 1, TRUE),
('manager.dina', '$2a$10$dummyhash7', 'Dina Mariana', 2, TRUE),
('admin.agus', '$2a$10$dummyhash8', 'Agus Kuncoro', 1, TRUE),
('admin.maya', '$2a$10$dummyhash9', 'Maya Sari', 1, FALSE),
('admin.indra', '$2a$10$dummyhash10', 'Indra Lesmana', 1, TRUE);

INSERT INTO `paket` (`nama_paket`, `deskripsi`, `kecepatan_mbps`, `harga`, `tipe_modem_id`, `status_paket_id`) VALUES
('HOME 0D', 'Paket entry-level. Cocok untuk penggunaan ringan hingga sedang.', 100, 175000.00, 1, 1),
('HOME 1D', 'Paket standar. Ideal untuk keluarga dengan streaming dan gaming.', 300, 375000.00, 1, 1),
('HOME 2D', 'Paket premium. Mendukung banyak perangkat secara bersamaan.', 400, 575000.00, 1, 1),
('HOME 3D', 'Paket ultra. Kecepatan tertinggi untuk kebutuhan paling intensif.', 500, 700000.00, 1, 1),
('HOME 0D BELI', 'Paket entry-level. Cocok untuk penggunaan ringan hingga sedang.', 100, 175000.00, 2, 1),
('HOME 1D BELI', 'Paket standar. Ideal untuk keluarga dengan streaming dan gaming.', 300, 375000.00, 2, 1),
('HOME 2D BELI', 'Paket premium. Mendukung banyak perangkat secara bersamaan.', 400, 575000.00, 2, 1),
('HOME 3D BELI', 'Paket ultra. Kecepatan tertinggi untuk kebutuhan paling intensif.', 500, 700000.00, 2, 1),
('HOME 0D PROMO', 'Paket entry-level. Cocok untuk penggunaan ringan hingga sedang.', 100, 150000.00, 1, 2),
('HOME 1D PROMO', 'Paket standar. Ideal untuk keluarga dengan streaming dan gaming.', 300, 300000.00, 1, 2);

INSERT INTO `klien` (`created_by`, `nama_klien`, `alamat`, `no_telepon`, `email`, `tanggal_daftar`) VALUES
(1, 'Asep Sunandar', 'Jl. Sukabirus No. 12, Bojongsoang, Bandung', '081122334455', 'asep.s@email.com', '2025-11-10'),
(1, 'Lilis Karlina', 'Jl. Buah Batu No. 42, Lengkong, Bandung', '081233445566', 'lilis.k@email.com', '2025-12-15'),
(3, 'Kang Ujang', 'Jl. Dago Asri No. 5, Coblong, Bandung', '081344556677', 'ujang.dago@email.com', '2026-01-05'),
(3, 'Ceu Popong', 'Jl. Cihampelas No. 22, Bandung Wetan, Bandung', '081455667788', 'popong22@email.com', '2026-01-20'),
(5, 'Tatang Sutarman', 'Komp. Margahayu Raya Blok B, Sekejati, Bandung', '081566778899', 'tatang.s@email.com', '2026-02-10'),
(5, 'Warkop Mang Oleh', 'Jl. Antapani Lama No. 8, Antapani, Bandung', '081677889900', 'warkop.oleh@email.com', '2026-02-28'),
(6, 'PT. Maju Mundur', 'Jl. Pasteur No. 88, Sukajadi, Bandung', '081788990011', 'admin@majumundur.co.id', '2026-03-10'),
(6, 'Dadang Konelo', 'Jl. Cibiru Hilir No. 5, Cibiru, Bandung', '081899001122', 'dadang.k@email.com', '2026-03-25'),
(8, 'Siti Maemunah', 'Jl. Kiaracondong No. 101, Babakan Surabaya, Bandung', '081900112233', 'siti.m@email.com', '2026-04-01'),
(8, 'Agus Kuncoro', 'Jl. Ujung Berung Kidul No. 3, Ujung Berung, Bandung', '082011223344', 'agus.k@email.com', '2026-04-05');

INSERT INTO `kontrak` (`klien_id`, `paket_id`, `created_by`, `tanggal_mulai`, `tanggal_selesai`, `harga_kontrak`, `tipe_modem_id`, `status_kontrak_id`) VALUES
(1, 1, 1, '2025-11-10', '2026-05-10', 1050000.00, 1, 1),
(2, 6, 1, '2025-12-15', '2026-12-15', 4500000.00, 2, 1),
(3, 3, 3, '2026-01-05', '2026-07-05', 3450000.00, 1, 1),
(4, 2, 3, '2026-01-20', '2026-02-20', 375000.00, 1, 2),
(4, 2, 3, '2026-02-20', '2026-08-20', 2250000.00, 1, 1), 
(5, 7, 5, '2026-02-10', '2027-02-10', 6900000.00, 2, 1),
(6, 4, 5, '2026-02-28', '2027-02-28', 8400000.00, 1, 1),
(7, 8, 6, '2026-03-10', '2027-03-10', 8400000.00, 2, 3),
(8, 1, 6, '2026-03-25', '2026-09-25', 1050000.00, 1, 1),
(9, 9, 8, '2026-04-01', '2026-05-01', 150000.00, 1, 1);

INSERT INTO `komunikasi` (`user_id`, `klien_id`, `tanggal_interaksi`, `jenis_komunikasi_id`, `catatan`) VALUES
(1, 1, '2025-11-11 10:00:00', 2, 'Kirim rincian kontrak awal via WhatsApp. Klien setuju.'),
(1, 2, '2025-12-16 14:30:00', 4, 'Kunjungan pemasangan modem beli di Buah Batu. Sinyal stabil.'),
(3, 3, '2026-02-10 09:15:00', 1, 'Klien komplain internet lambat. Direstart dari pusat via telepon.'),
(3, 4, '2026-02-18 16:00:00', 5, 'Klien Ceu Popong masuk masa tenggang. Akan difollow-up besok.'),
(3, 4, '2026-02-19 11:00:00', 1, 'Mengingatkan perpanjangan kontrak. Klien setuju perpanjang 6 bulan.'),
(5, 5, '2026-02-15 13:45:00', 2, 'Tanya detail cara ganti password WiFi. Dipandu via WA.'),
(5, 6, '2026-03-01 10:20:00', 4, 'Pemasangan router tambahan di area Warkop Antapani.'),
(6, 7, '2026-03-12 08:00:00', 3, 'Kirim Invoice dan Surat Perjanjian Kerjasama (SPK) via Email.'),
(6, 7, '2026-03-20 15:30:00', 5, 'PT Maju Mundur membatalkan layanan karena pindah gedung. Status diubah ke Dibatalkan.'),
(8, 9, '2026-04-02 09:00:00', 2, 'Follow up jadwal pemasangan promo di Kiaracondong besok pagi.');