package LinkedListImpl;

public class Rnf {
    public static void main(String[] args) {
        LinkedListB<Integer> listB = new LinkedListB<>(31, 32, 53, 56, 46);
        listB.print();
        listB.moveElementToWardsTail(46);
        listB.print();
        listB.moveElementToWardsTail(56);
        listB.print();
        listB.moveElementToWardsTail(31);
        listB.print();
        listB.moveElementToWardsHead(56);
        listB.print();
        listB.moveElementToWardsHead(32);
        listB.print();
        listB.moveElementToWardsHead(46);
        listB.print();
        listB.moveElementToWardsHead(31);
        listB.print();
        listB.moveElementToWardsHead(31);
        listB.print();
        listB.removeIndex(0);
        listB.print();

    }
}
