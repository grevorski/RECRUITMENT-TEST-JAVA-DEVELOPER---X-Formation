import java.util.ArrayList;

public class Drinks extends Item{
    public boolean isIce = false;
    public boolean isLemon = false;

    public Drinks(String name, double price) { super(name, price); }

    ArrayList<Drinks> drinks = new ArrayList<Drinks>();

    public Drinks() { super(); }

    public void addDrink(String name, double price){
        drinks.add(new Drinks(name,price));
    }

    public int getSize(){
        return drinks.size();
    }

    public void printDrinks(){
        for(int j=1,i = 0; i < drinks.size(); i++,j++) {
            System.out.print(j +") " + drinks.get(i).toString()+ "\n");
        }
    }

    public Drinks getDrink(int index){
        return drinks.get(index-1);
    }

    @Override
    public String toString() {
        return  getName() + " " + getPrice() ;
    }

}
