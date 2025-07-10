package com.example.demo.controller;

import com.example.demo.model.pojo.Kontainer;
import com.example.demo.response.DataResponse;
import com.example.demo.response.DefaultResponse;
import com.example.demo.response.ListResponse;
import com.example.demo.service.KontainerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Tag(name = "Kontainer", description = "API Kontainer")
@RestController
@RequestMapping("/kontainer")
@RequiredArgsConstructor
@Validated
public class KontainerController {

    private final KontainerService service;

    @PostMapping
    @Operation(summary = "Create Kontainer")
    public ResponseEntity<DataResponse<Kontainer>> create(@Valid @RequestBody Kontainer kontainer) {
        return ResponseEntity.ok(service.create(kontainer));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update Kontainer")
    public ResponseEntity<DataResponse<Kontainer>> update(@PathVariable Long id, @Valid @RequestBody Kontainer kontainer) {
        return ResponseEntity.ok(service.update(id, kontainer));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Kontainer")
    public ResponseEntity<DefaultResponse> delete(@PathVariable Long id) {
        return ResponseEntity.ok(service.delete(id));
    }

    @GetMapping("/findAll")
    @Operation(summary = "List all Kontainer")
    public ResponseEntity<ListResponse<Kontainer>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Find Kontainer by ID")
    public ResponseEntity<DataResponse<Kontainer>> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/byKodeGudangKantorDokumen")
    @Operation(summary = "Find Kontainer by kode_kantor, kode_gudang, nomor_dokumen")
    public ResponseEntity<DataResponse<Kontainer>> findByCompositeKey(
        @RequestParam String kodeKantor,
        @RequestParam String kodeGudang,
        @RequestParam String nomorDokumen
    ) {
        return ResponseEntity.ok(service.findByKodeKantorAndKodeGudangAndNomorDokumen(kodeKantor, kodeGudang, nomorDokumen));
    }
}
