import java.util.Scanner;

public class Menu {

    boolean exit;
    private final Desserts desserts = new Desserts();
    private final Drinks drinks = new Drinks();
    private final AllCuisines allCuisines = new AllCuisines();

    private void printMenu() {
        displayHeader("Please make an order");
        System.out.println("1) Order Lunch");
        System.out.println("2) Order Drink");
        System.out.println("3) Order Drink&Lunch");
        System.out.println("0) Exit");
    }


    private int getChoice() { //for choosing type of order
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
            case 1:
                AllCuisines.Enum e = (AllCuisines.Enum) choseCuisines();
                makeOrder(e);
                break;
            case 2:
                drinkOrder();
                break;
            case 3:
                AllCuisines.Enum e1 = (AllCuisines.Enum) choseCuisines();
                makeOrder(e1);
                drinkOrder();
                break;
            default:
                System.out.println("Error");
        }
    }

    private void drinkOrder(){
        Scanner sc = new Scanner(System.in);
        displayHeader("DRINKS");
        drinks.print();
        int choice = getChoice(drinks);
        int choice1 = -1;
        do{
            System.out.println("With: \n1)ice\n2)lemon\n3)without");
            try {
                choice1 = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid selection. Numbers only please.");
            }
            if(choice1 == 1 ) {
                drinks.isIce = true;
                System.out.println("Ordered drink: " + drinks.get(choice) + " with ice");
            }
            else if(choice1 == 2) {
                drinks.isLemon = true;
                System.out.println("Ordered drink: " + drinks.get(choice) + " with lemon" );
            }
            else if(choice1 == 3) {
                drinks.isLemon=false;
                drinks.isIce = false;
                System.out.println("Ordered drink: " + drinks.get(choice) );
            } else System.out.println("Choice outside of range. Please chose again.");
        }while (choice1 < 0 || choice1 > 4);


    }

    private Object choseCuisines(){
        Scanner sc = new Scanner(System.in);
        int choice = -1;
        do {
            displayHeader("Choose cuisines:");
            allCuisines.printCuisines();
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid selection. Numbers only please.");
            }
            if(choice == 1 ) return AllCuisines.Enum.POLISH;
            else if(choice == 2) return AllCuisines.Enum.ITALIAN;
            else if(choice == 3) return AllCuisines.Enum.MEXICAN;
            else System.out.println("Choice outside of range. Please chose again.");

        } while (choice < 0 || choice > 4);
        return null;
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

    private void makeOrder(AllCuisines.Enum e){
        displayHeader("LUNCH");
        allCuisines.printDishes(e);
        int choice = getLunchChoice();
        displayHeader("DESSERT");
        desserts.print();
        int dessertChoice = getChoice(desserts);
        System.out.println("Ordered lunch: " + allCuisines.getDish(e,choice) + "\nOrdered dessert: " + desserts.get(dessertChoice));
    }

    private int getLunchChoice() {
        Scanner keyboard = new Scanner(System.in);
        int choice = -1;
        do {
            System.out.print("Enter your choice: ");
            try {
                choice = Integer.parseInt(keyboard.nextLine());
            } catch (NumberFormatException exception) {
                System.out.println("Invalid selection. Numbers only please.");
            }
            if (choice < 0 || choice > allCuisines.getSize()) {
                System.out.println("Choice outside of range. Please chose again.");
            }
        } while (choice < 0 || choice > allCuisines.getSize());
        return choice;
    }

    private int getChoice(Items items) {
        Scanner keyboard = new Scanner(System.in);
        int choice = -1;
        do {
            System.out.print("Enter your choice: ");
            try {
                choice = Integer.parseInt(keyboard.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid selection. Numbers only please.");
            }
            if (choice < 0 || choice > items.getSize()) {
                System.out.println("Choice outside of range. Please chose again.");
            }
        } while (choice < 0 || choice > items.getSize());
        return choice;
    }

    public void runMenu() {
        printHeader();
        while (!exit) {
            printMenu();
            int choice = getChoice();
            performAction(choice);
        }
    }
    public void createMenu(){
        allCuisines.initializeCuisines();
        allCuisines.addDish(AllCuisines.Enum.POLISH,"kotlet",9.99);
        allCuisines.addDish(AllCuisines.Enum.POLISH,"zraz",29.99);
        allCuisines.addDish(AllCuisines.Enum.POLISH,"kaczka",39.99);
        allCuisines.addDish(AllCuisines.Enum.POLISH,"xD",42.99);
        allCuisines.addDish(AllCuisines.Enum.POLISH,"123",94.99);

        allCuisines.addDish(AllCuisines.Enum.ITALIAN,"pasta",100);
        allCuisines.addDish(AllCuisines.Enum.ITALIAN,"czedar",15);
        allCuisines.addDish(AllCuisines.Enum.ITALIAN,"makaroni",32);

        allCuisines.addDish(AllCuisines.Enum.MEXICAN,"takosy", 14.99);
        allCuisines.addDish(AllCuisines.Enum.MEXICAN,"burito", 19.99);
        allCuisines.addDish(AllCuisines.Enum.MEXICAN,"quesadilla", 14.99);
        allCuisines.addDish(AllCuisines.Enum.MEXICAN,"cos", 32.99);

        desserts.add("lody",12.22);
        desserts.add("lizak",9.99);
        desserts.add("ciastko",16.90);
        desserts.add("snikers",4.99);

        drinks.add("kolka",5.90);
        drinks.add("vodka",9.90);
        drinks.add("łycha",12.90);

    }
}
