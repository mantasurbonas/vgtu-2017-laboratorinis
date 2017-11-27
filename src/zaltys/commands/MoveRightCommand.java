package zaltys.commands;

import zaltys.Direction;
import zaltys.Snake;

public class MoveRightCommand implements CommandInterface {

    private Snake snake;

    public MoveRightCommand(Snake snake) {
        this.snake = snake;
    }

    @Override
    public void execute() {
        snake.setDirection(Direction.RIGHT);
    }
}
