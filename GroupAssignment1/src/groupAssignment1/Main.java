package groupAssignment1;
//\\samba.cs.ucalgary.ca\huynm\Documents\SENG\ProjectInteration1\source\SourceCode\src\sources

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;

public class Main extends IOException {
	

	
	public static void main(String[] args) throws IOException {
		String source;
		String dir;
		String type;
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter Directory of interest: ");
		dir = input.nextLine();
		System.out.print("Enter qualified type: ");
		type = input.nextLine();
		input.close();
		
		Parser parse = new Parser();
		File directory = new File(dir);
		File[] listOfFiles = directory.listFiles();
		for(int i = 0; i < listOfFiles.length; i++) {
			File file = listOfFiles[i];
			if (file.isFile() && file.getName().endsWith( ".java")) {
				System.out.println(file.getName());
				source = readFileToString(file.getAbsolutePath());
				System.out.println(source);
				parse.Parse(source.toCharArray(), type);
			}
		}
		
	}
	
	// translate file source code into a string
	public static String readFileToString(String filePath) throws IOException {
		StringBuilder fileData = new StringBuilder(1000); 						// creates a new string builder of capacity 1000 for the data in the file
		BufferedReader reader = new BufferedReader(new FileReader(filePath)); // buffered reader reads text from the file reader. file reader reads the stream of characters from the file
		 
		char[] buffer = new char[10]; // create a new buffer of 10 characters
		int characters_read = 0;
		// while it is not the end of the file
		while ((characters_read = reader.read(buffer)) != -1) {
			//System.out.println(characters_read);
			String readData = String.valueOf(buffer, 0, characters_read); // save the data read into a string
			fileData.append(readData); // append the readData into the total fileData
			buffer = new char[1024]; // create a new buffer of more characters
		}
		 
		reader.close(); // close the reader
		 
		return  fileData.toString(); // return the fileData as a string
	}
}
