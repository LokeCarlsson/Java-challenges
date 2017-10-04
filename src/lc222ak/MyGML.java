package lc222ak;

import graphs.DirectedGraph;
import graphs.GML;
import graphs.Node;

import java.util.Iterator;

public class MyGML<E> extends GML<E> {
    public MyGML(DirectedGraph<E> dg) {
        super((MyGraph<E>) dg);
    }

    public String toGML() {
        MyGraph<E> gi = super.graph;
        StringBuilder sb = new StringBuilder();
        sb.append("graph [\n");
        sb.append("\tcomment This is a cool graph\n");
        sb.append("\tdirected 1\n");
        sb.append("\tid 1\n");
        for (Node<E> n : gi) {
            Iterator<Node<E>> i = n.succsOf();
            sb.append("\tnode [\n");
            sb.append("\t\tvalue ").append(n.num).append("\n");
            sb.append("\t\tout ").append(n.outDegree()).append("\n");
            sb.append("\t\tin ").append(n.inDegree()).append("\n");
            sb.append("\t]\n");

            while (i.hasNext()) {
                Node<E> edge = i.next();
                sb.append("\tedge [\n");
                sb.append("\t\tsource ").append(n).append("\n");
                sb.append("\t\ttarget ").append(edge).append("\n");
                sb.append("\t\tedge \"Edge from node ").append(edge.num).append(" to node ").append(n.num).append("\"");
                sb.append("\t]\n");
            }
        }
        sb.append("]");

        return String.valueOf(sb);
    }
}
