package testsomething;

import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.IVariableBinding;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.jdt.core.dom.VariableDeclarationStatement;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.IVariableBinding;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.jdt.core.dom.VariableDeclarationStatement;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.Set;
//import java.io.File;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.Set;
//
//import org.eclipse.jdt.core.dom.AST;
//import org.eclipse.jdt.core.dom.ASTParser;
//import org.eclipse.jdt.core.dom.ASTVisitor;
//import org.eclipse.jdt.core.dom.CompilationUnit;
//import org.eclipse.jdt.core.dom.ForStatement;
//import org.eclipse.jdt.core.dom.SimpleName;
//import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
//
//import org.eclipse.jdt.core.dom.CompilationUnit;
//import org.eclipse.jdt.core.dom.ForStatement;
//
//public class something {
//	
//	public static void main(String[] args) throws IOException {
//		String sourceStart = "public class A {";
//		String mid = "";
//		//String tempMiddle = mid;
//		//add a fake class A as a shell, to meet the requirement of ASTParser
//		for(String s : tempMiddle){	
//			s = s.trim();
//			if(s.trim().length()>0 && !s.startsWith("---") && !s.startsWith("/") && !s.startsWith("*") )
//			mid += s.trim() + "\n";
//		}
//		String sourceEnd = "}";
//		 
//		String source = sourceStart + mid + sourceEnd;
//		ASTParser parser = ASTParser.newParser(AST.JLS9);
//		parser.setSource(source.toCharArray());
//		parser.setKind(ASTParser.K_COMPILATION_UNIT);
//		final CompilationUnit cu = (CompilationUnit) parser.createAST(null);
//		
//		Set statements = new HashSet();
//		cu.accept(new ASTVisitor() {
//		        //by add more visit method like the following below, then all king of statement can be visited.
//			public boolean visit(ForStatement node) {
//		 
//				System.out.println("ForStatement -- content:" + node.toString());
//		 
//				ArrayList<Integer> al = new ArrayList<Integer>();
//				al.add(node.getStartPosition());
//				al.add(node.getLength());
//		 
//				statements.add(al);
//				return false;
//			}
//		 
//		      	/*
//			IfStatement
//			ForStatement
//			WhileStatement
//			DoStatement
//			TryStatement
//			SwitchStatement
//			SynchronizedStatement
//			*/
//		});
//	}
//}
// 
//
// 
//	public static void main(String[] args) {
//		String path ="C:\\Users\\pc\\workspace\\asttester\\src\\test\\Apple.java";
//		File file = new File(path);
//		String str = Util.readFileToString(file);
// 
//		ASTParser parser = ASTParser.newParser(AST.JLS8);
//		parser.setResolveBindings(true);
//		parser.setKind(ASTParser.K_COMPILATION_UNIT);
// 
//		parser.setBindingsRecovery(true);
// 
//		Map options = JavaCore.getOptions();
//		parser.setCompilerOptions(options);
// 
//		String unitName = "Apple.java";
//		parser.setUnitName(unitName);
// 
//		String[] sources = { "C:\\Users\\pc\\workspace\\asttester\\src" }; 
//		String[] classpath = {"C:\\Program Files\\Java\\jre1.8.0_25\\lib\\rt.jar"};
// 
//		parser.setEnvironment(classpath, sources, new String[] { "UTF-8"}, true);
//		parser.setSource(str.toCharArray());
// 
//		CompilationUnit cu = (CompilationUnit) parser.createAST(null);
// 
//		if (cu.getAST().hasBindingsRecovery()) {
//			System.out.println("Binding activated.");
//		}
// 
//		TypeFinderVisitor v = new TypeFinderVisitor();
//		cu.accept(v);		
//	}
//}
// 
//class TypeFinderVisitor extends ASTVisitor{
// 
//	public boolean visit(VariableDeclarationStatement node){
//		for (Iterator iter = node.fragments().iterator(); iter.hasNext();) {
//			System.out.println("------------------");
// 
//			VariableDeclarationFragment fragment = (VariableDeclarationFragment) iter.next();
//			IVariableBinding binding = fragment.resolveBinding();
// 
//			System.out.println("binding variable declaration: " +binding.getVariableDeclaration());
//			System.out.println("binding: " +binding);
//		}
//		return true;
//	}
//}
//	
//
//
//
//	    public static void main(String[] args) {
//
//	        String str = "package sources;\r\n" + 
//	        		"\r\n" + 
//	        		"public class Source {\r\n" + 
//	        		"	String a = \"Hello\"; \r\n" + 
//	        		"	String b = \"World\";\r\n" + 
//	        		"	int e = 1;\r\n" + 
//	        		"	int f = 2;\r\n" + 
//	        		"	char adfasdf;\r\n" + 
//	        		"	char adkljfj;\r\n" + 
//	        		"	float lasjfsaljf;\r\n" + 
//	        		"	enum Quack{a, e};\r\n" + 
//	        		"	double g = 3.1;\r\n" + 
//	        		"	double h = 1.9;\r\n" + 
//	        		"	\r\n" + 
//	        		"	int d = e + f;\r\n" + 
//	        		"	String c = a + b;\r\n" + 
//	        		"	double i = g + h;\r\n" + 
//	        		"	\r\n" + 
//	        		"	public void stringtype() {\r\n" + 
//	        		"		String ab; \r\n" + 
//	        		"	}\r\n" + 
//	        		"	\r\n" + 
//	        		"	public void strint(String i) {\r\n" + 
//	        		"		String ad;\r\n" + 
//	        		"		int aa;\r\n" + 
//	        		"		\r\n" + 
//	        		"	}\r\n" + 
//	        		"\r\n" + 
//	        		"}";
//	        ASTParser parser = ASTParser.newParser(AST.JLS9);
//	        parser.setSource(str.toCharArray());
//	        parser.setKind(ASTParser.K_COMPILATION_UNIT);
//	        parser.setResolveBindings(true);
//	        CompilationUnit cu = (CompilationUnit) parser.createAST(null);
//
//
//	        TypeFinderVisitor v = new TypeFinderVisitor();
//	        cu.accept(v);       
//	    }
//	}
//
//	class TypeFinderVisitor extends ASTVisitor{
//
//	    public boolean visit(VariableDeclarationStatement node){
//	        System.out.println(node.getType()); //iii
//	        for (Iterator iter = node.fragments().iterator(); iter.hasNext();) {
//	            VariableDeclarationFragment fragment = (VariableDeclarationFragment) iter.next();
//
//	            System.out.println(fragment.getName());
//
//	            IVariableBinding binding = fragment.resolveBinding();
//
//	            System.out.println("binding: " +binding);
//	        }
//	        return true;
//
//	    }
//	}
	
//	Set name = new HashSet();
	 
//	public boolean visit(VariableDeclarationFragment node) {
//		SimpleName name = node.getName();
//		
//		//System.out.println(nodes.getType());
//		//System.out.println(name.getIdentifier());
//		//this.name.add(name.getIdentifier());
//		//System.out.println("Declaration of '"+name+"' at line"+cu.getLineNumber(name.getStartPosition()));
//		return false; // do not continue to avoid usage info
//		
//	}
//
////	public boolean visit(SimpleName node) {
////		if (this.names.contains(node.getIdentifier())) {
////		System.out.println("Usage of '" + node + "' at line " +	cu.getLineNumber(node.getStartPosition()));
////		}
////		return true;
////	}
//////	
//	 public boolean visit(VariableDeclarationStatement node){
//		  System.out.println(node.getType());
//	       for (Iterator iter = node.fragments().iterator(); iter.hasNext();) {
//	           VariableDeclarationFragment fragment = (VariableDeclarationFragment) iter.next();
//	            System.out.println(fragment.getName());
//	            IVariableBinding binding = fragment.resolveBinding();
//	            System.out.println("binding: " +binding);
//			
//
//	       }
//	       return false;
//	}
//
