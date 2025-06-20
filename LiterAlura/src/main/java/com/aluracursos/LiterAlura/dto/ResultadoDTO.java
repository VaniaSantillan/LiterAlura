package com.aluracursos.LiterAlura.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ResultadoDTO(
    List<LibroDTO> results
) {}
