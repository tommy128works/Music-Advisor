import java.net.http.HttpClient;

public class AuthClient {
    private final HttpClient client;

    public AuthClient() {
        this.client = HttpClient.newBuilder().build();
    }

    public void getAccessToken() {


    }

}
