package org.example.models;

import java.util.*;

public class Grocery {
    public static List<String> groceryList = new ArrayList<>();

    public static void startGrocery(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 0:
                    return;
                case 1:
                    System.out.println("Eklenmesini istediğiniz elemanları giriniz.");
                    String itemsToAdd = scanner.nextLine();
                    addItems(itemsToAdd);
                    break;
                case 2:
                    System.out.println("Cıkarılmasını istediğiniz elemanları giriniz.");
                    String itemsToRemove = scanner.nextLine();
                    removeItems(itemsToRemove);
                    break;
            }
            printSorted();
        }
    }
    public static void addItems(String itemsToAdd) {
        String[] items = itemsToAdd.split(",");
        for(String item: items){
            item= item.trim();
            if(!checkItemIsInList(item)) {
                groceryList.add(item);
            }
        }
        Collections.sort(groceryList);
    }
    public static void removeItems(String itemsToRemove) {
        String[] items = itemsToRemove.split(",");
        for (String item : items) {
            item = item.trim();
            if (checkItemIsInList(item)) {
                groceryList.remove(item);
            }
        }
        Collections.sort(groceryList);
    }
    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product);
    }
    public static void printSorted() {
        Collections.sort(groceryList);
        System.out.println(groceryList);
    }
    
}
