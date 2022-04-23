public class MyHeap<T extends Comparable<T>> {
    private MyList<T> arr;

    public MyHeap() {
        arr = new MyArrayList<>();
    }

    private int currentIndex = 0;

    private int getLeftChildIndex(int parentIndex) { return 2 * parentIndex + 1; }
    private int getRightChildIndex(int parentIndex) { return 2 * parentIndex + 2; }
    private int getParentIndex(int childIndex) { return (childIndex - 1) / 2; }

    private boolean hasLeftChild(int index) { return getLeftChildIndex(index) < arr.size(); }
    private boolean hasRightChild(int index) { return getRightChildIndex(index) < arr.size(); }
    private boolean hasParent(int index) { return getParentIndex(index) >= 0; }

    private T leftChild(int index) { return arr.get(getLeftChildIndex(index)); }
    private T rightChild(int index) { return arr.get(getRightChildIndex(index)); }
    private T parent(int index) { return arr.get(getParentIndex(index)); }

    private void swap(int firstIndex, int secondIndex) {
        T temp = arr.get(firstIndex);
        arr.add(arr.get(secondIndex), firstIndex);
        arr.add(temp, secondIndex);
    }

    private boolean smallerOrGreater(T o, T o2){
        return o.compareTo(o2) > 0;
    }

    public int size() {
        return arr.size();
    }

    public T peek() {
        return arr.get(0);
    }

    public T get(int index) {
        return arr.get(index);
    }

    public void add(T item) {
        arr.add(item, arr.size());
        heapify();
    }

    public T removeRoot() {
        T item = arr.get(0);
        arr.add(arr.get(arr.size() - 1), 0);
        arr.remove(arr.size() - 1);
        currentIndex = 0;
        heapify();
        return item;
    }

    public boolean remove(T item) {
        boolean check = false;
        for (int i = 0; i < arr.size(); i++)
            if (arr.get(i).equals(arr.get(arr.indexOf(item)))) {
                check = true; break;
            }
        if (!check) return false;
        currentIndex = arr.indexOf(item);
        arr.add(arr.get(arr.size() - 1), arr.indexOf(item));
        arr.remove(arr.size() - 1);
        heapify();
        return true;
    }

    // min-heap

    private void heapify() {
        int index = arr.size() - 1;
        while (hasParent(index) && smallerOrGreater(parent(index), arr.get(index))) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
            if (hasParent(index) && !(smallerOrGreater(parent(index), arr.get(index))) ||
                !hasParent(index) && smallerOrGreater(parent(index), arr.get(index))) {
                break;
            }
        }
        while (hasLeftChild(currentIndex)) {
            int smallerChildIndex = getLeftChildIndex(currentIndex);
            if (hasRightChild(currentIndex) && smallerOrGreater(leftChild(currentIndex), rightChild(currentIndex))) {
                smallerChildIndex = getRightChildIndex(currentIndex);
            }

            if (smallerOrGreater(arr.get(smallerChildIndex), arr.get(currentIndex))) {
                break;
            } else {
                swap(currentIndex, smallerChildIndex);
                currentIndex = smallerChildIndex;
            }
        }
    }
}
