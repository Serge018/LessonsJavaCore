package Lesson_04;

import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class PhoneBook {
    /*
    * key - номер телефона
    * value - имя абонента
    */
    private final HashMap<String, String> catalog;


    public PhoneBook() {
        catalog = new HashMap<>();
    }


    /*
    * Добавляет данные абонента
    */
    public void add(String phone, String name) {
        catalog.put(phone, name);
    }


    /*
    * Возвращает номера телефонов абонентов с именем эквивалентным переданному
    */
    public ArrayList<String> get(String name) {
        ArrayList<String> result = new ArrayList<>();

        for (Map.Entry<String, String> catalogEntry : catalog.entrySet()) {
            if (catalogEntry.getValue().equals(name)) {
                result.add(catalogEntry.getKey());
            }
        }

        return result;
    }
}
