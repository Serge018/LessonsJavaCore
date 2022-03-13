package Lesson_03;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // Задание 1
        String[] array = { "str1", "str2", "str3" };
        int firstIndex = 0;
        int secondIndex = 4;

        try {
            changeArrayElements(array, firstIndex, secondIndex);
            System.out.println(Arrays.toString(array));
        } catch (ArrayIndexOutOfBoundsException error) {
            System.out.println("Передан некорректный индекс:\n" +
                "firstIndex : " + firstIndex + "\n" +
                "secondIndex : " + secondIndex + "\n" +
                "arrayLength : " + array.length);
        }
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
