public class Main {
    public static void main(String[] args) {
        AppService service = new AppService();
        TextUI ui = new TextUI(service);
        ui.start();
    }
}
