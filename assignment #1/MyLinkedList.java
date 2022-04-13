public class MyLinkedList<T extends Comparable<T>> implements MyList<T>{
    private static class MyNode<T>{
        T data;
        MyNode<T> next, prev;

        MyNode(T data) { this.data = data; }
    }

    private int length = 0;
    private MyNode<T> head, tail;

    public MyLinkedList() {}

    private boolean firstIsGreater(T ob, T ob2){
        return ob.compareTo(ob2) > 0;
    }

    private void deleteNode(MyNode<T> node){
        MyNode<T> nextNode = node.next;
        MyNode<T> prevNode = node.prev;
        if (prevNode == null)
            head = nextNode;
        else if (nextNode == null)
            tail = node.prev;
        else {
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
        }
        length--;
    }

    @Override
    public int size() { return length; }

    @Override
    public boolean contains(Object ob) {
        MyNode<T> i = head;
        do {
            i = i.next;
            if (i.data.equals(ob))
                return true;
        } while (i.next != null);

        return false;
    }

    @Override
    public void add(T item) {
        MyNode<T> newNode = new MyNode<>(item);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    @Override
    public void add(T item, int index) {
        if (index > length) {
            int n = index - length;
            for(int i=0; i<n; i++)
                this.add(null);
            this.add(item);
        } else if(index == length){
            this.add(item);
        } else {
            MyNode<T> temp = head;
            for(int i=0; i<index; i++){
                temp = temp.next;
            }
            temp.data = item;
        }
    }

    @Override
    public boolean removeByItem(T item) {
        for(MyNode<T> node = head; node != null; node = node.next) {
            if (item == node.data) {
                deleteNode(node);
                return true;
            }
        }
        return false;
    }

    @Override
    public T remove(int index) {
        MyNode<T> temp = head;
        for(int i = 0; i < index; i++) {
            temp = temp.next;
        }
        T removed = temp.data;
        deleteNode(temp);
        return removed;
    }

    @Override
    public void clear() {
        length = 0;
        head = null;
        tail = null;
    }

    @Override
    public T get(int index) {
        if (index >= length || index < 0)
            throw new IndexOutOfBoundsException("index should be positive and less than size");
        MyNode<T> temp = head;

        while (index != 0) {
            temp = temp.next;
            index--;
        }
        return temp.data;
    }

    @Override
    public int indexOf(Object o) {
        int i = 0;
        for(MyNode<T> node = head; node != null; node = node.next, i++)
            if(node.data.equals(o))
                return i;
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int index = -1;
        int i = 0;
        for(MyNode<T> node = head; node != null; node = node.next, i++)
            if (node.data == o)
                index = i;
        return index;
    }

    @Override
    public void sort() {
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                T el1 = this.get(j); T el2 = this.get(j + 1);
                if (firstIsGreater(el1, el2)) {
                    this.add(el2, j);
                    this.add(el1,j + 1);
                }
            }
        }
    }
}
