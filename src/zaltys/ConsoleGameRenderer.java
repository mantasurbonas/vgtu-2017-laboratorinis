package zaltys;

public class ConsoleGameRenderer {

	private GameMap map;
	private Snake snake;
	
	public ConsoleGameRenderer(GameMap map, Snake snake){
		this.map = map;
		this.snake = snake;
	}
	
	public void render(){
			for (int y=0; y<map.getHeight(); y++){
				for (int x =0 ;x<map.getWidth(); x++){
					if (snake.isMe(x, y)){
						System.out.print("*");
					}else
					if (map.isWall(x, y)){
						System.out.print("#");
					}else
					if (map.isApple(x, y)){
						System.out.print("o");
					}else{
						System.out.print(" ");
					}
				}
				System.out.println();
			}
	}
}
