package flightgearserver.ServerScoket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public interface ClientHandler{
    void handleClient(Socket aClient) throws IOException;

}