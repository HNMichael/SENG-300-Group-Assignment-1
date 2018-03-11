package groupAssignment1;

import java.io.File;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;

public class Parser {
	
	public void Parse(char[] dir) {
		
		ASTParser parse = ASTParser.newParser(AST.JLS9);
		parse.setKind(ASTParser.K_COMPILATION_UNIT);
		parse.setSource(dir);
		
		CompilationUnit cu = (CompilationUnit)parse.createAST(null);
		
	}

}
