package com.flightgearserver.demo.Javafx.Controllers;

import com.flightgearserver.demo.Javafx.Model;

import java.util.Observable;
import java.util.Observer;

public class onlineController implements Observer {

    Model model;
    onlineWindowController wc;

    public onlineController(onlineWindowController wc,Model m) {
        this.wc = wc;
        this.model=m;
        m.addObserver(this);
        wc.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o==model){
            wc.changeColor();
        }
    }
}
