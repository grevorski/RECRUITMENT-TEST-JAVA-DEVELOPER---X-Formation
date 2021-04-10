import java.util.Scanner;

public class Menu {

    private final Desserts desserts = new Desserts();
    private final Drinks drinks = new Drinks();
    private final Cuisine allCuisines = new Cuisine();

    public void drinkOrder(){
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
                System.out.println("Ordered drink: " + drinks.get(choice) + " with ice");
            }
            else if(choice1 == 2) {
                System.out.println("Ordered drink: " + drinks.get(choice) + " with lemon" );
            }
            else if(choice1 == 3) {
                System.out.println("Ordered drink: " + drinks.get(choice) );
            } else System.out.println("Choice outside of range. Please chose again.");
        }while (choice1 < 0 || choice1 > 4);
    }

    public Cuisine.Type choseCuisines(){
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
            if(choice == 1 ) return Cuisine.Type.POLISH;
            else if(choice == 2) return Cuisine.Type.ITALIAN;
            else if(choice == 3) return Cuisine.Type.MEXICAN;
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

    public void makeOrder(Cuisine.Type e){
        displayHeader("LUNCH");
        allCuisines.printDishes(e);
        int choice = getLunchChoice(e);
        displayHeader("DESSERT");
        desserts.print();
        int dessertChoice = getChoice(desserts);
        System.out.println("Ordered lunch: " + allCuisines.getDish(e,choice) + "\nOrdered dessert: " + desserts.get(dessertChoice));
    }

    private int getLunchChoice(Cuisine.Type e) {
        Scanner sc = new Scanner(System.in);
        int choice = -1;
        do {
            System.out.print("Enter your choice: ");
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException exception) {
                System.out.println("Invalid selection. Numbers only please.");
            }
            if (choice < 0 || choice > allCuisines.getSize(e)) {
                System.out.println("Choice outside of range. Please chose again.");
            }
        } while (choice < 0 || choice > allCuisines.getSize(e));
        return choice;
    }

    private int getChoice(Items items) {
        Scanner sc = new Scanner(System.in);
        int choice = -1;
        do {
            System.out.print("Enter your choice: ");
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid selection. Numbers only please.");
            }
            if (choice < 0 || choice > items.getSize()) {
                System.out.println("Choice outside of range. Please chose again.");
            }
        } while (choice < 0 || choice > items.getSize());
        return choice;
    }


    public void createMenu(){
        allCuisines.initializeCuisines();
        allCuisines.addDish(Cuisine.Type.POLISH,"kotlet",9.99);
        allCuisines.addDish(Cuisine.Type.POLISH,"zraz",29.99);
        allCuisines.addDish(Cuisine.Type.POLISH,"kaczka",39.99);
        allCuisines.addDish(Cuisine.Type.POLISH,"qew",42.99);
        allCuisines.addDish(Cuisine.Type.POLISH,"eqw",94.99);

        allCuisines.addDish(Cuisine.Type.ITALIAN,"pasta",100);
        allCuisines.addDish(Cuisine.Type.ITALIAN,"czedar",15);
        allCuisines.addDish(Cuisine.Type.ITALIAN,"makaroni",32);

        allCuisines.addDish(Cuisine.Type.MEXICAN,"takosy", 14.99);
        allCuisines.addDish(Cuisine.Type.MEXICAN,"burito", 19.99);
        allCuisines.addDish(Cuisine.Type.MEXICAN,"quesadilla", 14.99);
        allCuisines.addDish(Cuisine.Type.MEXICAN,"cos", 32.99);

        desserts.add("lody",12.22);
        desserts.add("lizak",9.99);
        desserts.add("ciastko",16.90);
        desserts.add("snikers",4.99);

        drinks.add("kolka",5.90);
        drinks.add("vodka",9.90);
        drinks.add("łycha",12.90);

    }
}
