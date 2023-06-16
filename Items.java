package RMOrder;

import java.util.ArrayList;
import java.util.List;

public class Items extends Main {
    List<MenuItem> menu;

    public Items() {
        menu = new ArrayList<>();
    }

    public void addItemToMenu(MenuItem item) {
        menu.add(item);
    }

    public void printMenu() {
        System.out.println("Menu:");
        for (MenuItem item : menu) {
            System.out.println(item.getName() + " - " + item.getPrice());
        }
    }
}
