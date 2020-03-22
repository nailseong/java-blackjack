package domain.result;

import domain.user.Dealer;
import domain.user.Player;
import domain.user.Players;

import java.util.HashMap;
import java.util.Map;

public class Result {
	private static final int OPPOSITE_SIGN = -1;

	private final Map<Player, ResultType> results;

	public Result(Map<Player, ResultType> results) {
		this.results = results;
	}

	public static Result from (Dealer dealer, Players players) {
		Map<Player, ResultType> results = new HashMap<>();
		players.forEach(player -> results.put(player, player.compare(dealer)));
		return new Result(results);
	}

	public double createDealerRevenueResult() {
		return results.entrySet().stream()
				.mapToDouble(entry -> {
					ResultType resultType = entry.getValue();
					Player player = entry.getKey();

					return resultType.getExchangedBettingMoney(player.getBettingMoney());
				})
				.sum() * OPPOSITE_SIGN;
	}

	public ResultType get(Player player) {
		return results.get(player);
	}
}