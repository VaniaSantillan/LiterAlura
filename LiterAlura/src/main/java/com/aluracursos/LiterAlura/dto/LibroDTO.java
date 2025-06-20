package com.aluracursos.LiterAlura.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record LibroDTO(
    @JsonAlias("id") int id,
    @JsonAlias("title") String titulo,
    @JsonAlias("authors") List<AutorDTO> autores
) {}
