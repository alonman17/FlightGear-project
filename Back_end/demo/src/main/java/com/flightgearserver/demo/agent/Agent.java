package com.flightgearserver.demo.agent;

import com.flightgearserver.demo.liveCache.FlightLiveValues;
import com.flightgearserver.demo.Utils.TimeSeries;

import java.net.Socket;

public class Agent {
    private Socket socket;
    private TimeSeries ts;
    private FlightLiveValues values;

    public Agent(Socket socket) {
        this.socket = socket;
        ts=new TimeSeries("");
        values=new FlightLiveValues();

    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public TimeSeries getTs() {
        return ts;
    }

    public void setTs(TimeSeries ts) {
        this.ts = ts;
    }

    public FlightLiveValues getValues() {
        return values;
    }

    public void setValues(FlightLiveValues values) {
        this.values = values;
    }

}
