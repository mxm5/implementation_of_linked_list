package LinkedListImpl;

public class Rne {
    public static void main(String[] args) {
        LinkedListB<Integer> listB = new LinkedListB<>(
                1, 22, 4, 6, 2,8,4,13);
        //
        //                 index threshold
        //                 0,1 [,]2,3,         --- 4   2    --- 3   1.5 =1 | ---  2,3
        //                 0,1 ,[2],3,4        --- 5   2.5  --- 4   2   =2 | ---  3,4
        //                 0,1 ,2[,]3,4,5      --- 6   3    --- 5   2.5 =2 | ---  3,4,5
        //                 0,1 ,2,[3],4,5,6    --- 7   3.5  --- 6   3   =3 | ---  4,5,6
        //                 0,1 ,2,3[,]4,5,6,7  --- 8   4    --- 7   3.5 =3 | ---  4,5,6,7
        //                 index>((size-1)/2) reverse
        //                 how many steps do I have to take in reverse
        //                 maxIndex-1;
        //
        listB.print();
        listB.getWithLog(0);
        System.out.println();
        listB.getWithLog(6);
        System.out.println();
        listB.getWithLog(2);
        System.out.println();
        listB.getWithLog(3);
        System.out.println();
        listB.getWithLog(4);
        System.out.println();
        listB.getWithLog(5);
    }
}
