package blackjack;

import java.util.Arrays;

public class Player {
    private final String name;

    private final Card[] cards ;

    public Player(String name, Card[] cards) {
        this.name = name;
        this.cards = cards;
    }

    public String getName() {
        return name;
    }

    public Card[] getCards() {
        return cards;
    }

    int getScore() {
        int sum = 0;
        for (Card card : cards) {
            //TODO review
            sum = sum + card.getValue();
        }
        return sum;
    }

    boolean isBlackJack() {
        return false;
    }

    boolean isLost() {
        return false;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", cards=" + Arrays.toString(cards) +
                '}';
    }
}
