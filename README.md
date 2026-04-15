# Tugas Deployment Perangkat Lunak - Praktikum 6

## 👤 Identitas Mahasiswa

| Atribut | Keterangan |
|---------|------------|
| **Nama** | Andika Arya Putra |
| **NIM** | 20230140214 |
| **Mata Kuliah** | Deployment Perangkat Lunak |
| **Tugas** | Praktikum 6 - Docker |

---

## 📋 Deskripsi Project

Project ini merupakan aplikasi **Website Mahasiswa** berbasis **Spring Boot** yang berfungsi sebagai sistem manajemen data mahasiswa secara temporary (in-memory). Aplikasi ini di-deploy menggunakan **Docker** sebagai bagian dari tugas Praktikum 6 mata kuliah Deployment Perangkat Lunak.

### Fitur Utama:
- 🔐 **Login Page** — Autentikasi pengguna dengan username dan password (NIM)
- 🏠 **Home Page** — Menampilkan daftar data mahasiswa dalam bentuk tabel
- 📝 **Form Input** — Form untuk menambahkan data mahasiswa baru (Nama, NIM, Jenis Kelamin)
- 🚪 **Logout** — Keluar dari aplikasi

---

## 🛠️ Teknologi yang Digunakan

| Teknologi | Keterangan |
|-----------|------------|
| **Java 25** | Bahasa pemrograman utama |
| **Spring Boot 4.0.5** | Framework backend |
| **Thymeleaf** | Template engine untuk frontend |
| **Lombok** | Library untuk mengurangi boilerplate code |
| **Maven** | Build tool & dependency management |
| **Docker** | Containerization untuk deployment |
| **Eclipse Temurin JDK 25** | Base image Docker |

---

## 📁 Struktur Project

```
deployment6/
├── src/
│   └── main/
│       ├── java/com/example/deployment6/
│       │   ├── Deployment6Application.java
│       │   ├── controller/
│       │   │   └── UserController.java
│       │   └── model/
│       │       └── User.java
│       └── resources/
│           ├── application.properties
│           └── templates/
│               ├── login.html
│               ├── home.html
│               └── form.html
├── Dockerfile
├── pom.xml
└── README.md
```

---

## 🐳 Dockerfile

```dockerfile
FROM eclipse-temurin:25-jdk
ARG JAR_FILE=target/*.jar
COPY ./target/deployment6-0.0.1-SNAPSHOT.jar app.jar
LABEL authors="ACER"

ENTRYPOINT ["java", "-jar", "/app.jar"]
EXPOSE 8080
```

---

## 🚀 Cara Menjalankan

### Menjalankan Secara Lokal
```bash
# Build project
./mvnw clean package

# Jalankan aplikasi
java -jar target/deployment6-0.0.1-SNAPSHOT.jar
```

### Menjalankan dengan Docker
```bash
# Build Docker image
docker build -t tugas-20230140214:1.0 .

# Jalankan container
docker run -d -p 8080:8080 --name web-20230140214 tugas-20230140214:1.0
```

### Akses Aplikasi
- **URL:** `http://localhost:8080`
- **Username:** `admin`
- **Password:** `20230140214`

---

## 📸 Screenshot Aplikasi

### Website Andika Arya Putra

#### 1. Halaman Login
Halaman login dengan form username dan password untuk autentikasi pengguna.

![Halaman Login](Screenshot%20(1153).png)

#### 2. Halaman Home — Data Mahasiswa (1 Data)
Menampilkan halaman utama dengan satu data mahasiswa yaitu Andika Arya Putra.

![Halaman Home - 1 Data](Screenshot%20(1155).png)

#### 3. Halaman Form Input Mahasiswa
Form untuk menambahkan data mahasiswa baru dengan field Nama, NIM, dan Jenis Kelamin.

![Form Input Mahasiswa](Screenshot%20(1152).png)

#### 4. Halaman Home — Data Mahasiswa (2 Data)
Menampilkan halaman utama setelah data mahasiswa baru (Indra Hafid Saputra) ditambahkan.

![Halaman Home - 2 Data](Screenshot%20(1151).png)

#### 5. Halaman Home — Data Mahasiswa (Setelah Tambah Data Teman)
Menampilkan halaman utama dengan data Andika Arya Putra dan Muhammad Arya Habil Damara.

![Halaman Home - Data Teman](Screenshot%20(1166).png)

---

### Website Teman (localhost:32768)

#### 1. Halaman Login Teman
Halaman login website teman yang berjalan di port 32768.

![Login Teman](Screenshot%20(1157).png)

#### 2. Halaman Home Teman — Belum Ada Data
Menampilkan halaman home website teman dengan tabel kosong dan pesan "Belum ada data mahasiswa. Silakan tambah data."

![Home Teman - Kosong](Screenshot%20(1158).png)

#### 3. Halaman Form Input Teman
Form input data mahasiswa pada website teman dengan field Nama, NIM, dan Jenis Kelamin (dropdown).

![Form Input Teman](Screenshot%20(1159).png)

#### 4. Halaman Home Teman — Setelah Input Data
Menampilkan halaman home website teman setelah data Andika Arya Putra berhasil ditambahkan.

![Home Teman - Data](Screenshot%20(1160).png)

---

### Tampilan Docker Desktop

#### 1. Docker Images
Menampilkan daftar Docker images yang telah dibuild, termasuk image `tugas-20230140214:1.0` dan image dari teman `axen4u/tugas-20230140202`.

![Docker Images](Screenshot%20(1162).png)

#### 2. Docker Containers
Menampilkan daftar container yang berjalan, termasuk container `web-20230140202` dari image teman yang berjalan di port `32768:8080`.

![Docker Containers](Screenshot%20(1163).png)

---

## 📝 Catatan

- Data mahasiswa disimpan secara **in-memory** (temporary), sehingga data akan hilang ketika aplikasi di-restart.
- Aplikasi ini menggunakan autentikasi sederhana (hardcoded) untuk keperluan praktikum.
- Container teman (`axen4u/tugas-20230140202`) di-pull dari Docker Hub dan dijalankan di port `32768`.
