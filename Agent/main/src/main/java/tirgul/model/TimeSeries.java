package tirgul.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TimeSeries {
    private String line = "";
    private String[] valuse;
    private int index;
    private boolean first = true;
    private List<String[]> stringList = new ArrayList<>();
    private HashMap<String, Double[]> csvMap = new HashMap<>();

    public TimeSeries(String fileName) {

        try {
            BufferedReader bf = new BufferedReader(new FileReader(fileName));
            line = bf.readLine();
            valuse = line.split(",");
            for (String value : valuse) {
                csvMap.put(value, null);
            }
            while ((line = bf.readLine()) != null) {
                valuse = line.split(",");
                csvMap.forEach((k, v) -> {
                    Double[] numbers = new Double[1000];
                    int i = 0;
                    for (String value : valuse) {
                        numbers[i] = Double.parseDouble(value);
                    }
                    v = numbers;
                });
            }

        } catch (Exception e) {
            // TODO: handle exception
        }

    }

}
