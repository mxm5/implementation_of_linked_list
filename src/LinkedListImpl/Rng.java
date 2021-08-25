package LinkedListImpl;

public class Rng {
    public static void main(String[] args) {

        CachedLinkedList<Character> list = new CachedLinkedList<>(
'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z');
        System.out.println("show list");
        list.print();
        System.out.println("show cache");
        list.getCache().print();

        System.out.println("find element 'z'");
        Character integer1 = list.find('z');
        System.out.println("show new cache");
        list.getCache().print();

        System.out.println("find element 'h'");
        Character integer = list.find('h');
        System.out.println("show new cache");
        list.getCache().print();

        System.out.println("find element 'h' again");
        Character integer3 = list.find('h');
        System.out.println("show new cache");
        list.getCache().print();


    }
}
