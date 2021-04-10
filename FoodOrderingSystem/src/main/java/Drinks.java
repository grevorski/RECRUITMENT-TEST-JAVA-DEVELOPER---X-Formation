import java.util.ArrayList;

public class Drinks implements Items<Drink>{

    private final ArrayList<Drink> drinks = new ArrayList<Drink>();


    public int getSize(){
        return drinks.size();
    }

    public void add(String name, double price) {
        drinks.add(new Drink(name,price));
    }

    public Drink get(int index) {
        return drinks.get(index-1);
    }

    public void print() {
        for(int j=1,i = 0; i < drinks.size(); i++,j++) {
            System.out.print(j +") " + drinks.get(i).toString()+ "\n");
        }
    }
}
