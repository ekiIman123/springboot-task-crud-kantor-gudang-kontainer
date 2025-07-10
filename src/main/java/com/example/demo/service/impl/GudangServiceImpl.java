package com.example.demo.service.impl;

import com.example.demo.exception.NotFoundException;
import com.example.demo.model.pojo.Gudang;
import com.example.demo.repository.GudangRepository;
import com.example.demo.response.DataResponse;
import com.example.demo.response.DefaultResponse;
import com.example.demo.response.ListResponse;
import com.example.demo.service.GudangService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Log4j2
@Service
@RequiredArgsConstructor
public class GudangServiceImpl implements GudangService {

    private final GudangRepository repository;

    @Override
    @Transactional
    public DataResponse<Gudang> create(Gudang gudang) {
        try {
            return new DataResponse<>(repository.save(gudang));
        } catch (Exception e) {
            log.error("Failed to create gudang", e);
            throw e;
        }
    }

    @Override
    @Transactional
    public DataResponse<Gudang> update(Long id, Gudang gudang) {
        try {
            Gudang existing = repository.findById(id).orElseThrow(() -> new NotFoundException("Gudang not found"));
            existing.setKodeGudang(gudang.getKodeGudang());
            existing.setKodeKantor(gudang.getKodeKantor());
            existing.setAlamat(gudang.getAlamat());
            existing.setLatitude(gudang.getLatitude());
            existing.setLongitude(gudang.getLongitude());
            return new DataResponse<>(repository.save(existing));
        } catch (Exception e) {
            log.error("Failed to update gudang", e);
            throw e;
        }
    }

    @Override
    @Transactional
    public DefaultResponse delete(Long id) {
        try {
            Gudang existing = repository.findById(id).orElseThrow(() -> new NotFoundException("Gudang not found"));
            repository.delete(existing);
            return new DefaultResponse("Deleted successfully");
        } catch (Exception e) {
            log.error("Failed to delete gudang", e);
            throw e;
        }
    }

    @Override
    public DataResponse<Gudang> findById(Long id) {
        return new DataResponse<>(repository.findById(id).orElseThrow(() -> new NotFoundException("Gudang not found")));
    }

    @Override
    public ListResponse<Gudang> findAll() {
        return new ListResponse<>(repository.findAll());
    }

    @Override
    public ListResponse<Gudang> findByKodeKantor(String kodeKantor) {
        return new ListResponse<>(repository.findByKodeKantor(kodeKantor));
    }
}
