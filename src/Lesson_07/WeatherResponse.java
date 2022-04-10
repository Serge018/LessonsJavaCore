package Lesson_07;


import javax.json.JsonObject;
import javax.json.JsonArray;


public class WeatherResponse {
    private final String cityName;
    private final double currentTemp;
    private final double currentTempFeelsLike;
    private final DayForecast[] dayForecasts;

    public WeatherResponse(String cityName, JsonObject jsonObject) {
        this.cityName = cityName;

        // Погода на текущий момент
        JsonObject fact = jsonObject.getJsonObject("fact");
        currentTemp = fact.getJsonNumber("temp").doubleValue();
        currentTempFeelsLike = fact.getJsonNumber("feels_like").doubleValue();

        // Данные о погоде на предстоящие пять дней
        JsonArray jsonDayForecastsArray = jsonObject.getJsonArray("forecasts");
        dayForecasts = new DayForecast[jsonDayForecastsArray.size()];

        for (int dayCount = 0; dayCount < dayForecasts.length; dayCount++) {
            JsonObject jsonForecast = jsonDayForecastsArray.getJsonObject(dayCount);

            DayForecast dailyForecast = new DayForecast(jsonForecast);
            dayForecasts[dayCount] = dailyForecast;
        }
    }


    /*
    * Отображает данные о погоде на текущий момент
    */
    public void printCurrentWeather() {
        System.out.println("Погода в городе " + cityName + " на данный момент");
        System.out.println("Температура : " + currentTemp + "C");
        System.out.println("Ощущается как: " + currentTempFeelsLike + "C\n");
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (DayForecast dayForecasts : dayForecasts) {
            stringBuilder.append("В городе " + cityName + "\n");
            stringBuilder.append(dayForecasts.toString() + "\n");
        }

        return stringBuilder.toString();
    }
}
