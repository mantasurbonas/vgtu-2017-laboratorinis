package zaltys.gamefactory;

import java.io.IOException;

public class GameFactory {
    public Game createGame(String param) throws IOException {
        if(param.equals("console")){
            return new ConsoleGame();
        }
        else {
            return new WindowsGame();
        }
    }
}
