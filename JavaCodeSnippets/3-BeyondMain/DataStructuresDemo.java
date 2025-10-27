import java.util.Iterator;
import java.util.NoSuchElementException;

public class DataStructuresDemo {

    /*
     * SINGLE LINKED LIST: collection of items linked together like a chain. The
     * LinkedList object itself keeps track of the first "chain," last "chain", and
     * the length of the chain.
     * 
     * <Item> is considered a generic parameter type, allowing the user to define
     * the type at compile time. Unlike if we were to use Objects, this will
     * actually let Java type check everything coming in and going out of the
     * LinkedList.
     */
    public static class LinkedList<Item> implements Iterable<Item> {
        // Private variables that can only be seen inside this class.
        private Node<Item> first; // First node
        private Node<Item> last; // Last node
        private int size = 0;

        /*
         * Node represents one link in the chain and has two variables: the Item itself
         * (whatever type specified at List creation) and a link to the next node in
         * the chain.
         */
        private static class Node<Item> {
            Item item;
            Node<Item> next;

            // This is the constructor for data type Node
            Node(Item item) {
                this.item = item;
            }
        }

        // Add an item to the front of the list
        public void addFirst(Item item) {
            Node<Item> newNode = new Node<>(item);
            newNode.next = first;
            first = newNode;
            if (last == null)
                last = first; // First node in list
            size++;
        }

        // Add an item to the end of the list
        public void addLast(Item item) {
            Node<Item> newNode = new Node<>(item);
            if (isEmpty()) {
                first = last = newNode;
            } else {
                last.next = newNode;
                last = newNode;
            }
            size++;
        }

        // Remove and return the last item in the list
        public Item removeLast() {
            if (isEmpty())
                throw new NoSuchElementException("List is empty");

            // Special case: only one element
            if (first == last) {
                Item item = first.item;
                first = last = null;
                size = 0;
                return item;
            }

            // Otherwise, iterate to second-to-last node
            Node<Item> current = first;
            while (current.next != last) {
                current = current.next;
            }
            Item item = last.item;
            last = current;
            last.next = null;
            size--;
            return item;
        }

        // Insert a new item after the first occurrence of 'key'
        public void insertAfter(Item key, Item newItem) {
            Node<Item> current = first;
            while (current != null && !current.item.equals(key)) {
                current = current.next;
            }
            if (current == null)
                throw new NoSuchElementException("Key not found: " + key);

            Node<Item> newNode = new Node<>(newItem);
            newNode.next = current.next;
            current.next = newNode;
            if (current == last)
                last = newNode; // Update last if inserted at end
            size++;
        }

        // Check if list is empty
        public boolean isEmpty() {
            return first == null;
        }

        // Return number of items
        public int size() {
            return size;
        }

        // Returns a string showing linked structure (A -> B -> C -> null)
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (Node<Item> x = first; x != null; x = x.next) {
                sb.append(x.item).append(" -> ");
            }
            sb.append("null");
            return sb.toString();
        }

