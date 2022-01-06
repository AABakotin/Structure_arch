package lesson8;

import java.util.ArrayList;

public class ChainHashTable <K, V> implements HashTable<K, V> {
    private final ArrayList<Item<K, V>>[] data;
    private int size;
    private int capacity;

    static class Item<K, V> implements Entry<K, V> {
        private final K key;
        private V value;

        public Item(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Item{" + "key=" + key + ", value=" + value + '}';
        }
    }

    public ChainHashTable(int initialCapacity) {
        this.data = new ArrayList[initialCapacity * 2];
    }

    public ChainHashTable() {
        this(16);
    }

    @Override
    public boolean put(K key, V value) {
        if (size() == data.length) {
            return false;
        }
        int index = hashFunc(key);

        if (data[index] == null) {
            ArrayList<Item<K, V>> itemsList = new ArrayList<>();
            Item newItem = new Item<>(key, value);
            itemsList.add(newItem);
            data[index] = itemsList;
            size++;
            capacity++;
            return true;
        }
        if(!isKeysContains(data[index], key)) {
            data[index].add(new Item<>(key, value));
            capacity++;
            return true;
        }
        return false;
    }

    private boolean isKeysContains(ArrayList<Item<K, V>> item, K key) {
        for (Item<K, V> i: item) {
            if(i.getKey().equals(key)) return true;
        }
        return false;
    }

    private int hashFunc(K key) {
        return Math.abs(key.hashCode() % data.length);
    }

    @Override
    public V get(K key) {
        int index = hashFunc(key);
        ArrayList<Item<K, V>> items = data[index];
        for (Item<K, V> i: items) {
            if(i.getKey().equals(key)) return i.getValue();
        }
        return null;
    }

    @Override
    public V remove(K key) {
        int index = hashFunc(key);
        ArrayList<Item<K, V>> items = data[index];
        for(int i = 0; i < items.size(); i++) {
            if(items.get(i).getKey().equals(key)) {
               Item<K, V> temp = items.get(i);
               items.remove(i);
                capacity--;

               if(items.size() == 0){
                   data[index] = null;
                   size--;
               }
               return temp.getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    public int quantity() {
        return capacity;
    }

    @Override
    public boolean isEmpty() {
        return size != 0;
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("-----------------------\n");
        for (int i = 0; i < data.length; i++) {
            sb.append(String.format("%d = [%s]%n", i, data[i]));
        }
        sb.append("-----------------------\n");
        return sb.toString();
    }
}
