package com.example.demo.controller;

import com.example.demo.model.pojo.Kantor;
import com.example.demo.response.DataResponse;
import com.example.demo.response.DefaultResponse;
import com.example.demo.response.ListResponse;
import com.example.demo.service.KantorService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Tag(name = "Kantor", description = "API Kantor")
@RestController
@RequestMapping("/kantor")
@RequiredArgsConstructor
@Validated
public class KantorController {

    private final KantorService kantorService;

    @PostMapping
    @Operation(summary = "Create Kantor")
    public ResponseEntity<DataResponse<Kantor>> create(@Valid @RequestBody Kantor kantor) {
        return ResponseEntity.ok(kantorService.create(kantor));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update Kantor")
    public ResponseEntity<DataResponse<Kantor>> update(@PathVariable Long id, @Valid @RequestBody Kantor kantor) {
        return ResponseEntity.ok(kantorService.update(id, kantor));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Kantor")
    public ResponseEntity<DefaultResponse> delete(@PathVariable Long id) {
        return ResponseEntity.ok(kantorService.delete(id));
    }

    @GetMapping("/findAll")
    @Operation(summary = "List All Kantor")
    public ResponseEntity<ListResponse<Kantor>> findAll() {
        return ResponseEntity.ok(kantorService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Kantor by ID")
    public ResponseEntity<DataResponse<Kantor>> findById(@PathVariable Long id) {
        return ResponseEntity.ok(kantorService.findById(id));
    }
}
