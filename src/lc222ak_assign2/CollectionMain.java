package lc222ak_assign2;

public class CollectionMain {
    public static void main() {
        ArrayIntList list = new ArrayIntList();
        for (int i = 1; i <= 25; i++) {
            list.add(i);
        }

        list.addAt(123123, 4);

        System.out.println(list.toString());
    }
}
