package Lesson_02;

import java.util.Random;

public class Main {
    private static Random random = new Random();

    public static void main(String[] args) {

        String[][] array = createTwoDimensionalStringArray(4);
        // addNotConvertedToIntegerElement(array); // добавляет элемент, который нельзя привести к числу

        try {
            int sum = calculateSum(array, 4);
            System.out.println("Сумма всех элементов : " + sum);
        } catch(MyArraySizeException e) {
            System.out.println("Некорректная длинна массива");
        } catch (MyArrayDataException e) {
            System.out.println("Не удалось расчитать сумму всех элементов массива");
        }
    }


    private static int calculateSum(String[][] array, int expectedLengthArray) throws MyArraySizeException, MyArrayDataException {
        checkLength(array, expectedLengthArray);

        int sum = 0;
        for (String[] includedArray : array) {
            for (String element : includedArray) {
                try {
                    sum += Integer.valueOf(element);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException();
                }
            }
        }

        return sum;
    }


    private static boolean checkLength(String[][] array, int expectedLengthArray) throws MyArraySizeException {
        // проверяем длину основного массива
        if (array.length != expectedLengthArray)
        {
            throw new MyArraySizeException();
        }

        // проверяем длину всех вложенных массивов
        boolean result = true;
        for (String[] includedArray : array) {
            if (includedArray.length != expectedLengthArray) {
                result = false;
                break;
            }
        }
        if (!result) {
            throw new MyArraySizeException();
        }

        return true;
    }


    private static String[][] createTwoDimensionalStringArray(int length) {
         String[][] array = new String[length][length];

         for (int i = 0; i < array.length; i++) {
             String[] includedArray = array[i];
             for (int j = 0; j < includedArray.length; j++) {
                includedArray[j] = String.valueOf(random.nextInt());
            }
        }

         return array;
    }


    private static void addNotConvertedToIntegerElement(String[][] array) {
        int length = array.length;
        int randomInteger = random.nextInt(length);

        array[randomInteger][randomInteger] = "notConvertedStringToInteger";
    }
}