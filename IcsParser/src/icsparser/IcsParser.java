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
     */
    public static void main(String[] args) throws FileNotFoundException   {
        Scanner in = new Scanner(System.in);
        
        // TODO code application logic here
        System.out.println("Please put in ICS file's path");
        ArrayList<Assignment> assignments = new ArrayList<>();
        String filePath = in.nextLine();
        File file = new File(filePath);
        in = new Scanner(file);
        int date = 0;
        String name ="";
        String course = "";
        while(in.hasNext()) {
            name ="";
           // System.out.println(in.next());

           String line = in.next();
          // System.out.println(line);
         
           if(line.equals("BEGIN:VEVENT")) {
               
               date =Integer.parseInt( in.next().substring(8, 16));
             //  System.out.println(date);
             
               
           }
           String summary = "";
           if(line.contains("SUMMARY:")) {
               
              while(!(line.contains("URL"))) {
                  summary += line;
                  line= in.next();
              }
            course = summary.substring(summary.indexOf("["));
            name = summary.substring(8,summary.indexOf("["));
            
           
            assignments.add(new Assignment(date, name, course));
           }
        }
        for(Assignment ass: assignments) {
            System.out.println(ass);
        }
    }

    
}
