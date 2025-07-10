package com.example.demo.model.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "kantor")
public class Kantor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @NotBlank
    @Column(name = "nama_kantor", nullable = false)
    private String namaKantor;

    @NotBlank
    @Column(name = "kode_kantor", unique = true, nullable = false, length = 10)
    private String kodeKantor;

    @Column(name = "alamat_kantor")
    private String alamatKantor;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Column(name = "waktu_rekam", updatable = false)
    private LocalDateTime waktuRekam;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Column(name = "waktu_update")
    private LocalDateTime waktuUpdate;

    @PrePersist
    public void onCreate() {
        waktuRekam = LocalDateTime.now();
        waktuUpdate = LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate() {
        waktuUpdate = LocalDateTime.now();
    }
}
