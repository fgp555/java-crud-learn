import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class PingPongServer {

    public static void main(String[] args) throws IOException {
        // crear un servidor HTTP en el puerto 8080
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        // endpoint /ping
        server.createContext("/ping", new HttpHandler() {
            @Override
            public void handle(HttpExchange exchange) throws IOException {
                // imprime info del request (similar a console.log)
                System.out.println("Solicitud: " +
                        exchange.getRequestMethod() + " " + // método (GET, POST…)
                        exchange.getRequestURI()); // ruta solicitada

                String response = "pong";
                exchange.sendResponseHeaders(200, response.getBytes().length);
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            }
        });

        System.out.println("Servidor iniciado en http://localhost:8080/ping");
        server.start();
    }
}
