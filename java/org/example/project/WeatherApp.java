package org.example.project;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class WeatherApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Main layout
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: #F0F2F5;");

        //Header
        HBox header = new HBox();
        header.setStyle("-fx-background-color: #2B3A4C;");
        header.setPrefHeight(60);
        header.setAlignment(Pos.CENTER);

        Label titleLabel = new Label("Smart Weather & Wardrobe Advisor");
        titleLabel.setTextFill(Color.WHITE);
        titleLabel.setFont(Font.font("SansSerif", FontWeight.BOLD, 20));
        header.getChildren().add(titleLabel);

        root.setTop(header);

        // Main content area
        VBox mainContent = new VBox(20);
        mainContent.setAlignment(Pos.TOP_CENTER);
        mainContent.setPadding(new Insets(30, 50, 30, 50));

        // Input Panel
        HBox inputBox = new HBox(10);
        inputBox.setAlignment(Pos.CENTER);

        TextField cityInput = new TextField("");
        cityInput.setFont(Font.font("SansSerif", 16));
        cityInput.setPrefWidth(250);

        Button searchButton = new Button("Get Recommendation");
        searchButton.setFont(Font.font("SansSerif", FontWeight.BOLD, 14));
        searchButton.setStyle("-fx-background-color: #3498DB; -fx-text-fill: white; -fx-cursor: hand;");

        inputBox.getChildren().addAll(cityInput, searchButton);

        // Weather Card
        VBox weatherCard = new VBox(10);
        weatherCard.setAlignment(Pos.CENTER);
        weatherCard.setMaxWidth(450);
        weatherCard.setPadding(new Insets(30));
        weatherCard.setStyle("-fx-background-color: white; -fx-background-radius: 8; " +
                             "-fx-border-color: #E0E0E0; -fx-border-radius: 8; -fx-border-width: 1;");

        Label iconLabel = new Label(""); // Cloud Unicode
        iconLabel.setFont(Font.font("SansSerif", 75));

        Label cityLabel = new Label("Waiting input");
        cityLabel.setFont(Font.font("SansSerif", FontWeight.BOLD, 32));

        Label conditionLabel = new Label("");
        conditionLabel.setFont(Font.font("SansSerif", 18));
        conditionLabel.setTextFill(Color.web("#666666"));

        weatherCard.getChildren().addAll(iconLabel, cityLabel, conditionLabel);

        // Recommendation Card
        VBox recCard = new VBox(10);
        recCard.setAlignment(Pos.CENTER);
        recCard.setMaxWidth(450);
        recCard.setPadding(new Insets(20));
        recCard.setStyle("-fx-background-color: white; -fx-background-radius: 8; " +
                         "-fx-border-color: #E0E0E0; -fx-border-radius: 8; -fx-border-width: 1;");

        Label recTitle = new Label("Wardrobe Recommendation:");
        recTitle.setFont(Font.font("SansSerif", FontWeight.BOLD, 14));

        Label recText = new Label("Awaiting search...");
        recText.setFont(Font.font("SansSerif", 14));
        recText.setWrapText(true); // JavaFX handles text wrapping beautifully!
        recText.setTextAlignment(TextAlignment.CENTER);

        recCard.getChildren().addAll(recTitle, recText);

        mainContent.getChildren().addAll(inputBox, weatherCard, recCard);
        root.setCenter(mainContent);

        //Event handler
        searchButton.setOnAction(e -> {
            String city = cityInput.getText().trim();
            if (city.isEmpty()) return;

            try {
                WeatherData weather = WeatherService.fetchWeather(city);
                String advice = WardrobeAdvisor.getRecommendation(weather);

                iconLabel.setText(getWeatherIcon(weather.getCondition()));
                cityLabel.setText(weather.getCityName());
                conditionLabel.setText(String.format("%s | %.1f°C", weather.getCondition(), weather.getTemperature()));
                recText.setText(advice);

            } catch (Exception ex) {
                iconLabel.setText("\u2716"); // X symbol
                cityLabel.setText("Error");
                conditionLabel.setText("City not found or API down.");
                recText.setText("N/A");
            }
        });

        //Show window
        Scene scene = new Scene(root, 600, 550);
        primaryStage.setTitle("Smart Weather & Wardrobe Advisor");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private String getWeatherIcon(String condition) {
        condition = condition.toLowerCase();
        if (condition.contains("clear")) return "\u2600";
        if (condition.contains("cloud")) return "\u2601";
        if (condition.contains("rain") || condition.contains("showers")) return "\u2602";
        if (condition.contains("snow")) return "\u2744";
        if (condition.contains("thunder")) return "\u26A1";
        return "\u26AA";
    }

    public static void main(String[] args) {
        launch(args);
    }
}