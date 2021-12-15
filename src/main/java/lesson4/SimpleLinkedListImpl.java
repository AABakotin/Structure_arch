package lesson4;

import java.util.Iterator;

public class SimpleLinkedListImpl<E> implements LinkedList<E>, Iterable<E> {

    protected Node<E> first;
    protected int size;

    @Override
    public void insertFirst(E value) {
        first = new Node<>(value, first);
        size++;
/*        Node<E> actualFirst = first;
        Node<E> newFirst = new Node<>(value, actualFirst);
        this.first = newFirst;*/
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }

        Node<E> removedNode = first;
        first = removedNode.next;
        removedNode.next = null;
        size--;
        return removedNode.item;
    }

    @Override
    public boolean remove(E value) {
        Node<E> current = first;
        Node<E> prev = null;

        while (current != null) {
            if (current.item.equals(value)) {
                break;
            }
            prev = current;
            current = current.next;
        }

        if (current == null) {
            return false;
        } else if (current == first) {
            removeFirst();
            return true;
        }

        prev.next = current.next;
        current.next = null;
        size--;

        return true;
    }

    @Override
    public boolean contains(E value) {
        Node<E> current = first;
        while (current != null) {
            if (current.item.equals(value)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> current = first;
        while (current != null) {
            sb.append(current.item);
            if (current.next != null) {
                sb.append(" -> ");
            }
            current = current.next;
        }
        return sb.append("]").toString();
    }

    @Override
    public E getFirst() {
        return first.item;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }


    private class LinkedListIterator implements Iterator<E> {

        private SimpleLinkedListImpl<E> list;
        Node<E> current;
        Node<E> prev;


        public LinkedListIterator() {
            this.list = SimpleLinkedListImpl.this;
            reset();
        }


        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            while (!hasNext()) {
                return null;
            }
            E item = current.item;
            prev = current;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {
            if (prev == null) {
                list.first = current.next;
                reset();
            } else {
                prev.next = current.next;
                if (!hasNext()) {
                    reset();
                } else {
                    current = current.next;
                }

            }
        }

        public void reset() {
            current = list.first;
            prev = null;
        }
    }
}
