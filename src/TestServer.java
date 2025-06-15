
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;
import java.io.IOException;

public class TestServer {
    private HttpServer server;

    public TestServer() {
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
    }

    public void start() {
        this.server.start();
    }

    public void stop() {
        this.server.stop(1);
    }

}
