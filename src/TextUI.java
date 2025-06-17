import java.io.IOException;
import java.util.Scanner;

public class TextUI {
    private final Scanner scanner;
    private final AppService service;
//    private final TestServer server;
//    private final TestClient client;
    private final AuthServer server;
    private final AuthClient client;

    public TextUI(AppService service) {
        this.scanner = new Scanner(System.in);
        this.service = service;
//        this.server = new TestServer();
//        this.client = new TestClient();
        this.server = new AuthServer();
        this.client = new AuthClient();
    }

    public void start() {
//        this.server.start();
//        this.client.sendGETRequestTest();
//        this.server.stop();


        // loop until program ends
        while (true) {
            String request = this.inputRequest();
            this.processRequest(request);
            if (request.equals("exit")) {
                break;
            }
        }

    }

    public String inputRequest() {
        return this.scanner.nextLine();
    }

    public void processRequest(String request) {
        if (request.equals("exit")) {
            System.out.println("---GOODBYE!---");
            return;
        } else if (!this.service.getIsAuthorized()) {
            if (request.equals("auth")) {
                this.server.start();

                this.service.setIsAuthorized(true);
                System.out.println(this.service.getAuthLink());


                System.out.println("---SUCCESS---");
            } else {
                System.out.println("Please, provide access for application.");
            }
            return;
        }

        // future - these cases should call a service method to process it
        switch (request) {
            case "new":
                System.out.println("---NEW RELEASES---");
                System.out.println("Mountains [Sia, Diplo, Labrinth]");
                System.out.println("Runaway [Lil Peep]");
                System.out.println("The Greatest Show [Panic! At The Disco]");
                System.out.println("All Out Life [Slipknot]");
                break;
            case "featured":
                System.out.println("---FEATURED---");
                System.out.println("Mellow Morning");
                System.out.println("Wake Up and Smell the Coffee");
                System.out.println("Monday Motivation");
                System.out.println("Songs to Sing in the Shower");
                break;
            case "categories":
                System.out.println("---CATEGORIES---");
                System.out.println("Top Lists");
                System.out.println("Pop");
                System.out.println("Mood");
                System.out.println("Latin");
                break;
            case "playlists Mood":
                System.out.println("---MOOD PLAYLISTS---");
                System.out.println("Walk Like A Badass ");
                System.out.println("Rage Beats");
                System.out.println("Arab Mood Booster");
                System.out.println("Sunday Stroll");
                break;
            default:
                System.out.println("No cases found");
        }
    }

}
