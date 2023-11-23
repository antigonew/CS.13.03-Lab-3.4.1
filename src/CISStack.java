import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class CISStack {
    private Node top;
    private int size;

    public CISStack() {
        top = null;
        size = 0;
    }

    public void push(Integer data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public Integer pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        Integer data = top.data;
        top = top.next;
        size--;
        return data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CISStack{stack=[");
        Node current = top;
        List<Integer> elements = new ArrayList<>();
        while (current != null) {
            elements.add(current.data);
            current = current.next;
        }
        for (int i = elements.size() - 1; i >= 0; i--) {
            sb.append(elements.get(i));
            if (i > 0) {
                sb.append(", ");
            }
        }
        sb.append("], size=").append(size).append("}");
        return sb.toString();
    }
    private static class Node {
        private Integer data;
        private Node next;

        public Node(Integer data) {
            this.data = data;
            this.next = null;
        }
    }
}