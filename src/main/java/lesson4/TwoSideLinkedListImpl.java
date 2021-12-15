package lesson4;

import java.util.Iterator;

public class TwoSideLinkedListImpl<E> extends SimpleLinkedListImpl<E> implements TwoSideLinkedList<E>, Iterable<E> {

    protected Node<E> last;

    @Override
    public void insertFirst(E value) {
        super.insertFirst(value);
        if (size == 1) {
            last = first;
        }
    }

    @Override
    public void insertLast(E value) {
        if (isEmpty()) {
            insertFirst(value);
            return;
        }

        Node<E> newNode = new Node<>(value, null);

        last.next = newNode;
//        last = last.next;
        last = newNode;
        size++;
    }

    @Override
    public E removeFirst() {
        E removedValue = super.removeFirst();

        if (isEmpty()) {
            last = null;
        }

        return removedValue;
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
        } else if (current == last) {
            last = prev;
            last.next = null;
        }

        prev.next = current.next;
        current.next = null;
        size--;

        return true;
    }

    @Override
    public Iterator<E> iterator() {
        return new IteratorLink ();
    }

    @Override
    public E getLast() {
        return last.item;
    }




    private class IteratorLink implements Iterator<E> {

        private final TwoSideLinkedListImpl <E> list;
        Node<E> current;
        Node<E> prev;

        public IteratorLink() {
            this.list = TwoSideLinkedListImpl.this;
            reset();
        }


        @Override
        public boolean hasNext() {
            return current != null;
        }

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



        public void reset() {
            current = list.first;
            prev = null;
        }

    }
}
