package com.pruebas.crud.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "productos")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre")
    private String name;
    @Column(name = "precio")
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "id_fabricante" , nullable = false)
    @JsonIgnore
    private MakerEntity maker;
}
