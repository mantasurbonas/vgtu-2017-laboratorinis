package zaltys;

import java.util.concurrent.ThreadLocalRandom;

public class GameRules {

	private GameMap map;
	private Snake snake;

	public GameRules(Snake snake, GameMap map){
		this.map = map;
		this.snake = snake;
		generateApple();
	}
	
	public Coord createNewHead(Coord oldHead, Direction snakeDirection) {
		Coord newHead = new Coord(oldHead.x, oldHead.y);
		
		switch(snakeDirection){
			case LEFT: newHead.x = newHead.x-1;break; 
			case RIGHT: newHead.x = newHead.x+1; break; 
			case DOWN: newHead.y = newHead.y+1;break;
			case UP: newHead.y = newHead.y-1;break;
		}
		return newHead;
	}

	public void gameOver(String goodbyeMessage) {
		System.out.println(goodbyeMessage);
		System.exit(0);
	}

	public void decideDirection(int n) {

		switch(n){
			case 'a':
				if(snake.getDirection() == Direction.RIGHT)
					break;
				snake.setDirection(Direction.LEFT);
				break;
			case 'd':
				if(snake.getDirection() == Direction.LEFT)
					break;
				snake.setDirection(Direction.RIGHT);
				break;
			case 's':
				if(snake.getDirection() == Direction.UP)
					break;
				snake.setDirection(Direction.DOWN);
				break;
			case 'w':
				if(snake.getDirection() == Direction.DOWN)
					break;
				snake.setDirection(Direction.UP);
				break;
		}
	}

	public void onTimer() {
		Coord oldHead = snake.getHead();
		Coord newHead = createNewHead(oldHead, snake.getDirection());

		if (map.isWall(newHead.x, newHead.y))
			gameOver("Game over, you hit the wall");
		
		if (snake.isMe(newHead.x, newHead.y))
			gameOver("Game over, you hit yourself");
		
		snake.addHead(newHead);
		
		if (map.isApple(newHead.x, newHead.y)) {
			map.eatApple(newHead.x, newHead.y); // don't trim
			generateApple();
		}
		else
			snake.trimTail();	
	}


	public void generateApple() {
		boolean applePlaced = false;

		while(!applePlaced) {
			int appleSpot = ThreadLocalRandom.current().nextInt(0, map.getHeight() * map.getWidth() + 1);
			int x = appleSpot % map.getWidth();
			int y = appleSpot / map.getHeight();

			if(map.isEmpty(x, y) && !snake.isMe(x, y)) {
				map.placeApple(x, y);
				applePlaced = true;
			}
		}
	}
}
