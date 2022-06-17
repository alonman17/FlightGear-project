package tirgul.Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class DataHandler {

    private File csvFile;
    private Scanner in;
    private PrintWriter out;
    private String[] symbols;

    public DataHandler() {
        symbols = null;
    }

    /**
     * This Function take a line from the Fg output data and concatinate it with its
     * Description
     * 
     * @param String : one line of data
     * @return String: one time stamp string of the Data plus its Description
     * @throws FileNotFoundException the sybol txt file must be pressent.
     */
    public String ParsData(String data) {

        StringBuilder sb = new StringBuilder();
        String[] dataValues;

        // create symbols array
        if (symbols == null) {

            try {
                in = new Scanner(new FileReader("src/main/resources/symbol.txt"));
                while (in.hasNext()) {
                    sb.append(in.nextLine() + ":,");
                }

                this.symbols = sb.toString().split(",");
                sb = null;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        sb = new StringBuilder();
        dataValues = data.split(",");

        // concat the symbols with the line values
        for (int i = 0; i < dataValues.length; i++) {
            sb.append(symbols[i] + dataValues[i] + ",");
        }
        sb.append("\n");
        return sb.toString();

    }

    public void PreformAnalitics() {
        // TODO : READ FROM CSV AND GET MAX AND MIN FROM FUTURES (TIMESIERIES)
    }

}
