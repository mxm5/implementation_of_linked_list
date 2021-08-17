package LinkedListImpl;

import java.util.Iterator;

public class LinkedListReverseIterator<T>  implements Iterator<T>  {

    public Node<T> getCurrentNode() {
        return currentNode;
    }

    public void setCurrentNode(Node<T> currentNode) {
        this.currentNode = currentNode;

    }

    private Node<T> currentNode;


    public LinkedListReverseIterator(Node<T> startingNode) {
        currentNode =startingNode;



    }

    @Override
    public boolean hasNext() {
        return currentNode != null;
    }

    @Override
    public T next() {

        T nodeData = currentNode.getNodeData();
        currentNode = currentNode.getPrevious();
        return nodeData;
    }


}


