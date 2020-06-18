import java.util.Arrays;

public class MyLinkedList<T> {
    private final int DEFAULT_CAPACITY = 10;
    private final Object[] EMPTY_DATA = {};

    private float loadFactor = 0.75f;
    private Node<T>[] arr;

    private int size = 0;
    private Node<T> first;
    private Node<T> last;

    @SuppressWarnings("unchecked")
    public MyLinkedList() {
        arr = new Node[DEFAULT_CAPACITY];
    }

    @SuppressWarnings("unchecked")
    public MyLinkedList(int initialCapacity) {
        int capacity = initialCapacity > 0 ? initialCapacity : DEFAULT_CAPACITY;
        arr = new Node[capacity];
    }

    public void addFirst(T el) {
        checkCongestion();
        if (size == 0) {
            setFirstNode(el);
        } else {
            arr[size + 1] = new Node<>(null, el, first, size + 1);
            first.setPrev(arr[size + 1]);
            first = arr[size + 1];
        }
        size++;
    }

    public void addLast(T el) {
        checkCongestion();
        if (size == 0) {
            setFirstNode(el);
        } else {
            arr[size + 1] = new Node<>(last, el, null, size + 1);
            last.setNext(arr[size + 1]);
            last = arr[size + 1];
        }
        size++;
    }

    private void setFirstNode(T el) {
        arr[0] = new Node<T>(null, el, null, 0);
        first = arr[0];
        last = arr[0];
    }

    private void checkCongestion() {
        if (size >= (arr.length * loadFactor)) {
            arr = Arrays.copyOf(arr, arr.length * 2 + 1);
        }
    }

    public void removeFirst() {
        if (size != 0) {
            first.getNext().setPrev(null);
            arr[size - 1].setIndex(first.getIndex());
            arr[first.getIndex()] = arr[size - 1];
            first = first.getNext();
        }
        size--;
    }

    public void removeLast() {
        if (size != 0) {
            last.getPrev().setNext(null);
            arr[size - 1].setIndex(last.getIndex());
            arr[last.getIndex()] = arr[size - 1];
            last = last.getPrev();
        }
        size--;
    }

    public void remove(T el) {
        Node<T> node = first;
        while (node.getNext() != null) {
            if (node.getItem().equals(el)) {
                arr[node.getIndex()] = arr[size - 1];
                if (node.getNext() != null) {
                    node.getNext().setPrev(node.getPrev());
                } else {
                    if (node.getPrev() != null) last = node.getPrev();
                }
                if (node.getPrev() != null) {
                    node.getPrev().setNext(node.getNext());
                } else {
                    if (node.getNext() != null) first = node.getNext();
                }
                size--;
                break;
            }
        }
    }

    @SuppressWarnings("unchecked")
    private void optimizeArray() {
        Node<T>[] tempArr = (Node<T>[]) new Object[size];
        Node<T> node = first;
        int counter = 0;
        while (node.getNext() != null) {
            tempArr[counter] = node;
            node.setIndex(counter);
            node = node.getNext();
            counter++;
        }
        arr = Arrays.copyOf(tempArr, size);
    }

    private static class Node<T> {
        private T item;
        private Node<T> next;
        private Node<T> prev;
        private int index;

        Node(MyLinkedList.Node<T> prev, T element, MyLinkedList.Node<T> next, int index) {
            this.item = element;
            this.next = next;
            this.prev = prev;
            this.index = index;
        }

        public T getItem() {
            return item;
        }

        public void setItem(T item) {
            this.item = item;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public Node<T> getPrev() {
            return prev;
        }

        public void setPrev(Node<T> prev) {
            this.prev = prev;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "item=" + item +
                    ", index=" + index +
                    '}';
        }
    }

    public float getLoadFactor() {
        return loadFactor;
    }

    public Node<T>[] getArr() {
        return arr;
    }

    public int getSize() {
        return size;
    }

    public Node<T> getFirst() {
        return first;
    }

    public Node<T> getLast() {
        return last;
    }
}
