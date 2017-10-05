package lc222ak;

import graphs.DFS;
import graphs.DirectedGraph;
import graphs.Node;

import java.util.*;

public class MyDFS<E> implements DFS<E> {


    public List<Node<E>> dfs(DirectedGraph<E> graph, Node<E> root) {
        Set<Node<E>> visited = new HashSet<>();
        List<Node<E>> nodes = new ArrayList<>();
        Stack<Node<E>> stack = new Stack<>();

        if (graph == null || root == null) {
            throw new RuntimeException("Graph or node cannot be null");
        }

        stack.add(root);

        while (!stack.isEmpty()) {
            Node<E> node = stack.pop();
            if (!visited.contains(node)) {
                visited.add(node);
                nodes.add(node);
                node.num = nodes.size();
                for (Iterator<Node<E>> successors = node.succsOf(); successors.hasNext(); ) {
                    Node<E> succ = successors.next();
                    if (!visited.contains(succ) && succ != null) {
                        stack.add(succ);
                    }
                }
            }
        }
        System.out.println(nodes);
        return nodes;
    }

    public List<Node<E>> dfs(DirectedGraph<E> graph) {
        List<Node<E>> nodes = new ArrayList<>();

        for (Node<E> n : graph) {
            List<Node<E>> dfsNodes = dfs(graph, n);
            for (Node<E> node : dfsNodes) {
                if (!nodes.contains(node)) {
                    nodes.add(node);
                }
            }

        }
        return nodes;
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
