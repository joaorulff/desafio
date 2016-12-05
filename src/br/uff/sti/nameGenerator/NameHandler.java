package br.uff.sti.nameGenerator;


public class NameHandler {
	
	
	public static String[] getNames(String name){
		
		String [] names = name.split(" ");
		return names;
	}
	
	public static String removeSpaces(String name){
		return name.replaceAll("\\s", "");
	}
	

}
