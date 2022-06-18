package tirgul.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.io.InputStreamReader;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import java.util.Scanner;

public class FgClientHandler implements ClientHandler {

    private PrintWriter outToClient;
    private Scanner inFromClient;

    @Override
    public void handleClient(InputStreamReader in, OutputStreamWriter out) {
        this.inFromClient = new Scanner(in);
        this.outToClient = new PrintWriter(out);
        // new Thread(() -> writeToCsv(inFromClient, outToClient)).start();

    }

    public void writeToCsv(Scanner in, PrintWriter out, String fileName) {

        System.out.println("Writing to CSV file ...");

        try {

            BufferedReader bf = new BufferedReader(new FileReader("Agent/main/src/main/resources/symbol.txt"));

            StringBuilder sb = new StringBuilder();
            String line = null;

            while ((line = bf.readLine()) != null) {
                sb.append(line.toUpperCase() + ",");
            }
            sb.append("\n");

            bf.close();
            line = null;

            FileWriter tempFile = new FileWriter(new File(fileName));
            tempFile.write(sb.toString());
            while (in.hasNext()) {
                line = in.nextLine();
                tempFile.write(line + " \n");
            }

            tempFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public File getCsv(String fileName) {

        File csvFile = new File("src/main/resources/symbol.txt");
        return csvFile;

    }

    public void closeConnection() {
        inFromClient.close();
        outToClient.close();
    }

}
