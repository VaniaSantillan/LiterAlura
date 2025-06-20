package com.aluracursos.LiterAlura;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.aluracursos.LiterAlura.dto.ResultadoDTO;
import com.aluracursos.LiterAlura.service.BookClient;

@SpringBootApplication
public class LiterAluraApplication {

    public static void main(String[] args) {
        SpringApplication.run(LiterAluraApplication.class, args);

        BookClient client = new BookClient();
        ResultadoDTO resultado = client.buscarLibros("Frankenstein");

        if (resultado != null) {
            resultado.results().forEach(System.out::println);
        }
    }
}
