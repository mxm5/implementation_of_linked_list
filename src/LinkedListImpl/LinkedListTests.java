package LinkedListImpl;

public class LinkedListTests {

    public static <T> void print(T object) {
        System.out.println(object);
    }

    public static void main(String[] args) {
        LinkedListB<Integer> customLinkedList =
                new LinkedListB<>(1, 2, 3, 4, 6, 7, 8);

        print("iterate through list");
        for (Integer element : customLinkedList) print(element);

        print("contains 8 ?");
        print(customLinkedList.contains(8));
        print("contains 9 ?");
        print(customLinkedList.contains(9));

        print("index of 8 ?");
        print(customLinkedList.indexOf(8));

        print("index of 9 ?");
        print(customLinkedList.indexOf(9));
        // reversing
        customLinkedList.reverse();
        print("reversing list");
        for (Integer element : customLinkedList) print(element);

        print("first the list was this");
        customLinkedList.reverse();
        for (Integer element : customLinkedList) System.out.print(element + ",");
        print("then");

        print("insert the 11 in index 2");

        customLinkedList.insertAt(2, 11);
        for (Integer element : customLinkedList) System.out.print(element + ",");
        print("");
        print("then");

        print("insert the 500 in index 0");

        customLinkedList.insertAt(0, 500);
        for (Integer element : customLinkedList) System.out.print(element + ",");
        print("");
        print("then");

        print("insert the 800 in index last " + customLinkedList.size());

        customLinkedList.insertAt(8, 66665);
        for (Integer element : customLinkedList) System.out.print(element + ",");
        print("");


        print("remove index 4 from linked list");
        customLinkedList.removeIndex(4);
        customLinkedList.print();
        print("poll ");
        customLinkedList.poll();
        customLinkedList.print();
        print("peek ");
        System.out.println(customLinkedList.peek());

    }

}