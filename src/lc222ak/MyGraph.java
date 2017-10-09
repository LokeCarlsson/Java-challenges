package lc222ak;

import graphs.*;

import java.util.*;

public class MyGraph<E> implements DirectedGraph<E> {

    private Map<E, MyNode<E>> Nodes;
    private Set<Node<E>> heads;
    private Set<Node<E>> tails;

    public MyGraph() {
        Nodes = new HashMap<>();
        heads = new HashSet<>();
        tails = new HashSet<>();
    }

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

    public Node<E> getNodeFor(E item) {
        if (!containsNodeFor(item)) {
            throw new RuntimeException("Received null as input");
        }
        return Nodes.get(item);
    }

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

    public boolean containsNodeFor(E item) {
        if (item == null) throw new RuntimeException("Item is null");
        return Nodes.containsKey(item);
    }

    public int nodeCount() {
        return Nodes.size();
    }

    public Iterator<Node<E>> iterator() {
        List<Node<E>> list = new ArrayList<>();
        list.addAll(Nodes.values());
        return list.iterator();
    }

    public Iterator<Node<E>> heads() {
        return heads.iterator();
    }

    public int headCount() {
        return heads.size();
    }

    public Iterator<Node<E>> tails() {
        return tails.iterator();
    }

    public int tailCount() {
        return tails.size();
    }

    public List<E> allItems() {
        List<E> list = new ArrayList<>();
        list.addAll(Nodes.keySet());
        return list;
    }

    public int edgeCount() {
        int res = 0;
        for(Node n : this) {
            res += n.outDegree();
        }
        return res;
    }

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

    public String toString() {
        return Nodes.toString();
    }

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
