package groupAssignment1;

import java.util.HashSet;
import java.util.Set;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;

public class Parser {
	
	private static int a = 0;
	private static int b = 0;
	
	public void Parse(char[] dir, String type) {
		
		ASTParser parse = ASTParser.newParser(AST.JLS9);
		parse.setKind(ASTParser.K_COMPILATION_UNIT);
		parse.setSource(dir);
		
		parse.setResolveBindings(true);
		parse.setBindingsRecovery(true);
		
		CompilationUnit cu = (CompilationUnit)parse.createAST(null);
		
		ASTVisitor newVisitor = new ASTVisitor() {
			int countDeclarations = 0;
			int countReferences = 0;
			Set names = new HashSet();
			public boolean visit(VariableDeclarationFragment node) {
				//System.out.println(node.getParent().toString());
				String all = node.getParent().toString();

				SimpleName name = node.getName();
				//System.out.println(name);
				//this.names.add(name.getIdentifier());
				String findStr = type;
				int lastIndex = 0;

				while(lastIndex != -1){

				    lastIndex = all.indexOf(findStr,lastIndex);

				    if(lastIndex != -1){
				        countDeclarations ++;
				        a++;
				        this.names.add(name.getIdentifier());
				        System.out.println(names);
				        lastIndex += findStr.length();
				    }
				}
				
				return false;
			}
			
			public boolean visit(SimpleName node) {
				if(this.names.contains(node.getIdentifier())) {
					countReferences++;
					b++;
				}
				return true;
			}

		};
		
		cu.accept(newVisitor);
		System.out.println("Declarations: "+a);
		System.out.println("References: "+b);

	
	

	}
}