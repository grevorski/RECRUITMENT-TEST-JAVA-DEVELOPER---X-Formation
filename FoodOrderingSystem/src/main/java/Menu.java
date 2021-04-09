import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    boolean exit;
    public static PolishCuisines polish = new PolishCuisines();
    public static MexicanCuisines mexican = new MexicanCuisines();
    public static ItalianCuisines italian = new ItalianCuisines();
    public static Dessert dessert = new Dessert();


    private void printMenu() {
        displayHeader("Please make an order");
        System.out.println("1) Order Lunch");
        System.out.println("2) Order Drink");
        System.out.println("3) Order Drink&Lunch");
        System.out.println("0) Exit");
    }


    private int getMenuChoice() {
        Scanner keyboard = new Scanner(System.in);
        int choice = -1;
        do {
            System.out.print("Enter your choice: ");
            try {
                choice = Integer.parseInt(keyboard.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid selection. Numbers only please.");
            }
            if (choice < 0 || choice > 4) {
                System.out.println("Choice outside of range. Please chose again.");
            }
        } while (choice < 0 || choice > 4);
        return choice;
    }

    private void performAction(int choice) {
        switch (choice) {
            case 0:
                displayHeader("Thank you for using our Ordering System.");
                exit = true;
                break;
            case 1://TODO wybranie kuchni i potrawy danie + deser
                makeOrder();
                break;
            case 2: //TODO wybranie drinka i zapytanie o lód/cytryne
            case 3: //TODO wybranie kuchni i potrawy danie + deser , wybranie drinka i zapytanie o lód/cytryne

            default:
                System.out.println("Error");
        }
    }

    private void displayHeader(String message){
        System.out.println();
        int width = message.length() + 6;
        StringBuilder sb = new StringBuilder();
        sb.append("+");
        for(int i = 0; i < width; ++i){
            sb.append("-");
        }
        sb.append("+");
        System.out.println(sb.toString());
        System.out.println("|   " + message + "   |");
        System.out.println(sb.toString());
    }

    private void printHeader() {
        System.out.println("+-----------------------------------+");
        System.out.println("|            Welcome to             |");
        System.out.println("|       Food Ordering System        |");
        System.out.println("+-----------------------------------+");
    }

    private void makeOrder(){
        displayHeader("LUNCH");
        polish.printDishes();
        int choice = getMenuChoice();
        displayHeader("DESSERT");
        dessert.printDesserts();
        int dessertChoice = getMenuChoice();
        System.out.println("thank you for ordering lunch: " + polish.getDish(choice) + "dessert: " + dessert.getDessert(dessertChoice));
        exit = true;
    }

    private void drinkOrder(){

    }

    public void runMenu() {
        printHeader();
        while (!exit) {
            printMenu();
            int choice = getMenuChoice();
            performAction(choice);
        }
    }
    public void createMenu(){
        polish.addDish("kotlet",9.99);
        polish.addDish("zraz",29.99);
        polish.addDish("kaczka",39.99);
        polish.addDish("xD",42.99);
        polish.addDish("123",94.99);

        dessert.addDessert("lody",12.22);
        dessert.addDessert("lizak",9.99);
        dessert.addDessert("ciastko",16.90);
        dessert.addDessert("snikers",4.99);
    }
}
