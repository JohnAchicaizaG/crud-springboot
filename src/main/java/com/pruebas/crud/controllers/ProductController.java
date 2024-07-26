package com.pruebas.crud.controllers;

import com.pruebas.crud.controllers.dto.MinMaxDTO;
import com.pruebas.crud.controllers.dto.ProductDTO;
import com.pruebas.crud.entities.ProductEntity;
import com.pruebas.crud.service.IProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        List<ProductEntity> optionalProduct = productService.findAll();

        if (optionalProduct.isEmpty()) return ResponseEntity.notFound().build();

        List<ProductDTO> productDTOS = optionalProduct.stream()
                .map(productEntity -> ProductDTO.builder()
                        .id(productEntity.getId())
                        .name(productEntity.getName())
                        .price(productEntity.getPrice())
                        .maker(productEntity.getMaker()).build())
                .toList();
        return ResponseEntity.ok(productDTOS);
    }


    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<ProductEntity> optinalProduct = productService.findById(id);

        if (optinalProduct.isPresent()) {
            return ResponseEntity.ok(optinalProduct);
        }

        return ResponseEntity.notFound().build();
    }


    @PostMapping("/save")
    public ResponseEntity<?> save(@Valid @RequestBody ProductDTO productDTO) throws URISyntaxException {
        productService.save(
                ProductEntity.builder()
                        .name(productDTO.getName())
                        .price(productDTO.getPrice())
                        .maker(productDTO.getMaker())
                        .build());
        return ResponseEntity.created(new URI("/api/product/save")).build();
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<ProductEntity> optionaProduct = productService.findById(id);
        if (optionaProduct.isPresent()) {
            productService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody ProductDTO productDTO) {
        Optional<ProductEntity> optionalProduct = productService.findById(id);

        if (optionalProduct.isPresent()) {
            ProductEntity productEntity = optionalProduct.get();
            productEntity.setName(productDTO.getName());
            productEntity.setPrice(productDTO.getPrice());
            productEntity.setMaker(productDTO.getMaker());
            productService.save(productEntity);
            return ResponseEntity.ok("Registro actualizado");
        }
        return ResponseEntity.notFound().build();
    }


    @GetMapping("/between")
    public ResponseEntity<?> between(@RequestBody MinMaxDTO minMaxDTO) {
        List<ProductEntity> optionalProduct = productService.findByPriceInRange(minMaxDTO.getMinPrice(), minMaxDTO.getMaxPrice());
        if (optionalProduct.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(optionalProduct);
    }
}
