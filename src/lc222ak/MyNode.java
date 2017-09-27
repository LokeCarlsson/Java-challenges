package lc222ak;

import graphs.Node;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MyNode<E> extends Node<E> {

    private Set<Node<E>> preds = new HashSet<>();
    private Set<Node<E>> succs = new HashSet<>();

    MyNode(E item) {
        super(item);
    }

    public boolean hasSucc(Node<E> node) {
        return false;
    }

    public int outDegree() {
        return 0;
    }

    public Iterator<Node<E>> succsOf() {
        return new NodeIterator();
    }

    public boolean hasPred(Node<E> node) {
        return false;
    }

    public int inDegree() {
        return 0;
    }

    public Iterator<Node<E>> predsOf() {
        return null;
    }

    protected void addSucc(Node<E> succ) {
        succs.add(succ);
    }

    protected void removeSucc(Node<E> succ) {
        succs.remove(succ);
    }

    protected void addPred(Node<E> pred) {
        preds.add(pred);
    }

    protected void removePred(Node<E> pred) {
        preds.remove(pred);
    }

    protected void disconnect() {
        
    }

    class NodeIterator implements Iterator<Node<E>> {
        public boolean hasNext() {
            return false;
        }

        public Node<E> next() {
            return null;
        }
    }
}
