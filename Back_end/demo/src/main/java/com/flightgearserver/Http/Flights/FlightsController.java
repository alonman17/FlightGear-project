package com.flightgearserver.Http.Flights;


import com.flightgearserver.Http.Entiteis.Flight;
import com.flightgearserver.Http.Entiteis.Flightsdatum;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class FlightsController {

    FlightsService service;
    @Autowired
    public FlightsController(FlightsService service) {
        this.service = service;
    }

    @GetMapping("api/flights/all")
    public List<Flight> getAllFlights(){
        return service.getAllFlights();
    }
    @GetMapping("api/flights/{id}")
    public Flight getFlight(@PathVariable("id") Long id){
        return service.getFlight(id);
    }
    @GetMapping("api/flights/data/{id}")
    public ResponseEntity<Resource> getFightData(@PathVariable("id") Long id) {
        String[] csvHeader = List.of(Flightsdatum.class.getDeclaredFields()).stream().map(f -> f.getName()).toArray(String[]::new);

        // replace this with your data retrieving logic
        List<Flightsdatum> data = service.getFightData(id);


        ByteArrayInputStream byteArrayOutputStream = null;

        // closing resources by using a try with resources
        // https://www.baeldung.com/java-try-with-resources
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            // defining the CSV printer
            CSVPrinter csvPrinter = new CSVPrinter(
                    new PrintWriter(out),
                    // withHeader is optional
                    CSVFormat.DEFAULT.withHeader(csvHeader)
            );

            // populating the CSV content
            for (Flightsdatum record : data) {
                List<String> datarecord= Arrays.asList(record.toString().split(","));
                csvPrinter.printRecord(datarecord);

                // writing the underlying stream
                csvPrinter.flush();
                byteArrayOutputStream = new ByteArrayInputStream(out.toByteArray());

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
            
        InputStreamResource fileInputStream = new InputStreamResource(byteArrayOutputStream);

        String csvFileName ="flight "+ id +"  flight data.csv";

        // setting HTTP headers
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + csvFileName);
        // defining the custom Content-Type
        headers.set(HttpHeaders.CONTENT_TYPE, "text/csv");

        return new ResponseEntity<>(
                fileInputStream,
                headers,
                HttpStatus.OK
        );
    }
        @GetMapping(value ="api/flights/normalFlight" ,produces = "text/csv")
    public @ResponseBody byte[] getNormalFlight() {
        return service.getNormalFlight();
    }
}
