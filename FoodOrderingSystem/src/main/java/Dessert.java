import java.util.ArrayList;

public class Dessert extends Item{

    public Dessert(String name, double price) {
        super(name, price);
    }

    public Dessert() {}

    @Override
    public String toString() {
        return getName() + " " + getPrice() ;
    }

    ArrayList<Dessert> desserts = new ArrayList<Dessert>();

    public void addDessert(String name, double price){
        desserts.add(new Dessert(name,price));
    }

    public void printDesserts(){
        for(int j=1,i = 0; i < desserts.size(); i++,j++) {
            System.out.print(j +") " + desserts.get(i).toString()+ "\n");
        }
    }

    public Dessert getDessert(int index){
        return desserts.get(index-1);
    }

    public int getSize(){
        return desserts.size();
    }
}
