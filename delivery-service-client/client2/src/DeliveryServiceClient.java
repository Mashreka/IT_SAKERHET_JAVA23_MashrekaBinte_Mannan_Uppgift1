import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class DeliveryServiceClient {

    private static final String BASE_URL = "http://localhost:8090/api/users";
    private static final HttpClient httpClient = HttpClient.newHttpClient();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Välj alternativ:");
            System.out.println("1. Skapa Konto");
            System.out.println("2. Visa Konto");
            System.out.println("3. Ta bort Konto");
            System.out.println("4. Avsluta");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1:
                    createUser(scanner);
                    break;
                case 2:
                    getUser(scanner);
                    break;
                case 3:
                    deleteUser(scanner);
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Ogiltigt val, försök igen.");
            }
        }
    }

    private static void createUser(Scanner scanner) {
        System.out.print("Användarnamn: ");
        String username = scanner.nextLine();
        System.out.print("Lösenord: ");
        String password = scanner.nextLine();
        System.out.print("E-post: ");
        String email = scanner.nextLine();

        String json = String.format("{\"username\":\"%s\", \"password\":\"%s\", \"email\":\"%s\"}", username, password, email);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/create"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                System.out.println("Konto skapat: " + response.body());
            } else if (response.statusCode() == 429) {
                System.out.println("För många förfrågningar. Försök igen senare.");
            } else {
                System.out.println("Fel vid skapande av konto: " + response.statusCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void getUser(Scanner scanner) {
        System.out.print("Ange användarnamn: ");
        String username = scanner.nextLine();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/" + username))
                .GET()
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                System.out.println("Kontoinformation: " + response.body());
            } else {
                System.out.println("Konto inte hittat: " + response.statusCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void deleteUser(Scanner scanner) {
        System.out.print("Ange användar-ID för att ta bort: ");
        long userId = scanner.nextLong();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/" + userId))
                .DELETE()
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                System.out.println("Konto borttaget.");
            } else {
                System.out.println("Fel vid borttagning av konto: " + response.statusCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
