package utilities;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class TeamsAlertUtility extends BaseUtility {
    public static void sendAlertOnTeamsChannel(String message) {
        try {
            String webhookUrl = System.getenv("WEBHOOK_URL");

            // Create proper JSON payload
            String payload = String.format("{\"text\": \"%s\"}", message.replace("\"", "\\\""));

            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(URI.create(webhookUrl))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(payload))
                    .build();

            HttpClient httpClient = HttpClient.newHttpClient();
            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            System.out.println("Teams Alert Response Code: " + httpResponse.statusCode());

        } catch (Exception e) {
            System.out.println("Failed to send the teams alert: " + e.getMessage());
        }
    }
}
