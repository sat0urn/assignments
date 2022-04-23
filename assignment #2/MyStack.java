public class MyStack<T extends Comparable<T>>  {
    private MyList<T> arr;

    public MyStack() {
        arr = new MyArrayList<>();
    }

    public void push(T value) {
        arr.add(value);
    }

    public T pop() {
        return arr.remove(arr.size() - 1);
    }

    public T peek() {
        return arr.get(arr.size() - 1);
    }

    public boolean isEmpty() {
        return arr.size() == 0;
    }

    public int size() {
        return arr.size();
    }
}
