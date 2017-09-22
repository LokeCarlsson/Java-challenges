package lc222ak_assign2.ex5;

import java.util.Iterator;

public class HashWordSet implements WordSet {
    private Node[] buckets = new Node[128];
    private int size;

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
        return new WordIterator();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Word w : this) {
            sb.append(w.toString()).append(" ");
        }
        return sb.toString();
    }


    class WordIterator implements Iterator<Word> {
        private int count = 0;
        private Node currentNode = null;

        public boolean hasNext() {
            return count < buckets.length - 1;
        }

        public Word next() {
            if (currentNode != null ) {
                Node temp = currentNode;
                currentNode = currentNode.next;
                return new Word(temp.toString());
            }
            while(count < buckets.length) {
                if (buckets[++count] != null) {
                    if (buckets[count] != null && buckets[count].next != null) {
                        currentNode = buckets[count].next;
                    }
                    return new Word(buckets[count].toString());
                }
            }
            return null;
        }
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
