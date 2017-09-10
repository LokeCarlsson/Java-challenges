package lc222ak_assign1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

class Deck {
    private List<Card> deck = new ArrayList<Card>();

    Deck() {}

    /**
     * Generate a 52 card deck from the class Card
     */
    void generateDeck() {
        Card.Rank[] ranks = Card.Rank.values();
        Card.Suit[] suits = Card.Suit.values();

        for (Card.Suit suit : suits) {
            for (Card.Rank rank : ranks) {
                deck.add(new Card(rank, suit));
            }
        }
    }

    /**
     * Shuffle the deck of cards using the Fisher–Yates algorithm
     */
    void shuffle() {
        if (deck.size() < 52) {
            throw new IllegalArgumentException("Deck must contain 52 cards to shuffle!");
        }
        Random rng = ThreadLocalRandom.current();
        for (int i = deck.size() - 1; i > 0; i--) {
            int index = rng.nextInt(i + 1);
            Card a = deck.get(index);
            deck.set(index, deck.get(i));
            deck.set(i, a);
        }
    }

    /**
     * @return - Removes one card from the deck and returns it
     */
    Card handOutNextCard() {
        return deck.remove(0);
    }

    /**
     * @return - The amount of cards left in the deck
     */
    int deckSize() {
        return deck.size();
    }
}
