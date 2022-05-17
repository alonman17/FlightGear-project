package com.flightgearserver.demo.agent;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class PropertyPage

{

    public PropertyPage (FGFSConnection fgfs, String name)
    {
	this.fgfs = fgfs;
	this.name = name;
	fields = new ArrayList();

    }

    public String getName ()
    {
	return name;
    }

    public void addField (String name, String caption)
    {
	PropertyField field = new PropertyField(fgfs, name, caption);
	fields.add(field);
    }

    public void update ()
	throws IOException
    {
	Iterator it = fields.iterator();
	while (it.hasNext()) {
	    ((PropertyField)it.next()).update();
	}
    }

    private FGFSConnection fgfs;
    private String name;
    private ArrayList fields;

}
