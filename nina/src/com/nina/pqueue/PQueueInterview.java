package com.nina.pqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.util.*;

/*
 * Create the Student and Priorities classes here.
 */
class Student {
    int id;
    String name;
    double cgpa;
    
    public Student(int id, String name, double cgpa){
        this.id=id;
        this.name=name;
        this.cgpa=cgpa;
    }
    
    public int getID(){
        return id;
    }
    
    public String getName(){
        return name;
    }
    
    public double getCGPA(){
        return cgpa;
    }
}

class StudentCamparator implements Comparator<Student> {
    public int compare (Student s1, Student s2){
        if( s1.getCGPA()>s2.getCGPA())
            return -1;
        else if( s1.getCGPA()<s2.getCGPA())
            return 1;
        else{
            int c = s1.getName().compareTo(s2.getName());
            if(c!=0)
                return c;
            else {
                if( s1.getID()<s2.getID())
                    return -1;
                else if( s1.getID()>s2.getID())
                    return 1;
                else {
                    return 0;
                }
            }
        }
    }
}

class Priorities {
    private static String ENTER_TYPE="ENTER";
    private static String SERVED_TYPE="SERVED";
    
    public List<Student> getStudents(List<String> events){
        //ENTER Shafaet 3.7 35
        //SERVED
        PriorityQueue<Student> pQueue = 
                          new PriorityQueue<Student>(events.size(), new StudentCamparator());
    
        for(String event: events){
            String[] inputs = event.split(" ");
            if(ENTER_TYPE.equals(inputs[0]))
                pQueue.add(new Student(Integer.parseInt(inputs[3]), inputs[1], Double.parseDouble(inputs[2])));
            else if(SERVED_TYPE.equals(inputs[0])){
                pQueue.poll();
            }
        }
        List<Student> studentList = new ArrayList<Student>();
        
        
        int size=pQueue.size();
        while(size>0){
            studentList.add(pQueue.poll());
            size--;
        }
        return studentList;
    }
}

public class PQueueInterview {
	private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();
    
    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());    
        List<String> events = new ArrayList<>();
        
        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }
        
        List<Student> students = priorities.getStudents(events);
        
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}
