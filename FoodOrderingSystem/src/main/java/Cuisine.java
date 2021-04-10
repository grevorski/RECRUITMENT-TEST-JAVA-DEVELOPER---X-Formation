import java.util.*;

public class Cuisine {
    public enum Type {
        POLISH,ITALIAN,MEXICAN;
    }

    private final Map<Type, ArrayList<Dish>> enumMap = new EnumMap<>(Type.class);

    public void initializeCuisines(){
        for(Type e : Type.values()){
            enumMap.put(e,new ArrayList<Dish>());
        }
    }

    public void addDish(Type e, String name, double price ){
        enumMap.get(e).add(new Dish(name,price));
    }

    public void printDishes(Type e) {
        for(int j = 1, i = 0; i < getSize(e); i++,j++) {
            System.out.print(j +") " + enumMap.get(e).get(i).toString());
        }
    }

    public Dish getDish(Type e, int index) {
        return enumMap.get(e).get(index-1);
    }



    public int getSize(Type e){
        return enumMap.get(e).size();
    }

    public void printCuisines(){
        int i = 1;
        for (Type s : Type.values()) {
            System.out.println(i++ + ") " + s);
        }
    }
}
