package lc222ak;

import graphs.DFS;
import graphs.DirectedGraph;
import graphs.Node;

import java.util.*;

public class MyDFS<E> implements DFS<E> {

    public List<Node<E>> dfs(DirectedGraph<E> graph, Node<E> root) {
        if (graph == null || root == null) {
            throw new RuntimeException("Graph or node cannot be null");
        }

        Set<Node<E>> nodes = new HashSet<>();
        nodes.add(root);

        return new ArrayList<>(runDFS(nodes));
    }

    public List<Node<E>> dfs(DirectedGraph<E> graph) {
        if (graph == null) {
            throw new RuntimeException("Graph cannot be null");
        }

        Set<Node<E>> nodes = new HashSet<>();

        for (Node<E> n : graph) {
            nodes.add(n);
        }

        return new ArrayList<>(runDFS(nodes));
    }

    public List<Node<E>> postOrder(DirectedGraph<E> g, Node<E> root) {
        if (g == null || root == null) {
            throw new RuntimeException("Graph or node cannot be null");
        }

        Set<Node<E>> postOrder = new HashSet<>();
        Set<Node<E>> visited = new HashSet<>();

        return new ArrayList<>(runPostOrder(root, visited, postOrder));
    }

    public List<Node<E>> postOrder(DirectedGraph<E> g) {
        if (g == null) {
            throw new RuntimeException("Graph cannot be null");
        }

        Set<Node<E>> postOrder = new HashSet<>();
        Set<Node<E>> visited = new HashSet<>();

        if (g.headCount() > 0) {
            for (Iterator<Node<E>> heads = g.heads(); heads.hasNext(); ) {
                Node<E> node = heads.next();
                runPostOrder(node, visited, postOrder);
            }
        } else {
            runPostOrder(g.getNodeFor(g.allItems().get(0)), visited, postOrder);
        }

        return new ArrayList<>(postOrder);
    }

    public List<Node<E>> postOrder(DirectedGraph<E> g, boolean attach_dfs_number) {
        if (attach_dfs_number) {
            return dfs(g);
        }
        return null;
    }

    public boolean isCyclic(DirectedGraph<E> graph) {
        for (Node<E> node : postOrder(graph)) {
            for (Iterator<Node<E>> n = node.succsOf(); n.hasNext();) {
                int succNumber = n.next().num;
                if (node.num <= succNumber) {
                    return true;
                }
            }
        }
        return false;
    }

    public List<Node<E>> topSort(DirectedGraph<E> graph) {
        if (isCyclic(graph)) {
            throw new RuntimeException("topSort not possible on cyclic graphs");
        }

        List<Node<E>> nodeList = postOrder(graph);
        Node<E>[] nodeArray = new Node[graph.nodeCount()];

        for (Node<E> n : nodeList) {
            nodeArray[graph.nodeCount() - n.num] = n;
        }

        return Arrays.asList(nodeArray);
    }

    private Set<Node<E>> runDFS(Set<Node<E>> nodesToRun) {
        Set<Node<E>> visited = new HashSet<>();
        Set<Node<E>> nodes = new HashSet<>();
        Stack<Node<E>> stack = new Stack<>();

        for (Node<E> n : nodesToRun) {
            stack.push(n);
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
        }
        return nodes;
    }

    /*
    * Tips taken from:
    * http://myitlearnings.com/depth-first-search-dfs-for-traversing-a-graph/
     */
    private Set<Node<E>> runPostOrder(Node<E> node, Set<Node<E>> visited, Set<Node<E>> postOrder) {
        visited.add(node);
        for (Iterator<Node<E>> successors = node.succsOf(); successors.hasNext(); ) {
            Node<E> succ = successors.next();
            if (!visited.contains(succ)) {
                runPostOrder(succ, visited, postOrder);
            }
        }
        node.num = (postOrder.size() + 1);
        postOrder.add(node);
        return postOrder;
    }
}
