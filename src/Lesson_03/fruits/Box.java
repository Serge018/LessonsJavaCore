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

    /*
    * Сравнивает вес коробок
    */
    public void compare(Box<?> another) {

        float incomingFruitsWeight = another.getWeight();
        float currentFruitsWeight = getWeight();

        if (currentFruitsWeight > incomingFruitsWeight) {
            System.out.println("Текущая коробка тяжелее.");
        } else if (currentFruitsWeight < incomingFruitsWeight) {
            System.out.println("Преданная коробка тяжелее.");
        } else {
            System.out.println("Коробки по весу равны.");
        }
    }

    /*
    * Перемещает все фрукты в другую коробку
    */
    public void transferTo(Box<T> anotherBox) {
        anotherBox.fruits.addAll(fruits);
        fruits.clear();
    }
}