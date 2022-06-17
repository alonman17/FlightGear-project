package com.flightgearserver.demo.Interperter;

import com.flightgearserver.demo.agent.AgentHandler;

public class Interpreter {

    Parser parser;
    public SharedMemory sharedMemory;
    AgentHandler agentHandler;

    public Interpreter(AgentHandler agentHandler, SharedMemory sharedMemory) {
        this.sharedMemory = sharedMemory;
        this.agentHandler = agentHandler;
        this.parser = new Parser(this.sharedMemory, this.agentHandler);
    }

    public void run(String code){
        this.parser.parse(Lexer.lexer(code));
    }
}
