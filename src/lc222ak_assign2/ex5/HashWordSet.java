package lc222ak_assign2.ex5;

import java.util.Iterator;

public class HashWordSet implements WordSet {
    private Node[] buckets = new Node[128];
    private int size;

    /**
     * @param word - Word to be added to the set
     */
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

    /**
     * @param str - String to generate hashcode from
     * @return - Returns generated hashcode
     */
    private int getBucketNumber(String str) {
        int hashCode = str.hashCode();
        if (hashCode < 0) {
            hashCode = Math.abs(hashCode);
        }
        return hashCode % buckets.length;
    }

    /**
     * Creates a new bucket twice as long and add the old nodes
     */
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

    /**
     * @param word - Word to check if exist in set
     * @return - Returns true if word is found
     */
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

    /**
     * @return - Returns size of set
     */
    public int size() {
        return size;
    }

    /**
     * @return - Returns a new instance of the WordIterator
     */
    public Iterator<Word> iterator() {
        return new WordIterator();
    }

    /**
     * @return - A String with all the words
     */
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

        /**
         * @return - Returns true if set has a next element
         */
        public boolean hasNext() {
            return count < buckets.length - 1;
        }

        /**
         * @return - Returns next word
         */
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

        /**
         * @param str - String to be stored
         */
        Node (String str ) {
            value = str;
        }

        /**
         * @return - Returns the String
         */
        public String toString () {
            return value;
        }
    }
}
