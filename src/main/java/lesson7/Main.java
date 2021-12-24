package lesson7;

import java.util.List;

public class Main {


    public static void main(String[] args) {
//      testGraph();
//        testDfs();
        testBfs();
    }

    private static void testGraph() {

        Graph graph = new GraphImpl(7);


        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");

        graph.addEdge("A", "B", 100);
        graph.addEdge("B", "C", 2000);
        graph.addEdge("C", "A", 500);
        graph.addEdge("D", "B", 300);

        System.out.println("Size of graph is " + graph.getSize());
//        graph.display();
    }

//    private static void testDfs() {
//        Graph graph = new GraphImpl(7);
//        graph.addVertex("A");
//        graph.addVertex("B");
//        graph.addVertex("C");
//        graph.addVertex("D");
//        graph.addVertex("E");
//        graph.addVertex("F");
//        graph.addVertex("G");
//
//        graph.addEdge("A", "B", "C", "D");
//        graph.addEdge("B", "E");
//        graph.addEdge("D", "F");
//        graph.addEdge("F", "G");
//
//        graph.dfs("A");
//    }

    private static void testBfs() {
        List<Route> routeList;
        Graph graph = new GraphImpl(10);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");
        graph.addVertex("H");
        graph.addVertex("W");
        graph.addVertex("Y");


        graph.addEdge("A", "B", 50);
        graph.addEdge("A", "C", 50);
        graph.addEdge("A", "H", 50);
        graph.addEdge("B", "E", 100);
        graph.addEdge("E", "W", 300);
        graph.addEdge("W", "Y", 500);
        graph.addEdge("Y", "F", 300);
        graph.addEdge("F", "G", 400);
        graph.addEdge("G", "D", 400);
//        graph.addEdge("D", "I", 400);
//        graph.addEdge("F", "O", 400);


//        graph.bfs("A","F");




        routeList = graph.find("A", "D");
        graph.display(routeList);


    }
}
