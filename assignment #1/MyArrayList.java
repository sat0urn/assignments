public class MyArrayList<T extends Comparable<T>> implements MyList<T> {
    private Object[] arr;
    private int length = 0;
    private int capacity = 1;

    public MyArrayList() {
        arr = new Object[capacity];
    }

    private boolean firstIsGreater(T a, T b) {
        return a.compareTo(b) > 0;
    }

    private void increaseCapacity() {
        capacity = 2 * capacity;
        Object[] temp = arr;
        arr = new Object[capacity];
        for(int i = 0; i < length; i++) {
            arr[i] = temp[i];
        }
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public void add(T item) {
        if(length == capacity)
            increaseCapacity();

        arr[length++] = item;
    }

    @Override
    public void add(T item, int index) {
        if(index < length){
            arr[index] = item;
        } else if (index == length){
            this.add(item);
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }

    }

    @Override
    public boolean removeByItem(T item) {
        for (int i = 0; i < length; i++) {
            if (item.equals(arr[i]) || item == arr[i]) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public T remove(int index) {
        T ex = (T) arr[index];
            arr[index] = null;
        if (arr[index] == null) {
            for (int j = index; j < length - 1; j++) {
                T temp = (T) arr[j + 1];
                arr[j + 1] = arr[j];
                arr[j] = temp;
            }
            length--;
        }
        return ex;
    }

    @Override
    public void clear() {
        for (int i = 0; i < length; i++)
            arr[i] = null;
        length = 0;
    }

    @Override
    public T get(int index) {
        return (T) arr[index];
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < length; i++) {
            if (arr[i] == o) return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int index = -1;
        for (int i = 0; i < length; i++) {
            if (arr[i].equals(o))
                index = i;
        }
        return index;
    }

    @Override
    public void sort() {
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                T el1 = this.get(j); T el2 = this.get(j + 1);
                if (firstIsGreater(el1, el2)) {
                    this.add(el2, j);
                    this.add(el1, j + 1);
                }
            }
        }
    }
}
