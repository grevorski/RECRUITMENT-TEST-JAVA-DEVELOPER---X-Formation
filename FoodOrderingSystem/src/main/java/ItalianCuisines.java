import java.util.ArrayList;

public class ItalianCuisines implements Cuisines{

    ArrayList<Dish> italianDishList = new ArrayList<Dish>();

    public void addDish(String name, double price) {
        italianDishList.add(new Dish(name,price));
    }

    public void printDishes() {
        for(int j=1,i = 0; i < italianDishList.size(); i++,j++) {
            System.out.print(j +") " + italianDishList.get(i).toString());
        }
    }

    public Dish getDish(int index) {
        return italianDishList.get(index-1);
    }

    public int getSize(){
        return italianDishList.size();
    }
}
