package lesson7;

import java.util.ArrayList;
import java.util.List;

public class Route {

    private List<Integer> route;

    public Route() {
        this.route = new ArrayList<>();
    }


    public List<Integer> getRoute() {
        return route;
    }

    public void setRoute(List<Integer> route) {
        this.route = route;
    }

    public void addIdex(Integer idx) {
        route.add(idx);

    }

    public void deletePrevIndex() {
        int size = route.size();
        if (size == 0)
            return;
        route.remove(size - 1);
    }

    public boolean contains(Integer idx) {
        return route.contains(idx);
    }
}
