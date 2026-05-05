package com.klientrack.backend.repository;

import com.klientrack.backend.entity.Paket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaketRepository extends JpaRepository<Paket, Integer> {
    boolean existsByNamaPaket(String namaPaket);
}