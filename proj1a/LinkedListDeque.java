public class LinkedListDeque<T> {
    private class Node<T> {
        Node prev;
        Node next;
        T element;
        public Node(T a, Node nprev, Node nnext) {
           element = a;
           prev = nprev;
           next = nnext; 
        }
    }

    private int len;
    private Node lld;

    public LinkedListDeque(LinkedListDeque other) {
        T k = null;
        lld = new Node<T>(k, null, null);
        len = 0;
        int l = other.size();
        for (int i = 0; i < l; i += 1) {
            this.addLast((T) other.get(i + 1));
        }
    }

    public LinkedListDeque() {
        T k = null;
        lld = new Node<T>(k, null, null);
        lld.next = lld;
        lld.prev = lld;
        len = 0;
    }

    public boolean isEmpty() {
        if(len == 0) {
            return true;
        }
        return false;
    }

    public void printDeque() {
        int i = 0;
        Node temp = lld;
        while (i < len) {
            temp = temp.next;
            i += 1;
            System.out.print(temp.element);
            System.out.print(" ");
        }
    }

    public void addLast(T a) {
        Node temp = new Node<T>(a, lld.prev, lld);
        lld.prev = temp;
        temp.prev.next = temp;
        len += 1;
    }

    public void addFirst(T item) {
        Node temp = new Node<T>(item, lld.next, lld);
        lld.next = temp;
        temp.next.prev = temp;
        len += 1;
    }    

    public T removeLast() {
        T ret =(T) lld.prev.element;
        if (len <= 0) {
            System.out.println("Error!");
        }
        len -= 1;
        lld.prev.prev.next = lld;
        lld.prev = lld.prev.prev;
        return ret;
    }

    public T removeFirst() {
        T ret =(T) lld.next.element;
        if (len <= 0) {
            System.out.println("Error!");
        }
        len -= 1;
        lld.next.next.prev = lld;
        lld.next = lld.next.next;
        return ret;
    }
    public T get(int i) {
        if (i > len) {
            System.out.println("Error!");
        }
        Node temp = lld;
        for (int j = 0; j < i; j += 1) {
            temp = temp.next;
        }
        return (T) temp.element;
    }

    public int size() {
        return len;
    }
}