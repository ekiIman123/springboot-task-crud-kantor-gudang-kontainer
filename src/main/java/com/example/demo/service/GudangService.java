package com.example.demo.service;

import com.example.demo.model.pojo.Gudang;
import com.example.demo.response.DataResponse;
import com.example.demo.response.DefaultResponse;
import com.example.demo.response.ListResponse;

public interface GudangService {
    DataResponse<Gudang> create(Gudang gudang);
    DataResponse<Gudang> update(Long id, Gudang gudang);
    DefaultResponse delete(Long id);
    DataResponse<Gudang> findById(Long id);
    ListResponse<Gudang> findAll();
    ListResponse<Gudang> findByKodeKantor(String kodeKantor);
}
