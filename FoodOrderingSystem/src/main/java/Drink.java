import java.util.ArrayList;

public class Drink extends Item{

    public boolean isIce = false;
    public boolean isLemon = false;

    public Drink(String name, double price) { super(name, price); }

    private final ArrayList<Drink> drinks = new ArrayList<Drink>();

    public Drink() {
    }


    public void addDrink(String name, double price){
        drinks.add(new Drink(name,price));
    }

    public int getSize(){
        return drinks.size();
    }

    public void printDrinks(){
        for(int j=1,i = 0; i < drinks.size(); i++,j++) {
            System.out.print(j +") " + drinks.get(i).toString()+ "\n");
        }
    }

    public Drink getDrink(int index){
        return drinks.get(index-1);
    }

    @Override
    public String toString() {
        return  getName() + " " + getPrice() ;
    }

}
