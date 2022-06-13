package flightgearserver.Javafx.Controllers;

import main.java.com.flightgearserver.Javafx.Model.onlineModel;
import main.java.com.flightgearserver.Javafx.View.onlineWindowController;

import java.util.Observable;
import java.util.Observer;

public class onlineController implements Observer {

    main.java.com.flightgearserver.Javafx.Model.onlineModel onlineModel;
    onlineWindowController wc;

    public onlineController(onlineWindowController wc, onlineModel m) {
        this.wc = wc;
        this.onlineModel =m;
        m.addObserver(this);
        wc.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o== onlineModel){
            if (arg!=null)
            wc.changeColor((int)arg);
        }if(o==wc){
            if (arg!=null)
            onlineModel.disconnectAgent((int)arg);
        }
    }

}
