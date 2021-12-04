package lesson2;

import java.util.ArrayList;
import java.util.List;


public class Main {



    private static final int NOTEBOOKS_COUNT = 1000;

    public static void main(String[] args) {
        List<Notebook> notebookArrayList = createListNotebooks();


        Sort.selection(notebookArrayList);
        viewListNotebooks(notebookArrayList);


    }


    private static ArrayList<Notebook> createListNotebooks() {
        ArrayList<Notebook> arrayList = new ArrayList<>();
        for (int i = 0; i < NOTEBOOKS_COUNT; i++) {
            arrayList.add(new Notebook());
        }
        return arrayList;
    }


    private static void viewListNotebooks(List<Notebook> list) {
        for (Notebook n : list) {
            System.out.printf("Ноутбук:\tцена: %s\tпамять: %s\tпроизводитель: %s%n", n.getPrice(), n.getMemory(), n.getName());

        }
    }
}
