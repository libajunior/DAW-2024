package com.unimater.controller;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.unimater.dao.TipoImovelDAO;
import com.unimater.model.TipoImovel;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.util.List;

public class TipoImovelHandler implements HttpHandler {

    private TipoImovelDAO tipoImovelDAO;
    private Connection connection;

    public TipoImovelHandler(Connection connection) {
        this.connection = connection;
    }

    private Gson gson = new Gson();

    public void handle(HttpExchange exchange) throws IOException {
        tipoImovelDAO = new TipoImovelDAO(connection);

        if (isGet(exchange)) {
            handleGet(exchange);
        } else if (isPost(exchange)) {
            handlePost(exchange);
        } else if (isPut(exchange)) {
            handlePut(exchange);
        } else if (isDelete(exchange)) {
            handleDelete(exchange);
        } else {
            exchange.sendResponseHeaders(405, -1);
        }
    }

    private void handleGet(HttpExchange exchange) throws IOException {
        String[] segments = segmentPath(exchange);

        if (segments.length == 2) {
            // Obter todos os itens
            try {
                List<TipoImovel> tipoImoveis = tipoImovelDAO.getAll();
                String jsonResponse = gson.toJson(tipoImoveis);
                exchange.getResponseHeaders().add("Content-Type", "application/json");
                exchange.sendResponseHeaders(200, jsonResponse.getBytes().length);
                sendOutputJson(exchange, jsonResponse);
            } catch (Exception e) {
                exchange.sendResponseHeaders(500, -1);
            }
        } else if (segments.length > 2) {
            try {
                int id = Integer.parseInt(segments[2]);
                TipoImovel tipoImovel = tipoImovelDAO.getById(id);
                if (tipoImovel != null) {
                    String jsonResponse = gson.toJson(tipoImovel);
                    exchange.getResponseHeaders().add("Content-Type", "application/json");
                    exchange.sendResponseHeaders(200, jsonResponse.getBytes().length);
                    sendOutputJson(exchange, jsonResponse);
                } else {
                    exchange.sendResponseHeaders(404, -1); // Not Found
                }
            } catch (NumberFormatException e) {
                exchange.sendResponseHeaders(400, -1); // Bad Request
            }
        } else {
            exchange.sendResponseHeaders(404, -1); // Not Found
        }
    }

    private void handlePost(HttpExchange exchange) throws IOException {
        TipoImovel tipoImovel = parseRequestBody(exchange, TipoImovel.class);
        if (tipoImovel != null && tipoImovel.getId() == 0) {
            tipoImovelDAO.upsert(tipoImovel);
            exchange.sendResponseHeaders(201, -1); // Created
        } else {
            exchange.sendResponseHeaders(400, -1); // Bad Request
        }
    }

    private void handlePut(HttpExchange exchange) throws IOException {
        TipoImovel tipoImovel = parseRequestBody(exchange, TipoImovel.class);
        if (tipoImovel != null && tipoImovel.getId() > 0) {
            tipoImovelDAO.upsert(tipoImovel);
            exchange.sendResponseHeaders(200, -1); // OK
        } else {
            exchange.sendResponseHeaders(400, -1); // Bad Request
        }
    }

    private void handleDelete(HttpExchange exchange) throws IOException {
        String[] segments = segmentPath(exchange);
        if (segments.length > 2) {
            try {
                int id = Integer.parseInt(segments[2]);
                tipoImovelDAO.delete(id);
                exchange.sendResponseHeaders(204, -1); // No Content
            } catch (NumberFormatException e) {
                exchange.sendResponseHeaders(400, -1); // Bad Request
            }
        } else {
            exchange.sendResponseHeaders(404, -1); // Not Found
        }
    }

    private <T> T parseRequestBody(HttpExchange exchange, Class<T> clazz) throws IOException {
        InputStreamReader reader = new InputStreamReader(exchange.getRequestBody(), StandardCharsets.UTF_8);
        return gson.fromJson(reader, clazz);
    }

    private static void sendOutputJson(HttpExchange exchange, String jsonResponse) throws IOException {
        OutputStream output = exchange.getResponseBody();
        output.write(jsonResponse.getBytes());
        output.flush();
        output.close();
    }

    private static String[] segmentPath(HttpExchange exchange) {
        String path = exchange.getRequestURI().getPath();
        String[] segments = path.split("/");
        return segments;
    }

    private static boolean isGet(HttpExchange exchange) {
        return exchange.getRequestMethod().equals("GET");
    }

    private static boolean isPost(HttpExchange exchange) {
        return exchange.getRequestMethod().equals("POST");
    }

    private static boolean isPut(HttpExchange exchange) {
        return exchange.getRequestMethod().equals("PUT");
    }

    private static boolean isDelete(HttpExchange exchange) {
        return exchange.getRequestMethod().equals("DELETE");
    }
}
