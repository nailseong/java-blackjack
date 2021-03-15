package blackjack.domain.player;

import blackjack.domain.card.Card;
import blackjack.domain.state.State;

public class Dealer extends Player {

    private static final int DRAW_STANDARD = 16;

    public Dealer(State state) {
        super("딜러", state);
    }

    @Override
    public void addCard(Card card) {
        if (calculateScore() > DRAW_STANDARD) {
            throw new IllegalArgumentException("[ERROR] 딜러의 점수가 16을 초과하여 카드를 추가할 수 없습니다.");
        }
        state = state.draw(card);
    }

    @Override
    public boolean canDraw() {
        return calculateScore() <= DRAW_STANDARD;
    }

    @Override
    public boolean isDealer() {
        return true;
    }
}