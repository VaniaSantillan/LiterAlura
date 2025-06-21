package com.aluracursos.LiterAlura.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.aluracursos.LiterAlura.model.Autor;
import com.aluracursos.LiterAlura.repository.AutorRepository;

@Service
public class AutorService {

    private final AutorRepository repository;

    public AutorService(AutorRepository repository) {
        this.repository = repository;
    }

    public Optional<Autor> buscarPorNombreYNacimiento(String nombre, Integer nacimiento) {
        return repository.findByNombreAndAnioNacimiento(nombre, nacimiento);
    }

    public List<Autor> listarAutores() {
        return repository.findAll();
    }

    // Nuevo método para obtener autores vivos en año dado con derived query
    public List<Autor> buscarVivosEn(Integer anio) {
        return repository.findByAnioNacimientoLessThanEqualAndAnioFallecimientoGreaterThanOrAnioFallecimientoIsNull(anio, anio);
    }

    public Autor guardar(Autor autor) {
        return repository.save(autor);
    }
}
