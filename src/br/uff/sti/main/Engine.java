package br.uff.sti.main;

import java.util.Scanner;

import br.uff.sti.DAO.Data;
import br.uff.sti.DAO.Loader;
import br.uff.sti.model.Student;
import br.uff.sti.nameGenerator.UsernameGenerator;
import br.uff.sti.sender.SMSSender;
import br.uff.sti.sender.Sender;

public class Engine {
	
	private static Scanner in = new Scanner(System.in);
	
	
	static{
		
		Loader.loadData();
	}
	
	
	public static void start(){
		
		System.out.println("Digite a sua matrícula: ");
		Student currentStudent = Data.getStudent(in.nextInt());
		if(currentStudent == null){
			
			System.out.println("Matricula inexistente");
			return;
			
		}
		
		if(currentStudent.getStatus().equals("Inativo")){
			System.out.println("Aluno Inativo");
		}else if(!currentStudent.getUffmail().equals("")){
			System.out.println("Aluno já possui cadastro no UFFMail");
		}else{
			Sender sender = new SMSSender();
			sender.sendMessage(setEmail(currentStudent));
		}	
	}
	
	private static Student setEmail(Student student){
		
		String [] usernames = UsernameGenerator.getPossibleUsernames(student);
		
		for (int i = 0; i < usernames.length; i++) {
			System.out.println((i+1)+" - " + usernames[i]);
		}
		
		int chosenMail = in.nextInt();
		student.setUffmail(usernames[chosenMail-1]);
		
		return student;
		
	}

}
