package com.pruebas.crud.controllers;

import com.pruebas.crud.controllers.dto.MakerDTO;
import com.pruebas.crud.entities.MakerEntity;
import com.pruebas.crud.service.IMakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/maker")
public class MakerController {
    @Autowired
    private IMakerService makerService;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<MakerEntity> makerOptional = makerService.findById(id);

        if (makerOptional.isPresent()) {
            MakerEntity maker = makerOptional.get();
            MakerDTO makerDTO = MakerDTO.builder()
                    .id(maker.getId())
                    .name(maker.getName())
                    .productList(maker.getProductList())
                    .build();

            return ResponseEntity.ok(makerDTO);
        }

        return ResponseEntity.notFound().build();
    }


    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        List<MakerEntity> makerList = makerService.findAll();
        if (makerList.isEmpty()) return ResponseEntity.notFound().build();

        List<MakerDTO> makerDTOs = makerList.stream()
                .map(makerEntity -> MakerDTO.builder()
                        .id(makerEntity.getId())
                        .name(makerEntity.getName())
                        .productList(makerEntity.getProductList())
                        .build())
                .toList();
        return ResponseEntity.ok(makerDTOs);
    }


    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody MakerDTO makerDTO) throws URISyntaxException {
        if (makerDTO.getName().isBlank()) return ResponseEntity.badRequest().build();
        makerService.save(
                MakerEntity.builder()
                        .name(makerDTO.getName())
                        .build());
        return ResponseEntity.created(new URI("/api/maker/save")).build();
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateMaker(@PathVariable Long id, @RequestBody MakerDTO makerDTO) {
        Optional<MakerEntity> makerOptional = makerService.findById(id);

        if (makerOptional.isPresent()) {
            MakerEntity makerEntity = makerOptional.get();
            makerEntity.setName(makerDTO.getName());
            makerService.save(makerEntity);
            return ResponseEntity.ok("Registro Actualizado");
        }
        return ResponseEntity.notFound().build();
    }


    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteMaker(@PathVariable Long id) {
        Optional<MakerEntity> makerOptional = makerService.findById(id);
        if (makerOptional.isPresent() || id != null) {
            makerService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(500).build();
    }
}
