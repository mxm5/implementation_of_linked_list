package LinkedListImpl;

import java.util.HashSet;
import java.util.Set;

public class CashWithLinkedList<T> extends LinkedListB<T> {

    private int cacheSize = 4;

    private Set<T> uniqueEntries = new HashSet();

    public int getCacheSize() {
        return cacheSize;
    }

    public void setCacheSize(int cacheSize) {

        this.cacheSize = cacheSize;
    }

    @Override
    public boolean add(T element) {
        super.add(element);
        boolean add = uniqueEntries.add(element);
        if(!add) removeElement(element);
        if(size()>cacheSize) removeIndex(0);
         return true;

    }

    @Override
    public void addAll(T... elements) {


        if (size() < cacheSize)
            super.addAll(elements);
    }
}
