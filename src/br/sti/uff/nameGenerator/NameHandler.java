package br.sti.uff.nameGenerator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameHandler {
	
	
	public static String[] getNames(String name){
		
		String [] names = name.split(" ");
		return names;
	}
	
	public static String removeSpaces(String name){
		return name.replaceAll("\\s", "");
	}
	

}
