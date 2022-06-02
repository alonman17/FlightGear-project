package tirgul.model;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public interface ClientHandler {
    public void handleClient(InputStreamReader in, OutputStreamWriter out, Socket clientSocket);
}
