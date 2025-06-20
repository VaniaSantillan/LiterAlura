package com.aluracursos.LiterAlura;

import java.util.Scanner;

import com.aluracursos.LiterAlura.dto.LibroDTO;
import com.aluracursos.LiterAlura.dto.ResultadoDTO;
import com.aluracursos.LiterAlura.service.BookClient;

public class MenuConsola {

    public void iniciar() {
        Scanner teclado = new Scanner(System.in);
        BookClient cliente = new BookClient();

        System.out.print("📘 Escribe el título del libro a buscar: ");
        String titulo = teclado.nextLine();

        ResultadoDTO resultado = cliente.buscarLibros(titulo);

        if (resultado != null && !resultado.results().isEmpty()) {
            for (LibroDTO libro : resultado.results()) {
                System.out.println("\nTítulo: " + libro.titulo());
                System.out.println("Autor(es):");
                libro.autores().forEach(autor ->
                    System.out.println("   - " + autor.nombre() +
                        " (" + autor.nacimiento() + " - " + autor.fallecimiento() + ")")
                );
            }
        } else {
            System.out.println("No se encontraron resultados.");
        }
    }
}

