package com.klientrack.backend.repository;

import com.klientrack.backend.entity.Kontrak;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

@Repository
public interface KontrakRepository extends JpaRepository<Kontrak, Integer> {

    // PROSES 5: Radar Expired (Memantau Masa Kontrak)
    @Query(value = "SELECT * FROM kontrak WHERE tanggal_selesai BETWEEN CURRENT_DATE AND (CURRENT_DATE + INTERVAL 30 DAY)", nativeQuery = true)
    List<Kontrak> getKontrakExpiredSoon();

    // PROSES 8: Statistik Distribusi Paket (Untuk Laporan Admin/Manager)
    @Query(value = "SELECT p.nama_paket as nama, COUNT(k.kontrak_id) as jumlah " +
            "FROM kontrak k JOIN paket p ON k.paket_id = p.paket_id " +
            "GROUP BY p.nama_paket", nativeQuery = true)
    List<Map<String, Object>> getStatistikDashboard();

    // PROSES 9: Statistik Pertumbuhan Pelanggan Per Bulan (Untuk Line Chart Manager)
    // Query ini mengambil nama bulan dan menghitung jumlah klien unik yang bergabung
    @Query(value = "SELECT MONTHNAME(tanggal_mulai) as bulan, COUNT(DISTINCT klien_id) as jumlah " +
            "FROM kontrak " +
            "GROUP BY MONTH(tanggal_mulai), MONTHNAME(tanggal_mulai) " +
            "ORDER BY MONTH(tanggal_mulai)",
            nativeQuery = true)
    List<Map<String, Object>> countKlienPerBulan();
}