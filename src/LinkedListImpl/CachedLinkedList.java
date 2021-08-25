package LinkedListImpl;

public class CachedLinkedList<T> extends LinkedListB<T> {

    CashWithLinkedList<T> cache = new CashWithLinkedList<>();

    public CashWithLinkedList<T> getCache() {
        return cache;
    }

    public void setCache(CashWithLinkedList<T> cache) {
        this.cache = cache;
    }

    public CachedLinkedList() {
    }

    @SafeVarargs
    public CachedLinkedList(T... elements) {
        addAll(elements);

    }

    @Override
    public boolean add(T element) {
        boolean add = super.add(element);
        cache.add(element);
        return add;
    }


    T find(T element) {
        int step = 0;
        cache.reverse();
        System.out.print("search cache: ");
        for (T t1 : cache) {
            ++step;
            System.out.print(t1 + "->");
            if (t1.equals(element)) {
                System.out.println("found in cach in " + step + " steps");
                cache.reverse();
                cache.add(element);
                return t1;
            }
        }
        System.out.println(" was not in cache ");
        cache.reverse();


        System.out.print("search linkedlist: ");
        for (T t2 : this) {
            ++step;
            System.out.print(t2 + "->");

            if (t2.equals(element)) {
                System.out.print("found in linked list in " + step + " steps");
                cache.add(element);
                return t2;
            }
        }
        return null;
    }


}