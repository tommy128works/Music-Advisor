public class AppService {
    private boolean isAuthorized;
    private final String authLink;

    public AppService() {
        this.isAuthorized = false;

        String clientID = "0e7c212c5dce45fb91dd4dc33be57b30";
        String redirectURI = "http://127.0.0.1:8080/callback";

        this.authLink = "https://accounts.spotify.com/authorize?client_id="
                + clientID + "&redirect_uri=" + redirectURI
                + "&response_type=code";
    }

    public void setIsAuthorized(boolean value) {
        this.isAuthorized = value;
    }

    public boolean getIsAuthorized() {
        return this.isAuthorized;
    }

    public String getAuthLink() {
        return this.authLink;
    }
}
