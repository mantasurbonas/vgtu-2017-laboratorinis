package zaltys;

public class GameRules {

	private GameMap map;
	private Snake snake;

	public GameRules(Snake snake, GameMap map){
		this.map = map;
		this.snake = snake;
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
			case 'a': snake.setDirection(Direction.LEFT); break;
			case 'd': snake.setDirection(Direction.RIGHT); break;
			case 's': snake.setDirection(Direction.DOWN); break;
			case 'w': snake.setDirection(Direction.UP); break;
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
		
		if (map.isApple(newHead.x, newHead.y))
			map.eatApple(newHead.x, newHead.y); // don't trim
		else
			snake.trimTail();	
	}
}
