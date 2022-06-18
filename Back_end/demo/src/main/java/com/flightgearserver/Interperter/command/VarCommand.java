package com.flightgearserver.Interperter.command;


import com.flightgearserver.Interperter.SharedMemory;

import java.util.ArrayList;

public class VarCommand implements Command {

    SharedMemory sharedMemory;

    public VarCommand(SharedMemory sharedMemory) {
        this.sharedMemory = sharedMemory;
    }

    @Override
    public int execute(ArrayList<String> tokens, int index) {
        String varName = tokens.get(index + 1);
        sharedMemory.symbolTable.put(varName,new Variable(0));
        return 1;
    }
}
