import java.util.ArrayList;

public class MexicanCuisines implements Cuisines{

    ArrayList<Dish> mexicanDishList = new ArrayList<Dish>();

    public void addDish(String name, double price) {
        mexicanDishList.add(new Dish(name,price));
    }

    public void printDishes() {
        for(int j=1,i = 0; i < mexicanDishList.size(); i++,j++) {
            System.out.print(j +") " + mexicanDishList.get(i).toString());
        }
    }

    public Dish getDish(int index) {
        return mexicanDishList.get(index-1);
    }

    public int getSize(){
        return mexicanDishList.size();
    }
}
