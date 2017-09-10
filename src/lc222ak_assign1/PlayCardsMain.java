package lc222ak_assign1;

public class PlayCardsMain {
    public void play() {
        // Generate and shuffle the deck.
        Deck deck = new Deck();
        deck.generateDeck();
        deck.shuffle();

        // Time to deal some cards!
        System.out.println(deck.deckSize());
        System.out.println(deck.handOutNextCard());
        System.out.println(deck.deckSize());
        System.out.println(deck.handOutNextCard());
        System.out.println(deck.deckSize());
        System.out.println(deck.handOutNextCard());
        System.out.println(deck.deckSize());
        System.out.println(deck.handOutNextCard());
        System.out.println(deck.deckSize());
        System.out.println(deck.handOutNextCard());
        System.out.println(deck.deckSize());
        System.out.println(deck.handOutNextCard());
        System.out.println(deck.deckSize());
    }
}
