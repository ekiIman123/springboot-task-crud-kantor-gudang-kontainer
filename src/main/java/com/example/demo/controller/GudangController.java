package com.example.demo.controller;

import com.example.demo.model.pojo.Gudang;
import com.example.demo.response.DataResponse;
import com.example.demo.response.DefaultResponse;
import com.example.demo.response.ListResponse;
import com.example.demo.service.GudangService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Tag(name = "Gudang", description = "API Gudang")
@RestController
@RequestMapping("/gudang")
@RequiredArgsConstructor
@Validated
public class GudangController {

    private final GudangService gudangService;

    @PostMapping
    @Operation(summary = "Create Gudang")
    public ResponseEntity<DataResponse<Gudang>> create(@Valid @RequestBody Gudang gudang) {
        return ResponseEntity.ok(gudangService.create(gudang));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update Gudang")
    public ResponseEntity<DataResponse<Gudang>> update(@PathVariable Long id, @Valid @RequestBody Gudang gudang) {
        return ResponseEntity.ok(gudangService.update(id, gudang));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Gudang")
    public ResponseEntity<DefaultResponse> delete(@PathVariable Long id) {
        return ResponseEntity.ok(gudangService.delete(id));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Find Gudang by ID")
    public ResponseEntity<DataResponse<Gudang>> findById(@PathVariable Long id) {
        return ResponseEntity.ok(gudangService.findById(id));
    }

    @GetMapping("/findAll")
    @Operation(summary = "Find all Gudang")
    public ResponseEntity<ListResponse<Gudang>> findAll() {
        return ResponseEntity.ok(gudangService.findAll());
    }

    @GetMapping("/byKodeKantor")
    @Operation(summary = "Find Gudang by Kode Kantor")
    public ResponseEntity<ListResponse<Gudang>> findByKodeKantor(@RequestParam String kodeKantor) {
        return ResponseEntity.ok(gudangService.findByKodeKantor(kodeKantor));
    }
}
