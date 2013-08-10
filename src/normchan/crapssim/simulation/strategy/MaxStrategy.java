package normchan.crapssim.simulation.strategy;

import normchan.crapssim.engine.Layout;
import normchan.crapssim.engine.Player;
import normchan.crapssim.engine.bets.Bet;
import normchan.crapssim.engine.bets.Come;
import normchan.crapssim.engine.bets.Field;
import normchan.crapssim.engine.bets.PassLine;
import normchan.crapssim.engine.bets.PassOrCome;

public class MaxStrategy extends PlayerStrategy {

	public MaxStrategy(Player player, Layout layout) {
		super(player, layout);
	}

	@Override
	public void bet() {
		if (!layout.isNumberEstablished()) {
//			System.out.println("Making new $5 pass line bet.");
			layout.addBet(new PassLine(layout, player, 5));
		} else {
//			System.out.println("Making new $5 come bet.");
			layout.addBet(new Come(layout, player, 5));

			for (Bet b : layout.getBets()) {
				if (b instanceof PassOrCome) {
					PassOrCome bet = (PassOrCome)b;
					if (bet.isNumberEstablished())
						bet.updateOddsBet(bet.getMaxOddsBet());
				}
			}

			handlePlaceBet(6, 12);
			handlePlaceBet(8, 12);
			
			handleHardWayBet(4, 5);
			handleHardWayBet(10, 5);
		}
		
//		System.out.println("Making new $10 field bet.");
		layout.addBet(new Field(layout, player, 10));
	}

}