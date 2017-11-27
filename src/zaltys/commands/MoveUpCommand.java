package zaltys.commands;

import zaltys.Direction;
import zaltys.Snake;

public class MoveUpCommand implements CommandInterface {

    private Snake snake;

    public MoveUpCommand(Snake snake) {
        this.snake = snake;
    }

    @Override
    public void execute() {
        snake.setDirection(Direction.UP);
    }
}
