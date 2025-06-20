package com.aluracursos.LiterAlura.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

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
        String url = "https://gutendex.com/books/?search=" + titulo.replace(" ", "%20");

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                return mapper.readValue(response.body(), ResultadoDTO.class);
            } else {
                System.out.println("Error: código de estado " + response.statusCode());
            }

        } catch (IOException | InterruptedException e) {
            System.out.println(" Error al hacer la solicitud HTTP");
            e.printStackTrace();
        }

        return null;
    }
}

