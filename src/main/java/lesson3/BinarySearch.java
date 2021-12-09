package lesson3;

public class BinarySearch {

    public static void search(Integer[] arr) {

        int start = 0;
        int end = arr.length - 1;
        int base;

        while (end >= start) {
            base = (start + end) / 2;
            if (arr[base] - base == 1) {
                start = base + 1;
            } else {
                end = base - 1;
            }
        }
        System.out.println("пропущено: " + (start + 1));
    }
}


