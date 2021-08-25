package LinkedListImpl;

import java.util.HashSet;
import java.util.Set;

public class CashWithLinkedList<T> extends LinkedListB<T> {

    private int cacheSize = 4;

    private Set<T> uniqueEntries = new HashSet();

//    private Set<T> uniqeEnteriesRecalculate(){
//
//    }

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
        if(!add) {
            removeElement(element);
        }
        if(size()>cacheSize) {

            T leastUsed = this.get(0);
            uniqueEntries.remove(leastUsed);
            boolean b = removeIndex(0);
//            System.out.println("removed first");
//            System.out.println(uniqueEntries);
//            this.print();
        }
         return true;

    }

    @Override
    public void addAll(T... elements) {


        if (size() < cacheSize)
            super.addAll(elements);
    }


}
