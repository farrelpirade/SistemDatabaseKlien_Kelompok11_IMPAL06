package com.klientrack.backend.repository;

import com.klientrack.backend.entity.Klien;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface KlienRepository extends JpaRepository<Klien, Integer> {
    // Fungsi ini wajib ada untuk mengecek duplikasi email di Service
    Optional<Klien> findByEmail(String email);
}