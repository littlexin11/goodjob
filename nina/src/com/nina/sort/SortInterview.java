package com.nina.sort;

import java.util.*;

class Student{
	private int id;
	private String fname;
	private double cgpa;
	public Student(int id, String fname, double cgpa) {
		super();
		this.id = id;
		this.fname = fname;
		this.cgpa = cgpa;
	}
	public int getId() {
		return id;
	}
	public String getFname() {
		return fname;
	}
	public double getCgpa() {
		return cgpa;
	}
    
    
}

//Complete the code
public class SortInterview 
{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		
		List<Student> studentList = new ArrayList<Student>();
		while(testCases>0){
			int id = in.nextInt();
			String fname = in.next();
			double cgpa = in.nextDouble();
			
			Student st = new Student(id, fname, cgpa);
			studentList.add(st);
			
			testCases--;
		}
      
        Collections.sort(studentList, new Comparator<Student>(){
            public int compare(Student st1, Student st2){
                if(st1.getCgpa()>st2.getCgpa()){
                    return -1;
                }else if(st1.getCgpa()<st2.getCgpa()){
                    return 1;
                }else{
                    int nameCompare = st1.getFname().compareTo(st2.getFname());
                    if(nameCompare!=0)
                        return nameCompare;
                    else{
                        if(st1.getId()<st2.getId())
                            return 1;
                        else if(st1.getId()> st2.getId())
                            return -1;
                        else return 0;
                    }
                }
            }
        });
      	for(Student st: studentList){
			System.out.println(st.getFname());
		}
	}
}



