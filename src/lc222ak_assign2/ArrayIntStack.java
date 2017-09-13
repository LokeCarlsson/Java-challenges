package lc222ak_assign2;

import da1031.AbstractIntCollection;
import da1031.IntStack;

import java.util.Arrays;

public class ArrayIntStack extends AbstractIntCollection implements IntStack {

    public void push(int n) {
        if (size == values.length) {
            resize();
        }
        values[size] = n;
        size++;
    }

    public int pop() throws IndexOutOfBoundsException {
        int res = 0;
        try {
            if (size < 0) {
                throw new IndexOutOfBoundsException();
            }
            res = values[size];
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        values[size] = 0;
        return res;
    }

    public int peek() throws IndexOutOfBoundsException {
        int res = 0;
        int index = size -1;
        try {
            if (index < 0) {
                index = 0;
            }
            if (size < 0) {
                throw new IndexOutOfBoundsException();
            }
            res = values[index];
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return res;
    }
}
