package lesson2;

import java.util.Random;

public class Notebook {
    private int memory;
    private String name;
    private int price;
    private final String[] Productname = {"Lenuvo", "Asos", "MacNote", "Eser", "Xamiou"};
    private Random random = new Random();

    public Notebook() {
        this.memory = (random.nextInt(6) + 1) * 4;
        this.name = Productname[random.nextInt(Productname.length)];
        this.price = random.nextInt(26) * 100 + 500;

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
