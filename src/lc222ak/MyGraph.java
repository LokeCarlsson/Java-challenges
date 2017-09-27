package lc222ak;

import graphs.*;

import java.util.*;

public class MyGraph<E> implements DirectedGraph<E> {

    private List<MyNode> Nodes = new ArrayList<>();
    private Map<E, MyNode<E>> item2node = new HashMap<>();
    private Set<Node<E>> heads = new HashSet<>();
    private Set<Node<E>> tails = new HashSet<>();

    public MyGraph() {
        //Generate an empty graph
    }

    public Node<E> addNodeFor(E item) {
        MyNode<E> newNode = new MyNode<>(item);
        if (item == null) throw new RuntimeException("Item is null");
        if (!containsNodeFor(item)) {
            Nodes.add(newNode);
        }
        return newNode;
    }

    public Node<E> getNodeFor(E item) {
        boolean nodePos = Nodes.contains(new MyNode<>(item));
        return null;
    }

    public boolean addEdgeFor(E from, E to) {
        return false;
    }

    public boolean containsNodeFor(E item) {
        if (item == null) throw new RuntimeException("Item is null");
        return Nodes.contains(new MyNode<>(item));
    }

    public int nodeCount() {
        return 0;
    }

    public Iterator<Node<E>> iterator() {
        return null;
    }

    public Iterator<Node<E>> heads() {
        return null;
    }

    public int headCount() {
        return 0;
    }

    public Iterator<Node<E>> tails() {
        return null;
    }

    public int tailCount() {
        return 0;
    }

    public List<E> allItems() {
        return null;
    }

    public int edgeCount() {
        return 0;
    }

    public void removeNodeFor(E item) {

    }

    public boolean containsEdgeFor(E from, E to) {
        return false;
    }

    public boolean removeEdgeFor(E from, E to) {
        return false;
    }
}
