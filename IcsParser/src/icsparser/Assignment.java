/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package icsparser;

import java.util.HashMap;

/**
 *
 * @author psam1
 */
public class Assignment implements Comparable{
    private int date;
    private String name;
    private String course;
    
    private HashMap<String,String>courses = new HashMap<String, String>();
    
    Assignment(int date, String name, String course) {
        this.date = date;
        this.name = name;
        courses.put("[202410-LTAM-1501-001-26608]", "LTAM-1501");
        courses.put("[202410-PHYS2101Leilabady-XLS2090202410_Combined]", "PHYS-2101");
        courses.put("[202410-WRDS1103-XLS2015202410_Combined]", "WRDS-1103");
        courses.put("[202410-MATH-1242-003-20525]", "MATH-1242");
        courses.put("[202410-COMM-3136-003-27202]", "COMM-3136");
        this.course = courses.get(course);

        
    }   
    public int getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }
    
    

    @Override
    public int compareTo(Object o) {
        if(this.getDate() < ((Assignment)o).getDate()) {
            return -1;
        }
        else if(this.getDate() > ((Assignment )o).getDate()) {
            return 1;
        }
        return 0;
    }
    @Override
    public String toString() {
        return (this.getCourse() + "," + this.getName() + "," + String.valueOf(this.getDate()).substring(0,4) + "/"+ String.valueOf(this.getDate()).substring(4,6) +"/" + String.valueOf(this.getDate()).substring(6,8));
    }
}