        // Iterator for for-each loops
        @Override
        public Iterator<Item> iterator() {
            return new Iterator<Item>() {
                private Node<Item> current = first;

                public boolean hasNext() {
                    return current != null;
                }

                public Item next() {
                    if (!hasNext())
                        throw new NoSuchElementException();
                    Item item = current.item;
                    current = current.next;
                    return item;
                }
            };
        }
    }

    /*
     * STACK: follows the LIFO (Last In, First Out) principle.
     * Some people consider the last-added item to be "first" on the stack, but
     * here, it's labeled as the "top" to align with the imagery of a stack of
     * paper. You both add and remove paper from the top of the stack.
     */
    public static class Stack<Item> implements Iterable<Item> {

        private Node<Item> top; // For stacks, we only need to care about the item added last
        private int size = 0; // We also track how big the stack is, though this isn't necessary per se

        private static class Node<Item> { // same implementation as before
            Item item;
            Node<Item> next;

            Node(Item item) {
                this.item = item;
            }
        }

        // Add item onto top of stack. Make top point back to the next oldest.
        public void push(Item item) {
            Node<Item> oldTop = top;
            top = new Node<>(item);
            top.next = oldTop;
            size++;
        }

        // Remove top item from stack. Make the next oldest item the top.
        public Item pop() {
            if (isEmpty())
                throw new NoSuchElementException("Stack underflow");
            Item item = top.item;
            top = top.next;
            size--;
            return item;
        }

        // Return (but don’t remove) the top item
        public Item peek() {
            if (isEmpty())
                throw new NoSuchElementException("Stack underflow");
            return top.item;
        }

        public boolean isEmpty() {
            return top == null;
        }

        public int size() {
            return size;
        }

        // Allow iteration from top to bottom
        @Override
        public Iterator<Item> iterator() {
            return new StackIterator();
        }

        private class StackIterator implements Iterator<Item> {
            private Node<Item> current = top;

            public boolean hasNext() {
                return current != null;
            }

            public Item next() {
                if (!hasNext())
                    throw new NoSuchElementException();
                Item item = current.item;
                current = current.next;
                return item;
            }
        }
    }

    /*
     * QUEUE: follows the FIFO (First In, First Out) principle.
     * Like a line of people at a ticket booth. First one in line gets a ticket
     * first, and people join at the end of the line.
     */
    public static class Queue<Item> implements Iterable<Item> {

        private Node<Item> first; // Like stacks, we need to track the first item
        private Node<Item> last; // Unlike stacks, we also need to track the last item
        private int size = 0; // We still track the length of the queue, though it's still not necessary

        private static class Node<Item> { // nothing new here
            Item item;
            Node<Item> next;

            Node(Item item) {
                this.item = item;
            }
        }

        /*
         * Add item to the end of the queue. Update Node reference on former last item
         * to point to new item. Also increment size
         */
        public void enqueue(Item item) {
            Node<Item> oldLast = last;
            last = new Node<>(item);
            if (isEmpty()) {
                first = last;
            } else {
                oldLast.next = last;
            }
            size++;
        }

        /*
         * Return first item in queue and remove it. Make the former second item into
         * the first.
         */
        public Item dequeue() {
            if (isEmpty())
                throw new NoSuchElementException("Queue underflow");
            Item item = first.item;
            first = first.next;
            if (first == null)
                last = null;
            size--;
            return item;
        }

        public boolean isEmpty() {
            return first == null;
        }

        public int size() {
            return size;
        }

        // Allow iteration from front to back
        @Override
        public Iterator<Item> iterator() {
            return new QueueIterator();
        }

        private class QueueIterator implements Iterator<Item> {
            private Node<Item> current = first;

            public boolean hasNext() {
                return current != null;
            }

            public Item next() {
                if (!hasNext())
                    throw new NoSuchElementException();
                Item item = current.item;
                current = current.next;
                return item;
            }
        }
    }

    // ----Demo client code----
    public static void main(String[] args) {
        LinkedListDemo(); // Moved to its own method for readability

        System.out.println("\n=== STACK DEMO ==="); // Last in, First out
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        for (int n : stack) { // stack is 10 -> 20 -> 30
            System.out.println(n);
        }
        System.out.println("Popped: " + stack.pop()); // returns 30

        System.out.println("\n=== QUEUE DEMO ==="); // First in, First out
        Queue<String> queue = new Queue<>();
        queue.enqueue("One");
        queue.enqueue("Two");
        queue.enqueue("Three"); // queue is One -> Two -> Three
        for (String s : queue) {
            System.out.println(s);
        }
        System.out.println("Dequeued: " + queue.dequeue()); // returns One
    }

    private static void LinkedListDemo() {
        System.out.println("=== LINKED LIST DEMO ===");
        LinkedList<String> list = new LinkedList<>();

        // Demonstrate front and back insertion
        list.addFirst("C"); // C
        list.addFirst("B"); // B -> C
        list.addFirst("A"); // A -> B -> C
        list.addLast("D"); // A -> B -> C -> D
        System.out.println("After addFirst/addLast: " + list);

        // Demonstrate inserting in the middle
        list.insertAfter("B", "B2"); // A -> B -> B2 -> C -> D
        System.out.println("After insertAfter(\"B\", \"B2\"): " + list);

        // Demonstrate removeLast
        String removed = list.removeLast(); // removes D
        System.out.println("After removeLast (removed " + removed + "): " + list);

        // Demonstrate iteration
        System.out.print("Iterating through list: ");
        for (String s : list) {
            System.out.print(s + " ");
        }
        System.out.println("\n");
    }
}