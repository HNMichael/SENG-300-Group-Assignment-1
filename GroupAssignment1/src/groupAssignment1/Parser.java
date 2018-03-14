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
			@SuppressWarnings("rawtypes")
			Set names = new HashSet();
			public boolean visit(VariableDeclarationFragment node) {
				String all = node.getParent().toString();
				SimpleName name = node.getName();
				this.names.add(name.getIdentifier());
				String findStr = type;
				int lastIndex = 0;

				while(lastIndex != -1){

				    lastIndex = all.indexOf(findStr,lastIndex);

				    if(lastIndex != -1){
				        a++;
				        
				        lastIndex += findStr.length();
				    }
				}
				
				if (node.toString().lastIndexOf("=") != -1) {
					for (int i = 0; i < names.toArray().length; i++) {
						String charc = (String) names.toArray()[i];
						if(node.toString().substring(node.toString().lastIndexOf("="), node.toString().length()).contains(charc)) {
							b++;
						}
					}

				}
				
				return false;
			}
	

		};
		
		cu.accept(newVisitor);
		System.out.println("<" + type + ">. Declarations: " + a + " References: " + b );
		
	
	

	}
}