package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Grocery {

   public static ArrayList<String> groceryList = new ArrayList<>();

    public  static  void  startGrocery() {
        Scanner scanner = new Scanner(System.in);
       boolean running = true;
        while (running){
            System.out.println("Please choose an option: ");
            System.out.println("0 - Exit");
            System.out.println("1 - Add items ");
            System.out.println("2 - Remove items ");
            System.out.println("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 0:
                    System.out.println("Exiting the application...");
                    running= false;
                    break;
                case 1:
                    System.out.print("Enter the items to add (comma-separated or single item): ");
                    String itemsToAdd = scanner.nextLine();
                    addItems(itemsToAdd);
                    break;
                case 2:
                    System.out.print("Enter the items to add (comma-separated or single item): ");
                    String itemsToRemove= scanner.nextLine();
                    removeItems(itemsToRemove);
                    break;
                case 3:
                    System.out.print("Enter the item to check: ");
                    String itemToCheck = scanner.nextLine();
                    if (checkItemsInList(itemToCheck)){
                        System.out.println(itemToCheck + " is in the grocery list.");
                    }
                    else{
                        System.out.println(itemToCheck + " is not in the grocery list.");
                    }
                    break;
                case 4:
                    printSorted();
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }

    public  static void addItems(String input){
        String[] itemsArray = input.split(",");

        for (String item: itemsArray){
            item = item.trim();
            if(!groceryList.contains(item)){
                groceryList.add(item);
                System.out.println(item+ " added to the grocery list");
            }
            else {
                System.out.println(item+ " is already in the grocery list.");
            }
        }
        sortList();
    }

    public  static  void removeItems(String input){
        String[] itemsArray = input.split(",");

        for (String item: itemsArray){
            item = item.trim();
            if(groceryList.contains(item)){
                groceryList.remove(item);
                System.out.println(item+ " removed from the grocery list");
            }
            else {
                System.out.println(item+ " is not in the grocery list.");
            }
        }
        sortList();
    }

    public static boolean checkItemsInList (String product){
        return groceryList.contains(product.trim());
    }

    public static void printSorted(){
        System.out.println("Sorted Grocery List:");
        sortList();
        for(String item: groceryList){
            System.out.println("- "+item);
        }
    }

    public static  void sortList(){
        Collections.sort(groceryList);
    }

}
