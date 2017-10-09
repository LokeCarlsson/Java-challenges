package lc222ak;

import graphs.ConnectedComponents;
import graphs.DirectedGraph;
import graphs.Node;

import java.util.*;

/*
* Algorithm made with tips from first answer in following link:
* https://stackoverflow.com/questions/19736393/using-bfs-or-dfs-to-determine-the-connectivity-in-a-non-connected-graph
 */
public class MyConnectedComponents<E> implements ConnectedComponents<E> {
    public Collection<Collection<Node<E>>> computeComponents(DirectedGraph<E> dg) {
        Collection<Collection<Node<E>>> nodes = new ArrayList<>();
        Collection<Collection<Node<E>>> result = new ArrayList<>();
        if (dg == null) {
            return nodes;
        }

        Set<Node<E>> visited = new HashSet<>();
        MyDFS<E> dfs = new MyDFS<>();

        for (Node<E> node : dg) {
            if (!visited.contains(node)) {
                Set<Node<E>> nodeSet = new HashSet<>();
                nodeSet.add(node);
                visited.add(node);
                List<Node<E>> vertices = dfs.dfs(dg, node);

                for (Node<E> n : vertices) {
                    visited.add(n);
                    nodeSet.add(n);
                }
                nodes.add(nodeSet);
                for (Collection<Node<E>> n : nodes) {
                        nodeSet.addAll(vertices);
                    if (!Collections.disjoint(n, vertices)) {
//                        System.out.println("Node " + n);
//                        System.out.println("Set  " + nodeSet);
//                        System.out.println("Vertices  " + vertices);
//                        System.out.println();
                        result.remove(n);
                        result.add(nodeSet);
                    }
                }
            }
        }
        System.out.println(result);
        return result;
    }
}
