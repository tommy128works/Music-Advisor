import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class AuthServer {

    private HttpServer server;

    public AuthServer() {
        try {
            this.server = HttpServer.create();
            this.server.bind(new InetSocketAddress(8080), 0);
        } catch (IOException e) {
            System.err.println("IO error occurred: " + e.getMessage());
            e.printStackTrace(); // Optional: helpful for debugging
        }

        this.server.createContext("/",
                new HttpHandler() {
                    public void handle(HttpExchange exchange) throws IOException {
                        String hello = "hello, world";
                        exchange.sendResponseHeaders(200, hello.length());
                        exchange.getResponseBody().write(hello.getBytes());
                        exchange.getResponseBody().close();
                    }
                }
        );

        this.server.createContext("/callback",
                new HttpHandler() {
                    public void handle(HttpExchange exchange) throws IOException {
                        String query = exchange.getRequestURI().getQuery();
                        Map<String, String> queryMap = parseQuery(query);
                        String code = queryMap.get("code");
                        String message;
                        if (code != null) {
                            message = "Got the code. Return back to your program.";
                        } else {
                            message = "Authorization code not found. Try again.";
                        }
                        exchange.sendResponseHeaders(200, message.length());
                        exchange.getResponseBody().write(message.getBytes());
                        exchange.getResponseBody().close();
                        server.stop(1);
                    }
                }
        );

    }

    public void start() {
        this.server.start();
    }

    public void stop() {
        this.server.stop(1);
    }

    private static Map<String, String> parseQuery(String query) {
        Map<String, String> result = new HashMap<>();
        if (query == null || query.isEmpty()) return result;

        for (String param : query.split("&")) {
            String[] pair = param.split("=", 2);
            String key = URLDecoder.decode(pair[0], StandardCharsets.UTF_8);
            String value = pair.length > 1 ? URLDecoder.decode(pair[1], StandardCharsets.UTF_8) : "";
            result.put(key, value);
        }

        return result;
    }


}
