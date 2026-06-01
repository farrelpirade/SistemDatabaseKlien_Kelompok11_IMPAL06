# 🚀 Tugas Besar: Sistem Database Klien

> **Dosen Pengampu:** Muhammad Shiddiq Azis, S.T., MBA

---

## 📊 Perancangan Sistem

Bagian ini memuat rancangan aliran data dan arsitektur sistem perangkat lunak.

### 1. Data Flow Diagram (DFD)

**DFD Level 0** ![DFD Level 0](docs/diagrams/DFDLevel0.png)  
_Diagram Konteks yang menunjukkan aliran data global._

**DFD Level 1** ![DFD Level 1](docs/diagrams/DFDLevel1.png)  
_Detail proses bisnis dan integrasi database._

### 2. Entity Relationship Diagram (ERD)

![ERD](docs/diagrams/ERD.png)  
_Pemodelan struktur tabel basis data dan relasi antar entitas._

### 3. Class Diagram

![Class Diagram](docs/diagrams/ClassDiagram.png)  
_Struktur kelas, atribut, metode, dan hubungan antar objek dalam sistem._

---

## 🎨 Mockup Antarmuka

Rancangan UI aplikasi yang berfokus pada pengalaman pengguna.

### 🔐 Autentikasi & Dashboard Utama

| Login Page                                | Dashboard Admin                                          | Dashboard Manager                                            |
| :---------------------------------------: | :------------------------------------------------------: | :----------------------------------------------------------: |
| ![Login](docs/mockup/Login.png)           | ![Dashboard Admin](docs/mockup/Dashboard_Admin.png)      | ![Dashboard Manager](docs/mockup/Dashboard_Manager.png)      |

### 👥 Manajemen Klien & Kontrak (Akses Admin)

| Daftar Client                                              | Detail Daftar Client                                                   | Edit Data Klien                                              | Buat Kontrak                                              |
| :--------------------------------------------------------: | :--------------------------------------------------------------------: | :----------------------------------------------------------: | :-------------------------------------------------------: |
| ![Daftar Client](docs/mockup/Daftar%20Client_Admin.png)    | ![Detail Daftar Client](docs/mockup/Detail%20Daftar%20Client_Admin.png)| ![Edit Data Klien](docs/mockup/Edit%20Data%20Klien_Admin.png)| ![Buat Kontrak](docs/mockup/Buat%20Kontrak_Admin.png)     |

| Konfirmasi Kontrak                                                          | Lihat Kontrak                              | Edit & Update Kontrak                                                    |
| :-------------------------------------------------------------------------: | :----------------------------------------: | :----------------------------------------------------------------------: |
| ![Konfirmasi Kontrak](docs/mockup/Konfirmasi%20Buat%20Kontrak_Admin.png)    | ![Lihat Kontrak](docs/mockup/Kontrak_Admin.png) | ![Edit Update Kontrak](docs/mockup/Edit%20%26%20Update%20Kontrak_Admin.png) |

### 📦 Manajemen Layanan & Paket (Akses Admin)

| Paket Layanan                                          | Tambah Paket Layanan                                              | Edit Detail Paket                                          |
| :----------------------------------------------------: | :---------------------------------------------------------------: | :--------------------------------------------------------: |
| ![Paket Layanan](docs/mockup/Paket%20Layanan_Admin.png)| ![Tambah Paket](docs/mockup/Tambah%20Paket%20Layanan_Admin.png)   | ![Edit Paket](docs/mockup/Edit%20Detail%20Paket_Admin.png) |

### ⚙️ Pengaturan & Akun (Akses Admin & Manager)

| Pengaturan Admin                                    | Pengaturan Manager                                       | Tambah Akun Admin                                                   | Tambah Akun Manager                                                      | Edit Detail Akun                                                  |
| :-------------------------------------------------: | :------------------------------------------------------: | :-----------------------------------------------------------------: | :----------------------------------------------------------------------: | :---------------------------------------------------------------: |
| ![Pengaturan Admin](docs/mockup/Pengaturan_Admin.png) | ![Pengaturan Manager](docs/mockup/Pengaturan_Manager.png) | ![Tambah Akun Admin](docs/mockup/Tambah%20Akun%20Admin_Manager.png) | ![Tambah Akun Manager](docs/mockup/Tambah%20Akun%20Manager_Manager.png)  | ![Edit Akun Manager](docs/mockup/Edit%20Detail%20Akun_Manager.png)|

---

## 🛠️ Stack Teknologi

- **Frontend:** Bootstrap + Thymeleaf
- **Backend:** Spring Boot
- **Database:** MySQL

---

## 📂 Cara Instalasi

1. Clone repositori ini ke dalam direktori lokal Anda.
   ```bash
   git clone <url-repositori-anda>
