public class Dish extends Item {

    public Dish(String name, double price) {
        super(name, price);
    }

    int getSize() { return 0; }

    @Override
    public String toString() {
        return  getName() + " " + getPrice() + "\n";
    }
}
