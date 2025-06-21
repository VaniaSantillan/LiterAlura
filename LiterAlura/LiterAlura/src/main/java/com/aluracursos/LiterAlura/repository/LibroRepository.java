package com.aluracursos.LiterAlura.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aluracursos.LiterAlura.model.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long> {
    long countByIdioma(String idioma);
    List<Libro> findByIdioma(String idioma);
}
