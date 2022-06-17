package com.flightgearserver.demo.Interperter.command;

public class Variable {
   volatile float value;
    String bindTo;

    public Variable(float value) {
        this.value = value;
        this.bindTo = null;
    }

    public float getValue() {
        return value;
    }

    public String getBindTo() {
        return bindTo;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public void setBindTo(String bindTo) {
        this.bindTo = bindTo;
    }
}
