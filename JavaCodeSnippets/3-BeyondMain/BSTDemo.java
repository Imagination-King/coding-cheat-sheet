
/**
 * BinarySearchTreeDemo.java
 *
 * Demonstrates the power and flexibility of Binary Search Trees (BSTs)
 * using Strings as keys (words from a quote) and their indices as values.
 *
 */

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class BSTDemo {

    /**
     * ========================
     * BINARY SEARCH TREE CLASS
     * ========================
     */
    public static class BST<Key extends Comparable<Key>, Value> implements Iterable<Key> {

        private Node<Key, Value> root;

        private static class Node<Key, Value> {
            Key key;
            Value val;
            Node<Key, Value> left, right;

            Node(Key key, Value val) {
                this.key = key;
                this.val = val;
            }
        }

        /** Insert key-value pair */
        public void put(Key key, Value val) {
            root = put(root, key, val);
        }

        private Node<Key, Value> put(Node<Key, Value> x, Key key, Value val) {
            if (x == null)
                return new Node<>(key, val);
            int cmp = key.compareTo(x.key);
            if (cmp < 0)
                x.left = put(x.left, key, val);
            else if (cmp > 0)
                x.right = put(x.right, key, val);
            else
                x.val = val; // update existing
            return x;
        }

        /** Get value by key */
        public Value get(Key key) {
            Node<Key, Value> x = root;
            while (x != null) {
                int cmp = key.compareTo(x.key);
                if (cmp < 0)
                    x = x.left;
                else if (cmp > 0)
                    x = x.right;
                else
                    return x.val;
            }
            return null;
        }

        /** Check if key exists */
        public boolean contains(Key key) {
            return get(key) != null;
        }

        /** Min key */
        public Key min() {
            if (root == null)
                throw new NoSuchElementException("Tree empty");
            Node<Key, Value> x = root;
            while (x.left != null)
                x = x.left;
            return x.key;
        }

        /** Max key */
        public Key max() {
            if (root == null)
                throw new NoSuchElementException("Tree empty");
            Node<Key, Value> x = root;
            while (x.right != null)
                x = x.right;
            return x.key;
        }

        /** Delete minimum key */
        public void deleteMin() {
            if (root == null)
                throw new NoSuchElementException("Tree empty");
            root = deleteMin(root);
        }

        private Node<Key, Value> deleteMin(Node<Key, Value> x) {
            if (x.left == null)
                return x.right;
            x.left = deleteMin(x.left);
            return x;
        }

        /** Delete specific key */
        public void delete(Key key) {
            root = delete(root, key);
        }

        private Node<Key, Value> delete(Node<Key, Value> x, Key key) {
            if (x == null)
                return null;
            int cmp = key.compareTo(x.key);
            if (cmp < 0)
                x.left = delete(x.left, key);
            else if (cmp > 0)
                x.right = delete(x.right, key);
            else {
                if (x.right == null)
                    return x.left;
                if (x.left == null)
                    return x.right;
                Node<Key, Value> t = x;
                x = minNode(t.right);
                x.right = deleteMin(t.right);
                x.left = t.left;
            }
            return x;
        }

        private Node<Key, Value> minNode(Node<Key, Value> x) {
            while (x.left != null)
                x = x.left;
            return x;
        }

        /** Number of nodes */
        public int size() {
            return size(root);
        }

        private int size(Node<Key, Value> x) {
            if (x == null)
                return 0;
            return 1 + size(x.left) + size(x.right);
        }

        /** Tree height */
        public int height() {
            return height(root);
        }

        private int height(Node<Key, Value> x) {
            if (x == null)
                return -1;
            return 1 + Math.max(height(x.left), height(x.right));
        }

        /** Check if tree is balanced */
        public boolean isBalanced() {
            return isBalanced(root);
        }

        private boolean isBalanced(Node<Key, Value> x) {
            if (x == null)
                return true;
            int leftHeight = height(x.left);
            int rightHeight = height(x.right);
            if (Math.abs(leftHeight - rightHeight) > 1)
                return false;
            return isBalanced(x.left) && isBalanced(x.right);
        }

        /** Sideways tree print */
        public void printTree() {
            printTree(root, 0);
        }

        private void printTree(Node<Key, Value> x, int depth) {
            if (x == null)
                return;
            printTree(x.right, depth + 1);
            for (int i = 0; i < depth; i++)
                System.out.print("    ");
            System.out.println(x.key + " : " + x.val);
            printTree(x.left, depth + 1);
        }

        /** Pretty in-order print with depth-based indentation */
        public void prettyPrintInOrder() {
            prettyPrintInOrder(root, 0);
        }

        private void prettyPrintInOrder(Node<Key, Value> x, int depth) {
            if (x == null)
                return;
            prettyPrintInOrder(x.left, depth + 1);
            for (int i = 0; i < depth; i++)
                System.out.print("  ");
            System.out.println(x.key + " : " + x.val);
            prettyPrintInOrder(x.right, depth + 1);
        }

        /** Iterator for in-order traversal */
        @Override
        public Iterator<Key> iterator() {
            return new Iterator<Key>() {
                private final Stack<Node<Key, Value>> stack = new Stack<>();
                private Node<Key, Value> current = root;

                public boolean hasNext() {
                    return current != null || !stack.isEmpty();
                }

                public Key next() {
                    while (current != null) {
                        stack.push(current);
                        current = current.left;
                    }
                    if (stack.isEmpty())
                        throw new NoSuchElementException();
                    Node<Key, Value> node = stack.pop();
                    current = node.right;
                    return node.key;
                }
            };
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (Key key : this)
                sb.append(key).append(" ");
            return sb.toString().trim();
        }
    }

    /**
     * ===================
     * DEMONSTRATION (main)
     * ===================
     */
    public static void main(String[] args) {
        System.out.println("=== BINARY SEARCH TREE DEMO (Strings as Keys) ===");

        BST<String, Integer> bst = new BST<>();

        // Famous quote: "Not all those who wander are lost"
        String[] words = { "Not", "all", "those", "who", "wander", "are", "lost" };

        System.out.println("\nInserting words from the quote:");
        for (int i = 0; i < words.length; i++) {
            System.out.println("Inserting: " + words[i]);
            bst.put(words[i], i);
        }

        System.out.println("\nIn-order traversal (alphabetical order):");
        for (String key : bst)
            System.out.print(key + " ");
        System.out.println("\n");

        System.out.println("Tree structure (sideways):");
        bst.printTree();

        System.out.println("\nPretty in-order print (indented by depth):");
        bst.prettyPrintInOrder();

        System.out.println("\nTree height: " + bst.height());
        System.out.println("Tree is balanced? " + bst.isBalanced());

        // Lookups
        System.out.println("\nContains 'wander'? " + bst.contains("wander"));
        System.out.println("Value for 'wander': " + bst.get("wander"));

        // Delete example
        System.out.println("\nDeleting 'Not' (root key)...");
        bst.delete("Not");
        bst.printTree();
        System.out.println("\nPretty in-order after deletion:");
        bst.prettyPrintInOrder();

        System.out.println("\nTree height after deletion: " + bst.height());
        System.out.println("Tree is balanced? " + bst.isBalanced());
    }
}
