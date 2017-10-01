package lc222ak;

import graphs.*;

import java.util.*;

public class MyGraph<E> implements DirectedGraph<E> {

    private Map<E, MyNode<E>> Nodes = new HashMap<>();
    private Set<Node<E>> heads = new HashSet<>();
    private Set<Node<E>> tails = new HashSet<>();

    public MyGraph() {
        //Generate an empty graph
    }

    public Node<E> addNodeFor(E item) {
        if (item == null) throw new RuntimeException("Item is null");
        MyNode<E> newNode = new MyNode<>(item);
        if (!containsNodeFor(item)) {
            Nodes.put(item, newNode);
            if (!heads.contains(newNode)) {
                heads.add(newNode);
            }
            if (!tails.contains(newNode)) {
                tails.add(newNode);
            }
        }

        return Nodes.get(item);
    }

    public Node<E> getNodeFor(E item) {
        return Nodes.get(item);
    }

    public boolean addEdgeFor(E from, E to) {
        if (from == null || to == null) throw new RuntimeException("Received null as input");
        MyNode<E> src = (MyNode<E>) addNodeFor(from);
        MyNode<E> tgt = (MyNode<E>) addNodeFor(to);

        if (src.hasSucc(tgt)) {
            return false;
        } else {
            src.addSucc(tgt);
            tgt.addPred(src);
            heads.remove(src);
            tails.remove(tgt);
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
        Node node = Nodes.get(item);

        Nodes.get(item).disconnect();

        if (heads.contains(node)) {
            heads.remove(node);
        }

        if (tails.contains(node)) {
            tails.remove(node);
        }
    }

    public boolean containsEdgeFor(E from, E to) {
        MyNode<E> src = (MyNode<E>) getNodeFor(from);
        MyNode<E> tgt = (MyNode<E>) getNodeFor(to);
        return src.hasSucc(tgt) && tgt.hasPred(src);
    }

    public boolean removeEdgeFor(E from, E to) {
        return true;
    }
}
