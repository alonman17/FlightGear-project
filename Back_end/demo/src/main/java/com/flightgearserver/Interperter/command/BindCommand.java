package com.flightgearserver.Interperter.command;


import com.flightgearserver.Interperter.SharedMemory;
import com.flightgearserver.agent.AgentHandler;



import java.util.ArrayList;

public class BindCommand implements Command{

    SharedMemory sharedMemory;
    AgentHandler agent;

    public BindCommand(SharedMemory sharedMemory, AgentHandler agent) {
        this.sharedMemory = sharedMemory;
        this.agent = agent;
    }

    @Override
    public int execute(ArrayList<String> tokens, int index) {
        String bindCommand = tokens.get(index+1);
        String agentVarName = this.getAgentVarName(bindCommand);
        String varName = tokens.get(index - 2);
        Variable var  = sharedMemory.symbolTable.get(varName);
        var.setBindTo(bindCommand);
        sharedMemory.isBind.put(varName,var);
        this.updateValueFromAgent(agentVarName,varName);

        return 1;
    }

    private void updateValueFromAgent(String agentvarName,String varName) {
        Double varValue = agent.getFlightLiveValues().values.get(agentvarName);
        sharedMemory.symbolTable.get(varName).setValue(Float.parseFloat(String.valueOf(varValue)));
        sharedMemory.isBind.get(varName).setValue(Float.parseFloat(String.valueOf(varValue)));
        sharedMemory.varNameToAgentVarName.put(agentvarName,varName);
    }
    private String getAgentVarName(String varName){
        String[] strings = varName.split("/");
        String line = strings[strings.length -1 ];
        return line;

    }
}
