/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package icsparser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author psam1
 */
public class IcsParser {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException   {
        Scanner in = new Scanner(System.in);
        String name ="";
        String course = "";
        String summary = "";
        System.out.println("Please put in ICS file's path");
        ArrayList<Assignment> assignments = new ArrayList<>();
        String filePath = in.nextLine();
        File file = new File(filePath);
        in = new Scanner(file);
        int date = 0;
        
        while(in.hasNext()) {
           
           String line = in.next();
           if(line.contains("DTSTART")) {
                if(line.contains("VALUE=DATE")) {
                    date = Integer.parseInt(  line.substring(line.indexOf("=DATE:") +6,line.length()));
                }
                else {
                    date = Integer.parseInt(  line.substring(8,line.length()-8));
                }     
           }
           
           if(line.contains("SUMMARY:")) {
              summary ="";
              while(!(line.contains("URL"))) {
                  summary += line;
                  line= in.next();
              }
            course = summary.substring(summary.indexOf("["));
            name = summary.substring(8,summary.indexOf("["));
            assignments.add(new Assignment(date, name, course));
            
           }
        }
        for(Assignment assignment: assignments) {
            System.out.println(assignment);
        }
    }

    
}
