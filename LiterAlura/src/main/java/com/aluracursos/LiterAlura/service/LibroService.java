package com.aluracursos.LiterAlura.service;

import java.util.*;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.aluracursos.LiterAlura.dto.LibroDTO;
import com.aluracursos.LiterAlura.dto.AutorDTO;
import com.aluracursos.LiterAlura.model.Autor;
import com.aluracursos.LiterAlura.model.Libro;
import com.aluracursos.LiterAlura.repository.LibroRepository;

@Service
public class LibroService {

    private final LibroRepository repository;
    private final AutorService autorService;

    public LibroService(LibroRepository libroRepository, AutorService autorService) {
        this.repository = libroRepository;
        this.autorService = autorService;
    }

    public void guardarLibro(LibroDTO dto) {
        if (!dto.getIdiomas().isEmpty() && !dto.getAutores().isEmpty()) {
            AutorDTO autorDTO = dto.getAutores().get(0);
            Autor autor = autorService
                .buscarPorNombreYNacimiento(autorDTO.nombre(), autorDTO.nacimiento())
                .orElseGet(() -> autorService.guardar(new Autor(
                        autorDTO.nombre(), autorDTO.nacimiento(), autorDTO.fallecimiento())));

            Libro libro = new Libro(
                dto.getTitulo(),
                dto.getIdiomas().get(0),
                dto.getDescargas(),
                autor
            );

            repository.save(libro);
        }
    }

    public List<Libro> obtenerTodos() { return repository.findAll(); }
    public List<Libro> buscarPorIdioma(String idioma) { return repository.findByIdioma(idioma); }
    public long contarLibrosPorIdioma(String idioma) { return repository.countByIdioma(idioma); }

    public Map<String, Long> contarLibrosPorCadaIdioma() {
        return repository.findAll().stream()
            .collect(Collectors.groupingBy(Libro::getIdioma, Collectors.counting()));
    }
}