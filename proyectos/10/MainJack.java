import java.io.*;
import java.util.*;
import java.lang.*;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;
//import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
class MainJack{
	public static FileWriter outM;
	public static FileWriter outTM;
	public static PrintWriter pw;
	public static PrintWriter pwT;

    public  static void main(String[] args){
        try{
            if (args.length != 1) {
            	System.err.println("Error: Argumentos invalidos");
                System.exit(0);
            }
            ANTLRFileStream afs = null;
            try {
        		afs = new ANTLRFileStream(args[0]);
		    }catch (IOException ioe) {
                System.err.println("Error: " + ioe);
                System.exit(0);
            }
			JACKLexer lexer = new JACKLexer(afs);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			JACKParser parser = new JACKParser(tokens);
			ParseTree tree = parser.classes();
			ParseTreeWalker walker = new ParseTreeWalker();
			JACKBaseListener listener=new JACKBaseListener();
			// walker.walk( listener, tree);
			try{
				//Se crean los archivos de salida y se escribe en ellos lo que nos retorna el listener
				String outFile = args[0].split(".jack")[0];
				String M = outFile + "M.xml";
				String TM = outFile + "TM.xml";
                outM = new FileWriter(M);
                outTM = new FileWriter(TM);
                pw = new PrintWriter(outM);
                pwT = new PrintWriter(outTM);
                //Clase traida de antler, se recorre el arbol generado
                walker.walk( listener, tree);
				//Se cierran los archivos y los escritores de archivo
				pw.close(); 
            	outM.close();
				outTM.close();
				pwT.close();
			}catch(IOException e){
				System.out.println("Error");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}