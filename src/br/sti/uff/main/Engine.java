package br.sti.uff.main;

import java.util.Scanner;
import br.sti.uff.model.Student;
import br.sti.uff.nameGenerator.UsernameGenerator;
import br.sti.uff.sender.SMSSender;
import br.sti.uff.sender.Sender;
import br.uff.sti.DAO.Data;
import br.uff.sti.DAO.Loader;

public class Engine {
	
	private static Scanner in = new Scanner(System.in);
	
	static{
		
		Loader.loadData();
	}
	
	
	public static void start(){
		
		System.out.println("Digite a sua matrícula: ");
		Student currentStudent = Data.getStudent(in.nextInt());
		
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
