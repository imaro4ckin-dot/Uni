package org.example.project;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WeatherService {

    public static WeatherData fetchWeather(String city) throws Exception {
        HttpClient client = HttpClient.newHttpClient();

        // Geocoding API (Convert City Name to Latitude/Longitude)
        String geoUrl = "https://geocoding-api.open-meteo.com/v1/search?name="
                        + city.replace(" ", "%20") + "&count=1&format=json";

        HttpRequest geoRequest = HttpRequest.newBuilder().uri(URI.create(geoUrl)).GET().build();
        HttpResponse<String> geoResponse = client.send(geoRequest, HttpResponse.BodyHandlers.ofString());
        String geoJson = geoResponse.body();

        if (!geoJson.contains("\"latitude\"")) {
            throw new Exception("City not found in database.");
        }

        double lat = extractDouble(geoJson, "\"latitude\":([-0-9.]+)");
        double lon = extractDouble(geoJson, "\"longitude\":([-0-9.]+)");

        //  Forecast API (Fetch weather using the Coordinates)
        String weatherUrl = "https://api.open-meteo.com/v1/forecast?latitude=" + lat
                            + "&longitude=" + lon + "&current_weather=true";

        HttpRequest weatherRequest = HttpRequest.newBuilder().uri(URI.create(weatherUrl)).GET().build();
        HttpResponse<String> weatherResponse = client.send(weatherRequest, HttpResponse.BodyHandlers.ofString());
        String weatherJson = weatherResponse.body();

        double temp = extractDouble(weatherJson, "\"temperature\":([-0-9.]+)");
        int weatherCode = (int) extractDouble(weatherJson, "\"weathercode\":([0-9]+)");

        String condition = mapWeatherCode(weatherCode);

        return new WeatherData(city, temp, condition);
    }

    // Extracts a number from JSON using Regex
    private static double extractDouble(String json, String regex) {
        Matcher matcher = Pattern.compile(regex).matcher(json);
        if (matcher.find()) {
            return Double.parseDouble(matcher.group(1));
        }
        return 0.0;
    }

    // Maps Open-Meteo WMO codes to text
    private static String mapWeatherCode(int code) {
        if (code == 0) return "Clear";
        if (code >= 1 && code <= 3) return "Cloudy";
        if (code >= 51 && code <= 67) return "Rain";
        if (code >= 71 && code <= 77) return "Snow";
        if (code >= 95) return "Thunderstorm";
        return "Unknown";
    }
}