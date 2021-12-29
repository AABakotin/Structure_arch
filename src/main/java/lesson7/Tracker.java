package lesson7;

public class Tracker {
    int location;
    int index;
    int size;

    public Tracker(int location, int size) {
        this.location = location;
        this.index = 0;
        this.size = size;
    }


    public void setSize(int size) {
        this.size = size;
    }

    public int getLocation() {
        return location;
    }

    public int getIndex() {
        return index;
    }

    public int getSize() {
        return size;
    }

    public void next() {
        index++;
    }


    public boolean isActive() {
        return index < size;
    }
}
