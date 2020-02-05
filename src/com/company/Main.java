package com.company;

import javax.print.MultiDocPrintService;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Map<String, String> mapEliza = new HashMap<>();
        mapEliza.put("i", "you"); // key and value
        mapEliza.put("me", "you");
        mapEliza.put("my", "your");
        mapEliza.put("am", "are");
        String[] str; // will hold user input from keyboard
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your sentence");
        String useInput = sc.nextLine();
        // will store the input by breaking the empty space
        str = useInput.split(" ");
        // will contain every word attaching to the previous value
        StringBuilder result = new StringBuilder();
        //go through every word
        for (int i = 0; i < str.length; i++) {
            // search the word in the mapEliza hashmap
            for (String key : mapEliza.keySet()) { // for every key value eg. i , me or my
                if (str[i].equalsIgnoreCase(key)) { // check if the key value is same as str[i] first word in the input
                    //for testing purpose only
                   //System.out.println("@ i=:" + i + " value " + str[i] + " is replaced by " + mapEliza.get(key));
                    str[i] = mapEliza.get(key);
                    break;
                }
            }
            result.append(str[i] + " ");
        }
        System.out.println(result);
    }
}
