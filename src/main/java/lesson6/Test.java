package lesson6;

public class Test {

    private static Tree<Integer> tree = new TreeImpl<>();


    public static void main(String[] args) {


        for (int i = 0; i < 10; i++) {
            generatorTree(10);
        }





//        Tree<Integer> tree = new TreeImpl<>();
//
//
//        tree.add(60);
//        tree.add(50);
//        tree.add(66);
//        tree.add(40);
//        tree.add(55);
//        tree.add(70);
//        tree.add(31);
//        tree.add(45);
//        tree.add(42);
//        tree.add(43);
//        tree.add(69);
//        tree.add(67);
//        tree.add(68);
//        tree.add(81);
//        System.out.println(tree.level());
//
//        tree.display();
////        tree.remove(31);
////        tree.remove(42);
//        tree.remove(70);
//        tree.remove(40);
//
//        tree.display();

//        tree.traverse(Tree.TraversMode.IN_ORDER);

    }

    public static void generatorTree(int countElements) {
            tree = new TreeImpl<>();
            while (countElements > 0) {
                    int a = (int) (Math.random() * (50 + 1)) - 25;
                    tree.add(a);
                    --countElements;
            }

        tree.display();



    }


}


