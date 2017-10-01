package zaltys;

import java.io.IOException;

public class Main {

	private static int readUserInput() throws IOException{
		int n = System.in.read();
		while (System.in.available() > 0)
			System.in.read();
		return n;
	}
	
	public static void main(String[] args) throws IOException {
		
		GameMap map = new GameMap();
		
		Snake snake = new Snake(
				Direction.RIGHT,
				new Coord(10,10),
				new Coord(9,10),
				new Coord(8,10),
				new Coord(7,10),
				new Coord(6,10)
			);;
		
		ConsoleGameRenderer gameRenderer = new ConsoleGameRenderer(map, snake);
		
		GameRules gameRules = new GameRules(snake, map);
		
		while(true){
			gameRenderer.render();
			
			int n = readUserInput();
			
			gameRules.decideDirection(n);

			gameRules.onTimer();
		}
	}



}
