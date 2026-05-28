package org.example.project;

public class WeatherData {
    private double temperature;
    private String condition;
    private String cityName;

    public WeatherData(String cityName, double temperature, String condition) {
        this.cityName = cityName;
        this.temperature = temperature;
        this.condition = condition;
    }

    public double getTemperature() { return temperature; }
    public String getCondition() { return condition; }
    public String getCityName() { return cityName; }
}
