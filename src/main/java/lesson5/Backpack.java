package lesson5;

import java.util.ArrayList;
import java.util.List;

public class Backpack {

    private final double maxW;
    private double bestPrice;
    private List<Item> bestItems;

    public Backpack(double maxW) {
        this.maxW = maxW;
    }

    private double CalcWeigth(List<Item> items) {
        double sumW = 0;
        for (Item item : items) {
            sumW += item.getWeight();
        }
        return sumW;
    }

    private double CalcPrice(List<Item> items) {
        double sumPrice = 0;
        for (Item item :
                items) {
            sumPrice += item.getPrice();
        }
        return sumPrice;
    }

    private void checkSet(List<Item> items) {
        if (bestItems == null) {
            if (CalcWeigth(items) <= maxW) {
                this.bestItems = items;
                this.bestPrice = CalcPrice(items);
            }
        } else {
            if ( this.CalcWeigth(items) <=  this.maxW &&  this.CalcPrice(items) >  this.bestPrice) {
                this.bestItems = items;
                this.bestPrice = CalcPrice(items);
            }
        }
    }

    public void sets (List<Item> items) {
        if (items.size() > 0) {
            this.checkSet(items);
        }
        for (int i = 0; i < items.size(); i++) {
            List<Item> newSet = new ArrayList<>(items);
            newSet.remove(i);
            sets(newSet);
        }
    }

    public List<Item> GetBestSet() {
        return  this.bestItems;
    }
}

