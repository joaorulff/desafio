package br.uff.sti.sender;

import br.uff.sti.model.Student;

public class SMSSender implements Sender{

	@Override
	public void sendMessage(Student student) {
		
		System.out.println("A criação do seu e-mail "+student.getUffmail() + " será feita nos próximos minutos.\n"
				+ "Um SMS foi enviado para "+student.getTelephone()+" com a sua senha de acesso.");
		
	}
	
	
	

}
