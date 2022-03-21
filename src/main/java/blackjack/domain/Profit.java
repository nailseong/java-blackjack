package blackjack.domain;

import blackjack.domain.participant.Dealer;
import blackjack.domain.participant.Player;
import blackjack.domain.participant.Players;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Profit {

    private static final int DEALER_PROFIT_RATE = -1;

    private final Map<String, Double> profitByName;

    private Profit(final Map<String, Double> profitByName) {
        this.profitByName = profitByName;
    }

    public static Profit of(final Dealer dealer, final Players players) {
        final Map<String, Double> value = players.getValue().stream()
                .collect(Collectors.toMap(
                        Player::getName,
                        player -> player.calculateProfit(dealer.getScore(), dealer.isBlackjack()),
                        (a, b) -> a,
                        LinkedHashMap::new));

        return new Profit(value);
    }

    public double findDealerProfit() {
        final double totalPlayerProfit = profitByName.values().stream()
                .mapToDouble(Double::doubleValue)
                .sum();

        return totalPlayerProfit * DEALER_PROFIT_RATE;
    }

    public double findPlayerProfit(String name) {
        return profitByName.get(name);
    }
}
