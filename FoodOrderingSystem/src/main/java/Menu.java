import java.util.Scanner;

public class Menu {

    boolean exit;
    private final Cuisines polish = new PolishCuisines();
    private final Cuisines mexican = new MexicanCuisines();
    private final Cuisines italian = new ItalianCuisines();
    private final Dessert dessert = new Dessert();
    private final Drink drink = new Drink();


    private void printMenu() {
        displayHeader("Please make an order");
        System.out.println("1) Order Lunch");
        System.out.println("2) Order Drink");
        System.out.println("3) Order Drink&Lunch");
        System.out.println("0) Exit");
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

    private void performAction(int choice) {
        switch (choice) {
            case 0:
                displayHeader("Thank you for using our Ordering System.");
                exit = true;
                break;
            case 1:
                Cuisines cuisines = (Cuisines) choseCuisines();
                makeOrder(cuisines);
                break;
            case 2:
                drinkOrder();
                break;
            case 3:
                Cuisines cuisines1 = (Cuisines) choseCuisines();
                makeOrder(cuisines1);
                drinkOrder();
                break;
            default:
                System.out.println("Error");
        }
    }

    private void drinkOrder(){
        Scanner sc = new Scanner(System.in);
        displayHeader("DRINKS");
        drink.printDrinks();
        int choice = getChoice(drink);
        do{
            System.out.println("With: \n1)ice\n2)lemon\n3)without");
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid selection. Numbers only please.");
            }
            if(choice == 1 ) {
                drink.isIce = true;
                System.out.println("Ordered drink: " + drink.getDrink(choice) + " with ice");
            }
            else if(choice == 2) {
                drink.isLemon = true;
                System.out.println("Ordered drink: " + drink.getDrink(choice) + " with lemon" );
            }
            else if(choice == 3) {
                drink.isLemon=false;
                drink.isIce = false;
                System.out.println("Ordered drink: " + drink.getDrink(choice) );
            } else System.out.println("Choice outside of range. Please chose again.");
        }while (choice < 0 || choice > 4);


    }

    private Object choseCuisines(){
        Scanner sc = new Scanner(System.in);
        int choice = -1;
        do {
            System.out.print("Choose cuisines:\n1) Polish\n2) Italian\n3) Mexican\n");
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid selection. Numbers only please.");
            }
            if(choice == 1 ) return polish;
            else if(choice == 2) return italian;
            else if(choice == 3) return mexican;
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

    private void makeOrder(Cuisines input){
        displayHeader("LUNCH");
        input.printDishes();
        int choice = getChoice(input);
        displayHeader("DESSERT");
        dessert.printDesserts();
        int dessertChoice = getChoice(dessert);
        System.out.println("Ordered lunch: " + input.getDish(choice) + "\nOrdered dessert: " + dessert.getDessert(dessertChoice));
    }

    private int getChoice(Cuisines c) {
        Scanner keyboard = new Scanner(System.in);
        int choice = -1;
        do {
            System.out.print("Enter your choice: ");
            try {
                choice = Integer.parseInt(keyboard.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid selection. Numbers only please.");
            }
            if (choice < 0 || choice > c.getSize()) {
                System.out.println("Choice outside of range. Please chose again.");
            }
        } while (choice < 0 || choice > c.getSize());
        return choice;
    }

    private int getChoice(Item item) {
        Scanner keyboard = new Scanner(System.in);
        int choice = -1;
        do {
            System.out.print("Enter your choice: ");
            try {
                choice = Integer.parseInt(keyboard.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid selection. Numbers only please.");
            }
            if (choice < 0 || choice > item.getSize()) {
                System.out.println("Choice outside of range. Please chose again.");
            }
        } while (choice < 0 || choice > item.getSize());
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
        polish.addDish("kotlet",9.99);
        polish.addDish("zraz",29.99);
        polish.addDish("kaczka",39.99);
        polish.addDish("xD",42.99);
        polish.addDish("123",94.99);

        italian.addDish("pasta",100);
        italian.addDish("czedar",15);
        italian.addDish("makaroni",32);

        mexican.addDish("takosy", 14.99);
        mexican.addDish("burito", 19.99);
        mexican.addDish("quesadilla", 14.99);
        mexican.addDish("cos", 32.99);

        dessert.addDessert("lody",12.22);
        dessert.addDessert("lizak",9.99);
        dessert.addDessert("ciastko",16.90);
        dessert.addDessert("snikers",4.99);

        drink.addDrink("kolka",5.90);
        drink.addDrink("vodka",9.90);
        drink.addDrink("łycha",12.90);

    }
}
