package br.uff.sti.DAO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVParser;
import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;

import br.uff.sti.model.Student;
import br.uff.sti.utils.Paths;

public class Loader {
	
	@SuppressWarnings({"rawtypes", "unchecked"})
	public static void loadData(){
		
		try{
			
			CsvToBean csvToBean = new CsvToBean<>();
			CSVReader csvReader = new CSVReader(new FileReader(Paths.csvPath), CSVParser.DEFAULT_SEPARATOR, CSVParser.DEFAULT_QUOTE_CHARACTER, 1);
			
			List list = csvToBean.parse(setMapping(), csvReader);
			
			for(Object object: list){
				Student student = (Student) object;
				Data.addStudent(student);
			}
			
			
			csvReader.close();
			
		}catch(FileNotFoundException exceptionFileNotFound){
			System.out.println("Please, confirm if the csv path is ok");
			exceptionFileNotFound.printStackTrace();
		}catch(IOException exceptionIO){
			System.out.println("Please, check you csv file");
			exceptionIO.printStackTrace();
		}
	}
	
	@SuppressWarnings({"rawtypes", "unchecked"})
	
	private static ColumnPositionMappingStrategy setMapping(){
		ColumnPositionMappingStrategy mappingStrategy = new ColumnPositionMappingStrategy();
		mappingStrategy.setType(Student.class);
		String [] columns = new String[] {"name", "idNumber", "telephone", "email", "uffMail", "status"};
		mappingStrategy.setColumnMapping(columns);
		return mappingStrategy;
	}
}
