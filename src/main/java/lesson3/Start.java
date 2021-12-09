package lesson3;

public class Start {


    public static void main(String[] args) {

    /*
             1. Дан массив из n элементов, начиная с 1. Каждый следующий элемент равен (предыдущий + 1).
             Но в массиве гарантированно 1 число пропущено.
             Необходимо вывести на экран пропущенное число.
    */

        Integer[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 16}; // => 11
        Integer[] arr2 = {1, 2, 4, 5, 6}; //=> 3
        Integer[] arr3 = {}; //  => 1

        BinarySearch.search(arr1);
        BinarySearch.search(arr2);
        BinarySearch.search(arr3);

    /*
        2. Создать класс для реализации Deque.
    */

        Deque<Integer> deq = new DequeImpl<>(6);

        insertRight(deq, 1);
        insertRight(deq, 2);
        insertRight(deq, 3);
        insertRight(deq, 4);// 1 2 3 4
        insertLeft(deq, 5); // 5 1 2 3 4
        insertLeft(deq, 6); // 6 5 1 2 3 4

        removeLeft(deq); // 5 1 2 3 4
        removeRight(deq); // 5 1 2 3

     //   displayLeftToRight(deq); // Queue
        displayRightToLeft(deq); //Stack
    }

    private static <E> void insertRight(Deque<E> deq, E value) {
        if (!deq.isFull()) {
            deq.insertRight(value);
        }
    }

    private static <E> void insertLeft(Deque<E> deq, E value) {
        if (!deq.isFull()) {
            deq.insertLeft(value);
        }
    }

    private static <E> void removeRight(Deque<E> deq) {
        if (!deq.isEmpty()) {
            deq.removeRight();
        }
    }

    private static <E> void removeLeft(Deque<E> deq) {
        if (!deq.isEmpty()) {
            deq.removeLeft();
        }
    }

    private static <E> void displayRightToLeft(Deque<E> deq) {
        while (!deq.isEmpty()) {
            System.out.print(deq.removeRight());
        }
    }

    private static <E> void displayLeftToRight(Deque<E> deq) {
        while (!deq.isEmpty()) {
            System.out.print(deq.removeLeft());
        }
    }
}
