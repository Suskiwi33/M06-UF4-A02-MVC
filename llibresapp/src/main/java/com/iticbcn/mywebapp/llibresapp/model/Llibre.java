package com.iticbcn.mywebapp.llibresapp.model;

import lombok.*;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "llibre")
public class Llibre{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLlibre;

    @Column
    private String titol;

    @Column
    private String autor;

    @Column
    private String editorial;

    @Column
    private LocalDate datapublicacio;

    @Column
    private String tematica;

    @Column(unique = true, nullable = false)
    private String isbn;
    
}