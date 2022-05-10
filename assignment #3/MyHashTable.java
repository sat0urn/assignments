public class MyHashTable<K, V> {
    private static class HashNode<K, V> {
        private K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" + key + " " + value + "}";
        }
    }

    private HashNode<K, V>[] buckets;
    private int capacity = 7;
    private int length = 0;
    private float loadFactor = 0.75f;

    public MyHashTable() {
        buckets = new HashNode[capacity];
    }

    public MyHashTable(int initialCapacity) {
        capacity = (int) (initialCapacity * loadFactor);
        buckets = new HashNode[capacity];
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7FFFFFFF) % capacity;
    }

    public void put(K key, V value) {
        HashNode<K, V> newNode = new HashNode<>(key, value);
        int index = hash(key);

        for (HashNode<K, V> node = buckets[index]; node != null; node = node.next) {
            if (node.key.equals(key)) {
                System.out.println("The key " + key.hashCode() + " has a duplicate");
                return;
            }
        }

        if (buckets[index] == null) {
            buckets[index] = newNode;
        } else {
            newNode.next = buckets[index];
            buckets[index] = newNode;
        }
        length++;
    }

    public V get(K key) {
        int index = hash(key);

        HashNode<K, V> node = buckets[index];
        while (node != null) {
            if (node.key.equals(key))
                return node.value;
            node = node.next;
        }
        return null;
    }

    public boolean contains(V value) {
        for (HashNode<K, V> bucket : buckets) {
            for (HashNode<K, V> node = bucket; node != null; node = node.next) {
                if (node.value.equals(value))
                    return true;
            }
        }
        return false;
    }

    public V remove(K key) {
        int index = hash(key);
        HashNode<K, V> node = buckets[index];
        HashNode<K, V> temp = node;
        V removedValue = null;
        while (node != null) {
            if (buckets[index] == node && node.key.equals(key)) {
                removedValue = node.value;
                buckets[index] = node.next;
                return removedValue;
            } else if (node.key.equals(key)) {
                removedValue = node.value;
                temp.next = node.next;
            }
            temp = node;
            node = node.next;
        }
        return removedValue;
    }

    public K getKey(V value) {
        for (HashNode<K, V> bucket : buckets) {
            for (HashNode<K, V> node = bucket; node != null; node = node.next) {
                if (node.value.equals(value))
                    return node.key;
            }
        }
        return null;
    }

    public void printAll() {
        for (int i = 0; i < buckets.length; i++) {
            System.out.print(i + " -> ");
            HashNode<K, V> it = buckets[i];
            while (it != null) {
                System.out.print(it.value + "(" + it.key.hashCode() + ") ");
                it = it.next;
            }
            System.out.println();
        }
    }
}

