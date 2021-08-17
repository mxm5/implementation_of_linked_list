package LinkedListImpl;

public interface LinkedListApis<T> {

    boolean add(T element);

    boolean removeElement(T element);

    boolean removeIndex(int index);

    void poll();

    int size();

    boolean contains(T element);

    T[] toArray();

    int indexOf(T element);

    boolean insertAt(int index , T element);

    T get(int index);

    void print();

    T peek();
}
