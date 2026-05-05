package com.klientrack.backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
// Gunakan backtick ( ` ) di dalam string agar Hibernate mengirimkannya dengan benar ke MySQL
@Table(name = "`user`")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    private String username;
    private String password;
    private String nama;

    @Column(name = "role_id")
    private Integer roleId;

    @Column(name = "is_active")
    private Boolean isActive = true;

    @Column(name = "created_at", insertable = false, updatable = false)
    private LocalDateTime createdAt;
}