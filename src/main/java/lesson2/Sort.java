package lesson2;

import java.util.List;


public class Sort {

    public static List<Notebook> selection (List<Notebook> arr) {
        int min;
        for (int i = 0; i < arr.size() - 1; i++) {
            min = i;
            for (int j = i + 1; j < arr.size(); j++) {
                if (arr.get(j).getPrice() < arr.get(min).getPrice()) {
                    min = j;
                }
                if (arr.get(j).getPrice() == arr.get(min).getPrice() && arr.get(j).getMemory() < arr.get(min).getMemory()) {
                    min = j;
                }
                Notebook temp = arr.get(i);
                arr.set(i, arr.get(min));
                arr.set(min, temp);
            }
        }
        return arr;
    }

}

