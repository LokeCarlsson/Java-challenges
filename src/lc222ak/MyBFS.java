package lc222ak;

import graphs.BFS;
import graphs.DirectedGraph;
import graphs.Node;

import java.util.*;

public class MyBFS<E> implements BFS<E> {
    public List<Node<E>> bfs(DirectedGraph<E> graph, Node<E> root) {
        if (graph == null || root == null) {
            throw new RuntimeException("Graph or root is null");
        }

        List<Node<E>> nodes = new ArrayList<>();
        nodes.add(root);

        return new ArrayList<>(runBFS(nodes));
    }

    public List<Node<E>> bfs(DirectedGraph<E> graph) {
        if (graph == null) {
            throw new RuntimeException("Graph is null");
        }

        List<Node<E>> nodes = new ArrayList<>();

        for (Node<E> n : graph) {
            nodes.add(n);
        }

        return runBFS(nodes);
    }

    private List<Node<E>> runBFS(List<Node<E>> nodesToRun) {
        Set<Node<E>> nodes = new HashSet<>();
        Set<Node<E>> visited = new HashSet<>();

        while (!nodesToRun.isEmpty()) {
            Node<E> node = nodesToRun.remove(0);
            if (!visited.contains(node)) {
                visited.add(node);
                nodes.add(node);
                node.num = visited.size();
                for (Iterator<Node<E>> successors = node.succsOf(); successors.hasNext(); ) {
                    Node<E> succ = successors.next();
                    if (!visited.contains(succ)) {
                        nodesToRun.add(succ);
                    }
                }
            }
        }
        return new ArrayList<>(nodes);
    }
}
