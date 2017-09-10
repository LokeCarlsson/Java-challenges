package lc222ak_assign1;

public class Card {
    /**
     * Enum that represents the cards suit
     */
    protected enum Suit {
        Clubs,
        Diamonds,
        Hearts,
        Spades;
    }

    /**
     * Enum that represents the cards rank
     */
    protected enum Rank {
        Two,
        Three,
        Four,
        Five,
        Six,
        Seven,
        Eight,
        Nine,
        Ten,
        Jack,
        Queen,
        King,
        Ace;
    }

    private final Suit suit;
    private final Rank rank;

    /**
     * @param rank - Rank of the card
     * @param suit - Suit of the card
     */
    Card(final Rank rank, final Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }


    /**
     * @return - A string that represents a card
     */
    public String toString(){
        return rank.name() + " of " + suit.name();
    }

}
