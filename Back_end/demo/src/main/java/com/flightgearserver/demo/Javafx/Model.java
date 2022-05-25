package com.flightgearserver.demo.Javafx;

import com.flightgearserver.demo.agent.AgentManager;

import java.util.Observable;
import java.util.Observer;

public class Model implements Observer {

    AgentManager manager=AgentManager.getInstance();


    @Override
    public void update(Observable o, Object arg) {

    }

}
