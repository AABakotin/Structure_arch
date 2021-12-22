package lesson5;

import java.util.ArrayList;
import java.util.List;

public class Start {

    public static void main(String[] args) {

        //  1. Написать программу по возведению числа в степень с помощью рекурсии.
//        System.out.println(square(5, 5));


        //    2. Написать программу «Задача о рюкзаке» с помощью рекурсии.


        List<Item> items = new ArrayList<>();
        items.add(new Item("notebook", 10, 40000));
        items.add(new Item("binokl", 5, 10000));
        items.add(new Item("book", 4, 5000));
        items.add(new Item("watch", 4, 2000));
        items.add(new Item("headphones", 7, 10000));
        items.add(new Item("netbook", 10, 30000));

        Backpack backpack = new Backpack(30);
        backpack.sets(items);
        System.out.println(backpack.GetBestSet());


    }

    public static double square(int number, int square) {
        return (square == 1 ? number : number * Math.pow(number, square - 1));
    }


}
