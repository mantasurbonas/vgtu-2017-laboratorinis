package zaltys;

import zaltys.drawingstrategy.AppleDrawingStrategy;
import zaltys.drawingstrategy.DrawingStrategy;
import zaltys.drawingstrategy.SnakeDrawingStragey;
import zaltys.drawingstrategy.WallDrawingStragey;

import java.util.ArrayList;
import java.util.List;

public class ConsoleGameRenderer {

	private GameMap map;
	private Snake snake;

	private List<DrawingStrategy> drawingStrategies = new ArrayList<>();


	public ConsoleGameRenderer(GameMap map, Snake snake){
		this.map = map;
		this.snake = snake;

		drawingStrategies.add(new SnakeDrawingStragey(snake));
		drawingStrategies.add(new WallDrawingStragey(map));
		drawingStrategies.add(new AppleDrawingStrategy(map));
	}
	
	public void render(){
			for (int y=0; y<map.getHeight(); y++){
				for (int x =0 ;x<map.getWidth(); x++){
					drawElement(y, x);
				}
				System.out.println();
			}
	}

	private void drawElement(int y, int x) {
		for (DrawingStrategy strategy : drawingStrategies) {
            if (strategy.doesApply(x, y)) {
                strategy.draw();
                return;
            }
        }
		System.out.print(" ");
	}
}
