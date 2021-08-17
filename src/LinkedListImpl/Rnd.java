package LinkedListImpl;

public class Rnd {
    public static void main(String[] args) {
        LinkedListB<Integer> listB = new LinkedListB<>(1,22,4,6,2);
        listB.print();
        listB.removeIndex(0);
        listB.print();
        listB.add(300);
        listB.print();
        listB.poll();
        listB.print();
        listB.poll();
        listB.print();
        listB.poll();
        listB.print();
    }
}
