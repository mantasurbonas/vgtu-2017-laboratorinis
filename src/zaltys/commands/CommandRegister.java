package zaltys.commands;

import zaltys.commands.CommandInterface;

import java.util.HashMap;
import java.util.Map;

public class CommandRegister {
    private Map<Character,CommandInterface> commands = new HashMap<>();

    public void registerCommand(Character w,CommandInterface commandInterface){
        commands.put(w,commandInterface);
    }
    public CommandInterface getCommand(Character w){
        return commands.get(w);
    }
}
