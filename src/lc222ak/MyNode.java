package lc222ak;

import graphs.Node;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MyNode<E> extends Node<E> {

    private Set<Node<E>> preds = new HashSet<>();
    private Set<Node<E>> succs = new HashSet<>();

    /**
     * @param item
     */
    MyNode(E item) {
        super(item);
    }

    /**
     * @param node
     * @return true if contains successor
     */
    public boolean hasSucc(Node<E> node) {
        return succs.contains(node);
    }

    /**
     * @return the amount of successors
     */
    public int outDegree() {
        return succs.size();
    }

    /**
     * @return iterator over all successors
     */
    public Iterator<Node<E>> succsOf() {
        return succs.iterator();
    }

    /**
     * @param node
     * @return true if has predecessor
     */
    public boolean hasPred(Node<E> node) {
        return preds.contains(node);
    }

    /**
     * @return the amount of predecessor
     */
    public int inDegree() {
        return preds.size();
    }

    /**
     * @return iterator of all predecessor
     */
    public Iterator<Node<E>> predsOf() {
        return preds.iterator();
    }

    /**
     * @param succ
     */
    protected void addSucc(Node<E> succ) {
        succs.add(succ);
    }

    /**
     * @param succ
     */
    protected void removeSucc(Node<E> succ) {
        succs.remove(succ);
    }

    /**
     * @param pred
     */
    protected void addPred(Node<E> pred) {
        preds.add(pred);
    }

    /**
     * @param pred
     */
    protected void removePred(Node<E> pred) {
        preds.remove(pred);
    }

    /**
     * Disconnect the node from the graph
     */
    protected void disconnect() {
        for (Node<E> n : succs) {
            MyNode<E> mn = (MyNode<E>) n;
            mn.removePred(this);
        }
        for (Node<E> n : preds) {
            MyNode<E> mn = (MyNode<E>) n;
            mn.removeSucc(this);
        }
        preds.clear();
        succs.clear();
    }
}
