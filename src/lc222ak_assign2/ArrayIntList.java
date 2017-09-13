package lc222ak_assign2;

import da1031.AbstractIntCollection;
import da1031.IntList;

import java.util.Arrays;

public class ArrayIntList extends AbstractIntCollection implements IntList {

    public void add(int n) {
        System.out.println(values.length);
        System.out.println(size);
        if (values[size] >= values.length) {
            System.out.println("OMGMGOGMOMGGOMGOM");
        }
        values[size++] = n;

        System.out.println(values.length);
        System.out.println("Size: " + size());
        System.out.println(Arrays.toString(values));
    }

    public void addAt(int n, int index) throws IndexOutOfBoundsException {
        try {
            values[index] = n;
            size++;
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void remove(int index) throws IndexOutOfBoundsException {

    }

    public int get(int index) throws IndexOutOfBoundsException {
        return 0;
    }

    public int indexOf(int n) {
        return 0;
    }
}
