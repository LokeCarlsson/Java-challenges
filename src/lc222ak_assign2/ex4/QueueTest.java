package lc222ak_assign2.ex4;

import org.junit.*;
import static junit.framework.TestCase.*;

public class QueueTest {

    private LinkedQueue<Integer> queue;

    @Before
    public void InitializeList() {
        queue = new LinkedQueue<>();
    }

    @Test
    public void shouldBeEmptyFirst() {
        assertEquals(queue.size(), 0);
    }

    @Test
    public void shouldBeEmptyBeforeEnqueue() {
        assertEquals(queue.isEmpty(), true);
    }

    @Test
    public void shouldNotBeEmptyAfterEnqueue() {
        queue.enqueue(123);
        assertEquals(queue.isEmpty(), false);
    }

    @Test
    public void shouldBeAbleToHandleManyElements() {
        for (int i = 0; i < 100000; i++) {
            queue.enqueue(i);
        }
        assertEquals(queue.size(), 100000);
    }

    @Test
    public void shouldBeAbleToHandleManySize() {
        for (int i = 0; i < 500000; i++) {
            queue.size();
        }
        assertEquals(queue.size(), 0);
    }

    @Test
    public void shouldDequeue() {
        for (int i = 1; i <= 5; i++) {
            queue.enqueue(i);
        }
        queue.dequeue();
        assertEquals(queue.size(), 4);
    }

    @Test
    public void shouldHandleLargeValues() {
        queue.enqueue(Integer.MAX_VALUE);
        assertEquals(queue.first(), (Integer) Integer.MAX_VALUE);
    }

    @Test
    public void shouldHandleLargeNegativeValues() {
        queue.enqueue(Integer.MIN_VALUE);
        assertEquals(queue.first(), (Integer) Integer.MIN_VALUE);
    }

    @Test
    public void queueShouldHaveSameFirstElement() {
        queue.enqueue(123);
        assertEquals(queue.first(), (Integer) 123);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void shouldThrowExceptionOnEmptyDequeue() {
        queue.dequeue();
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void shouldThrowExceptionOnEmptyFirst() {
        queue.first();
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void shouldThrowExceptionOnEmptyLast() {
        queue.last();
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void shouldThrowExceptionOnEmptyIteratorNext() {
        queue.iterator().next();
    }

    @Test
    public void shouldNotBeNull() {
        assertNotNull(queue);
    }


}
