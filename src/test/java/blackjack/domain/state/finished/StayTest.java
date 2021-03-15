package blackjack.domain.state.finished;

import static blackjack.domain.Fixture.FIXTURE_KING;
import static blackjack.domain.Fixture.FIXTURE_THREE;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import blackjack.domain.state.State;
import blackjack.domain.state.StateFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StayTest {

    @DisplayName("스테이 상태에서 카드를 더 뽑으면 예외가 발생한다.")
    @Test
    void draw() {
        // given, when
        State state = StateFactory.generateState(FIXTURE_KING, FIXTURE_THREE);

        // when
        State stay = state.stay();

        // then
        assertThatIllegalArgumentException().isThrownBy(() ->{
            stay.draw(FIXTURE_KING);
        });
    }

}