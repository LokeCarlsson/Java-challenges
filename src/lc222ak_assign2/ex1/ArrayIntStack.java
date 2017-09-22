package lc222ak_assign2.ex1;

import da1031.AbstractIntCollection;
import da1031.IntStack;

public class ArrayIntStack extends AbstractIntCollection implements IntStack {

    /**
     * @param n - Number to add to the stack
     */
    public void push(int n) {
        if (size == values.length) {
            resize();
        }
        values[size] = n;
        size++;
    }

    /**
     * @return - Returns the first element in the stack and removes it
     * @throws IndexOutOfBoundsException
     */
    public int pop() throws IndexOutOfBoundsException {
        int res;
        if (size <= 0) {
            throw new IndexOutOfBoundsException();
        }
        res = values[size];
        values[size-1] = 0;
        return res;
    }

    /**
     * @return - Returns the first element in the stack without removing it
     * @throws IndexOutOfBoundsException
     */
    public int peek() throws IndexOutOfBoundsException {
        int res;
        if (size <= 0) {
            throw new IndexOutOfBoundsException();
        }
        int index = size -1;
        res = values[index];
        return res;
    }
}
