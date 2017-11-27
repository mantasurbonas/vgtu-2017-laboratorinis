package zaltys.commands;

import zaltys.Direction;
import zaltys.Snake;

public class MoveDownCommand implements CommandInterface {

    private Snake snake;

    public MoveDownCommand(Snake snake) {
        this.snake = snake;
    }

    @Override
    public void execute() {
        snake.setDirection(Direction.DOWN);
    }
}
