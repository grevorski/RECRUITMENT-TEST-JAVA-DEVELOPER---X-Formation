import java.util.*;

public class AllCuisines {
    public enum Enum {
        POLISH,ITALIAN,MEXICAN;
    }

    Map<Enum, ArrayList<Dish>> enumMap = new EnumMap<>(Enum.class);

    public void initializeCuisines(){
        for(Enum e : Enum.values()){
            enumMap.put(e,new ArrayList<Dish>());
        }
    }

    public void addDish(Enum e, String name, double price ){
        enumMap.get(e).add(new Dish(name,price));
    }

    public void printDishes(Enum e) {
        for(int j = 1, i = 0; i < Enum.values().length; i++,j++) {
            System.out.print(j +") " + enumMap.get(e).get(i).toString());
        }
    }

    public Dish getDish(Enum e, int index) {
        return enumMap.get(e).get(index-1);
    }

    public int getSize(){
        return Enum.values().length;
    }

    public void printCuisines(){
        int i = 1;
        for (Enum s : Enum.values()) {
            System.out.println(i++ + ") " + s);

        }
    }
}
