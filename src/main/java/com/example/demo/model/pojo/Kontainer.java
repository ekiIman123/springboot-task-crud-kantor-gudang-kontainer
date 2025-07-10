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
@Table(name = "kontainer")
public class Kontainer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @NotBlank
    @Column(name = "kode_kantor", length = 10, nullable = false)
    private String kodeKantor;

    @NotBlank
    @Column(name = "kode_gudang", length = 10, nullable = false)
    private String kodeGudang;

    @NotBlank
    @Column(name = "nomor_dokumen", length = 50, nullable = false)
    private String nomorDokumen;

    @NotBlank
    @Column(name = "nomor_kontainer", length = 50, nullable = false)
    private String nomorKontainer;

    @Column(name = "jenis_kontainer", length = 30)
    private String jenisKontainer;

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
