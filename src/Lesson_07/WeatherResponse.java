package Lesson_07;


import javax.json.JsonObject;


public class WeatherResponse {
    private final double currentTemp;
    private final double currentTempFeelsLike;
    private final String cityName;

    public WeatherResponse(String cityName, JsonObject jsonObject) {
        this.cityName = cityName;

        // Погода на текущий момент
        JsonObject fact = jsonObject.getJsonObject("fact");
        currentTemp = fact.getJsonNumber("temp").doubleValue();
        currentTempFeelsLike = fact.getJsonNumber("feels_like").doubleValue();
    }


    /*
    * Отображает данные о погоде на текущий момент
    */
    public void printCurrentWeather() {
        System.out.println("Погода в городе " + cityName + " на данный момент");
        System.out.println("Температура (цельсия): " + currentTemp);
        System.out.println("Ощущается как: " + currentTempFeelsLike);
    }
}
