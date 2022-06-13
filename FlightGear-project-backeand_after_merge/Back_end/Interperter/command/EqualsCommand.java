package Interperter.command;

import Interperter.SharedMemory;

import java.util.ArrayList;

public class EqualsCommand implements Command{

    SharedMemory sharedMemory;
    int returnIndex;

    public EqualsCommand(SharedMemory sharedMemory) {
        this.sharedMemory = sharedMemory;
        this.returnIndex = 0;
    }

    private String getExpression(ArrayList<String> tokens, int index){
        StringBuilder sb = new StringBuilder();
        Variable variable;
        String token;
        for (int i = index; !tokens.get(i).equals("\n") ; i++) {
            token = tokens.get(i);
            if((variable = sharedMemory.symbolTable.get(token))!=null) {
                token = String.valueOf(variable.getValue());
            }
            sb.append(token+" ");
            returnIndex++;
        }
        return sb.toString().trim();
    }
    @Override
    public int execute(ArrayList<String> tokens, int index) {
        if(tokens.get(index+1).intern()!= "bind") {
            String line = getExpression(tokens, index + 1);
            sharedMemory.symbolTable.get(tokens.get(index - 1))
                    .setValue((float) SharedMemory
                            .calc(line));
        }
        else {
            returnIndex = 0;
        }

        return returnIndex;
    }
}
