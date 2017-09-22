package lc222ak_assign2.ex5;

import java.util.Iterator;
import java.util.Stack;

public class TreeWordSet implements WordSet {
    private Node root = null;
    private int size = 0;

    public void add(Word word) {
        if (root == null) {
            root = new Node(word);
        } else {
            root.add(word);
        }
        size++;
    }

    public int size() {
        return size;
    }

    public boolean contains(Word word) {
        return root.contains(word.hashCode());
    }

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

        if (current.left == null && current.right == null) {
            if (current == root) {
                root = null;
            }
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

    private Node getReplacement(Node removeNode) {
        Node replacement = null;
        Node replacementParent = null;
        Node current = removeNode.right;

        while (current != null) {
            replacementParent = replacement;
            replacement = current;
            current = current.left;
        }

        if (replacement != removeNode.right) {
            replacementParent.left = replacement.right;
            replacement.right = removeNode.right;
        }

        return replacement;
    }

    public Iterator<Word> iterator() {
        return new WordIterator();
    }

    public void print() {
        root.print(root);
    }

    class WordIterator implements Iterator<Word> {
        private Stack<Node> stack = new Stack<>();
        private Node current = root;

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

        void add(Word w) {
            if (w.hashCode() < value) {
                if (left == null) {
                    left = new Node(w);
                } else {
                    left.add(w);
                }
            } else if (w.hashCode() > value) {
                if (right == null) {
                    right = new Node(w);
                } else {
                    right.add(w);
                }
            }
        }

        void print(Node root) {
            if (root != null) {
                print(root.left);
                System.out.print(" " + root.word.toString());
                print(root.right);
            }
        }

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
