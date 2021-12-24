package lesson7;

import java.util.List;

public interface Graph {

    void addVertex(String label);

    //    boolean addEdge(String startLabel, String secondLabel, String... others);
    boolean addEdge(String startLabel, String secondLabel, int distance);

    int getSize();

    List<Route> find(String startLabel, String secondLabel);

    void display(List<Route> routes);


    /**
     * англ. Depth-first search, DFS
     */
    void dfs(String startLabel, String secondLabel);

    /**
     * англ. breadth-first search, BFS
     */
    void bfs(String startLabel, String secondLabel);

}
