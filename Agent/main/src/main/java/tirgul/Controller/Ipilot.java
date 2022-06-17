package tirgul.Controller;

public interface Ipilot {

    public void handleInstractions();

    public void sendCommands(String command);

    public void getCommands(String commands);

}
