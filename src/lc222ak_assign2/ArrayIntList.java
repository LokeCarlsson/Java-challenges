package lc222ak_assign2;

import da1031.AbstractIntCollection;
import da1031.IntList;

public class ArrayIntList extends AbstractIntCollection implements IntList {

    public void add(int n) {
        if (size == values.length) {
            resize();
        }
        values[size] = n;
        size++;
    }

    public void addAt(int n, int index) throws IndexOutOfBoundsException {
        try {
            if (!checkIndex(index, size)) {
                throw new IndexOutOfBoundsException();
            }
            shiftArr(index);
            size++;
            values[index] = n;
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    public void remove(int index) throws IndexOutOfBoundsException {
        try {
            if (index > size || index < 0) {
                throw new IndexOutOfBoundsException();
            }
            values[index] = 0;
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    public int get(int index) throws IndexOutOfBoundsException {
        int res = 0;
        try {
            if (index > size || index < 0) {
                throw new IndexOutOfBoundsException();
            }
            res = values[index];
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return res;
    }

    public int indexOf(int n) {
        int res = 0;

        for (int i = 0; i < size; i++) {
            if (values[i] == n) {
                res = i;
                break;
            } else {
                res = -1;
            }
        }

        return res;
    }

    private void shiftArr(int index) {
        if(values.length > 1){
            System.arraycopy(values, index, values, index + 1, values.length - index - 1);
        }

    }
}
