package com.flightgearserver.Interperter.command;



import com.flightgearserver.Interperter.SharedMemory;
import com.flightgearserver.agent.AgentHandler;

import java.util.ArrayList;

public class EqualsCommand implements Command{

    SharedMemory sharedMemory;
    AgentHandler agentHandler;
    int returnIndex;

    public EqualsCommand(SharedMemory sharedMemory, AgentHandler agentHandler) {
        this.sharedMemory = sharedMemory;
        this.agentHandler = agentHandler;
        this.returnIndex = 0;
    }

    private String getExpression(ArrayList<String> tokens, int index){
        StringBuilder sb = new StringBuilder();
        Variable variable;
        returnIndex = 0;
        String token = tokens.get(index);
        while(!tokens.get(index + returnIndex).equals("\n")){
            if((variable = sharedMemory.symbolTable.get(token))!=null) {
                token = String.valueOf(variable.getValue());
            }
            sb.append(token + " ");
            returnIndex++;
            token = tokens.get(index + returnIndex);
        }
        return sb.toString().trim();
    }

    @Override
    public int execute(ArrayList<String> tokens, int index) {
        if(tokens.get(index+1).intern()!= "bind") {
            String line = getExpression(tokens, index + 1);
            float result = (float) SharedMemory.calc(line);
            sharedMemory.symbolTable.get(tokens.get(index - 1))
                    .setValue(result);
            if(sharedMemory.isBind.containsKey(tokens.get(index-1))) {
                String change ="set " + sharedMemory.isBind.get(tokens.get(index - 1)).getBindTo() + " " + result;
                agentHandler.writeToClient(change);
            }

        }
        else {
            returnIndex = 0;
        }

        return returnIndex;
    }
}
