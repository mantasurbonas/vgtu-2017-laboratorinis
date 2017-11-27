package zaltys.commands;

import zaltys.Direction;
import zaltys.Snake;

public class MoveLeftCommand implements CommandInterface {

    private Snake snake;

    public MoveLeftCommand(Snake snake) {
        this.snake = snake;
    }

    @Override
    public void execute() {
        snake.setDirection(Direction.LEFT);
    }
}
