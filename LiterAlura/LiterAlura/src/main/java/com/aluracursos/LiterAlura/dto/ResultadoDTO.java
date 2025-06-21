package com.aluracursos.LiterAlura.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true) 
public class ResultadoDTO {

    private List<LibroDTO> results;

    public ResultadoDTO() {
    }

    public List<LibroDTO> getResults() {
        return results;
    }

    public void setResults(List<LibroDTO> results) {
        this.results = results;
    }
    
    @Override
    public String toString() {
        return "ResultadoDTO{" +
               "results=" + results +
               '}';
    }
}