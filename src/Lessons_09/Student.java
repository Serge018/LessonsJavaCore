package Lessons_09;

import java.util.List;

public class Student {
    String name;
    List<Course> courses;


    public Student(String name, List<Course> courses) {
        this.name = name;
        this.courses = courses;
    }


    String getName() {
        return this.name;
    }


    List<Course> getAllCourses() {
        return this.courses;
    }


    int getQuantityCourses() {
        return this.courses.size();
    }


    boolean isSubscribeToCourse(Course course)
    {
        return this.courses.contains(course);
    }


    @Override
    public String toString() {
        return this.name;
    }
}
