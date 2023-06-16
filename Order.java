package RMOrder;

import java.util.ArrayList;
import java.util.List;

public class Order extends Main{
    private List<MenuItem> items;

    public Order() {
        items = new ArrayList<>();
    }

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public double getTotalPrice() {
        double totalPrice = 0.0;
        for (MenuItem item : items) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }

    public void printOrder() {
        System.out.println("Order:");
        for (MenuItem item : items) {
            System.out.println(item.getName() + " - " + item.getPrice());
        }
        System.out.println("Total: " + getTotalPrice());
    }
}
