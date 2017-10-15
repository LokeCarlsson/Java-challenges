package lc222ak;

import graphs.*;

import java.util.*;

public class MyGraph<E> implements DirectedGraph<E> {

    private Map<E, MyNode<E>> Nodes;
    private Set<Node<E>> heads;
    private Set<Node<E>> tails;

    /**
     * Graph constructor
     */
    public MyGraph() {
        Nodes = new HashMap<>();
        heads = new HashSet<>();
        tails = new HashSet<>();
    }

    /**
     * @param item,
     * @return a node
     */
    public Node<E> addNodeFor(E item) {
        if (item == null) throw new RuntimeException("Item is null");

        if (containsNodeFor(item)) {
            return Nodes.get(item);
        }

        MyNode<E> newNode = new MyNode<>(item);
        Nodes.put(item, newNode);
        heads.add(newNode);
        tails.add(newNode);
        return newNode;
    }

    /**
     * @param item
     * @return a node
     */
    public Node<E> getNodeFor(E item) {
        if (!containsNodeFor(item)) {
            throw new RuntimeException("Received null as input");
        }
        return Nodes.get(item);
    }

    /**
     * @param from, source node
     * @param to,   target node
     * @return true if added successfully
     */
    public boolean addEdgeFor(E from, E to) {
        if (from == null || to == null) throw new RuntimeException("Received null as input");

        MyNode<E> src = (MyNode<E>) addNodeFor(from);
        MyNode<E> tgt = (MyNode<E>) addNodeFor(to);

        if (src.hasSucc(tgt) || tgt.hasPred(src)) {
            return false;
        } else {
            src.addSucc(tgt);
            tgt.addPred(src);
            tails.remove(src);
            heads.remove(tgt);
            return true;
        }
    }

    /**
     * @param item, node to be checked.
     * @return true if node is found
     */
    public boolean containsNodeFor(E item) {
        if (item == null) throw new RuntimeException("Item is null");
        return Nodes.containsKey(item);
    }

    /**
     * @return an interger representing the size of the nodes
     */
    public int nodeCount() {
        return Nodes.size();
    }

    /**
     * @return an iterator
     */
    public Iterator<Node<E>> iterator() {
        List<Node<E>> list = new ArrayList<>();
        list.addAll(Nodes.values());
        return list.iterator();
    }

    /**
     * @return an iterator over the heads
     */
    public Iterator<Node<E>> heads() {
        return heads.iterator();
    }

    /**
     * @return an iteger over the amount of head nodes
     */
    public int headCount() {
        return heads.size();
    }

    /**
     * @return a tail iterator
     */
    public Iterator<Node<E>> tails() {
        return tails.iterator();
    }

    /**
     * @return an integer over the amount of tail nodes
     */
    public int tailCount() {
        return tails.size();
    }

    /**
     * @return a list of all items
     */
    public List<E> allItems() {
        List<E> list = new ArrayList<>();
        list.addAll(Nodes.keySet());
        return list;
    }

    /**
     * @return an integer over the amount of edges
     */
    public int edgeCount() {
        int res = 0;
        for (Node n : this) {
            res += n.outDegree();
        }
        return res;
    }

    /**
     * @param item, node to be removed.
     */
    public void removeNodeFor(E item) {
        if (item == null) {
            throw new RuntimeException("Cannot check null!");
        }
        MyNode<E> node = Nodes.get(item);
        if (node == null) {
            throw new RuntimeException("Node is null!");
        }
        heads.remove(node);
        tails.remove(node);
        node.disconnect();
        Nodes.remove(item);

        checkForNewHeadAndTail();
    }

    /**
     * @param from, source node item
     * @param to,   target node item
     * @return true if graph has the edge
     */
    public boolean containsEdgeFor(E from, E to) {
        if (from == null || to == null) {
            throw new RuntimeException("Cannot check null!");
        }
        if (Nodes.containsKey(from) && Nodes.containsKey(to)) {
            MyNode<E> src = (MyNode<E>) getNodeFor(from);
            MyNode<E> tgt = (MyNode<E>) getNodeFor(to);
            return src.hasSucc(tgt) && tgt.hasPred(src);
        }
        return false;
    }

    /**
     * @param from, source node item
     * @param to,   target node item
     * @return true if edge was removed
     */
    public boolean removeEdgeFor(E from, E to) {
        if (from == null || to == null) {
            throw new RuntimeException("Must not be null");
        }
        if (Nodes.containsKey(from) && Nodes.containsKey(to)) {
            MyNode<E> src = (MyNode<E>) getNodeFor(from);
            MyNode<E> tgt = (MyNode<E>) getNodeFor(to);
            src.removeSucc(tgt);
            tgt.removePred(src);
            checkForNewHeadAndTail();
            return true;
        }
        return false;
    }

    /**
     * @return a string representing the nodes
     */
    public String toString() {
        return Nodes.toString();
    }

    /**
     * Check if there are new heads or tails
     */
    private void checkForNewHeadAndTail() {
        for (Node<E> n : this) {
            if (n.inDegree() == 0) {
                heads.add(n);
            }
            if (n.outDegree() == 0) {
                tails.add(n);
            }
        }
    }
}
