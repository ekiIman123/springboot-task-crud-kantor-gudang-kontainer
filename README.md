# Spring Boot CRUD API — Kantor, Gudang, Kontainer

Proyek ini adalah bagian dari technical test backend (interview) yang diberikan oleh tim ALUGRA. Aplikasi ini membangun RESTful API dengan tiga entitas utama: `KANTOR`, `GUDANG`, dan `KONTAINER`, menggunakan **Spring Boot 2.7.18**, **Java 17**, dan **PostgreSQL**.

## ✅ Fitur yang Diselesaikan

- CRUD KANTOR (`/kantor`)
- CRUD GUDANG (`/gudang`)
- CRUD KONTAINER (`/kontainer`)
- Custom endpoint: `/kontainer/byKodeGudangKantorDokumen`
- Validasi field (`@NotBlank`, `@Valid`)
- Otomatis isi waktu (`waktu_rekam`, `waktu_update`)
- Response terstandarisasi (`DataResponse`, `ListResponse`, `DefaultResponse`)
- Swagger UI aktif (`localhost:8080/swagger-ui.html`)
- Logging menggunakan **Log4j2**

## 💻 Teknologi

- Java 17
- Spring Boot 2.7.18
- Maven
- Spring Data JPA
- Spring Validation
- PostgreSQL
- Swagger (springdoc-openapi 1.6.15)
- Log4j2 (pengganti logback)
- Lombok

## 🏁 Menjalankan Aplikasi

1. Pastikan PostgreSQL aktif dan database `dbmu` sudah dibuat.
2. Edit `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/dbmu
spring.datasource.username=postgres
spring.datasource.password=Postgrenih123*
```

3. Jalankan perintah:

```properties
mvn clean install
mvn spring-boot:run
```

4. Akses Swagger UI di browser:

```properties
http://localhost:8080/swagger-ui.html
```

## 🧪 Contoh Payload

POST /kantor

```properties
{
  "namaKantor": "Kantor Pusat",
  "kodeKantor": "KTR001",
  "alamatKantor": "Jl. Merdeka No. 123"
}
```

POST /gudang

```properties
{
  "kodeGudang": "GD001",
  "kodeKantor": "KTR001",
  "alamat": "Jl. Gudang No. 45",
  "latitude": -6.200000,
  "longitude": 106.816666
}
```

POST /kontainer

```properties
{
  "kodeKantor": "KTR001",
  "kodeGudang": "GD001",
  "nomorDokumen": "DO12345",
  "nomorKontainer": "CNT123456",
  "jenisKontainer": "Dry Container"
}
```

## 📂 Struktur Project

```properties
src/main/java/com/example/demo/
├── controller/
├── exception/
├── model/
│   └── pojo/
├── repository/
├── response/
├── service/
│   └── impl/
└── DemoApplication.java
```

## 📬 Postman Collection

Import file berikut ke Postman untuk langsung mencoba semua endpoint:

- [springboot-task.postman_collection.json](./springboot-task.postman_collection.json)

## 📌 Catatan

- Semua kode sudah divalidasi dan berjalan di Swagger.
- Fokus utama adalah desain layer REST API yang clean dan maintainable.
- Aplikasi ini siap dikembangkan lebih lanjut untuk implementasi auth atau deploy ke cloud.

Terima kasih atas kesempatan tes ini 🙏
Silakan cek kode lengkap di repo ini. Bila diperlukan, saya siap menjelaskan arsitektur atau design choice yang saya ambil.
