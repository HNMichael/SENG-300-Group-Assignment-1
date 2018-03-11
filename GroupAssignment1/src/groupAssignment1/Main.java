package groupAssignment1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;

public class Main extends IOException {
	
	private static String dir;
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Directory of interest: ");
		dir = input.nextLine();
		input.close();
		
		Parser parse = new Parser();
		File source = new File(dir);
		
		//change file source to file reader and story source as string[]
		//while reading through each line check for java types and ad them to a counter maybe?
		//then set source to be parsed?
		
		source.toString();
		
	
	
	}
}
