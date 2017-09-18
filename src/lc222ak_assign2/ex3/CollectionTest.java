package lc222ak_assign2.ex3;

import lc222ak_assign2.ex1.ArrayIntList;
import org.junit.*;

public class CollectionTest {
    @Test
    public void shouldAddOneToList() {
        ArrayIntList myList = new ArrayIntList();
        myList.add(5);
        assert(myList.size() == 1);
    }
    @Test
    public void shouldAddOneAtIndexToList() {
        ArrayIntList myList = new ArrayIntList();
        myList.add(5);
        myList.addAt(5, 0);
        assert(myList.size() == 2);
    }
    @Test
    public void shouldReplaceAtIndex() {
        ArrayIntList myList = new ArrayIntList();
        for (int i = 0; i < 5; i++) {
            myList.add(i);
        }
        myList.addAt(10, 2);
        assert(myList.get(2) == 10);
    }
    @Test
    public void shouldRemoveAtIndex() {
        ArrayIntList myList = new ArrayIntList();
        for (int i = 0; i < 5; i++) {
            myList.add(i);
        }
        myList.remove(2);
        assert(myList.get(2) == 0);
    }
    @Test
    public void shouldGetAtIndex() {
        ArrayIntList myList = new ArrayIntList();
        for (int i = 0; i < 5; i++) {
            myList.add(i);
        }
        assert(myList.get(2) == 2);
    }
    @Test
    public void shouldFindIndex() {
        ArrayIntList myList = new ArrayIntList();
        for (int i = 0; i < 5; i++) {
            myList.add(i);
        }
        assert(myList.indexOf(2) == 2);
    }
}
