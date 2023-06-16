import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Item {
    String name;
    int quantity;

    public Item(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

public class InventoryStocksManagementSystem {
    
    public static List<Item> stocksinventory = new ArrayList<>();

    public static void main(String[] args)
    {
        
        Scanner inv = new Scanner(System.in);
        String choice;

    do {
        
        System.out.println("\n------ Stocks Inventory Management ------");
        System.out.println("1. Add item to inventory");
        System.out.println("2. Remove item from inventory");
        System.out.println("3. Display inventory");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
        choice = inv.nextLine();

          switch (choice) {
            case "1":
            addItem(inv);
            break;
            
            case "2":
            removeItem(inv);
            break;
            
            case "3":
            displayInventory();
            break;
            
            case "4":
            System.out.println("EXITING...");
            break;
            
            default:
            System.out.println("INVALID!!!!!!");
            
            }
            
        } 
        
        while (!choice.equals("4"));
    }
    

    public static void addItem(Scanner inv) {
        System.out.print("Enter the item name/ inventory name: ");
        String itemName = inv.nextLine();

        System.out.print("Enter the quantity of the item: ");
        int quantity = inv.nextInt();
        inv.nextLine(); 

        Item itemname = findItem(itemName);

        if (itemname != null) {
            itemname.setQuantity(itemname.getQuantity() + quantity);
            System.out.println("Item quantity updated!");
        } else {
            stocksinventory.add(new Item(itemName, quantity));
            System.out.println("Item added to inventory!");
        }
    }

    public static void removeItem(Scanner inv) {
        System.out.print("Enter the item name/ inventory name: ");
        String itemName = inv.nextLine();

        Item itemname = findItem(itemName);

        if (itemname != null) {
            System.out.print("Enter the quantity to remove in the item: ");
            int quantity = inv.nextInt();
            inv.nextLine();

            if (quantity > itemname.getQuantity()) {
                System.out.println("Insufficient quantity!");
            }
            else if (quantity == itemname.getQuantity()) {
                stocksinventory.remove(itemname);
                System.out.println("Item removed from inventory!");
            } else
            {
                itemname.setQuantity(itemname.getQuantity() - quantity);
                System.out.println("Item quantity updated!");
            }
        } 
        else {
            System.out.println("Item not found!!!!!!!!");
        }
    }

    public static void displayInventory() {
        for (Item itemname : stocksinventory) {
        System.out.println(itemname.getName() + " --> Quantity: " + itemname.getQuantity());
        
            }
        }
    

    public static Item findItem(String itemName) {
        for (Item itemname : stocksinventory) {
            if (itemname.getName().equalsIgnoreCase(itemName)) {
                return itemname;
            }
        }
        return null;
    }
}
