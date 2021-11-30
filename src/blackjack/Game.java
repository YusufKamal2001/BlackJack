package blackjack;

import java.util.Random;

public class Game {

    public static final int DECKLENGTH = 52;
    Player[] players = new Player[4];
    Card[] cardDeck = new Card[DECKLENGTH];
    int highScore;

    public void initiateCardsDeck() {
        for (int rank = 0; rank <= 12; rank++) {

            for (int suit = 0; suit <= 3; suit++) {
                cardDeck[rank * 4 + suit] = new Card(suit, rank, getValue(rank));
            }
        }
    }

    private int getValue(int rank) {
        if (rank < 10) {
            return rank + 1;
        } else
            return 10;
    }

    public Card[] getCardDeck() {
        return cardDeck;
    }

    public Card drawCard() {
        System.out.println("draw");
        Random random = new Random();
        int index = random.nextInt(DECKLENGTH - 1);
        if (cardDeck[index] != null) {
            Card card = new Card(cardDeck[index]);
            cardDeck[index] = null;
            return card;
        } else return drawCard();
    }

    public static void main(String[] args) {
        GUI gui = new GUI();
        Game game = new Game();
        game.initiateCardsDeck();

        Player[] players = new Player[4];
        for (int i = 0; i < 4; i++) {
            players[i] = new Player("player" + i, getInitialDraw(game));
        }
        for (Player player : players) {
            System.out.println(player);
        }

        gui.runGUI(game.getCardDeck(),
                players[0].getCards(),
                players[1].getCards(),
                players[2].getCards(),
                players[3].getCards());

    }

    private static Card[] getInitialDraw(Game game) {
        Card[] cards = new Card[2];
        for (int i = 0; i < 2; i++) {
            cards[i] = game.drawCard();
        }
        return cards;
    }
}
