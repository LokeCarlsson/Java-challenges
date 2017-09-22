package lc222ak_assign2.ex1;

public class CollectionMain {
    public void main() {
        ArrayIntList list = new ArrayIntList();
        ArrayIntStack stack = new ArrayIntStack();
        for (int i = 1; i <= 25; i++) {
            list.add(i);
        }

        list.addAt(123, 4);

        list.remove(5);

        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);

        System.out.println(stack.toString());
        System.out.println(list.toString());
    }
}
