package com.flightgearserver.demo.agent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class AgentHandler {
    Agent agent;
    Logger logger= LoggerFactory.getLogger(AgentHandler.class);
    public void Handle(Agent agent){
        Scanner in;
        PrintWriter out;
        try {
            in =new Scanner(new InputStreamReader(agent.getSocket().getInputStream()));
            out=new PrintWriter(agent.getSocket().getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //while loop that handles data stream of the agent
        while (in.hasNext()){
            StringBuilder stringBuilder=new StringBuilder();
            String line=in.nextLine();
            //Assuming our lines comes out as valName:value,valName1:value1....
            String[] values=line.split(",");
            for (int i = 0; i < values.length; i++)
            {
                String[] temp=values[i].split(":");
                agent.getValues().setSingleValue(temp[0], Double.parseDouble(temp[1]));
                stringBuilder.append(temp[1]+",");
            }
            stringBuilder.deleteCharAt(stringBuilder.length());
            agent.getTs().addRow(stringBuilder.toString());
        }
    }
}
