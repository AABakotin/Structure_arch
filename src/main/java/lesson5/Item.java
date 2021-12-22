package lesson5;

public class Item {


    private final String name;
    private final double weight;
    private final double price;

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public double getPrice() {
        return price;
    }

    public Item(String name, double weight, double price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }


    @Override
    public String toString() {
        return
                name +
                " weight = " + weight +
                " price = " + price;
    }

}
