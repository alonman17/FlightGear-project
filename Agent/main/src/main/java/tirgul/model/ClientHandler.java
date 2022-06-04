package tirgul.model;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public interface ClientHandler {
    public void handleClient(InputStreamReader in, OutputStreamWriter out);
}
