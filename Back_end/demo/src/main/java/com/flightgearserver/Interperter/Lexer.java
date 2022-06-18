package com.flightgearserver.Interperter;

import java.util.ArrayList;
import java.util.Scanner;

public class Lexer {
    public static ArrayList<String> lexer(String code){
        ArrayList<String> tokens = new ArrayList<>();
        Scanner scanner = new Scanner(code);
        scanner.useDelimiter(" ");
        while (scanner.hasNext()){
            String token = scanner.next();
            tokens.add(token);
        }
        return tokens;
    }
}
