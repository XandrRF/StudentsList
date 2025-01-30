/* New branch#1
Задача: Управление списком студентов
Напишите программу, которая позволяет управлять списком студентов в классе.
Каждый студент имеет имя и возраст. Программа должна предоставлять следующие функции:
Добавление нового студента.
Удаление студента по имени.
Вывод списка всех студентов.
Поиск студента по имени.
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
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
    Scanner inputManagement = new Scanner(System.in);
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

    public void editStudentDetails(String name) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).name.equalsIgnoreCase(name)) {
                System.out.print("Введите изменённое имя студента: ");
                String EditName = inputManagement.nextLine();

                System.out.print("Введите изменённый возраст студента: ");
                int EditAge = inputManagement.nextInt();

                students.set(i, new Student(EditName, EditAge));
                return;
            }
        }
        System.out.println("Ученик ненайден");
    }

//    public void addFile() throws FileNotFoundException {
//        File file = new File("src/List");
//        PrintWriter pw = new PrintWriter(file);
//        for (int i = 0; i < students.size(); i++) {
//            System.out.println(i);
//        }

    }

}

class Menu {
    Scanner input = new Scanner(System.in);
    StudentManagement list = new StudentManagement();
    int choice;

    public void startMenu() throws IOException {
        do {
            System.out.println("\n1. Добавить студента");
            System.out.println("2. Удалить студента");
            System.out.println("3. Показать всех студентов");
            System.out.println("4. Найти студента");
            System.out.println("5. Изменить данные студента");
            System.out.println("6. Сохранить в файл");
            System.out.println("0. Выход");
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
                    System.out.println("Введите имя для изменения: ");
                    String editName = input.nextLine();
                    list.editStudentDetails(editName);
                    break;
//                case 6:
//                    list.addFile();

                case 0:
                    System.out.println("Выход из программы!");
                    break;
                default:
                    System.out.println("Не верный выбор :)");
            }
        } while (choice != 0);
    }
}

public class StudentsList {
    public static void main(String[] args) throws IOException {
        Menu menu = new Menu();
        menu.startMenu();


    }
}
