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
                Node<T> currentNode = getCurrentNode();
                removeNode(currentNode);
                size--;
                break;
            }
        }
        return false;
    }


    public boolean removeReverseElement(T element) {
        reverse = true;
        for (T item : this) {
            if (item.equals(element)) {
                Node<T> currentNode = getCurrentNode();
                removeNode(currentNode);
                size--;
                reverse =false;
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
                Node<T> currentNode = getCurrentNode();

                removeNode(currentNode);
                size--;
                return true;

            }
            counter++;

        }
        return false;
    }

    @Override
    public T poll() {
        removeNode(tailNode);
        size--;
        return tailNode.getNodeData();
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
            iterator = new LinkedListReverseIterator<T>(tailNode);
        else
            iterator = new LinkedListIterator<T>(headNode);
        return iterator;
    }


    public  T[] toarray() {
        ArrayList<T> array = new ArrayList<>(size);

        for (T element : this)
            array.add(element);

        return (T[]) array.toArray( );
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
                Node<T> currentNode = getCurrentNode();

                this.insertBehind(node, currentNode);
                return true;

            }
            counter++;

        }
        return false;
    }

    private Node<T> getCurrentNode() {
        Node<T> currentNode = ((LinkedListIterator<T>) this.getIterator()).getCurrentNode();
        currentNode = currentNode != null ? currentNode.getPrevious() : this.tailNode;
        return currentNode;
    }

    @Override
    public T get(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException("index out of range");
        int maxIndex = size - 1;
        reverse = (maxIndex / 2) < index;
        int counter = 0;
        int recalculatedIndex = reverse ? maxIndex - index : index;


        for (T element : this) {

            if (counter == recalculatedIndex) {
                reverse = false;
                return element;
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
        for (T elemtnt : this) {
            System.out.print(" " + elemtnt + " ->");
            if (counter == recalculatedIndex) {
                System.out.print("[" + elemtnt + "= result]");
                reverse = false;
                return elemtnt;
            }
            counter++;

        }
        return null;
    }

    @Override
    public void print() {
        System.out.print("[");
        for (T k : this) System.out.print(k + ",");
        System.out.println("]" + " -> size : " + size);
    }

    @Override
    public T peek() {
        return tailNode.getNodeData();
    }



    @Override
    public boolean insertAtHead(T element) {

        return insertAt(0,element);
    }

    @Override
    public boolean insertAtTail(T element) {
        return add(element);
    }

    @Override
    public void moveElementToWardsHead(T element) {
        if(!element.equals(headNode.getNodeData())) {
            int index = indexOf(element);
            insertAt(index-1,element);
            removeIndex(index+1);


        }

        }


    @Override
    public void moveElementToWardsTail(T element) {
        if(!element.equals(tailNode.getNodeData())) {
            int index = indexOf(element);
            T next = get(index + 1);
            moveElementToWardsHead(next);
        }
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

    public  void addAll(T ... elements) {
        this.addAll(Arrays.stream(elements).toList());
    }
}
