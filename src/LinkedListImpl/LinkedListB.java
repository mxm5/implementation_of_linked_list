package LinkedListImpl;

import java.util.*;

public class LinkedListB<T> implements Iterable<T>, LinkedListApis<T> {

    Node<T> headNode = new Node<>(null, null, null);

    private int size = 0;

    Node<T> tailNode;

    private Iterator<T> iterator = new LinkedListIterator<T>(headNode);

    private boolean reverse = false;

    void reverse() {
        this.reverse = !reverse;
    }


    public Iterator<T> getIterator() {
        return iterator;
    }

    public void setIterator(Iterator<T> iterator) {
        this.iterator = iterator;
    }

    public LinkedListB() {
        headNode = null;
        tailNode = null;
        setIterator(iterator);
    }

    public LinkedListB(T... elements) {
        this.addAll(Arrays.stream(elements).toList());
    }


    public boolean add(T element) {
        if (headNode == null || (headNode.getNodeData() == null && headNode.getNext() == null)) {
            headNode = new Node<T>(null, element, null);
            tailNode = headNode;
            setIterator(iterator);
            ((LinkedListIterator<T>) iterator).setCurrentNode(headNode);
            ++size;
            return true;
        } else if (tailNode != null && tailNode.getNext() == null) {
            tailNode.setNext(new Node<T>(tailNode, element, null));
            this.tailNode = tailNode.getNext();
            ++size;
            return true;
        }

        return false;
    }

    @Override
    public boolean removeElement(T element) {
        reverse = false;
        for (T item : this) {
            if (item.equals(element)) {
                Node<T> currentNode = ((LinkedListIterator<T>) this.getIterator()).getCurrentNode();
                currentNode = currentNode != null ? currentNode.getPrevious() : this.tailNode;
                removeNode(currentNode);
                size--;
                break;
            }
        }
        return false;
    }


    @Override
    public boolean removeIndex(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException("index out of range");

        int counter = 0;


        for (T x : this) {
            if (counter == index) {
                Node<T> currentNode = ((LinkedListIterator<T>) this.getIterator()).getCurrentNode();
                currentNode = currentNode != null ? currentNode.getPrevious() : this.tailNode;

                removeNode(currentNode);
                size--;
                return true;

            }
            counter++;

        }
        return false;
    }

    @Override
    public void poll() {
        removeNode(tailNode);
        size--;
    }


    public boolean addAll(Collection<? extends T> c) {
        try {
            for (T element : c) add(element);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public int size() {
        return size;
    }


    public boolean isEmpty() {
        return size == 0;
    }


    public boolean contains(T search) {
        for (T element : this) {
            if (search == element) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        if (reverse)
            iterator = new LinkedListReverseIterator(tailNode);
        else
            iterator = new LinkedListIterator<T>(headNode);
        return iterator;
    }


    public T[] toArray() {
        ArrayList<T> array = new ArrayList<>(size);

        for (T element : this)
            array.add(element);

        return (T[]) array.toArray();
    }

    @Override
    public int indexOf(T search) {

        int index = 0;
        for (T element : this) {
            if (search == element) {
                return index;
            }
            index++;
        }
        return -1;
    }


    @Override
    public boolean insertAt(int index, T input) {
        reverse = false;
        int counter = 0;

        Node<T> node = new Node<T>(null, input, null);

        for (T x : this) {
            if (counter == index) {
                Node<T> currentNode = ((LinkedListIterator<T>) this.getIterator()).getCurrentNode();
                currentNode = currentNode != null ? currentNode.getPrevious() : this.tailNode;

                this.insertBehind(node, currentNode);
                return true;

            }
            counter++;

        }
        return false;
    }

    @Override
    public T get(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException("index out of range");
        int maxIndex = size - 1;
        reverse = (maxIndex / 2) < index;
        int counter = 0;
        int recalculatedIndex = reverse ? maxIndex - index : index;


        for (T x : this) {

            if (counter == recalculatedIndex) {

                return x;
            }
            counter++;

        }
        return null;
    }


    public T getWithLog(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException("index out of range");
        int maxIndex = size - 1;
        reverse = (maxIndex / 2) < index;
        int counter = 0;
        int recalculatedIndex = reverse ? maxIndex - index : index;
        String begin = reverse ? "[ end ]" : "[start]";
        System.out.print(begin);
        for (T x : this) {
            System.out.print(" " + x + " ->");
            if (counter == recalculatedIndex) {
                System.out.print("[" + x + "= result]");
                return x;
            }
            counter++;

        }
        return null;
    }

    @Override
    public void print() {
        System.out.print("\n[");
        for (T k : this) System.out.print(k + ",");
        System.out.println("]" + " -> size : " + size);
    }

    @Override
    public T peek() {
        return tailNode.getNodeData();
    }


    boolean insertBehind(Node<T> newNode, Node<T> nodeInPosition) {


        Node<T> previousNode = nodeInPosition.getPrevious();
        if (previousNode != null) previousNode.setNext(newNode);
        newNode.setPrevious(previousNode);
        nodeInPosition.setPrevious(newNode);
        newNode.setNext(nodeInPosition);
        if (newNode.getPrevious() == null) headNode = newNode;
        size++;
        return true;
    }

    private boolean removeNode(Node<T> removedNode) {

        if (removedNode.equals(tailNode)) {
            Node<T> tailsPreviousNode = tailNode.getPrevious();
            tailsPreviousNode.setNext(null);
            tailNode = tailsPreviousNode;
            return true;
        } else if (removedNode.equals(headNode)) {
            Node<T> headNextNode = headNode.getNext();
            headNextNode.setPrevious(null);
            headNode = headNextNode;
            return true;
        } else {
            Node<T> nodePrevious = removedNode.getPrevious();
            Node<T> nodeNext = removedNode.getNext();
            nodePrevious.setNext(nodeNext);
            nodeNext.setPrevious(nodePrevious);
            return true;
        }


    }

}
