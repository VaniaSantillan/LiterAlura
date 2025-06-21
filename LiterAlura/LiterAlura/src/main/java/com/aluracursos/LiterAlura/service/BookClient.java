package com.aluracursos.LiterAlura.service;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

import com.aluracursos.LiterAlura.dto.ResultadoDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BookClient {
    private final HttpClient client;
    private final ObjectMapper mapper;

    public BookClient() {
        this.client = HttpClient.newHttpClient();
        this.mapper = new ObjectMapper();
    }

    public ResultadoDTO buscarLibros(String titulo) {
        // Codificación adecuada del título para la URL
        String url = "https://gutendex.com/books/?search=" + URLEncoder.encode(titulo, StandardCharsets.UTF_8);

        // Crear la solicitud HTTP GET
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        try {
            // Enviar la solicitud y obtener la respuesta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Verificar si la respuesta es exitosa
            if (response.statusCode() == 200) {
                return mapper.readValue(response.body(), ResultadoDTO.class);
            } else {
                // Manejo de errores HTTP, puedes lanzar una excepción o devolver un mensaje
                System.out.println("Error: código de estado " + response.statusCode());
                return null;  // O podrías retornar un ResultadoDTO vacío o con un error específico
            }

        } catch (IOException e) {
            System.out.println("Error de entrada/salida en la solicitud HTTP");
            e.printStackTrace();
        } catch (InterruptedException e) {
            System.out.println("La solicitud HTTP fue interrumpida");
            Thread.currentThread().interrupt();  // Restaurar el estado de interrupción
        }

        return null;
    }
}
