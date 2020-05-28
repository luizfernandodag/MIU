package edu.mum.cs.cs425.demos.studentrecordsmgmtapp.LAB61;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Comparator;
import java.util.stream.Collectors;

import edu.mum.cs.cs425.demos.studentrecordsmgmtapp.LAB61.model.Student;
public class MyStudentRecordsMgmtApp {
	
	static List<Student> StudentArray = new ArrayList<Student>();
	
	//Student Array Functions
		//Add Student method 1
	public static void addStudent(Student student)
	{
		StudentArray.add(student);
	}
		//Add Stundent method 2
	public void addStudent(int studentID, String name, String date)
	{

		Student s = new Student(studentID,name,date);
		StudentArray.add(s);
	}
		//add Student method 3
	public void addStudent(int studentID, String name, int year, int month, int day)
	{
		LocalDate date = LocalDate.of(year, month, day);
		Student s = new Student(studentID,name,date);
		StudentArray.add(s);
	}
	//method to order array by name
	public static ArrayList<Student> getOrderedListStudents(List<Student> StudentList)
	{
		return (ArrayList<Student>) StudentList.stream()
				.sorted((s1,s2) -> s1.getName().compareTo(s2.getName()))
				.collect(Collectors.toList());
	}

	//order and print list of students
	public static void printListOfStudent(List<Student> StudentList)
	{			
		
		ArrayList<Student> orderedList = getOrderedListStudents(StudentList);
			
		for(Student s:orderedList)
		{
			System.out.print(s.toString());
			
		}
	}
	
	//get list of platinum students: Admission more than 30 years ago
	public static ArrayList<Student> getListOfPlatinumAlumniStudents(List<Student> listStudents)
	{
		
		return (ArrayList<Student>) listStudents.stream()
				.filter((Student s) -> LocalDate.now().compareTo(s.getDateOfAdmission())>= 30)
				.sorted((s1,s2) -> s1.getName().compareTo(s2.getName()))
				.collect(Collectors.toList());
	}
	
	
	static void printHello(List<Integer> listInt)
	{
		System.out.println(listInt.toString());
		for(Integer i: listInt)
		{
			
			if(i%5==0 && i%7!=0)
				System.out.println(i+": Hello");
			if(i%5!=0 && i%7==0)
				System.out.println(i+": World");
			else if(i%5==0 && i%7==0)
				System.out.println(i+": HelloWorld");


			
		}
		System.out.println();

	}
	
	static int findSecondBiggest(int[] listInt)
	{
		int max = listInt[0];
		int secondMax = listInt[0];
		int size = listInt.length;
		//int [] intsLIST = {2,5,3,67,23};
		System.out.println();

		for(int i = 0;i< size; ++i)
		{				
			System.out.println(i+": " + listInt[i]);

			if(max< listInt[i])
			{				
				secondMax = max;
				max = listInt[i];
				//System.out.println("MAX: " + max + " SECOND: " + secondMax);
			}
			else if( secondMax < listInt[i])
			{
				secondMax = listInt[i];
			}
		}
		return secondMax;
	}
	
	

	public static void main(String[] args) {
		
		//Create Students and add to array;
		
		addStudent(new Student(110001,"Dave","11/18/1951"));
	    addStudent(new Student(110002,"Anna","12/17/1990"));
		addStudent(new Student(110003,"Erica","11/18/1951"));
		addStudent(new Student(110004,"Carlos","08/22/2009"));
		addStudent(new Student(110003,"Bob","03/05/1990"));

		//ORIGINAL ARRAY
		System.out.println("***********************************************************************************");
		System.out.println("ORIGINAL LIST OF STUDENTS");
		System.out.println("***********************************************************************************");

		System.out.println(StudentArray.toString());
		//ORDERED ARRAY
		System.out.println("***********************************************************************************");

		System.out.println("ORDERED LIST OF STUDENTS");
		System.out.println("***********************************************************************************");

		printListOfStudent(StudentArray);
		System.out.println("***********************************************************************************");

		
		System.out.println("PLATINUM STUDENTS");
		System.out.println("***********************************************************************************");

		System.out.println(getListOfPlatinumAlumniStudents(StudentArray).toString());
		System.out.println("***********************************************************************************");
		
		Integer[] ints = {5,7,35,45};
		ArrayList<Integer> intList = new ArrayList<Integer>(Arrays.asList(ints));
		System.out.println("HELLO WORLD FUNCTION");
		printHello(intList);
		
		
		System.out.println("***********************************************************************************");
		System.out.println("SECOND BIGGEST");
		int [] intsLIST = {2,5,3,67,23};
		int second = findSecondBiggest(intsLIST);
		System.out.println("Second Biggest: " + second);
		System.out.println("***********************************************************************************");

		
		
		
		
		

	}

}
