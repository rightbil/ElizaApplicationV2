package com.company;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
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
        // control the user if he wants to exit
        String quit="C";
        while (!quit.equalsIgnoreCase("Q")) {
            System.out.println("Enter your sentence");
            String useInput = sc.nextLine();
            if(!useInput.equalsIgnoreCase("Q")) {
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
                }// replacement of pronouns is finished till here

                String[] hedges = new String[]{"Please tell me more", "Many of my patients tell me the same thing", "It is getting late, maybe we had better quit"};
                String[] qualifiers = new String[]{"Why do you say that", "You seem to think that", "So, you are concerned that"};
                // random hedges and qualifier generator
                Random randHedges = new Random();
                int rndHedge = randHedges.nextInt(hedges.length);
                // need to create a separate Random b/c hedges and qualifiers have different lengths
                Random randQualifier = new Random();
                int rndQualifier = randHedges.nextInt(qualifiers.length);

                // let's capture the random values using the random values as index
                String qualifier = qualifiers[rndQualifier];
                String hedge = hedges[rndHedge];

                System.out.println(qualifier + " " + result);
                System.out.println(hedge);
            }
            else { // this time the user input Q
                System.out.println("sorry to see you go, have a nice day");
                quit=useInput;// this means Q so that the outer while loop will not excute again.
                break;
            }
        } // end of while loop

    }
}
