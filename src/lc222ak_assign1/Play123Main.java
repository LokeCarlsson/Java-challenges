package lc222ak_assign1;

import java.util.Objects;

public class Play123Main {
    public void main() {
        int result = 0;
        for (int i = 0; i < 10000; i++) {
          if (play123()) {
            result++;
          }
        }
        float percentage = (float) result*100/10000;
        System.out.println("Result: " + result);
        System.out.println("Win chance: " + percentage + "%");
    }

    private boolean play123() {
        boolean winning = true;
        Deck deck = new Deck();
        deck.generateDeck();
        deck.shuffle();

        while(deck.deckSize() > 1) {
            for (int i = 1; i <= 3; i++) {
                Card drawnCard = deck.handOutNextCard();
                if (drawnCard.toString().contains(Card.Rank.Ace.toString()) && i == 1) {
                    winning = false;
                } else if (drawnCard.toString().contains(Card.Rank.Two.toString()) && i == 2) {
                    winning = false;
                } else if (drawnCard.toString().contains(Card.Rank.Three.toString()) && i == 3) {
                    winning = false;
                }
            }
        }
        return winning;
    }
}
