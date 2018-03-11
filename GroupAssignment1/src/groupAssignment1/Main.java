package groupAssignment1;

import java.io.File;
import java.util.Scanner;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;

public class Main {
	public static void main(String[] args) {
		
		InputSource source = new InputSource();
		Parser parse = new Parser();
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter directory name: ");
		String dir = input.nextLine();
		input.close();
		
		File[] s = source.getSource(dir);
		parse.getFile(s);
		
		
		
		
	}
}
