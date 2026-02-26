package myOwnCode;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExternalApiPractice {
    public static void main(String[] args) {
        // 1. The URL of the API (Random Advice)
        String url = "https://api.adviceslip.com/advice";

        // 2. Create the Client
        HttpClient client = HttpClient.newHttpClient();

        // 3. Build the Request
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        // 4. Send the request and handle the response
        try {
            System.out.println("Fetching random advice...");

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Check if the request was successful (Status Code 200)
            if (response.statusCode() == 200) {
                System.out.println("--- API Response ---");
                System.out.println(response.body());
            } else {
                System.out.println("Error: Received status code " + response.statusCode());
            }

        } catch (Exception e) {
            System.err.println("An error occurred while calling the API: " + e.getMessage());
            e.printStackTrace();
        }
    }
}