package lc222ak_assign1;

public class PlayCardsMain {
    public void play() {
        Deck deck = new Deck();
        deck.generateDeck();
        deck.shuffle();
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
