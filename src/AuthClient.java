import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Base64;

public class AuthClient {
    private final HttpClient client;
    private final String clientID;
    private final String clientSecret;

    public AuthClient() {
        this.client = HttpClient.newBuilder().build();
        this.clientID = "0e7c212c5dce45fb91dd4dc33be57b30";
        this.clientSecret = "9e61b7d69d3f47caa437c4cadf816208";
    }

    public void getAccessToken(String redirectURI) {
        String auth = this.clientID + ":" + clientSecret;
        String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes());

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://accounts.spotify.com/api/token"))
                .header("Authorization", "Basic " + encodedAuth)
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString("grant_type=authorization_code"))
                .build();

        try {
            HttpResponse<String> response = this.client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Response: " + response.body());
        } catch (Exception e) {
            System.err.println("Exception occurred: " + e.getMessage());
            e.printStackTrace(); // Optional: helpful for debugging
        }
    }

}
