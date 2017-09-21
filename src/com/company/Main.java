package com.company;

import lc222ak_assign1.*;
import lc222ak_assign2.ex1.*;
import lc222ak_assign2.ex2.*;
import lc222ak_assign2.ex3.*;
import lc222ak_assign2.ex4.*;
import lc222ak_assign2.ex5.HashWordSet;
import lc222ak_assign2.ex5.IdentifyWordsMain;
import lc222ak_assign2.ex5.Word;
import lc222ak_assign2.ex5.WordCount1Main;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) throws Exception {
//        FerryMain ferry = new FerryMain();
//        ferry.main();
//        LinkedQueue queue = new LinkedQueue();
//        IdentifyWordsMain words = new IdentifyWordsMain();
//        WordCount1Main count = new WordCount1Main();
//        count.main();
        HashWordSet hashWordSet = new HashWordSet();
//        hashWordSet.add(new Word("Loke"));
//        hashWordSet.add(new Word("Sloken"));
//        hashWordSet.add(new Word("LOKE"));
        for (int i = 0; i < 1000; i++) {
            hashWordSet.add(new Word(String.valueOf(i)));
        }

        Iterator<Word> i = hashWordSet.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }

//        for (int i = 0; i < 1000; i++) {
//            System.out.println("-- > " + i + " -- >  " + hashWordSet.iterator().next());
//        }
        System.out.println(hashWordSet.size());

    }
}
