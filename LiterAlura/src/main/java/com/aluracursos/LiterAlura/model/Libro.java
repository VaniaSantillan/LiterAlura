package com.aluracursos.LiterAlura.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String idioma;
    private Integer numeroDeDescargas;

    @ManyToOne(cascade = CascadeType.ALL)
    private Autor autor;

    public Libro() {}

    public Libro(String titulo, String idioma, Integer numeroDeDescargas, Autor autor) {
        this.titulo = titulo;
        this.idioma = idioma;
        this.numeroDeDescargas = numeroDeDescargas;
        this.autor = autor;
    }

    public Long getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getIdioma() { return idioma; }
    public Integer getNumeroDeDescargas() { return numeroDeDescargas; }
    public Autor getAutor() { return autor; }

    @Override
    public String toString() {
        return "Libro: " + titulo +
               ", Idioma: " + idioma +
               ", Descargas: " + numeroDeDescargas +
               ", Autor: " + (autor != null ? autor.getNombre() : "Desconocido");
    }
}
