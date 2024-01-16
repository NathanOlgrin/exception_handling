package view;

import presenter.Presenter;
import java.util.Scanner;

public class ConsoleUI {
    private Scanner scanner;
    private Presenter presenter;
    private boolean check;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
    }

    public void start() throws Exception {
        check = true;
        while (check){
            System.out.println("Введите через пробел фамилию, имя, отчество, дату рождения (в формате dd.mm.yyyy), номер телефона (без разделяющих знаков), пол (f - female, m - male)");
            String text = scanner.nextLine();
            boolean flag = presenter.add(text);
            if(flag){
                System.out.println("Данные успешно введены. Продолжаем? y/n");
                String choice = scanner.nextLine();
                switch (choice){
                    case "y":
                        check = true;
                        break;
                    case "n":
                        check = false;
                        break;
                }
            }
            if(!flag){
                check = flag;
            }
        }
    }
}
