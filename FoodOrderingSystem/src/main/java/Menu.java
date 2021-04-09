import java.util.Scanner;

public class Menu {

    boolean exit;

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.runMenu();
    }

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
                System.out.println("Thank you for using our Ordering System.");
                System.exit(0);
                break;
            case 1: //TODO wybranie kuchni i potrawy danie + deser
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

    public void runMenu() {
        printHeader();
        while (!exit) {
            printMenu();
            int choice = getMenuChoice();
            performAction(choice);
        }
    }
}
