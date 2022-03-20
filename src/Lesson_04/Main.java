package Lesson_04;

import java.util.HashMap;
import java.util.Map;


public class Main {

    public static void main(String[] args) {
        // Задание №1
        String[] words = getWords();
        // Вывод данных о количестве уникальных и повторяющихся словов
        printUnique(words);

        // Задание №2
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("8(928)846-93-12", "Анастасия Прокофьевна");
        phoneBook.add("8(921)347-20-71", "Вован");
        phoneBook.add("8(921)495-15-69", "Вован");
        phoneBook.add("8(911)552-11-34", "Ксюша секретарь");
        phoneBook.add("8(865)524-69-70", "Моя Алабама");
        phoneBook.add("8(800)203-09-00", "РосТелеком");
        phoneBook.add("8(800)100-08-00", "РосТелеком");
        phoneBook.add("8(800)707-12-12", "РосТелеком");
        phoneBook.add("+7(812)383-0-383", "Yami Yami");

        System.out.println(phoneBook.get("Вован"));
        System.out.println(phoneBook.get("РосТелеком"));
        System.out.println(phoneBook.get("Yami Yami"));
    }


    /*
    * Возвращает массив слов
    */
    static String[] getWords() {
        return new String[] {
            "клавиатура", "монитор", "гейпад",
            "Василий", "мышь", "слово",
            "мышь", "Полохутенко", "клавиатура",
            "красивое", "клавиатура", "молодчик"
        };
    }


    /*
    * Выводит данные о количестве уникальных и повторяющихся словов
    */
    static void printUnique(String[] words) {
        HashMap<String, Integer> wordsToCount = new HashMap<>();
        final int countStart = 1;

        for (String word : words) {
            if (wordsToCount.containsKey(word)) {
                int count = wordsToCount.get(word);
                wordsToCount.put(word, count + 1);
            } else {
                wordsToCount.put(word, countStart);
            }
        }

        System.out.println("Уникальные слова:");
        for (Map.Entry<String, Integer> wordEntry : wordsToCount.entrySet()) {
            if (wordEntry.getValue() == countStart) {
                System.out.println("- " + wordEntry.getKey());
            }
        }
        System.out.println("Повторяющиеся слова:");
        for (Map.Entry<String, Integer> wordEntry : wordsToCount.entrySet()) {
            if (wordEntry.getValue() > countStart) {
                System.out.println("- " + wordEntry.getKey() + " (" + wordEntry.getValue() + ")");
            }
        }
    }
}
