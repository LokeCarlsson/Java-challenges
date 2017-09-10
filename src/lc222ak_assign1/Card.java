package lc222ak_assign1;

public class Card {
    protected enum Suit {
        Clubs,
        Diamonds,
        Hearts,
        Spades;
    }

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

    Card(final Rank rank, final Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public String toString(){
        return rank.name() + " of " + suit.name();
    }

}
