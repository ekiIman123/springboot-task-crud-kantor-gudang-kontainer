package com.example.demo.repository;

import com.example.demo.model.pojo.Gudang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GudangRepository extends JpaRepository<Gudang, Long> {
    List<Gudang> findByKodeKantor(String kodeKantor);
}
