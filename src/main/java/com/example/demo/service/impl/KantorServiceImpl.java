package com.example.demo.service.impl;

import com.example.demo.model.pojo.Kantor;
import com.example.demo.repository.KantorRepository;
import com.example.demo.response.DataResponse;
import com.example.demo.response.DefaultResponse;
import com.example.demo.response.ListResponse;
import com.example.demo.service.KantorService;
import com.example.demo.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class KantorServiceImpl implements KantorService {

    private final KantorRepository repository;

    @Override
    @Transactional
    public DataResponse<Kantor> create(Kantor kantor) {
        try {
            Kantor saved = repository.save(kantor);
            return new DataResponse<>(saved);
        } catch (Exception e) {
            log.error("Failed to create kantor", e);
            throw e;
        }
    }

    @Override
    @Transactional
    public DataResponse<Kantor> update(Long id, Kantor kantor) {
        try {
            Kantor existing = repository.findById(id).orElseThrow(() -> new NotFoundException("Kantor not found"));
            existing.setNamaKantor(kantor.getNamaKantor());
            existing.setKodeKantor(kantor.getKodeKantor());
            existing.setAlamatKantor(kantor.getAlamatKantor());
            return new DataResponse<>(repository.save(existing));
        } catch (Exception e) {
            log.error("Failed to update kantor", e);
            throw e;
        }
    }

    @Override
    @Transactional
    public DefaultResponse delete(Long id) {
        try {
            Kantor existing = repository.findById(id).orElseThrow(() -> new NotFoundException("Kantor not found"));
            repository.delete(existing);
            return new DefaultResponse("Deleted successfully");
        } catch (Exception e) {
            log.error("Failed to delete kantor", e);
            throw e;
        }
    }

    @Override
    public ListResponse<Kantor> findAll() {
        return new ListResponse<>(repository.findAll());
    }

    @Override
    public DataResponse<Kantor> findById(Long id) {
        return new DataResponse<>(repository.findById(id).orElseThrow(() -> new NotFoundException("Kantor not found")));
    }
}
