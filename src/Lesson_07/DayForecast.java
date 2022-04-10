package Lesson_07;

import javax.json.JsonObject;

/**
 * Содержит ответ от сервера с данными о погоде на день
 */
public class DayForecast {
    private final String date;
    private final double minimumTemperature;
    private final double maximumTemperature;
    private final String dayTextDescription;
    private final String nightTextDescription;

    public DayForecast(JsonObject jsonDayForecast) {
        date = jsonDayForecast.getString("date");

        minimumTemperature = jsonDayForecast
            .getJsonObject("parts")
            .getJsonObject("day")
            .getJsonNumber("temp_max")
            .doubleValue();

        maximumTemperature = jsonDayForecast
            .getJsonObject("parts")
            .getJsonObject("night")
            .getJsonNumber("temp_min")
            .doubleValue();

        dayTextDescription = jsonDayForecast
            .getJsonObject("parts")
            .getJsonObject("day_short")
            .getString("condition");

        nightTextDescription = jsonDayForecast
            .getJsonObject("parts")
            .getJsonObject("night_short")
            .getString("condition");
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("на дату " + date + " ожидается \n");
        stringBuilder.append("ТЕМПЕРАТУРА: \n");
        stringBuilder.append("минимальная: " + minimumTemperature + " C\n");
        stringBuilder.append("максимальная: " + maximumTemperature + " C\n");
        stringBuilder.append("ОБЛАЧНОСТЬ: \n");
        stringBuilder.append("днём: " + dayTextDescription + "\n");
        stringBuilder.append("ночью: " + nightTextDescription + "\n");

        return stringBuilder.toString();
    }
}
