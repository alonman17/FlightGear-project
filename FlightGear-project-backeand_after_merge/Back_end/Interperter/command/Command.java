package Interperter.command;

import java.util.ArrayList;

public interface Command {

    public int execute(ArrayList<String> tokens, int index);
}
