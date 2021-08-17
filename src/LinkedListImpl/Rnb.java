package LinkedListImpl;

public class Rnb {
    public static void main(String[] args) {
        LinkedListB<Integer> listB = new LinkedListB<>(1, 3, 5, 6, 2, 0);

        System.out.print("\n[");
        for (int k : listB) System.out.print(k + ",");
        System.out.println("]");

//        insAt(listB,0,200);
//        insAt(listB,2,200);
//        insAt(listB,5,200);
        listB.insertAt(0,200);
        listB.insertAt(2,200);
        listB.insertAt(5,200);
        listB.insertAt(listB.size()-1,200);


        System.out.print("\n[");
        for (int k : listB) System.out.print(k + ",");
        System.out.println("]");

    }

    static void insAt(LinkedListB<Integer> listB,int index,Integer input){

        int z = 0;

        Node<Integer> node = new Node<>(null, input, null);

        for (int x : listB) {
            if (z == index) {
                Node<Integer> currentNode = ((LinkedListIterator<Integer>) listB.getIterator()).getCurrentNode();
                currentNode = currentNode != null ? currentNode.getPrevious() : listB.tailNode;

                listB.insertBehind(node, currentNode);


            }
            z++;

        }

    }
}
