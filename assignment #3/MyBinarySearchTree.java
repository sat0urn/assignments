public class MyBinarySearchTree<K extends Comparable<K>, V> {
    private Node root;
    private class Node {
        private K key;
        private V value;
        private Node left, right;
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    public void put(K key, V val) {
        Node newNode = new Node(key, val);
        root = put(root, newNode);
    }
    private Node put(Node current, Node newNode) {
        if (current == null) return newNode;

        if (newNode.key.compareTo(current.key) > 0)
            current.right = put(current.right, newNode);
        else if (newNode.key.compareTo(current.key) < 0)
            current.left = put(current.left, newNode);
        return current;
    }

    public V get(K key) {
        return get(root, key);
    }
    private V get(Node node, K key) {
        if (node == null)
            return null;

        if (node.key.equals(key))
            return node.value;
        else if (node.key.compareTo(key) < 0)
            return get(node.right, key);
        else if (node.key.compareTo(key) > 0)
            return get(node.left, key);
        else
            return null;
    }

    public void delete(K key) {
        if(get(key) != null) {
            delete(root, key);
        }
    }
    private Node delete(Node node, K key) {
        if(node == null) {
            return node;
        }
        else if(node.key.compareTo(key) > 0) {
            node.left = delete(node.left, key);
        }
        else if(node.key.compareTo(key) < 0) {
            node.right = delete(node.right, key);
        }
        else {
            if(node.left == null && node.right == null) {
                node = null;
            }
            else if(node.right != null) {
                node.key = findMinV(node);
                node.right = delete(node.right, node.key);
            }
            else {
                node.key = findMaxV(node);
                node.left = delete(node.left, node.key);
            }
        }
        return node;
    }
    private K findMinV(Node node) {
        node = node.right;
        while(node.left != null){
            node = node.left;
        }
        return node.key;
    }
    private K findMaxV(Node node) {
        node = node.left;
        while(node.right != null){
            node = node.right;
        }
        return node.key;
    }

    //public Iterable<K> iterator() {}
}
