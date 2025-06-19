public class AppService {
    private boolean isAuthorized;
    private final String clientID;
    private final String redirectURI;
    private final String serverPath;

    public AppService() {
        this.isAuthorized = false;
        this.clientID = "0e7c212c5dce45fb91dd4dc33be57b30";
        this.redirectURI = "http://127.0.0.1:8080/callback";
        this.serverPath = "https://accounts.spotify.com";
    }

    public void setIsAuthorized(boolean value) {
        this.isAuthorized = value;
    }

    public boolean getIsAuthorized() {
        return this.isAuthorized;
    }

    public String getAuthLink() {
        return this.serverPath + "/authorize?client_id="
                + this.clientID + "&redirect_uri=" + this.redirectURI
                + "&response_type=code";
    }

    public String getRedirectURI() {
        return this.redirectURI;
    }
}
