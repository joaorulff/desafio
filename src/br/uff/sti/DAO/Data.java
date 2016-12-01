package br.uff.sti.DAO;

import java.util.HashMap;

import br.uff.sti.model.Student;

public class Data {
	
	private static HashMap<Integer, Student> hashMap = new HashMap<>();
	
	
	public static void addStudent(Student student){
		
		hashMap.put(student.getIdNumber(), student);
		
	}
	
	public static Student getStudent(int idNumber){
		
		return hashMap.get(idNumber);
		
	}
	

}
