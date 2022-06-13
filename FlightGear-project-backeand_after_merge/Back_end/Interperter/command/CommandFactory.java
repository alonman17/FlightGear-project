package Interperter.command;

import Interperter.SharedMemory;

import java.util.HashMap;

public class CommandFactory {
    HashMap<String,Command> commands;

    public CommandFactory(SharedMemory sharedMemory) {
        this.commands = new HashMap<>();
        this.commands.put("sleep",new SleepCommand());
        this.commands.put("var",new VarCommand(sharedMemory));
        this.commands.put("=",new EqualsCommand(sharedMemory));
    }

    public Command getCommand(String command){
        return this.commands.get(command);
    }
}
