package blackjack.domain.card;

import java.util.Collections;
import java.util.List;

public class ShuffleOrderStrategy implements CardOrderStrategy {

    @Override
    public List<Card> generate() {
        final List<Card> allCards = Card.getAllCards();
        Collections.shuffle(allCards);

        return allCards;
    }
}