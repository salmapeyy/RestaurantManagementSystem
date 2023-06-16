import java.util.ArrayList;
import java.util.List;

public class GeneratingReports {

    public static void main(String[] args) {
        
        List<Report> menu = new ArrayList<>();
        
        //MAIN DISH
        menu.add(new Report("Grilled Roast Beef         ", 0 , 2000.00));
        menu.add(new Report("Seafood Pack               ", 0, 1580.00));
        menu.add(new Report("Spicy Pork Rim             ", 0, 1330.00));
        menu.add(new Report("Baked Fish with Chili Sauce", 0,  700.00));
        menu.add(new Report("Buttered Shrimp Bucket     ", 0, 1645.78));
        
        //APPETIZERS
        menu.add(new Report("Pork Dumplings             ", 0, 150.00));
        menu.add(new Report("Spinach Pancakes           ", 0, 175.00));
        menu.add(new Report("MIld Mushroom With Shrimp  ", 0, 340.00));
        
        //DESSERTS
        menu.add(new Report("Prawn Salad                ", 0, 247.00));
        menu.add(new Report("Vegetable Salad            ", 0, 299.00));
        menu.add(new Report("Fruit Salad                ", 0, 250.00));
       
        //Dipa tapos

        generateReport(menu);
    }
class Report {
    private String itemName;
    private int quantity;
    private double price;

    public Report(String itemName, int quantity, double price) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
    }

    public String getItemName() {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
}

    public static void generateReport(List<Report> orders) {
        double totalSales = 0;
        System.out.println("Generating Report");
        System.out.println("-----------------------------------------------------");
        System.out.println("Item\t\t\t\tQuantity\tPrice");

        for (Report report : orders) {
            double totalPrice = report.getPrice() * report.getQuantity();
            totalSales += totalPrice;

            System.out.printf("%-15s\t%d\t\tP%.2f%n", report.getItemName(), report.getQuantity(), totalPrice);
        }

        System.out.println("-----------------------------------------------------");
        System.out.printf("Total Sales: P%.2f%n", totalSales);
    }
}

