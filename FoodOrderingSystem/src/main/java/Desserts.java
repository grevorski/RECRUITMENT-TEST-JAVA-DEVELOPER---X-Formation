import java.util.ArrayList;

public class Desserts extends Item{

    public Desserts(String name, double price) {
        super(name, price);
    }

    public Desserts() {
        super();
    }

    @Override
    public String toString() {
        return getName() + " " + getPrice() ;
    }

    ArrayList<Desserts> desserts = new ArrayList<Desserts>();

    public void addDessert(String name, double price){
        desserts.add(new Desserts(name,price));
    }

    public void printDesserts(){
        for(int j=1,i = 0; i < desserts.size(); i++,j++) {
            System.out.print(j +") " + desserts.get(i).toString()+ "\n");
        }
    }

    public Desserts getDessert(int index){
        return desserts.get(index-1);
    }

    public int getSize(){
        return desserts.size();
    }
}
