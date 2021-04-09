import java.util.ArrayList;

public class PolishCuisines implements Cuisines{
    ArrayList<Dish> polishDishList = new ArrayList<Dish>();

    public void addDish(String name, double price){
        polishDishList.add(new Dish(name,price));
    }

    public void printDishes(){
        for(int j=1,i = 0; i < polishDishList.size(); i++,j++) {
            System.out.print(j +") " + polishDishList.get(i).toString());
        }
    }

    public Dish getDish(int index){
       return polishDishList.get(index-1);
    }
}
