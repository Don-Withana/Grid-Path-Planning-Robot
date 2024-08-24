public class IntArrayList {
    private Node head;

    // Method to add a new node with data at the beginning of the list
    public void addFirst(int[] data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Method to get the data at a specific index in the list
    public int[] get(int index) {
        Node current = head;
        for (int i = 0; i < index; i++) {
            if (current == null) {
                throw new IndexOutOfBoundsException("    Index out of bounds");
            }
            current = current.next;
        }
        if (current == null) {
            throw new IndexOutOfBoundsException("    Index out of bounds");
        }
        return current.data;
    }

    // Method to get the size of the list
    public int size() {
        int size = 0;
        Node current = head;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }
}
