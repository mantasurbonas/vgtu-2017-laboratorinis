package zaltys;

import zaltys.gamefactory.Game;
import zaltys.gamefactory.GameFactory;

public class Main {


	
	public static void main(String[] args) throws Exception {
		GameFactory gameFactory = new GameFactory();

		if (args.length > 0) {
			Game game = gameFactory.createGame(args[0]);
			game.run();
		}




	}



}
