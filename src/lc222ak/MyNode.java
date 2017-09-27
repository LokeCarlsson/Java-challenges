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
        return succs.contains(node);
    }

    public int outDegree() {
        return succs.size();
    }

    public Iterator<Node<E>> succsOf() {
        return succs.iterator();
    }

    public boolean hasPred(Node<E> node) {
        return preds.contains(node);
    }

    public int inDegree() {
        return preds.size();
    }

    public Iterator<Node<E>> predsOf() {
        return preds.iterator();
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
        preds.clear();
        succs.clear();
    }
}
