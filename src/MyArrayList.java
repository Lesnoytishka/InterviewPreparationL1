import java.util.Arrays;

public class MyArrayList<T>  {
    private final int DEFAULT_CAPACITY = 10;
    private final Object[] EMPTY_DATA = {};

    private T[] arr;
    private float loadFactor = 0.75f;
    private int size = 0;

    @SuppressWarnings("unchecked")
    public MyArrayList() {
        arr = (T[]) new Object[DEFAULT_CAPACITY];
    }

    @SuppressWarnings("unchecked")
    public MyArrayList(int initialCapacity) {
        int capacity = initialCapacity > 0 ? initialCapacity : DEFAULT_CAPACITY;
        arr = (T[]) new Object[capacity];
    }

    public Object[] getArr() {
        return arr;
    }

    public void add(T el) {
        size++;
        checkCongestion();
        arr[size-1] = el;
    }

    public void set(T el, int index){
        arr[index] = el;
    }

    public T get(int index) {
        return (T) arr[index];
    }

    public void trimToSize() {
        if (size < arr.length) {
            arr = Arrays.copyOf(arr, size);
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public float getLoadFactor() {
        return loadFactor;
    }

    public void setLoadFactor(float loadFactor) {
        this.loadFactor = loadFactor;
    }

    private void checkCongestion() {
        if (size >= (arr.length * loadFactor)) {
            arr = Arrays.copyOf(arr, arr.length * 2 + 1);
        }
    }

    public Object[] toArray() {
        return Arrays.copyOf(arr, size);
    }

    public void remove(Object o) {
        if (o == null) {
            for (int index = 0; index < size; index++)
                if (arr[index] == null) {
                    fastRemove(index);
                    return;
                }
        } else {
            for (int index = 0; index < size; index++)
                if (o.equals(arr[index])) {
                    fastRemove(index);
                    return;
                }
        }
    }

    private void fastRemove(int index) {
        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(arr, index+1, arr, index,
                    numMoved);
        arr[--size] = null; // clear to let GC do its work
    }

    @SuppressWarnings("unchecked")
    public void clear() {
        arr = (T[]) EMPTY_DATA;
        size = 0;
    }

}
