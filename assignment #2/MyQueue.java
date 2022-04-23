public class MyQueue<T extends Comparable<T>> {
    private MyList<T> arr;

    public MyQueue() {
        arr = new MyLinkedList<>();
    }

    public void enqueue(T value) {
        arr.add(value);
    }

    public T dequeue() {
        return arr.remove(0);
    }

    public T peek() {
        return arr.get(0);
    }

    public int size() {
        return arr.size();
    }

    public boolean isEmpty() {
        return arr.size() == 0;
    }
}
