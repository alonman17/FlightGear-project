package tirgul.model;

import java.io.FileWriter;
import java.io.IOException;

import java.io.InputStreamReader;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import java.util.Scanner;

public class FgClient implements ClientHandler {

    private PrintWriter outToClient;
    private Scanner inFromClient;

    @Override
    public void handleClient(InputStreamReader in, OutputStreamWriter out) {
        try {
            FileWriter tempFile = new FileWriter("FG_Data.txt");
            this.inFromClient = new Scanner(in);
            this.outToClient = new PrintWriter(out);
            String line = null;
            while (inFromClient.hasNext()) {
                line = inFromClient.nextLine();
                tempFile.write(line + " \n");
            }
            tempFile.close();
            inFromClient.close();
            outToClient.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
