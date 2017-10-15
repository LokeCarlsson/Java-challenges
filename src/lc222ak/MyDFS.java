package lc222ak;

import graphs.DFS;
import graphs.DirectedGraph;
import graphs.Node;

import java.util.*;

public class MyDFS<E> implements DFS<E> {

    /**
     * @param graph
     * @param root
     * @return - List of nodes
     */
    public List<Node<E>> dfs(DirectedGraph<E> graph, Node<E> root) {
        if (graph == null || root == null) {
            throw new RuntimeException("Graph or node cannot be null");
        }

        List<Node<E>> nodes = new ArrayList<>();
        nodes.add(root);

        return runDFS(nodes);
    }

    /**
     * @param graph
     * @return list of nodes
     */
    public List<Node<E>> dfs(DirectedGraph<E> graph) {
        if (graph == null) {
            throw new RuntimeException("Graph cannot be null");
        }

        List<Node<E>> nodes = new ArrayList<>();

        for (Node<E> n : graph) {
            nodes.add(n);
        }

        return runDFS(nodes);
    }

    /**
     * @param g
     * @param root
     * @return list of nodes
     */
    public List<Node<E>> postOrder(DirectedGraph<E> g, Node<E> root) {
        if (g == null || root == null) {
            throw new RuntimeException("Graph or node cannot be null");
        }

        List<Node<E>> postOrder = new ArrayList<>();
        Set<Node<E>> visited = new HashSet<>();

        runPostOrder(root, visited, postOrder);

        return postOrder;
    }

    /**
     * @param g
     * @return list of nodes
     */
    public List<Node<E>> postOrder(DirectedGraph<E> g) {
        if (g == null) {
            throw new RuntimeException("Graph cannot be null");
        }

        List<Node<E>> postOrder = new ArrayList<>();
        Set<Node<E>> visited = new HashSet<>();

        if (g.headCount() > 0) {
            for (Iterator<Node<E>> heads = g.heads(); heads.hasNext(); ) {
                Node<E> node = heads.next();
                runPostOrder(node, visited, postOrder);
            }
        } else {
            runPostOrder(g.getNodeFor(g.allItems().get(0)), visited, postOrder);
        }

        return postOrder;
    }

    /**
     * @param g
     * @param attach_dfs_number
     * @return list of nodes
     */
    public List<Node<E>> postOrder(DirectedGraph<E> g, boolean attach_dfs_number) {
        if (attach_dfs_number) {
            return dfs(g);
        }
        return null;
    }

    /**
     * @param graph
     * @return true if graph is cyclic
     */
    public boolean isCyclic(DirectedGraph<E> graph) {
        for (Node<E> node : postOrder(graph)) {
            for (Iterator<Node<E>> n = node.succsOf(); n.hasNext();) {
                Node<E> succ = n.next();
                if (node.num <= succ.num) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @param graph
     * @return list of nodes
     */
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

    /**
     * @param nodesToRun
     * @return list of nodes
     */
    private List<Node<E>> runDFS(List<Node<E>> nodesToRun) {
        Set<Node<E>> visited = new HashSet<>();
        List<Node<E>> nodes = new ArrayList<>();
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

    /**
     * @param node
     * @param visited
     * @param postOrder
     *
     * Tips taken from:
     * http://myitlearnings.com/depth-first-search-dfs-for-traversing-a-graph/
     */
    private void runPostOrder(Node<E> node, Set<Node<E>> visited, List<Node<E>> postOrder) {
        visited.add(node);
        for (Iterator<Node<E>> successors = node.succsOf(); successors.hasNext(); ) {
            Node<E> succ = successors.next();
            if (!visited.contains(succ)) {
                runPostOrder(succ, visited, postOrder);
            }
        }
        node.num = postOrder.size() + 1;
        postOrder.add(node);
    }
}
