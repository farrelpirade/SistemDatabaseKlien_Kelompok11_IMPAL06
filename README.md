# 🚀 Tugas Besar: Sistem Database Klien

> **Dosen Pengampu:** Muhammad Shiddiq Azis, S.T., MBA

---

## 📊 Perancangan Sistem

Bagian ini memuat rancangan aliran data dan arsitektur sistem perangkat lunak.

---

### 1. Data Flow Diagram (DFD)

**DFD Level 0**

![DFD Level 0](docs/diagrams/DFDLevel0.png)

_Diagram Konteks yang menunjukkan aliran data global._

---

**DFD Level 1**

![DFD Level 1](docs/diagrams/DFDLevel1.png)

_Detail proses bisnis dan integrasi database._

---

### 2. Entity Relationship Diagram (ERD)

![ERD](docs/diagrams/ERD.png)

_Pemodelan struktur tabel basis data dan relasi antar entitas._

---

### 3. Sequence Diagram

Berikut daftar seluruh Sequence Diagram yang menggambarkan alur interaksi antar komponen sistem:

#### P1 — Registrasi Akun Baru (Autentikasi)

| Kode | Nama | File |
|------|------|------|
| P1.1 | Registrasi Akun Baru | ![P1.1](docs/diagrams/SequenceDiagram/SD_Registrasi%20Akun%20Baru.png) |

#### P2 — Login (Manajemen sesi)

| Kode | Nama | File |
|------|------|------|
| P2.1 | Login | ![P2.1](docs/diagrams/SequenceDiagram/SD_Login.png) |
| P2.2 | Logout | ![P2.2](docs/diagrams/SequenceDiagram/SD_Logout.png) |
| P2.3 | Reset Password | ![P2.3](docs/diagrams/SequenceDiagram/SD_Reset%20Password.png) |

#### P3 — Olah data klien (Manajemen Klien)

| Kode | Nama | File |
|------|------|------|
| P3.1 | Tambah Data Klien | ![P3.1](docs/diagrams/SequenceDiagram/SD_Tambah%20Data%20Klien.png) |
| P3.2 | Detail Klien | ![P3.2](docs/diagrams/SequenceDiagram/SD_Detail%20Klien.png) |
| P3.3 | Update Data Klien | ![P3.3](docs/diagrams/SequenceDiagram/SD_Update%20Data%20Klien.png) |
| P3.4 | Hapus Data Klien | ![P3.4](docs/diagrams/SequenceDiagram/SD_Hapus%20Data%20Klien.png) |

#### P4 — Olah data paket layanan (Manajemen Paket Layanan)

| Kode | Nama | File |
|------|------|------|
| P4.1 | Tambah Paket | ![P4.1](docs/diagrams/SequenceDiagram/SD_Tambah%20Paket.png) |
| P4.2 | List Paket Layanan | ![P4.2](docs/diagrams/SequenceDiagram/SD_List%20Paket%20Layanan.png) |
| P4.3 | Edit Data Paket | ![P4.3](docs/diagrams/SequenceDiagram/SD_Edit%20Data%20Paket.png) |
| P4.4 | Hapus Data Paket | ![P4.4](docs/diagrams/SequenceDiagram/SD_Hapus%20Data%20Paket.png) |

#### P5 — Memantau masa kontrak (Manajemen Kontrak)

| Kode | Nama | File |
|------|------|------|
| P5.1 | Buat Kontrak Baru | ![P5.1](docs/diagrams/SequenceDiagram/SD_Buat%20Kontrak%20Baru.png) |

#### P6 — Update Status Kontrak (Update Kontrak)

| Kode | Nama | File |
|------|------|------|
| P6.1 | Update Status Kontrak | ![P6.1](docs/diagrams/SequenceDiagram/SD_Update%20Status%20Kontrak.png) |

#### P7 — Pencatatan Interaksi (Riwayat Komunikasi)

| Kode | Nama | File |
|------|------|------|
| P7.1 | Tambah Riwayat Komunikasi | ![P7.1](docs/diagrams/SequenceDiagram/SD_Tambah%20Riwayat%20Komunikasi.png) |
| P7.2 | List Riwayat per Klien | ![P7.2](docs/diagrams/SequenceDiagram/SD_List%20Riwayat%20per%20Klien.png) |

