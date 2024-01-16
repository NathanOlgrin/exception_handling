package presenter;
import model.PhoneBook;
import view.ConsoleUI;

public class Presenter {
    private PhoneBook phoneBook;
    private ConsoleUI consoleUI;

    public Presenter(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
        phoneBook = new PhoneBook();
    }

    public boolean add(String text) throws Exception {
        boolean flag = phoneBook.add(text);
        return flag;
    }
}
