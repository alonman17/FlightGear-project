package com.flightgearserver.Interperter.command;


import com.flightgearserver.Interperter.SharedMemory;

import java.util.ArrayList;

public class PrintCommand implements Command{

    SharedMemory sharedMemory;

    public PrintCommand(SharedMemory sharedMemory) {
        this.sharedMemory = sharedMemory;
    }

    @Override
    public int execute(ArrayList<String> tokens, int index) {
        int num_of_args = 1;
        String token = tokens.get(index + num_of_args);
        while (!token.equals("\n")){

            if (sharedMemory.symbolTable.containsKey(token))
                token = String.valueOf(sharedMemory.symbolTable.get(token).getValue());

            System.out.print(token + " ");

            num_of_args++;
            token = tokens.get(index + num_of_args);

        }



        return num_of_args;
    }
}
