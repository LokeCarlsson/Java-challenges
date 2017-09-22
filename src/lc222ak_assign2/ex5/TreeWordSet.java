package lc222ak_assign2.ex5;

import java.util.Iterator;

public class TreeWordSet implements WordSet {
    private Node root = null;
    private int size = 0;

    public void add(Word word) {
        if (root==null) {
            root = new Node(word.hashCode());
        } else {
            root.add(word.hashCode());
        }
        size++;
    }

    public boolean contains(Word word) {
        return root.contains(word.hashCode());
    }

    public int size() {
        return size;
    }

    public Iterator<Word> iterator() {
        return new WordIterator();
    }

    class WordIterator implements Iterator<Word> {
        private int count = 0;
        private Node currentNode = null;

        public boolean hasNext() {
            return count < size;
        }

        public Word next() {
//            if (currentNode != null ) {
//                Node temp = currentNode;
//                currentNode = currentNode.next;
//                return new Word(temp.toString());
//            }
//            while(count < buckets.length) {
//                if (buckets[++count] != null) {
//                    if (buckets[count] != null && buckets[count].next != null) {
//                        currentNode = buckets[count].next;
//                    }
//                    return new Word(buckets[count].toString());
//                }
//            }
            return null;
        }
    }


    private  class Node {
        int value;
        Node left = null;
        Node right = null;

        private Node(int n) {
            value = n;
        }

        private void add(int n) {
            if (n < value) {
                if (left == null) {
                    left = new Node(n);
                } else {
                    left.add(n);
                }
            } else if (n > value) {
                if (right == null) {
                    right = new Node(n);
                } else {
                    right.add(n);
                }
            }
        }

        private boolean contains(int n) {
            if (n < value) {
                return left != null && left.contains(n);
            }
            else if (n > value) {
                return right != null && right.contains(n);
            }
            return true;
        }

        private Node remove(int n) {
            if (n < value) {
                if (left != null) left = left.remove(n);
            }
            else if (n > value) {
                if (right != null) right = right.remove(n);
            }
            else {
                if (left == null) {
                    return right;
                } else if (right == null) {
                    return left;
                } else {
                    if (right.left == null) {
                        value = right.value;
                        right = right.right;
                    }
//                        value = right.delete min();
                }
            }
            return this;
        }

    }
}
