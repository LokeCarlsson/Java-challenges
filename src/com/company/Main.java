package com.company;

import lc222ak_assign1.*;
import lc222ak_assign2.ex1.*;
import lc222ak_assign2.ex2.*;
import lc222ak_assign2.ex3.*;
import lc222ak_assign2.ex4.*;
import lc222ak_assign2.ex5.*;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) throws Exception {
//        FerryMain ferry = new FerryMain();
//        ferry.main();
//        LinkedQueue queue = new LinkedQueue();
//        IdentifyWordsMain words = new IdentifyWordsMain();
//        WordCount1Main count = new WordCount1Main();
//        count.main();
//        hashWordSet.add(new Word("Loke"));
//        hashWordSet.add(new Word("Sloken"));
//        hashWordSet.add(new Word("LOKE"));

//        WordCount2Main wc = new WordCount2Main();
//        wc.main();

        TreeWordSet TWS = new TreeWordSet();
        TWS.add(new Word("Loke"));
        System.out.println(TWS.size());
        TWS.add(new Word("Sloken"));
        System.out.println(TWS.size());
        System.out.println(TWS.contains(new Word("Sloken")));

//        for (int i = 0; i < 1000; i++) {
//            System.out.println("-- > " + i + " -- >  " + hashWordSet.iterator().next());
//        }

    }
}
