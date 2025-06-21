package com.aluracursos.LiterAlura;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.aluracursos.LiterAlura.service.AutorService;
import com.aluracursos.LiterAlura.service.LibroService;


@SpringBootApplication
public class LiterAluraApplication {

    public static void main(String[] args) {
        SpringApplication.run(LiterAluraApplication.class, args);

    }

    @Bean
    public CommandLineRunner ejecutar(MenuConsola menu) {
        return args -> menu.iniciar();
    }

    @Bean
    public MenuConsola menu(LibroService libroService, AutorService autorService) {
        return new MenuConsola(libroService, autorService);
    }
}
