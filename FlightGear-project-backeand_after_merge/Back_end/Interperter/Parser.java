package Interperter;

import Interperter.command.Command;
import Interperter.command.CommandFactory;

import java.util.ArrayList;

public class Parser {
CommandFactory cf;

    public Parser(SharedMemory sharedMemory) {
        cf = new CommandFactory(sharedMemory);
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
