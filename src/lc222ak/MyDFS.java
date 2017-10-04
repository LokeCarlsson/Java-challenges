package lc222ak;

import graphs.DFS;
import graphs.DirectedGraph;
import graphs.Node;

import java.util.ArrayList;
import java.util.List;

public class MyDFS<E> implements DFS<E> {
    
    public List<Node<E>> dfs(DirectedGraph<E> graph, Node<E> root) {
        if (graph == null || root == null) {
            throw new RuntimeException("Graph or node cannot be null");
        }
        List<Node<E>> list = new ArrayList<>();
        for (Node<E> n : graph) {
            if (n)
            list.add(n);
        }
        return list;
    }

    public List<Node<E>> dfs(DirectedGraph<E> graph) {
        return null;
    }

    public List<Node<E>> postOrder(DirectedGraph<E> g, Node<E> root) {
        return null;
    }

    public List<Node<E>> postOrder(DirectedGraph<E> g) {
        return null;
    }

    public List<Node<E>> postOrder(DirectedGraph<E> g, boolean attach_dfs_number) {
        return null;
    }

    public boolean isCyclic(DirectedGraph<E> graph) {
        return false;
    }

    public List<Node<E>> topSort(DirectedGraph<E> graph) {
        return null;
    }
}
