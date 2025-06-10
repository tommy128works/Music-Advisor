public class AppService {
    private boolean isAuthorized;

    public AppService() {
        this.isAuthorized = false;
    }

    public void setIsAuthorized(boolean value) {
        this.isAuthorized = value;
    }

    public boolean getIsAuthorized() {
        return this.isAuthorized;
    }
}
