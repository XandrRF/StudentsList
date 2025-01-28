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
import java.util.Scanner;

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
    ArrayList<Student> students = new ArrayList<>();

    public void addStudent(String name, int age) {
        students.add(new Student(name, age));
        System.out.println("Студент: " + name + " добавлен");
    }

    public void delStudent(String name) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).name.equalsIgnoreCase(name)) {
                students.remove(i);
                System.out.println("Студент с именем: " + name + " удалён");
                return;
            }
        }
        System.out.println("Такой студен не найден");
    }

    public void printList() {
        if (!students.isEmpty()) {
            for (Student student : students) {
                System.out.println(student);
            }
        } else {
            System.out.println("Список пуст!");
        }
    }

    public void findStudent(String name) {
        for (Student student : students) {
            if (student.name.equalsIgnoreCase(name)) {
                System.out.println("Ученик найден: " + name);
                return;
            }
        }
        System.out.println("Ученик ненайден");
    }

}

class Menu {
    Scanner input = new Scanner(System.in);
    StudentManagement list = new StudentManagement();
    int choice;

    public void startMenu() {
        do {
            System.out.println("\n1. Добавить студента");
            System.out.println("2. Удалить студента");
            System.out.println("3. Показать всех студентов");
            System.out.println("4. Найти студента");
            System.out.println("5. Выход");
            System.out.print("Выберите действие: ");
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Введите имя студента: ");
                    String name = input.nextLine();
                    System.out.print("Введите возраст студента: ");
                    int age = input.nextInt();
                    list.addStudent(name, age);
                    break;
                case 2:
                    System.out.println("Введите имя студента для удаления: ");
                    String delName = input.nextLine();
                    list.delStudent(delName);
                    break;
                case 3:
                    System.out.println("Весь список студентов: ");
                    list.printList();
                    break;
                case 4:
                    System.out.println("Введите имя для поиска: ");
                    String findName = input.nextLine();
                    list.findStudent(findName);
                    break;
                case 5:
                    System.out.println("Выход из программы!");
                    break;
                default:
                    System.out.println("Не верный выбор :)");
            }
        } while (choice != 5);
    }
}

public class StudentsList {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.startMenu();

    }
}
