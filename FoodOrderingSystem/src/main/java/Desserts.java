import java.util.ArrayList;
import java.util.List;

public class Desserts implements Items {

    private final List<Dessert> desserts = new ArrayList<Dessert>();

    public void add(String name, double price) {
        desserts.add(new Dessert(name,price));
    }

    public Dessert get(int index) {
        return desserts.get(index-1);
    }

    public void print() {
        for(int j=1,i = 0; i < desserts.size(); i++,j++) {
            System.out.print(j +") " + desserts.get(i).toString()+ "\n");
        }
    }

    public int getSize() {
        return desserts.size();
    }
}
