package com.flightgearserver.demo.Javafx.Controllers;

import com.flightgearserver.demo.Javafx.Model;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import java.util.Observable;


public class onlineWindowController extends Observable {

    Model model;
    @FXML
    Circle planeStatus1;

    public void changeColor(){
        planeStatus1.setFill(Color.RED);
        setChanged();
        notifyObservers();
    }

}
