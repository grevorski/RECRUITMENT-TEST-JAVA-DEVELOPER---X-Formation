import java.util.ArrayList;

public class Dessert {
    private String name;
    private double price;

    public Dessert(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Dessert() {
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return getName() + " " + getPrice();
    }

    ArrayList<Dessert> desserts = new ArrayList<Dessert>();

    public void addDessert(String name, double price){
        desserts.add(new Dessert(name,price));
    }

    public void printDesserts(){
        for(int j=1,i = 0; i < desserts.size(); i++,j++) {
            System.out.print(j +") " + desserts.get(i).toString());
        }
    }

    public Dessert getDessert(int index){
        return desserts.get(index-1);
    }
}
