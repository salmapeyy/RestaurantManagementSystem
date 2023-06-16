package com.mycompany.foodwastetrack;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class FoodWasteTrack extends JFrame {
    private JLabel lblText,lblItems;
    private JTextField txtfldItems;
    private JButton btnUpdate,btnHistory;
    private JComboBox cmbMenuCategory;
    private JComboBox<String> cmbMenuDishes;
    
    String[] MenuCategory = {"Select Category","Main Course","Appetizer","Salad","Desert","Drinks"};
    String [] SelectCategory = {};
    
    FoodWasteTrack(){
        setTitle("Food Waste Tracker");
        setSize(600,400);
        setLayout(null);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        lblText = new JLabel("Food Waste Tracker");
        lblText.setBounds(200,30,200,20);
        lblText.setFont(new Font("Arial",Font.BOLD,20));
        add(lblText);
        
        cmbMenuCategory = new JComboBox(MenuCategory);
        cmbMenuCategory.setBounds(200, 50, 200, 30);
        cmbMenuCategory.setFont(new Font("Arial",Font.PLAIN,15));
        add(cmbMenuCategory);
        
        cmbMenuDishes = new JComboBox<>();
        cmbMenuDishes.setBounds(200,100,200,30);
        cmbMenuDishes.setFont(new Font("Arial",Font.PLAIN,15));
        add(cmbMenuDishes);
        
        lblItems = new JLabel("No. of Items: ");
        lblItems.setBounds(100, 150, 100, 30);
        lblItems.setFont(new Font("Arial",Font.PLAIN,15));
        add(lblItems);
        
        txtfldItems = new JTextField();
        txtfldItems.setBounds(200, 150, 100, 30);
        txtfldItems.setFont(new Font("Arial",Font.PLAIN,15));
        add(txtfldItems);
        
        btnUpdate = new JButton("Update");
        btnUpdate.setBounds(300, 150, 100, 30);
        btnUpdate.setFont(new Font("Arial",Font.PLAIN,15));
        add(btnUpdate);
        
        btnHistory = new JButton("View History");
        btnHistory.setBounds(200, 200, 200, 30);
        btnHistory.setFont(new Font("Arial",Font.PLAIN,15));
        add(btnHistory);
        
        cmbMenuCategory.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String categorySelected = (String) cmbMenuCategory.getSelectedItem();
                menuOption(categorySelected);
            }
        });
        
        //Events for update
        btnUpdate.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String selectedMenuCategory = (String) cmbMenuCategory.getSelectedItem();
                String selectedMenuDishes = (String) cmbMenuDishes.getSelectedItem();
                String NumberOfItems = (String) txtfldItems.getText();
                
                int numberofitem = Integer.parseInt(NumberOfItems);
                JOptionPane.showMessageDialog(rootPane, "Successfully Update", "Update", JOptionPane.INFORMATION_MESSAGE);
                JOptionPane.showMessageDialog(rootPane, "Category: " + selectedMenuCategory + "\nDishes: " + selectedMenuDishes + "\nNumber of Items: " + NumberOfItems, "Update", JOptionPane.INFORMATION_MESSAGE);
                
                
            }
        });
        
        //revise update and view history
    }
   
    //events for category and dishes
    public void menuOption(String menuCategory){
        cmbMenuDishes.removeAllItems();
        
        if(menuCategory.equals(SelectCategory)){
            for(String category : SelectCategory){
                cmbMenuDishes.addItem(category);
            }
        }else if(menuCategory.equals("Main Course")){
        String[] MainCourse = {"Grilled Roast Beef","SeaFood Pack","Spicy Pork Rim","Baked Fish with Chili Sauce","Buttered Shrimp Bucket"};
        for(String course : MainCourse){
            cmbMenuDishes.addItem(course);
            }   
        }else if(menuCategory.equals("Appetizer")){
        String[] Appetizer = {"Pork Dumpling","Spinach Pancake","Mild Mushroom with Shrimp"};
        for(String appetizer : Appetizer){
            cmbMenuDishes.addItem(appetizer);
            }
        }else if(menuCategory.equals("Salad")){
        String[] Salad = {"Prawn Salad","Vegetable Salad","Fruit Salad"};
        for(String salad : Salad){
            cmbMenuDishes.addItem(salad);
        }
        }else if(menuCategory.equals("Desert")){
        String[] Desert = {"Coffee Tiramisu","Choco Lava Cake","Blueberyy CheeseCake","Leche Plan","Ube Halaya"};
        for(String desert : Desert){
            cmbMenuDishes.addItem(desert);
        }
        }else if(menuCategory.equals("Drinks")){
        String[] Drinks = {"Bottled Water","Mango Shake","Buko Shake","Sprite in Can","Coke in Can"};
        for(String drinks : Drinks){
            cmbMenuDishes.addItem(drinks);
        }
        }
    }
    
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FoodWasteTrack();
            }
        });
    }
    
}
