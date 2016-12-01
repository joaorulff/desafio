package br.sti.uff.nameGenerator;

import br.sti.uff.model.Student;

public class UsernameGenerator {
	
	
	private static String genAlgorithm1(Student student){
	//The first algorithm takes the first and the second names and separates it using underline
	//Exmaple: firstName_SecondName@id.uff.br
		
		String [] names = NameHandler.getNames(student.getName());
		String firstName = null, secondName = null;
		
		try{
			
			firstName = names[0].toLowerCase();
			secondName = names[1].toLowerCase();
			
		}catch(ArrayIndexOutOfBoundsException exception){
			
			return NameHandler.removeSpaces(student.getName()).toLowerCase()  + "@id.uff.br";
			
		}
		
		
		return firstName+"_"+secondName+"@id.uff.br";
		
		
	}
	
	private static String genAlgorithm2(Student student){
	//The second algorithm takes the first name and the initials of the other names
	//Example: firstName[initalLetterSecondName][initialLetterThirdName]@id.uff.br
		
		String [] names = NameHandler.getNames(student.getName());
		String firstName = null, secondName = null, thirdName = null;
		
		try{
			
			firstName = names[0].toLowerCase();
			secondName = names[1].toLowerCase();
			thirdName = names[2].toLowerCase();
			
		}catch(ArrayIndexOutOfBoundsException exception){
			
			return NameHandler.removeSpaces(student.getName()).toLowerCase()  + "@id.uff.br";
		}
		
		return firstName+secondName.charAt(0)+thirdName.charAt(0)+"@id.uff.br";
		
	}
	
	private static String genAlgorithm3(Student student){
	//The third algorithm takes the first and third names and separates it by underline
	//Exmaple: firstName_thirdName@id.uff.br
		
		String [] names = NameHandler.getNames(student.getName());
		String firstName = null, thirdName = null;
		
		try{
			
			firstName = names[0].toLowerCase();
			thirdName = names[2].toLowerCase();
			
		}catch(ArrayIndexOutOfBoundsException exception){
			
			return NameHandler.removeSpaces(student.getName()).toLowerCase() + "@id.uff.br";
			
		}
		
		return firstName+thirdName+"@id.uff.br";
		
		
	}
	
	private static String genAlgorithm4(Student student){
		
		String [] names = NameHandler.getNames(student.getName());
		String firstName = null, thirdName = null;
		
		try{
			
			firstName = names[0].toLowerCase();
			thirdName = names[2].toLowerCase();
			
		}catch(ArrayIndexOutOfBoundsException exception){
			
			return NameHandler.removeSpaces(student.getName()).toLowerCase() + "@id.uff.br";
			
		}
		
		return firstName.charAt(0)+thirdName+"@id.uff.br";
		
	}
	
	private static String genAlgorithm5(Student student){
		
		String [] names = NameHandler.getNames(student.getName());
		String firstName = null, secondName = null, thirdName = null;
		
		try{
			
			firstName = names[0].toLowerCase();
			secondName = names[1].toLowerCase();
			thirdName = names[2].toLowerCase();
			
		}catch(ArrayIndexOutOfBoundsException exception){
			
			return NameHandler.removeSpaces(student.getName()).toLowerCase() + "@id.uff.br";
		}
		
		return firstName.charAt(0)+secondName+thirdName+"@id.uff.com";
	}
	
	public static String [] getPossibleUsernames(Student student){
		
		String [] possibleUsernames = new String[5];
		possibleUsernames[0] = genAlgorithm1(student);
		possibleUsernames[1] = genAlgorithm2(student);
		possibleUsernames[2] = genAlgorithm3(student);
		possibleUsernames[3] = genAlgorithm4(student);
		possibleUsernames[4] = genAlgorithm5(student);
		
		return possibleUsernames;
		
	}

}
