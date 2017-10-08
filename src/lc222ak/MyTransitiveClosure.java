package lc222ak;

import graphs.DirectedGraph;
import graphs.Node;
import graphs.TransitiveClosure;

import java.util.*;

public class MyTransitiveClosure<E> implements TransitiveClosure<E> {
    public Map<Node<E>, Collection<Node<E>>> computeClosure(DirectedGraph<E> dg) {
        Map<Node<E>, Collection<Node<E>>> map = new HashMap<>();
        MyDFS<E> dfs = new MyDFS<>();

        for (Node<E> node : dg) {
            List<Node<E>> nodes = dfs.dfs(dg, node);
            map.put(node, nodes);
        }

        return map;
    }
}
