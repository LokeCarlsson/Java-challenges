package lc222ak_assign2.ex3;

import lc222ak_assign2.ex1.ArrayIntList;
import lc222ak_assign2.ex1.ArrayIntStack;
import org.junit.*;
import static junit.framework.TestCase.*;

public class CollectionTest {
    private ArrayIntList myList;
    private ArrayIntStack myStack;

    @Before
    public void InitializeList() {
        myList = new ArrayIntList();
        myStack = new ArrayIntStack();
    }

    @Test
    public void listShouldBeEmptyFirst() {
        assertEquals(myList.size(), 0);
    }

    @Test
    public void stackShouldBeEmptyFirst() {
        assertEquals(myStack.size(), 0);
    }

    @Test
    public void listShouldAddOneToList() {
        myList.add(5);
        assertEquals(myList.size(), 1);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void listShouldThrowExceptionWhenRemove() {
        myList.remove(1);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void listShouldThrowExceptionWhenAdd() {
        myList.addAt(1, 10);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void listShouldThrowExceptionWhenGet() {
        myList.get(1);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void stackShouldThrowExceptionWhenPop() {
        myStack.pop();
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void stackShouldThrowExceptionWhenPeek() {
        myStack.peek();
    }

    @Test
    public void listShouldAddOneAtIndexToList() {
        myList.add(5);
        myList.addAt(5, 0);
        assertEquals(myList.size(), 2);
    }

    @Test
    public void listShouldReplaceAtIndex() {
        for (int i = 0; i < 5; i++) {
            myList.add(i);
        }
        myList.addAt(10, 2);
        assertEquals(myList.get(2), 10);
    }

    @Test
    public void listShouldRemoveAtIndex() {
        for (int i = 0; i < 5; i++) {
            myList.add(i);
        }
        myList.remove(2);
        assertEquals(myList.get(2), 0);
    }

    @Test
    public void listShouldGetAtIndex() {
        for (int i = 0; i < 5; i++) {
            myList.add(i);
        }
        assertEquals(myList.get(2), 2);
    }

    @Test
    public void listShouldFindIndex() {
        for (int i = 0; i < 5; i++) {
            myList.add(i);
        }
        assertEquals(myList.indexOf(2), 2);
    }

    @Test
    public void listShouldReturnRightString() {
        for (int i = 0; i < 5; i++) {
            myList.add(i);
        }
        assertEquals(myList.toString(), "[ 0 1 2 3 4 ]");
    }

    @Test
    public void stackShouldNotBeEmpty() {
        for (int i = 0; i < 5; i++) {
            myStack.push(i);
        }
        assertFalse(myStack.isEmpty());
    }

    @Test
    public void stackShouldBeRightSize() {
        for (int i = 0; i < 5; i++) {
            myStack.push(i);
        }
        assertEquals(myStack.size(), 5);
    }

    @Test
    public void stackShouldHaveRightLastElementWhenPeeking() {
        for (int i = 0; i < 5; i++) {
            myStack.push(i);
        }
        assertEquals(myStack.peek(), 4);
    }

    @Test
    public void stackShouldReturnZeroWhenPeekingAfterPop() {
        for (int i = 1; i < 5; i++) {
            myStack.push(i);
        }
        myStack.pop();
        assertEquals(myStack.peek(), 0);
    }
}
