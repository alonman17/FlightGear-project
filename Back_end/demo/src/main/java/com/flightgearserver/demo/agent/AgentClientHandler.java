package com.flightgearserver.demo.agent;

import com.flightgearserver.demo.ServerScoket.ClientHandler;

import java.io.*;

public class AgentClientHandler implements ClientHandler {
    InputStreamReader in;
    PrintWriter out;
    @Override
    public void handleClient(InputStream inFromClient, OutputStream outToClient) throws IOException {
        in=new InputStreamReader(inFromClient);
        out=new PrintWriter(new OutputStreamWriter(outToClient));

    }
}
