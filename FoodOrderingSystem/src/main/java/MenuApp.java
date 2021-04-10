import java.util.Scanner;

public class MenuApp {
   private boolean exit;
   private final Menu menu = new Menu();

    public void runMenu() {
        menu.createMenu();
        printHeader();
        while (!exit) {
            printMenu();
            int choice = getChoice();
            performAction(choice);
        }
    }

    private void performAction(int choice) {
        switch (choice) {
            case 0:
                displayHeader("Thank you for using our Ordering System.");
                exit = true;
                break;
            case 1:
                Cuisine.Type e = menu.choseCuisines();
                menu.makeOrder(e);
                break;
            case 2:
                menu.drinkOrder();
                break;
            case 3:
                Cuisine.Type e1 = menu.choseCuisines();
                menu.makeOrder(e1);
                menu.drinkOrder();
                break;
            default:
                System.out.println("Error");
        }
    }

    private void printHeader() {
        System.out.println("+-----------------------------------+");
        System.out.println("|            Welcome to             |");
        System.out.println("|       Food Ordering System        |");
        System.out.println("+-----------------------------------+");
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

    private int getChoice() {
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

    private void printMenu() {
        displayHeader("Please make an order");
        System.out.println("1) Order Lunch");
        System.out.println("2) Order Drink");
        System.out.println("3) Order Drink&Lunch");
        System.out.println("0) Exit");
    }
}
