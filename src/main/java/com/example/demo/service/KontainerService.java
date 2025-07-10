package com.example.demo.service;

import com.example.demo.model.pojo.Kontainer;
import com.example.demo.response.DataResponse;
import com.example.demo.response.DefaultResponse;
import com.example.demo.response.ListResponse;

public interface KontainerService {
    DataResponse<Kontainer> create(Kontainer kontainer);
    DataResponse<Kontainer> update(Long id, Kontainer kontainer);
    DefaultResponse delete(Long id);
    ListResponse<Kontainer> findAll();
    DataResponse<Kontainer> findById(Long id);
    DataResponse<Kontainer> findByKodeKantorAndKodeGudangAndNomorDokumen(String kodeKantor, String kodeGudang, String nomorDokumen);
}
