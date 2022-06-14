package com.flightgearserver.Javafx.View;

import com.flightgearserver.agent.AgentManager;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.*;


public class onlineWindowController extends Observable  {

    int size= AgentManager.getInstance().getNumOfAicrafts();
    Map<String,Circle> planeStatuses;
    Map<String,Button> buttonMap;
    List<Label> labels;
    @FXML
    GridPane gridPane;
    public void changeColor(int id){
        buttonMap.get(String.valueOf(id)).setDisable(!buttonMap.get(String.valueOf(id)).isDisabled());
        Circle circle=planeStatuses.get(String.valueOf(id));
        Color color= circle.getFill() == Color.RED ? Color.GREEN : Color.RED;
        circle.setFill(color);
        setChanged();
        notifyObservers();
    }

    public void initialize() {
        planeStatuses=new HashMap();
        labels=new ArrayList<>();
        buttonMap=new HashMap<>();
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.setAlignment(Pos.CENTER);
        //Init the properties;
        for (int i = 0; i < size; i++) {
            planeStatuses.put(String.valueOf(i),new Circle());
            buttonMap.put(String.valueOf(i),new Button("Disconnect"));
            labels.add(new Label("Aircraft " + (i)));
        }
        for (int i = 0; i < buttonMap.values().size(); i++) {
            var btn=buttonMap.get(String.valueOf(i));
            btn.setId(String.valueOf(i));
            btn.setDisable(true);
            btn.setOnAction((actionEvent -> {
                setChanged();
                notifyObservers(Integer.parseInt(btn.getId()));
            }));
        }
        for (Circle c : planeStatuses.values()) {
            c.setFill(Color.RED);
            c.setCenterX(50);
            c.setCenterY(50);
            c.setRadius(10);
            c.setStrokeWidth(2);
            c.setStroke(Color.BLACK);
        }
        for (int i = 0; i < size; i++) {
            gridPane.addRow(i,labels.get(i),planeStatuses.get(String.valueOf(i)),buttonMap.get(String.valueOf(i)));
        }
    }
}
