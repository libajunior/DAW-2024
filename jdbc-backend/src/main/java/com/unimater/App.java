package com.unimater;

import com.sun.net.httpserver.HttpServer;
import com.unimater.controller.HelloWorldHandler;
import com.unimater.controller.ImovelHandler;
import com.unimater.controller.TipoImovelHandler;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {
    public static void main( String[] args ){


        try {
            HttpServer servidor = HttpServer.create(
                    new InetSocketAddress(8080),0
            );

            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/dawdb", "root", "root"
            );

            servidor.createContext("/helloWorld",
                    new HelloWorldHandler());

            servidor.createContext("/tipoImoveis",
                    new TipoImovelHandler(connection));

            servidor.createContext("/imoveis",
                    new ImovelHandler(connection));

            servidor.setExecutor(null);
            servidor.start();
            System.out.println("Servidor rodando na porta 8080");

        } catch (IOException e) {
            System.out.println(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
