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
}
