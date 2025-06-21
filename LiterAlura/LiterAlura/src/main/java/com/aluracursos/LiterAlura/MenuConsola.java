package com.aluracursos.LiterAlura;

import java.util.Scanner;

import com.aluracursos.LiterAlura.dto.LibroDTO;
import com.aluracursos.LiterAlura.dto.ResultadoDTO;
import com.aluracursos.LiterAlura.service.AutorService;
import com.aluracursos.LiterAlura.service.BookClient;
import com.aluracursos.LiterAlura.service.LibroService;

public class MenuConsola {

    private final LibroService libroService;
    private final AutorService autorService;
    private final Scanner teclado = new Scanner(System.in);
    private final BookClient cliente = new BookClient();
    


    public MenuConsola(LibroService libroService, AutorService autorService) {
        this.libroService = libroService;
        this.autorService = autorService;
    }

    public void iniciar() {
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("""
                \n--- MENÚ PRINCIPAL ---
                1 - Buscar libro por título
                2 - Listar libros almacenados
                3 - Buscar libros por idioma
                4 - Listar autores
                5 - Buscar autores vivos en un año
                0 - Salir
                """);

            System.out.print("Ingresa una opción: ");
            opcion = Integer.parseInt(teclado.nextLine());

            switch (opcion) {
                case 1 -> buscarLibro();
                case 2 -> listarLibros();
                case 3 -> buscarPorIdioma();
                case 4 -> listarAutores();
                case 5 -> autoresVivosEnAnio();
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida");
            }
        }
    }

    private void buscarLibro() {
        System.out.print("Ingresa el título del libro: ");
        String titulo = teclado.nextLine();
        ResultadoDTO resultado = cliente.buscarLibros(titulo);

        if (resultado != null && !resultado.getResults().isEmpty()) {
            LibroDTO dto = resultado.getResults().get(0);
            System.out.println(dto);
            libroService.guardarLibro(dto);
        } else {
            System.out.println("No se encontraron resultados.");
        }
    }

    private void listarLibros() {
        var libros = libroService.obtenerTodos();
        libros.forEach(System.out::println);
    }

    private void buscarPorIdioma() {
        System.out.print(" Ingresa el idioma (ej. 'en', 'es', 'fr'): ");
        String idioma = teclado.nextLine();
        var libros = libroService.buscarPorIdioma(idioma);
        if (libros.isEmpty()) {
            System.out.println("No hay libros en ese idioma.");
        } else {
            libros.forEach(System.out::println);
        }
    }

    private void listarAutores() {
        var autores = autorService.listarAutores();
        if (autores.isEmpty()) {
            System.out.println("No hay autores almacenados.");
        } else {
            autores.forEach(System.out::println);
        }
    }

    private void autoresVivosEnAnio() {
    System.out.print("Ingresa el año para consultar: ");
    String entrada = teclado.nextLine();

    try {
        int anio = Integer.parseInt(entrada);
        if (anio < 0) {
            System.out.println("El año no puede ser negativo.");
            return;
        }
        var vivos = autorService.buscarVivosEn(anio);
        if (vivos.isEmpty()) {
            System.out.println("No hay autores vivos en ese año.");
        } else {
            vivos.forEach(System.out::println);
        }
    } catch (NumberFormatException e) {
        System.out.println("Entrada inválida. Por favor ingresa un número válido para el año.");
    }
}

}


