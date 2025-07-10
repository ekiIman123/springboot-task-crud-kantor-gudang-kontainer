package com.example.demo.repository;

import com.example.demo.model.pojo.Kontainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface KontainerRepository extends JpaRepository<Kontainer, Long> {
    Optional<Kontainer> findByKodeKantorAndKodeGudangAndNomorDokumen(String kodeKantor, String kodeGudang, String nomorDokumen);
    List<Kontainer> findByKodeKantorAndKodeGudang(String kodeKantor, String kodeGudang);
}
