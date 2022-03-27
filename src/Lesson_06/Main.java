package Lesson_06;

import java.net.MalformedURLException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;



public class Main {
    /*
    * Для предоставления данныз о погоде исползуется сервис Яндекс.Погода
    */
    private final static String WeatherURL =  "https://api.weather.yandex.ru/v2/forecast";
    private final static String coordinates = "lat=59.9339&lon=30.3061";
    private final static String lang = "lang=ru_RU";
    private final static String limit = "limit=5";
    private final static String header_yandex_api_key = "X-Yandex-API-Key";
    private final static String header_yandex_api_value = "919cf666-abe6-4a32-b6d5-87ffdc78cf8f";


    public static void main(String[] args) {
        try {
            // Получаем объект URL
            URL weatherUrl = getUrl();
            // Осуществляем запрос
            HttpURLConnection urlConnection = (HttpURLConnection) weatherUrl.openConnection();
            urlConnection.setRequestProperty(header_yandex_api_key, header_yandex_api_value);
            int responseCode = urlConnection.getResponseCode();

            System.out.println("response code: " + responseCode);
            if (responseCode == 200) {
                // производим чтение
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()))) {
                    StringBuilder data = getResponseData(reader);
                    System.out.println(data);
                } catch (IOException exception) {
                    System.out.println("Ошибка при попытке прочесть данные ответа!\n" + exception.getMessage());
                }
            }
        } catch (MalformedURLException exception) {
            System.out.println("Не удалось получить URL!\n" + exception.getMessage());
        } catch (IOException exception) {
            System.out.println("Ошибка при получении кода ответа!\n" + exception.getMessage());
        }
    }


    /*
    * Возвращает объект URL для обращения к api погоды по Санкт-Петербургу
    */
    private static URL getUrl() throws MalformedURLException {
        String url = WeatherURL+ "?" + coordinates + "&" + lang + "&" + limit + ";";
        URL weatherUrl = new URL(url);

        return weatherUrl;
    }


    /*
    * Возвращает данные ответа в виде строки
    */
    private static StringBuilder getResponseData(BufferedReader reader) throws IOException {
        StringBuilder responseContent = new StringBuilder();
        String line = "";
        while ((line = reader.readLine()) != null) {
            responseContent.append(line);
        }

        return responseContent;
    }
}
