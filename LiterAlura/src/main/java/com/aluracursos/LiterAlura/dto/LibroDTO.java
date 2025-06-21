package com.aluracursos.LiterAlura.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LibroDTO {

    @JsonAlias("title")
    private String titulo;

    @JsonAlias("authors")
    private List<AutorDTO> autores;

    @JsonAlias("languages")
    private List<String> idiomas;

    @JsonAlias("download_count")
    private Integer descargas;

    public String getTitulo() {
        return titulo;
    }

    public List<AutorDTO> getAutores() {
        return autores;
    }

    public List<String> getIdiomas() {
        return idiomas;
    }

    public Integer getDescargas() {
        return descargas != null ? descargas : 0;
    }

    @Override
    public String toString() {
        return "Título: " + titulo +
               "\nAutor: " + (autores == null || autores.isEmpty() ? "Desconocido" : autores.get(0).nombre()) +
               "\nIdioma: " + (idiomas == null || idiomas.isEmpty() ? "Desconocido" : idiomas.get(0)) +
               "\nDescargas: " + getDescargas();
    }
}
