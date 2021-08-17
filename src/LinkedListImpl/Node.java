package LinkedListImpl;

public class Node<T> {
    private Node<T> previous;
    private Node<T> next;
    private T nodeData;

    public Node(Node<T> previous,T nodeData ,Node<T> next ) {
        this.previous = previous;
        this.next = next;
        this.nodeData = nodeData;
    }

    public Node() {
    }

    public Node<T> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public T getNodeData() {
        return nodeData;
    }

    public void setNodeData(T nodeData) {
        this.nodeData = nodeData;
    }
}
