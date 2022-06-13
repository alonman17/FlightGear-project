package Interperter.command;

import Interperter.SharedMemory;

import java.util.ArrayList;

public class BindCommand implements Command{

    SharedMemory sharedMemory;

    public BindCommand(SharedMemory sharedMemory,) {
        this.sharedMemory = sharedMemory;
    }

    @Override
    public int execute(ArrayList<String> tokens, int index) {
        String bindCommand = tokens.get(index+1);
        String varName = tokens.get(index-2);
        Variable var  = sharedMemory.symbolTable.get(index-2);
        var.setBindTo(bindCommand);
        sharedMemory.isBind.put(varName,var);
        this.updateValueFromAgent(varName);

        return 1;
    }

    private void updateValueFromAgent(String varName) {
    }
}
