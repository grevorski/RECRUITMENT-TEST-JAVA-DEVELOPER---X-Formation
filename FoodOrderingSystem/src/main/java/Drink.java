import java.util.ArrayList;

public class Drink extends Item{

    public Drink(String name, double price) { super(name, price); }

    ArrayList<Drink> drink = new ArrayList<Drink>();

    public Drink() { super(); }

    public void addDrink(String name, double price){
        drink.add(new Drink(name,price));
    }

    @Override
    public String toString() {
        return  getName() + " " + getPrice() + "\n";
    }

    public int getSize(){
        return drink.size();
    }

}
