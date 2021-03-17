package blackjack.domain.state;

import blackjack.domain.card.Cards;
import blackjack.domain.user.Dealer;

public class Stay extends Finished {
    public Stay(Cards cards) {
        super(cards);
    }

    @Override
    public double earningRate(Dealer dealer) {
        if (dealer.isBust() || dealer.score().lessThan(score())) {
            return 1;
        }

        if (score().equals(dealer.score())) {
            return 0;
        }

        return -1;
    }
}