#### P8 —  Pembuatan Laporan (Laporan)

| Kode | Nama | File |
|------|------|------|
| P8.1 | Generate Laporan | ![P8.1](docs/diagrams/SequenceDiagram/SD_Generate%20Laporan.png) |

#### P9 — Visualisasi dashboard manager (Statistik & Dashboard)

| Kode | Nama | File |
|------|------|------|
| P9.1 | Statistik Pertumbuhan Pelanggan | ![P9.1](docs/diagrams/SequenceDiagram/SD_Statistik%20Pertumbuhan%20Pelanggan.png) |

---

### 4. Class Diagram

![Class Diagram](docs/diagrams/ClassDiagram.png)

_Struktur kelas, atribut, metode, dan hubungan antar objek dalam sistem._

---

## 🎨 Mockup Antarmuka

Rancangan UI aplikasi yang berfokus pada pengalaman pengguna.

### 🔐 Autentikasi & Dashboard Utama

|           Login Page            |                   Dashboard Admin                   |                    Dashboard Manager                    |
| :-----------------------------: | :-------------------------------------------------: | :-----------------------------------------------------: |
| ![Login](docs/mockup/Login.png) | ![Dashboard Admin](docs/mockup/Dashboard_Admin.png) | ![Dashboard Manager](docs/mockup/Dashboard_Manager.png) |

### 👥 Manajemen Klien & Kontrak (Akses Admin)

|                      Daftar Client                      |                          Detail Daftar Client                           |                        Edit Data Klien                        |                     Buat Kontrak                      |
| :-----------------------------------------------------: | :---------------------------------------------------------------------: | :-----------------------------------------------------------: | :---------------------------------------------------: |
| ![Daftar Client](docs/mockup/Daftar%20Client_Admin.png) | ![Detail Daftar Client](docs/mockup/Detail%20Daftar%20Client_Admin.png) | ![Edit Data Klien](docs/mockup/Edit%20Data%20Klien_Admin.png) | ![Buat Kontrak](docs/mockup/Buat%20Kontrak_Admin.png) |

|                            Konfirmasi Kontrak                            |                  Lihat Kontrak                  |                            Edit & Update Kontrak                            |
| :----------------------------------------------------------------------: | :---------------------------------------------: | :-------------------------------------------------------------------------: |
| ![Konfirmasi Kontrak](docs/mockup/Konfirmasi%20Buat%20Kontrak_Admin.png) | ![Lihat Kontrak](docs/mockup/Kontrak_Admin.png) | ![Edit Update Kontrak](docs/mockup/Edit%20%26%20Update%20Kontrak_Admin.png) |

### 📦 Manajemen Layanan & Paket (Akses Admin)

|                      Paket Layanan                      |                      Tambah Paket Layanan                       |                     Edit Detail Paket                      |
| :-----------------------------------------------------: | :-------------------------------------------------------------: | :--------------------------------------------------------: |
| ![Paket Layanan](docs/mockup/Paket%20Layanan_Admin.png) | ![Tambah Paket](docs/mockup/Tambah%20Paket%20Layanan_Admin.png) | ![Edit Paket](docs/mockup/Edit%20Detail%20Paket_Admin.png) |

### ⚙️ Pengaturan & Akun (Akses Admin & Manager)

|                   Pengaturan Admin                    |                    Pengaturan Manager                     |                          Tambah Akun Admin                          |                           Tambah Akun Manager                           |                          Edit Detail Akun                          |
| :---------------------------------------------------: | :-------------------------------------------------------: | :-----------------------------------------------------------------: | :---------------------------------------------------------------------: | :----------------------------------------------------------------: |
| ![Pengaturan Admin](docs/mockup/Pengaturan_Admin.png) | ![Pengaturan Manager](docs/mockup/Pengaturan_Manager.png) | ![Tambah Akun Admin](docs/mockup/Tambah%20Akun%20Admin_Manager.png) | ![Tambah Akun Manager](docs/mockup/Tambah%20Akun%20Manager_Manager.png) | ![Edit Akun Manager](docs/mockup/Edit%20Detail%20Akun_Manager.png) |

---

## 🛠️ Stack Teknologi

- **Frontend:** Bootstrap
- **Backend:** Spring Boot
- **Database:** MySQL

---

## 📂 Cara Instalasi
