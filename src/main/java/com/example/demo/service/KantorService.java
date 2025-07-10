package com.example.demo.service;

import com.example.demo.model.pojo.Kantor;
import com.example.demo.response.DataResponse;
import com.example.demo.response.DefaultResponse;
import com.example.demo.response.ListResponse;

public interface KantorService {
    DataResponse<Kantor> create(Kantor kantor);
    DataResponse<Kantor> update(Long id, Kantor kantor);
    DefaultResponse delete(Long id);
    ListResponse<Kantor> findAll();
    DataResponse<Kantor> findById(Long id);
}
