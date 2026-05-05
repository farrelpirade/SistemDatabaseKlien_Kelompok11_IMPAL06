package com.klientrack.backend.repository;

import com.klientrack.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    // Metode ini digunakan untuk proses Login dan pencarian target Reset Password
    Optional<User> findByUsername(String username);

    // Metode findById(Integer id) sudah tersedia otomatis dari JpaRepository
    // untuk memvalidasi X-Requester-Id (Manager) di AuthController
}