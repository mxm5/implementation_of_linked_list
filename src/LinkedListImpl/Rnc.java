package LinkedListImpl;

public class Rnc {
    public static void main(String[] args) {
        LinkedListB<Integer> listB = new LinkedListB<>(1,2,3,5);
        listB.print();
        listB.removeElement(3);
        listB.print();
        listB.removeElement(5);
        listB.print();
        LinkedListB<String > listC = new LinkedListB<>("a","b","c","d");
        listC.print();
        listC.removeElement("b");
        listC.print();

    }
}
