package Lessons_09;

/*
* Домашнее задание:
* 1. Написать функцию, принимающую список Student и возвращающую список уникальных курсов, на которые подписаны студенты.
* 2. Написать функцию, принимающую на вход список Student и возвращающую список из трех самых любознательных (любознательность определяется количеством курсов).
* 3. Написать функцию, принимающую на вход список Student и экземпляр Course, возвращающую список студентов, которые посещают этот курс.
*/

import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        // Доступные курсы
        Course java = new Course("Java");
        Course git = new Course("Git");
        Course dataBase = new Course("DataBase");
        Course javaScript = new Course("JavaScript");
        Course react = new Course("React");
        Course html = new Course("HTML");
        Course css = new Course("CSS");
        Course photoShop = new Course("PhotoShop");
        Course linux = new Course("Linux");

        List<Student> students = new ArrayList<>(Arrays.asList(
            new Student("Vasya", new ArrayList<>(Arrays.asList(java, git, dataBase))),
            new Student("Fedya", new ArrayList<>(Arrays.asList(javaScript, html, css, photoShop))),
            new Student("Sergey", new ArrayList<>(Arrays.asList(javaScript, html, css, java, git, dataBase, linux, react))),
            new Student("Alina", new ArrayList<>(Arrays.asList(java, git, dataBase, linux, html))),
            new Student("Katya", new ArrayList<>(Arrays.asList(java, git, dataBase, linux, html, css, javaScript))),
            new Student("Islam", new ArrayList<>(Arrays.asList(java, git, dataBase, linux, html))),
            new Student("Michael", new ArrayList<>(Arrays.asList(java, git, linux, html)))
        ));

        // Получение уеикальных курсов, на которые подписаны студенты
        Set<Course> uniqueStudentsCourses = getUniqueStudentsCourses(students);
        System.out.println(uniqueStudentsCourses);


    }


    /*
    * Возвращает список уникальных курсов, на которые подписаны студенты
    */
    public static Set<Course> getUniqueStudentsCourses(List<Student> students) {
        Set<Course> result = new HashSet<>();

        // Получение всех курсов, которые посещают студенты
        Stream<Student> stream = students.stream();
        stream.forEach(student -> result.addAll(student.getAllCourses()));

        return result;
    }


    /*
     * Возвращает список указанной длинны из самых любознательных студентов
     */
//    public static List<Student> getCuriosStudents(List<Student> students, int CuriosStudentListLimit) {
//
//    }


    /*
     * Возвращает список студентов, которые посещают указанный курс
     */
//    public static List<Student> getCourseSubscribers {
//
//    }
}
