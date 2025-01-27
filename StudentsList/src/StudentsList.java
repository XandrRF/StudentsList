/*
Задача: Управление списком студентов
Напишите программу, которая позволяет управлять списком студентов в классе.
Каждый студент имеет имя и возраст. Программа должна предоставлять следующие функции:
Добавление нового студента.
Удаление студента по имени.
Вывод списка всех студентов.
Поиск студента по имени.
 */


import java.util.ArrayList;

class Student {
    String name;
    int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Имя: " + name + " возраст: " + age;
    }
}

class StudentManagement {

}

public class StudentsList {
    public static void main(String[] args) {
        Student studTest = new Student("Vasay", 19);
        ArrayList<Student> test = new ArrayList<>();
        test.add(studTest);
        System.out.println(studTest);


    }
}
