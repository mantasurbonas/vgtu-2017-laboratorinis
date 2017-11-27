package zaltys.drawingstrategy;

import zaltys.Snake;

public class SnakeDrawingStragey implements DrawingStrategy {

    private Snake snake;

    public SnakeDrawingStragey(Snake snake) {
        this.snake = snake;
    }

    @Override
    public boolean doesApply(int x, int y) {
        return snake.isMe(x, y);
    }

    @Override
    public void draw() {
        System.out.print("*");
    }
}
