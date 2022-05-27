package com.flightgearserver.demo.Javafx.Model;

import com.flightgearserver.demo.Javafx.View.onlineWindowController;
import com.flightgearserver.demo.agent.AgentManager;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Observable;


public class Model extends Observable implements PropertyChangeListener {

    AgentManager manager=AgentManager.getInstance();
    private onlineWindowController windowController=new onlineWindowController();
    int res;
    public void getChangeStatus(){
        res=1;
        setChanged();
        notifyObservers();

    }

    public int getRes() {
        return res;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        int newAircraft= Integer.valueOf(evt.getPropertyName());
        //windowController.changeColor();
        setChanged();
        notifyObservers(newAircraft);
    }

    public void disconnectAgent(int id) {
        manager.removeAgent(id);
        setChanged();
        notifyObservers();
    }
}
