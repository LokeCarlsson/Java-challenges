package lc222ak_assign2.ex5;

import java.util.Iterator;
import java.util.Stack;

public class TreeWordSet implements WordSet {
    private Node root = null;
    private int size = 0;

    /**
     * @param word - Word to be added to the set
     */
    public void add(Word word) {
        if (root == null) {
            root = new Node(word);
            size++;
        } else {
            root.add(word);
        }
    }

    /**
     * @return - Returns the amount of elements in the set
     */
    public int size() {
        return size;
    }

    /**
     * @param word - Word to search for
     * @return - Returns true if word is found
     */
    public boolean contains(Word word) {
        return root.contains(word.hashCode());
    }

    /**
     * @param word - Word to be deleted
     * @return - Word that has been deleted
     */
    public Word delete(Word word) {
        Node parent = root;
        Node current = root;
        boolean isLeftChild = false;

        while (current.word.hashCode() != word.hashCode()) {
            parent = current;
            if (current.word.hashCode() > word.hashCode()) {
                isLeftChild = true;
                current = current.left;
            } else {
                isLeftChild = false;
                current = current.right;
            }
            if (current == null) {
                return null;
            }
        }

        //Word has been found, time to delete it one of three ways depending on position
        if (current.left == null && current.right == null) {
            if (isLeftChild) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        } else if (current.right == null) {
            if (current == root) {
                root = current.left;
            } else if (isLeftChild) {
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }
        } else if (current.left == null) {
            if (current == root) {
                root = current.right;
            } else if (isLeftChild) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
        } else {
            Node replacement = getReplacement(current);

            if (current == root) {
                root = replacement;
            } else if (isLeftChild) {
                parent.left = replacement;
            } else {
                parent.right = replacement;
            }
            replacement.left = current.left;
        }
        return current.word;
    }

    /**
     * @param nodeToRemove - Node that is going to be removed and replaced
     * @return - Returns a new node that is replacing the old
     */
    private Node getReplacement(Node nodeToRemove) {
        Node replacement = null;
        Node replacementParent = null;
        Node current = nodeToRemove.right;

        while (current != null) {
            replacementParent = replacement;
            replacement = current;
            current = current.left;
        }

        if (replacement != nodeToRemove.right) {
            replacementParent.left = replacement.right;
            replacement.right = nodeToRemove.right;
        }

        return replacement;
    }

    /**
     * @return - A string with all words in set
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Word w : this) {
            sb.append(w.toString()).append(" ");
        }
        return sb.toString();
    }

    /**
     * @return - Returns a new instance of WordIterator
     */
    public Iterator<Word> iterator() {
        return new WordIterator();
    }

    /**
     * Prints all the Words in the set
     */
    public void print() {
        root.print(root);
    }

    class WordIterator implements Iterator<Word> {
        private Stack<Node> stack = new Stack<>();
        private Node current = root;

        /**
         * @return - Returns true if set has a next element
         */
        public Word next() {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            Node node = current;
            current = current.right;
            return node.word;
        }

        /**
         * @return - Returns next word
         */
        public boolean hasNext() {
            return (!stack.isEmpty() || current != null);
        }
    }

    class Node {
        private Word word;
        private int value;
        Node left = null;
        Node right = null;

        Node(Word w) {
            this.value = w.hashCode();
            this.word = w;
        }

        /**
         * @param w - Word to be added to the set
         */
        void add(Word w) {
            if (w.hashCode() < value) {
                if (left == null) {
                    left = new Node(w);
                    size++;
                } else {
                    left.add(w);
                }
            } else if (w.hashCode() > value) {
                if (right == null) {
                    right = new Node(w);
                    size++;
                } else {
                    right.add(w);
                }
            }
        }

        /**
         * @param root - First node in the set
         */
        void print(Node root) {
            if (root != null) {
                print(root.left);
                System.out.print(" " + root.word.toString());
                print(root.right);
            }
        }

        /**
         * @param n - Hashcode to search for
         * @return - Returns true if hashcode is found
         */
        boolean contains(int n) {
            if (n < value) {
                return left != null && left.contains(n);
            } else if (n > value) {
                return right != null && right.contains(n);
            }
            return true;
        }
    }
}
