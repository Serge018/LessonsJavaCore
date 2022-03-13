package Lesson_03.fruits;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private ArrayList<T> fruits;

    public Box(ArrayList<T> fruits) {
        this.fruits = fruits;
    }

    /*
    * Возвращает вес фруктов в ящике
    */
    public float getWeight() {
        float result = 0;

        for (T fruit : fruits) {
            result += fruit.weight;
        }

        return result;
    }

    /*
    * Добавление фрукта
    */
    public void append(T fruit) {
        fruits.add(fruit);
    }
}