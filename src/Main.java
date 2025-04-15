import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<String> myList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n" + "Выберите операцию:");
            System.out.println("0. Выход из программы");
            System.out.println("1. Добавить дело");
            System.out.println("2. Показать дела");
            System.out.println("3. Удалить дело по номеру");
            System.out.println("4. Удалить дело по названию");
            System.out.println("5. Удалить все дела по ключевому слову");
            System.out.print("Ваш выбор: ");
            int number = Integer.parseInt(scanner.nextLine());
            if (number == 0) {
                System.out.println("Программа завершена");
                break;
            }

            switch (number) {
                case 1 -> addTask(scanner, myList);

                case 2 -> showListTasks(myList);

                case 3 -> deleteTaskByNumber(scanner, myList);

                case 4 -> deleteTaskByName(scanner, myList);

                case 5 -> deleteTaskByWord(scanner, myList);

            }
        }
    }

    public static void addTask(Scanner scanner, List<String> myList) {
        System.out.print("Введите название задачи: ");
        String task = scanner.nextLine();
        myList.add(task);
        System.out.println("Добавлено!");
        showListTasks(myList);

    }

    public static void showListTasks(List<String> myList) {
        System.out.println("Ваш список дел:");
        for (int i = 0; i < myList.size(); i++) {
            int a = i + 1;
            System.out.println(a + ". " + myList.get(i));
        }
    }

    public static void deleteTaskByNumber(Scanner scanner, List<String> myList) {
        System.out.print("Введите номер для удаления:");
        int number = Integer.parseInt(scanner.nextLine());
        if (number > 0 && number <= myList.size()) {
            myList.remove(number - 1);
            System.out.println("Удалено!");
        } else {
            System.out.println("Задача не найдена!");
        }
        showListTasks(myList);
    }

    public static void deleteTaskByName(Scanner scanner, List<String> myList) {
        System.out.print("Введите задачу для удаления:");
        String task = scanner.nextLine();
        if (myList.remove(task)) {
            System.out.println("Удалено!");
        } else {
            System.out.println("Задача не найдена!");
        }
        showListTasks(myList);
    }

    public static void deleteTaskByWord(Scanner scanner, List<String> myList) {
        List<String> trashList = new ArrayList<>();
        System.out.print("Введите ключевое слово: ");
        String word = scanner.nextLine();
        for (String task : myList) {
            if (task.contains(word)) {
                trashList.add(task);
            }
        }
        myList.removeAll(trashList);
        showListTasks(myList);
    }
}