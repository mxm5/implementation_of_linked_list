package LinkedListImpl;

public class Rnf {
    public static void main(String[] args) {
        LinkedListB<Integer> b = new LinkedListB<>(31, 32, 53, 56, 46);
        b.print();
        b.moveElementToWardsTail(46);
        b.print();
        b.moveElementToWardsTail(56);
        b.print();
        b.moveElementToWardsTail(31);
        b.print();
        b.moveElementToWardsHead(56);
        b.print();
        b.moveElementToWardsHead(32);
        b.print();
        b.moveElementToWardsHead(46);
        b.print();
        b.moveElementToWardsHead(31);
        b.print();
        b.moveElementToWardsHead(31);
        b.print();
        b.removeIndex(0);
        b.print();

    }
}
