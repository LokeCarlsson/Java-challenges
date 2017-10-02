package com.company;

import graphs.Node;
import lc222ak.MyGraph;
import lc222ak_assign1.*;
import lc222ak_assign2.ex1.*;
import lc222ak_assign2.ex2.*;
import lc222ak_assign2.ex3.*;
import lc222ak_assign2.ex4.*;
import lc222ak_assign2.ex5.*;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) throws Exception {

        MyGraph<String> graph = new MyGraph<>();
        graph.addNodeFor("a");
        graph.addNodeFor("b");
        graph.addNodeFor("c");
        graph.addNodeFor("d");
        graph.addNodeFor("e");
        graph.addNodeFor("f");
        graph.addNodeFor("g");

        graph.addEdgeFor("a", "c");
        graph.addEdgeFor("a", "b");
        graph.addEdgeFor("c", "d");
        graph.addEdgeFor("b", "d");
        graph.addEdgeFor("d", "b");
        graph.addEdgeFor("d", "e");
        graph.addEdgeFor("f", "d");
        graph.addEdgeFor("e", "f");
        graph.addEdgeFor("e", "g");

        graph.removeNodeFor("a");

//        graph.removeEdgeFor("d", "b");

        for (Iterator<Node<String>> it = graph.heads(); it.hasNext(); ) {
            Node h = it.next();
            System.out.println("Head: " + h);
        }

        for (Iterator<Node<String>> it = graph.tails(); it.hasNext(); ) {
            Node h = it.next();
            System.out.println("Tails: " + h);
        }

        System.out.println("Edges: " + graph.edgeCount());

        System.out.println(graph.toString());

        for (Node g : graph) {
//            System.out.println(g);

//            Iterator i = g.predsOf();
//            while (i.hasNext()) {
//                System.out.println(i.next());
//            }
//            Iterator k = g.succsOf();
//            while (k.hasNext()) {
//                System.out.println(k.next());
//            }
        }

//        FerryMain ferry = new FerryMain();
//        ferry.main();
//        LinkedQueue queue = new LinkedQueue();
//        IdentifyWordsMain words = new IdentifyWorgdsMain();
//        words.main();
//        WordCount1Main count = new WordCount1Main();
//        count.main();
//        hashWordSet.add(new Word("Loke"));
//        hashWordSet.add(new Word("Sloken"));
//        hashWordSet.add(new Word("LOKE"));

//        WordCount2Main wc = new WordCount2Main();
//        wc.main();

//        CollectionMain cm = new CollectionMain();
//        cm.main();

//        TreeWordSet TWS = new TreeWordSet();
//        for (int i = 1; i < 10; i++) {
//            TWS.add(new Word("Loke" + String.valueOf(i)));
//        }

//        System.out.println("Del: " + TWS.delete(new Word("Loke5")));

//        System.out.println(TWS.size());
//        System.out.println("Contains? " + TWS.contains(new Word("Loke5")));

//        TWS.print();

//        while(TWS.iterator().hasNext()) {
//            System.out.println(TWS.iterator().next());
//        }


//        for (int i = 0; i < 1000; i++) {
//            System.out.println("-- > " + i + " -- >  " + hashWordSet.iterator().next());
//        }

    }
}
