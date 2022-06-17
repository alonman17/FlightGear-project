package com.flightgearserver.demo.Interperter;


import com.flightgearserver.demo.Interperter.command.Command;
import com.flightgearserver.demo.Interperter.command.CommandFactory;
import com.flightgearserver.demo.agent.AgentHandler;

import java.util.ArrayList;

public class Parser {
CommandFactory cf;
SharedMemory sharedMemory;
AgentHandler agentHandler;


    public Parser(SharedMemory sharedMemory, AgentHandler agentHandler) {
    this.sharedMemory = sharedMemory;
    this.agentHandler = agentHandler;
        cf = new CommandFactory(sharedMemory, agentHandler);
    }

    public void parse(ArrayList<String> tokens){
        Command command = null;

        for (int i = 0; i < tokens.size(); i++) {
            command = cf.getCommand(tokens.get(i));
            if(command!=null){
                i+=command.execute(tokens,i);
            }


            }
        }
    }

