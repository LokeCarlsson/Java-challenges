package lc222ak_assign2.ex5;

import java.util.Iterator;

public class HashWordSet implements WordSet {
    private Node[] buckets = new Node[128];
    private int size;
    private int count = 0;

    public void add(Word word) {
        int pos = getBucketNumber(word.toString());
        Node node = buckets[pos];
        while (node != null) {
            if (node.value. equals(word.toString()))
                return;
            else
                node = node.next;
        }
        node = new Node(word.toString());
        node.next = buckets[pos];
        buckets[pos] = node;
        size++;
        if (size == buckets.length) {
            rehash();
        }
    }

    private int getBucketNumber(String str) {
        int hashCode = str.hashCode();
        if (hashCode < 0) {
            hashCode = Math.abs(hashCode);
        }
        return hashCode % buckets.length;
    }

    private void rehash() {
        Node[] temp = buckets;
        buckets = new Node[temp.length * 2];
        size = 0;
        for (Node n : temp) {
            if (n == null) continue;
            while (n != null ) {
                add(new Word(n.value));
                n = n.next;
            }
        }
    }

    public boolean contains(Word word) {
        int pos = getBucketNumber(word.toString());
        Node node = buckets[pos];
        while (node != null) {
            if (node.value. equals(word.toString()))
                return true;
            else
                node = node.next;
        }
        return false;
    }

    public int size() {
        return size;
    }
    public Iterator<Word> iterator() {
        return new Iterator<Word>() {
            public boolean hasNext() {
                return count < 2;
            }

            public Word next() {
                while (buckets[count] == null && count <= size) {
                    count++;
                }
                Word newWord = new Word(buckets[count].toString());
                count++;
                return newWord;
            }
        };
    }

    private class Node {
        String value;
        Node next = null;

        Node (String str ) {
            value = str;
        }

        public String toString () {
            return value;
        }
    }
}
