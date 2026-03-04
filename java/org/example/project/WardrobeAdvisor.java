package org.example.project;

import java.util.Random;

public class WardrobeAdvisor {

    public static String getRecommendation(WeatherData weather) {
        String baseOutfit = "";
        double temp = weather.getTemperature();
        String condition = weather.getCondition().toLowerCase();

        // Control Flow
        if (temp < 10) {
            baseOutfit = "Heavy coat, scarf, and gloves.";
        } else if (temp >= 10 && temp < 20) {
            baseOutfit = "A light jacket or sweater.";
        } else {
            baseOutfit = "T-shirt and shorts.";
        }

        // conditional logic
        if (condition.contains("rain") || condition.contains("showers")) {
            baseOutfit += " Wear a waterproof jacket and carry an umbrella.";
        } else if (condition.contains("clear") && temp >= 15) {
            baseOutfit += " Grab some sunglasses!";
        }

        // Randomization & Loops
        String[] colors = {"Red", "Blue", "Green", "Black", "Yellow"};
        String chosenColor = "";

        // Loop
        for (int i = 0; i < colors.length; i++) {
            if (i == new Random().nextInt(colors.length)) {
                chosenColor = colors[i];
                break;
            }
        }

        // Fallback just in case the random loop misses
        if (chosenColor.isEmpty()) chosenColor = colors[0];

        return baseOutfit + "\n(Suggested accessory color: " + chosenColor + ")";
    }
}