import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Calculator {
    private final List<Item> items  = new LinkedList<>();
    public void start(int quantity, Scanner sc) {
        addItems(sc);
        calculatePrice(quantity);
    }

    private void addItems(Scanner sc) {
        while(true) {
            System.out.println("Введите товар");
            String name = sc.next();
            System.out.println("Введите цену в формате: рубли,копейки");
            double price = sc.nextDouble();
            items.add(new Item(name, price));

            System.out.println("Для завершения ввода товаров введите завершить, в противном случае любой символ");
            String isClose = sc.next();
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
