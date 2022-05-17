package com.flightgearserver.demo.agent;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class PropertyField
    extends JPanel
{

    public PropertyField (FGFSConnection fgfs,
			  String name,
			  String caption)
    {
	this.fgfs = fgfs;
	propertyName = name;
	label = new JLabel(caption);
	value = new JTextField(10);
	value.addActionListener(ev -> {
	try {
		modify();
		grabFocus();
	} catch (IOException ex) {
		System.err.println("Failed to update " + propertyName);
	}
	});

	add(label);
	add(value);

    }

    public void update ()
	throws IOException
    {
	if (!value.hasFocus())
	    value.setText(fgfs.get(propertyName));
    }

    public void modify ()
	throws IOException
    {
	fgfs.set(propertyName, value.getText());
    }

    private FGFSConnection fgfs;
    private String propertyName;
    private JLabel label;
    private JTextField value;

}
