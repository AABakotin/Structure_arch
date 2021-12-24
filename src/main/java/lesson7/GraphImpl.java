package lesson7;

import java.util.*;

public class GraphImpl implements Graph {
    private final List<Vertex> vertexList;
    private final int[][] adjMatrix;


    public GraphImpl(int maxVertexCount) {
        this.vertexList = new ArrayList<>(maxVertexCount);
        this.adjMatrix = new int[maxVertexCount][maxVertexCount];

    }

    @Override
    public void addVertex(String label) {
        vertexList.add(new Vertex(label));
    }


    @Override
    public boolean addEdge(String startLabel, String secondLabel, int distance) {

        int startIndex = indexOf(startLabel);
        int endIndex = indexOf(secondLabel);

        if (startIndex == -1 || endIndex == -1) {
            return false;
        }
        adjMatrix[startIndex][endIndex] = distance;
        return true;
    }

    private int indexOf(String label) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (vertexList.get(i).getLabel().equals(label)) {
                return i;
            }
        }
        return -1;
    }


//    @Override
//    public boolean addEdge(String startLabel, String secondLabel, String... others) {
//        boolean result = addEdge(startLabel, secondLabel);
//
//        for (String other : others) {
//            result &= addEdge(startLabel, other);
//        }
//
//
//        return result;
//    }


    @Override
    public int getSize() {
        return vertexList.size();
    }

    @Override
    public void display(List<Route> routes) {
        Integer[] distance;
        distance = sumDistance(routes);
        List<Integer> shortestRoutes = minDistance(distance);
        for (int i : shortestRoutes
        ) {
            System.out.print(vertexList.get(routes.get(i).getRoute().get(0)));
            for (int j = 1; j < routes.get(i).getRoute().size(); j++) {
                System.out.print(" -> " +
                        vertexList.get(routes.get(i).getRoute().get(j)));

            }

        }

    }

    private Integer[] sumDistance(List<Route> routes) {
        Integer[] dist = new Integer[routes.size()];
        for (int i = 0; i < routes.size(); i++) {
            int sum = 0;
            int start = routes.get(i)
                    .getRoute()
                    .get(0);
            int finish;

            for (int j = 1; j < routes.get(i).getRoute().size(); j++) {
                finish = routes.get(i)
                        .getRoute()
                        .get(j);
                sum += adjMatrix[start][finish];
                start = finish;
            }
            dist[i] = sum;
        }
        return dist;
    }


    @Override
    public List<Route> find(String fromLabel, String toLabel) {
        int startIndex = indexOf(fromLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Неверная вершина: " + fromLabel);
        }
        Stack<Tracker> stack = new Stack<>();
        List<Route> routes = new ArrayList<>();
        Route route = new Route();
        Tracker tracker = new Tracker(startIndex, getSize());
        stack.push(tracker);
        while (!stack.isEmpty()) {
            while (tracker.isActive()) {
                if (adjMatrix[tracker.getLocation()][tracker.getIndex()] != 0) {

                    if (!route.contains(tracker.getLocation())) {
                        route.addIdex(tracker.getLocation());
                    }
                    if (vertexList.get(tracker.getIndex()).getLabel().equals(toLabel)) {
                        route.addIdex(indexOf(toLabel));

                        List<Integer> routeList = new ArrayList<>(route.getRoute());
                        Route rt = new Route();
                        rt.setRoute(routeList);
                        routes.add(rt);
                        route.deletePrevIndex();
                        tracker.next();
                    } else {
                        stack.push(tracker);
                        int index = tracker.getIndex();
                        tracker = new Tracker(index, getSize());
                    }
                } else {
                    tracker.next();
                }
            }
            route.deletePrevIndex();
            tracker = stack.pop();
            tracker.next();
        }
        return routes;
    }


    @Override
    public void dfs(String startLabel, String secondLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Неверная вершина: " + startLabel);
        }
        Stack<Vertex> stack = new Stack<>();
        Vertex vertex = vertexList.get(startIndex);
        resetVertexVisited();
        visitVertex(stack, vertex);
        while (!stack.isEmpty()) {
            vertex = getNearUnvisitedVertex(stack.peek());
            if (vertex != null) {
                visitVertex(stack, vertex);
            } else {
                stack.pop();
            }
        }
    }

    private Vertex getNearUnvisitedVertex(Vertex vertex) {
        int currentIndex = vertexList.indexOf(vertex);
        for (int i = 0; i < getSize(); i++) {
            if (adjMatrix[currentIndex][i] > 0 && !vertexList.get(i).isVisited()) {
                return vertexList.get(i);
            }
        }
        return null;
    }

    private void resetVertexVisited() {
        for (Vertex vertex : vertexList) {
            vertex.setVisited(false);
        }
    }

    private List<Integer> minDistance(Integer[] distance) {
        List<Integer> result = new ArrayList<>();
        int minDistance = distance[0];
        result.add(0);
        for (int i = 1; i < distance.length; i++) {
            if (distance[i] < minDistance) {
                minDistance = distance[i];
                result.clear();
                result.add(i);
            } else if (distance[i] == minDistance) {
                result.add(i);
            }
        }
        return result;
    }


    private void visitVertex(Stack<Vertex> stack, Vertex vertex) {
        System.out.print(vertex.getLabel() + " -> ");
        stack.add(vertex);
        vertex.setVisited(true);
    }

    private void visitVertex(Queue<Vertex> queue, Vertex vertex) {
        System.out.print(vertex.getLabel() + " -> ");
        queue.add(vertex);
        vertex.setVisited(true);
    }

    @Override
    public void bfs(String startLabel, String secondLabel) {
        int startIndex = indexOf(startLabel);
        int endIndex = indexOf(secondLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Неверная вершина: " + startLabel);
        }

        Queue<Vertex> queue = new LinkedList<>();
        Vertex vertexStart = vertexList.get(startIndex);
        Vertex vertexEnd = vertexList.get(endIndex);
        resetVertexVisited();

        visitVertex(queue, vertexStart);
        while (!queue.isEmpty() && !(vertexStart == vertexEnd)) {

            vertexStart = getNearUnvisitedVertex(queue.peek());
            if (vertexStart != null) {
                visitVertex(queue, vertexStart);
            } else {
                queue.remove();
            }
        }

    }

}
