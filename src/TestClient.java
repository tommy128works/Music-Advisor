import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class TestClient {
    private final HttpClient client;

    public TestClient() {
        this.client = HttpClient.newBuilder().build();
    }

    public void sendGETRequestTest() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080"))
                .GET()
                .build();

        try {
            HttpResponse<String> response = this.client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        } catch (InterruptedException e) {
            System.err.println("Interrupted error occurred: " + e.getMessage());
            e.printStackTrace(); // Optional: helpful for debugging
        } catch (IOException e) {
            System.err.println("IO error occurred: " + e.getMessage());
            e.printStackTrace(); // Optional: helpful for debugging
        }


    }



}
