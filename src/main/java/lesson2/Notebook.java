package lesson2;

import java.util.Random;

public class Notebook {

    private int memory;
    private String name;
    private int price;
    private final Random random = new Random();

    public Notebook() {
        this.memory = (random.nextInt(6) + 1) * 4;
        this.name = randomName().name();
        this.price = random.nextInt(26) * 100 + 500;

    }

    private Product randomName() {
        int rn = new Random().nextInt(Product.values().length);
        return Product.values()[rn];
    }

    public int getMemory() {
        return memory;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }


    public void setMemory(int memory) {
        this.memory = memory;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }


}
