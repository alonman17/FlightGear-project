package com.flightgearserver.Interperter.command;


;

import com.flightgearserver.Interperter.SharedMemory;
import com.flightgearserver.agent.AgentHandler;

import java.util.HashMap;

public class CommandFactory {
    HashMap<String,Command> commands;

    public CommandFactory(SharedMemory sharedMemory, AgentHandler agentHandler) {
        this.commands = new HashMap<>();
        this.commands.put("sleep",new SleepCommand());
        this.commands.put("var",new VarCommand(sharedMemory));
        this.commands.put("=",new EqualsCommand(sharedMemory,agentHandler));
        this.commands.put("bind", new BindCommand(sharedMemory,agentHandler));
        this.commands.put("while", new WhileCommand(sharedMemory, agentHandler));
        this.commands.put("print", new PrintCommand(sharedMemory));
    }

    public Command getCommand(String command){
        return this.commands.get(command);
    }
}
