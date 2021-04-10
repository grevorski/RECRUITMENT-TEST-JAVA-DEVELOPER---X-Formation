public interface Items<T> {

   void add(String name, double price);

   T get(int index);

   void print();

   int getSize();

}
