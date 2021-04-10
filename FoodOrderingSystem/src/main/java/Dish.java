public class Dish extends Item {

    public Dish(String name, double price) { super(name, price); }

    @Override
    public String toString() {
        return  getName() + " " + getPrice() + "\n";
    }
}
