package lc222ak_assign2.ex1;

import da1031.AbstractIntCollection;
import da1031.IntList;

public class ArrayIntList extends AbstractIntCollection implements IntList {

    /**
     * @param n - Number to be added to the list
     */
    public void add(int n) {
        if (size == values.length) {
            resize();
        }
        values[size] = n;
        size++;
    }

    /**
     * @param n - Number to be added to the list
     * @param index - Index where the number should be added at
     * @throws IndexOutOfBoundsException
     */
    public void addAt(int n, int index) throws IndexOutOfBoundsException {
        if (!checkIndex(index, size)) {
            throw new IndexOutOfBoundsException();
        }
        shiftArr(index);
        size++;
        values[index] = n;
    }

    /**
     * @param index - Index of element to remove
     * @throws IndexOutOfBoundsException
     */
    public void remove(int index) throws IndexOutOfBoundsException {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        values[index] = 0;
    }

    /**
     * @param index - Index of element to get
     * @return - Returns the element with provided index
     * @throws IndexOutOfBoundsException
     */
    public int get(int index) throws IndexOutOfBoundsException {
        int res = 0;
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        res = values[index];
        return res;
    }

    /**
     * @param n - Number to find index of
     * @return - Returns the index of number provided
     */
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

    /**
     * @param index - Index from where to shift the array
     */
    private void shiftArr(int index) {
        if(values.length > 1){
            System.arraycopy(values, index, values, index + 1, values.length - index - 1);
        }

    }
}
