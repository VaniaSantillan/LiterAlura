package com.aluracursos.LiterAlura.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aluracursos.LiterAlura.model.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {

    Optional<Autor> findByNombreAndAnioNacimiento(String nombre, Integer anioNacimiento);

    // Derived query para autores vivos en un año:
    List<Autor> findByAnioNacimientoLessThanEqualAndAnioFallecimientoGreaterThanOrAnioFallecimientoIsNull(Integer anio1, Integer anio2);
}
