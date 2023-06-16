package RMOrder;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Items restaurant = new Items();

        //MAIN COURSE
        restaurant.addItemToMenu(new MenuItem("Grilled Roast Beef",         2000.00));
        restaurant.addItemToMenu(new MenuItem("Seafood Pack",               1580.00));
        restaurant.addItemToMenu(new MenuItem("Spicy Pork Rim",             1330.00));
        restaurant.addItemToMenu(new MenuItem("Baked Fish with Chli Sauce", 700.00));
        restaurant.addItemToMenu(new MenuItem("Buttered Shrimp Bucket",     1645.78));
        
        //APPETIZERS
        restaurant.addItemToMenu(new MenuItem("Pork Dumplings",             150.00));
        restaurant.addItemToMenu(new MenuItem("Spinach Pancakes",           175.00));
        restaurant.addItemToMenu(new MenuItem("Mild Mushroom with Shrimp",  340.00));
        
        //SALAD
        restaurant.addItemToMenu(new MenuItem("Prawn Salad",                247.00));
        restaurant.addItemToMenu(new MenuItem("Vegetable Salad",            299.00));
        restaurant.addItemToMenu(new MenuItem("Fruit Salad",                250.00));
        
        //DESSERT
        restaurant.addItemToMenu(new MenuItem("Coffee Tirimasu",            178.00));
        restaurant.addItemToMenu(new MenuItem("Choco Lava Cake",            230.00));
        restaurant.addItemToMenu(new MenuItem("Blueberry Cheesecake",       315.00));
        restaurant.addItemToMenu(new MenuItem("Leche Plan",                 100.00));
        restaurant.addItemToMenu(new MenuItem("Ube Halaya",                 60.00));
        
        //DRINKS
        restaurant.addItemToMenu(new MenuItem("Bottled Water",              40.00));
        restaurant.addItemToMenu(new MenuItem("Mango Shake",                150.00));
        restaurant.addItemToMenu(new MenuItem("Buko Shake",                 150.00));
        restaurant.addItemToMenu(new MenuItem("Sprite in Can",              99.00));
        restaurant.addItemToMenu(new MenuItem("Coke in Can",                99.00));
        
        // Printing the menu
        restaurant.printMenu();

        // Taking orders
        Scanner scanner = new Scanner(System.in);
        Order order = new Order();
        String itemName;
        do {
            System.out.print("Enter an item name (or 'exit' to exit the program): ");
            itemName = scanner.nextLine();
            if (!itemName.equalsIgnoreCase("exit")) {
                MenuItem item = findItemByName(restaurant, itemName);
                if (item != null) {
                    order.addItem(item);
                    System.out.println(item.getName() + " order added.");
                } else {
                    System.out.println("Item not found. Please order first.");
                }
            }
        } while (!itemName.equalsIgnoreCase("exit"));

        // Printing the final order
        order.printOrder();

        scanner.close();
    }

    private static MenuItem findItemByName(Items restaurant, String name) {
        for (MenuItem item : restaurant.menu) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }
}