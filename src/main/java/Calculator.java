import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import exception.NegativeNumberException;
import util.Util;

public class Calculator {
    private final List<Item> items  = new LinkedList<>();
    public void start(int quantity, Scanner scanner) {
        addItems(scanner);
        calculatePrice(quantity);
    }

    private void addItems(Scanner scanner) {
        while(true) {
            System.out.println("Введите товар");
            String name = scanner.next();
            System.out.println("Введите цену в формате: рубли,копейки");
            try {
                double price = scanner.nextDouble();
                if (price < 0) throw new NegativeNumberException("Введено отрицательное число");
                items.add(new Item(name, price));
            } catch (InputMismatchException e) {
                System.out.println("Неверный формат данных");

            } catch (NegativeNumberException e) {
                System.out.println(e.getMessage());
            }

            System.out.println("Для завершения ввода товаров введите завершить, в противном случае любой символ");
            String isClose = scanner.next();
            if (isClose.trim().equalsIgnoreCase("завершить")) break;
        }
    }

    private void calculatePrice(int quantity) {
        double fullPrice = 0.00;

        System.out.println("Добавленные товары:");
        for (var item: items) {
            System.out.println(item);
            fullPrice += item.getPrice();
        }

        double priceForOneGuest = fullPrice / quantity;

        System.out.printf("Сумма на каждого гостя: %.2f %s. Количество гостей: %s",
                priceForOneGuest ,
                Util.gettingCase((int) Math.floor(priceForOneGuest)),
                quantity);
    }

}
