package zaltys.gamefactory;

import zaltys.*;
import zaltys.commands.*;

import java.io.IOException;

public class ConsoleGame implements Game {

    private static int readUserInput() throws IOException {
        int n = System.in.read();
        while (System.in.available() > 0)
            System.in.read();
        return n;
    }

    public void run() throws Exception {

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

        CommandRegister register = new CommandRegister();
        register.registerCommand('w', new MoveUpCommand(snake));
        register.registerCommand('s', new MoveDownCommand(snake));
        register.registerCommand('a', new MoveLeftCommand(snake));
        register.registerCommand('d', new MoveRightCommand(snake));
        register.registerCommand('x', new ExitCommand());


        while(true){
            gameRenderer.render();

            int n = readUserInput();

            CommandInterface command = register.getCommand((char)n);
            command.execute();


            gameRules.onTimer();
        }
    }
}
