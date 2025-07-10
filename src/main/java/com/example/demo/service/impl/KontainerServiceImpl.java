package com.example.demo.service.impl;

import com.example.demo.exception.NotFoundException;
import com.example.demo.model.pojo.Kontainer;
import com.example.demo.repository.KontainerRepository;
import com.example.demo.response.DataResponse;
import com.example.demo.response.DefaultResponse;
import com.example.demo.response.ListResponse;
import com.example.demo.service.KontainerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Log4j2
@Service
@RequiredArgsConstructor
public class KontainerServiceImpl implements KontainerService {

    private final KontainerRepository repository;

    @Override
    @Transactional
    public DataResponse<Kontainer> create(Kontainer kontainer) {
        return new DataResponse<>(repository.save(kontainer));
    }

    @Override
    @Transactional
    public DataResponse<Kontainer> update(Long id, Kontainer kontainer) {
        Kontainer existing = repository.findById(id).orElseThrow(() -> new NotFoundException("Kontainer not found"));
        existing.setKodeKantor(kontainer.getKodeKantor());
        existing.setKodeGudang(kontainer.getKodeGudang());
        existing.setNomorDokumen(kontainer.getNomorDokumen());
        existing.setNomorKontainer(kontainer.getNomorKontainer());
        existing.setJenisKontainer(kontainer.getJenisKontainer());
        return new DataResponse<>(repository.save(existing));
    }

    @Override
    @Transactional
    public DefaultResponse delete(Long id) {
        Kontainer existing = repository.findById(id).orElseThrow(() -> new NotFoundException("Kontainer not found"));
        repository.delete(existing);
        return new DefaultResponse("Deleted successfully");
    }

    @Override
    public ListResponse<Kontainer> findAll() {
        return new ListResponse<>(repository.findAll());
    }

    @Override
    public DataResponse<Kontainer> findById(Long id) {
        return new DataResponse<>(repository.findById(id).orElseThrow(() -> new NotFoundException("Kontainer not found")));
    }

    @Override
    public DataResponse<Kontainer> findByKodeKantorAndKodeGudangAndNomorDokumen(String kodeKantor, String kodeGudang, String nomorDokumen) {
        return new DataResponse<>(repository.findByKodeKantorAndKodeGudangAndNomorDokumen(kodeKantor, kodeGudang, nomorDokumen)
                .orElseThrow(() -> new NotFoundException("Kontainer not found by those fields")));
    }
}
