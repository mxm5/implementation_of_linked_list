package LinkedListImpl;

public class CacheTests {
    public static void main(String[] args) {
        CashWithLinkedList<Integer> cach = new CashWithLinkedList<>();

        cach.add(1);

        cach.addAll(2, 3, 4);
        cach.print();
        cach.add(3);
        cach.print();
        cach.add(9);

        cach.print();

    }
}
