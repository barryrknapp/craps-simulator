package normchan.crapssim.simulation.strategy;

import java.util.Random;

import normchan.crapssim.engine.Layout;
import normchan.crapssim.engine.Player;
import normchan.crapssim.engine.bets.Lay;

public class LayStrategy extends PlayerStrategy {
	private static final Random engine = new Random();

	public LayStrategy(Player player, Layout layout) {
		super(player, layout);
	}

	@Override
	public void bet() {
		if (layout.getLayOn(4) == null) {
			int bet = (engine.nextInt(8) + 1) * 10;
			layout.addBet(new Lay(layout, player, bet, 4));
		} 
		if (layout.getLayOn(10) == null) {
			int bet = (engine.nextInt(8) + 1) * 10;
			layout.addBet(new Lay(layout, player, bet, 10));
		}
	}

}
