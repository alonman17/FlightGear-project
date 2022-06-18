package com.flightgearserver.Interperter.command;


import com.flightgearserver.Interperter.Interpreter;
import com.flightgearserver.Interperter.SharedMemory;
import com.flightgearserver.agent.AgentHandler;

import java.util.ArrayList;

public class WhileCommand implements Command{

    SharedMemory sharedMemory;
    AgentHandler agentHandler;

    public WhileCommand(SharedMemory sharedMemory, AgentHandler agentHandler) {
        this.sharedMemory = sharedMemory;
        this.agentHandler = agentHandler;
    }

    @Override
    public int execute(ArrayList<String> tokens, int index) {
        int num_of_args = 5; // as the basic nums of condition and {}
        String leftArg = tokens.get(index + 1);
        String rightArg = tokens.get(index + 3);
        Interpreter interpreter = new Interpreter(this.agentHandler, this.sharedMemory);
        float[] floatArr = StringToFloat(leftArg,rightArg);
        float leftArgVal = floatArr[0];
        float rightArgVal = floatArr[1];


        StringBuilder sb = new StringBuilder();
        while (!tokens.get(index + num_of_args).equals("}")){
            sb.append(tokens.get(index + num_of_args) + " ");
            num_of_args++;
        }

        while (leftArgVal < rightArgVal){
            interpreter.run(sb.toString());

            floatArr = StringToFloat(leftArg,rightArg);
            leftArgVal = floatArr[0];
            rightArgVal = floatArr[1];
        }
        return num_of_args;
    }

    private float[] StringToFloat(String leftArg, String rightArg){
        float[] floatArr = new float[2];
        if(sharedMemory.symbolTable.containsKey(leftArg))
            floatArr[0] = sharedMemory.symbolTable.get(leftArg).getValue();
        else floatArr[0] = Float.parseFloat(leftArg);

        if(sharedMemory.symbolTable.containsKey(rightArg))
            floatArr[1] = sharedMemory.symbolTable.get(rightArg).getValue();
        else floatArr[1] = Float.parseFloat(rightArg);

        return floatArr;
    }
}
