package LinkedListImpl;

public interface LinkedListApis<T> {

    boolean add(T element);

    boolean removeElement(T element);

    boolean removeIndex(int index);

    T poll();

    int size();

    boolean contains(T element);

    T[] toarray();

    int indexOf(T element);

    boolean insertAt(int index , T element);

    T get(int index);

    void print();

    T peek();



    boolean insertAtHead(T element);

    boolean insertAtTail(T element);

    void moveElementToWardsHead(T element);

    void moveElementToWardsTail(T element);

}
