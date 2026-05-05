package com.klientrack.backend.repository;

import com.klientrack.backend.entity.Komunikasi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface KomunikasiRepository extends JpaRepository<Komunikasi, Integer> {
    // Sesuai Class Diagram: Untuk menampilkan riwayat interaksi per klien
    List<Komunikasi> findByKlienIdOrderByCreatedAtDesc(Integer klienId);
}