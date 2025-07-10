# Spring Boot CRUD API — Kantor, Gudang, Kontainer

Proyek ini adalah bagian dari technical test backend (interview) yang diberikan oleh tim <NAMA PERUSAHAAN/REKRUTER>. Aplikasi ini membangun RESTful API dengan tiga entitas utama: `KANTOR`, `GUDANG`, dan `KONTAINER`, menggunakan **Spring Boot 2.7.18**, **Java 17**, dan **PostgreSQL**.

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
