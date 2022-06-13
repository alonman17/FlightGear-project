package Interperter.command;

import java.util.ArrayList;

public class SleepCommand implements Command {
    @Override
    public int execute(ArrayList<String> tokens, int index) {
        int time = Integer.parseInt(tokens.get(index+1));
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return 1;
    }
}
