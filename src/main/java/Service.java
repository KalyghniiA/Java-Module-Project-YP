import java.util.InputMismatchException;
import java.util.Scanner;

public class Service {
    Scanner scanner = new Scanner(System.in);
    Calculator calculator = new Calculator();

    public void start() {
        System.out.println("Добро пожаловать");
        while (true) {
            System.out.println("На скольких человек разделить счет?");
            int quantity = 0;
            try {
                quantity = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Введено некорректное значение");
                scanner.next();
                continue;
            }

            if (quantity < 1) {
                System.out.println("Введено некорректное количество гостей");
            } else if (quantity == 1) {
                System.out.println("На одного гостя делить не надо");
            } else {
                calculator.start(quantity, scanner);
                break;
            }

        }
    }
}
