package Lesson_03;

import java.util.ArrayList;
import java.util.Arrays;

import Lesson_03.fruits.Orange;
import Lesson_03.fruits.Apple;
import Lesson_03.fruits.Box;

public class Main {

    public static void main(String[] args) {
        // Задание 1
        String[] array = { "str1", "str2", "str3" };
        int firstIndex = 0;
        int secondIndex = 1;

        try {
            changeArrayElements(array, firstIndex, secondIndex);
            System.out.println(Arrays.toString(array));
        } catch (ArrayIndexOutOfBoundsException error) {
            System.out.println("Передан некорректный индекс:\n" +
                "firstIndex : " + firstIndex + "\n" +
                "secondIndex : " + secondIndex + "\n" +
                "arrayLength : " + array.length);
        }

        // Задание 2
        Box<Apple> appleBox = new Box<>(createApples(5));
        Box<Apple> anotherAppleBox = new Box<>(createApples(0));
        Box<Orange> orangeBox = new Box<>(createOrange(10));

        // appleBox.transferTo(anotherAppleBox);
        appleBox.compare(anotherAppleBox);

        // appleBox.compare(orangeBox);
        // orangeBox.compare(appleBox);
        // appleBox.transferTo(orangeBox); // генерирует ошибку компеляции
    }


    /*
    * Возвращает набор яблок
    */
    private static ArrayList<Apple> createApples(int count) {
        ArrayList<Apple> fruits = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            fruits.add(new Apple());
        }

        return fruits;
    }


    /*
    * Возвращает набор ананасов
    */
    private static ArrayList<Orange> createOrange(int count) {
        ArrayList<Orange> fruits = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            fruits.add(new Orange());
        }
        return fruits;
    }


    /*
    * Меняет местами элементы в массиве по переданным индексам
    */
     public static <T>void changeArrayElements(T[] array, int firstIndex, int secondIndex) throws ArrayIndexOutOfBoundsException {
        T element = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = element;
    }
}
