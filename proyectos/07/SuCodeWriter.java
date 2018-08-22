import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import jdk.nashorn.internal.ir.CatchNode;

/**
 * Clase SuCodeWriter
 * Clase principal del programa , recibe el arhicvo .vm , instancia al SuParser 
 * y recupera de este los comandos para posteriormente traducirlos, y escribir un archivo
 * .asm 
 * @author David Benitez 
 */

class SuCodeWriter {
   static File archivo = null;
    static FileReader file = null;
    //static BufferedReader b = null;
    static String line;
    static FileWriter fichero = null;
    static PrintWriter pw = null;
    static String name;
    static int stack = 256;
    static int cont = 0;
    static SuParser p;
    static String outFile;
   public static void main(String [] args) {
        try {
         archivo = new File (args[0]);
         file = new FileReader (archivo);
           p = new SuParser(archivo);
           outFile = setNameFile(args[0]);
          fichero = new FileWriter(outFile);
          pw = new PrintWriter(fichero);
       
        while(true) {
            if(p.commandType() == 0) {
                System.out.println(outFile +  "Contiene una instruccion invalida ");
                return;
            }

            if(p.commandType() == SuParser.C_ARITHMETIC) {
                writeArithmetic(p.arg1());
            } else if(p.commandType() == SuParser.C_PUSH || p.commandType() == SuParser.C_POP) {
                writePushPop(p.commandType(), p.arg1(), p.arg2());
            }
            if(p.hasMoreCommands()) {
                p.advance();
            } else break;
        }
        pw.println("(END)");
        pw.println("@END");
        pw.println("0;JMP");
        pw.close();
           
       }
      catch(Exception e){
         e.printStackTrace();
      }finally{
         try{
            if( null != file ){
               file.close();
               fichero.close();
            }
         }catch (Exception e2){
            e2.printStackTrace();
         }
      }
   }
   /**
    * Metodo que permite encontrar el nombre del archivo .vm 
    * y crear a partir de ese nombre el archivo .asm
    */
   public static String setNameFile(String file){
    int stop = file.indexOf(".");
    String outFile = file.substring(0,stop) + ".asm";
    return outFile;
 }
   
    /**
     * Metodo que traduce e imprime las instrucciones aritmeticas 
     * @param comando un string con el comando aritmetico
     */
    public static  void writeArithmetic(String comando) throws Exception{
        
        if(comando.equals("add")){
           stack -= 2;
           if(stack <256){throw new Exception("Stack over flow");}
           stack++;
           //pw.println("//add");
           pw.println("@SP");
           pw.println("AM=M-1");
           pw.println("D=M");
           pw.println("@SP");
           pw.println("A=M-1");
           pw.println("M=M+D");
        }else if(comando.equals("sub")){
            stack -= 2;
            if(stack <256){throw new Exception("Stack over flow");}
            stack++;
            //pw.println("//sub");
            pw.println("@SP");
            pw.println("AM=M-1");
            pw.println("D=M");
            pw.println("@SP");
            pw.println("A=M-1");
            pw.println("M=M-D");
        }else if(comando.equals("neg")){
            stack -= 2;
            if(stack <256){throw new Exception("Stack over flow");}
            stack++;
            //pw.println("//neg");
            pw.println("@SP");
            pw.println("A=M-1");
            pw.println("M=-M");
        }else if(comando.equals("not")){
            stack -= 2;
            if(stack <256){throw new Exception("Stack over flow");}
            stack++;
            //pw.println("//not");
            pw.println("@SP");
            pw.println("A=M-1");
            pw.println("M=!M");
        }else if(comando.equals("and")){
            stack -= 2;
            if(stack <256){throw new Exception("Stack over flow");}
            stack++;
            //pw.println("//and");
            pw.println("@SP");
            pw.println("AM=M-1");
            pw.println("D=M");
            pw.println("@SP");
            pw.println("A=M-1");
            pw.println("M=M&D");
        }else if(comando.equals("or")){
            stack -= 2;
            if(stack <256){throw new Exception("Stack over flow");}
            stack++;
            //pw.println("//or");
            pw.println("@SP");
            pw.println("AM=M-1");
            pw.println("D=M");
            pw.println("@SP");
            pw.println("A=M-1");
            pw.println("M=M|D");
       }else if(comando.equals("eq")){
            stack -= 2;
            if(stack <256){throw new Exception("Stack over flow");}
            stack++;
            cont++;
            //pw.println("//eq");
            pw.println("@SP");
            pw.println("AM=M-1");
            pw.println("D=M");
            pw.println("@SP");
            pw.println("A=M-1");
            pw.println("D=M-D");
            pw.println("M=0");
            pw.println("@MFE" +(cont));
            pw.println("D;JNE");
            pw.println("@SP");
            pw.println("A=M-1");
            pw.println("M=-1");
            pw.println("(MFE" + (cont)+")");
       }else if(comando.equals("gt")){
            stack -= 2;
            if(stack <256){throw new Exception("Stack over flow");}
            stack++;
            cont++;
            //pw.println("//gt");
            pw.println("@SP");
            pw.println("AM=M-1");
            pw.println("D=M");
            pw.println("@SP");
            pw.println("A=M-1");
            pw.println("D=M-D");
            pw.println("M=0");
            pw.println("@MFG" +(cont));
            pw.println("D;JLE");
            pw.println("@SP");
            pw.println("A=M-1");
            pw.println("M=-1");
            pw.println("(MFG" + (cont)+")");
       }else if(comando.equals("lt")){
            stack -= 2;
            if(stack <256){throw new Exception("Stack over flow");}
            stack++;
            cont++;
            //pw.println("//lt");
            pw.println("@SP");
            pw.println("AM=M-1");
            pw.println("D=M");
            pw.println("@SP");
            pw.println("A=M-1");
            pw.println("D=M-D");
            pw.println("M=0");
            pw.println("@MFL" +(cont));
            pw.println("D;JGE");
            pw.println("@SP");
            pw.println("A=M-1");
            pw.println("M=-1");
            pw.println("(MFL" + (cont)+")");
         
      }
    }

    /**
     * Metodo para traducir e imprimir las instrucciones que comiencen 
     * con un push o un pop 
     * @param comando tipo de comando 
     * @param segmento 
     * @param index 
     */

    public static void writePushPop(int comando, String segmento, int index)throws Exception{
        if(comando == SuParser.C_PUSH){
            stack ++;
            if(stack > 2047){throw new Exception("Stack Over Flow Error");}
            if(segmento.equals("static") || Integer.toString(index) == ""){
                if(index >=0 && index <=239){
                    //pw.println("//PUSH STATIC");
                    pw.println("@"+(index + 16));
                    pw.println("D=M");
                    pw.println("@SP");
                    pw.println("M=M+1");
                    pw.println("A=M-1");
                    pw.println("M=D");
                }
            }else if(segmento.equals("constant")){
                    if(index >=-32768 && index <= 32767){
                        //pw.println("//PUSH CONSTANT");
                        pw.println("@"+(index));
                        pw.println("D=A");
                        pw.println("@SP");
                        pw.println("M=M+1");
                        pw.println("A=M-1");
                        pw.println("M=D");
                    }
            }else if(segmento.equals("local")){
                    if(index>=0 && index <= 16383){
                        //pw.println("//PUSH LOCAL");
                        pw.println("@"+(index));
                        pw.println("D=A");
                        pw.println("@LCL");
                        pw.println("A=M+D");
                        pw.println("D=M");
                        pw.println("@SP");
                        pw.println("M=M+1");
                        pw.println("A=M-1");
                        pw.println("M=D");
                    }
            }else if(segmento.equals("argument")){
                if(index>=0 && index <= 16383){
                    //pw.println("//PUSH ARGUMENT");
                    pw.println("@"+(index));
                    pw.println("D=A");
                    pw.println("@ARG");
                    pw.println("A=M+D");
                    pw.println("D=M");
                    pw.println("@SP");
                    pw.println("M=M+1");
                    pw.println("A=M-1");
                    pw.println("M=D");
                }

            }else if(segmento.equals("this")){
                if(index>=0 && index <= 16383){
                    //pw.println("//PUSH THIS");
                    pw.println("@"+(index));
                    pw.println("D=A");
                    pw.println("@THIS");
                    pw.println("A=M+D");
                    pw.println("D=M");
                    pw.println("@SP");
                    pw.println("M=M+1");
                    pw.println("A=M-1");
                    pw.println("M=D");
                }
            }else if(segmento.equals("that")){
                if(index>=0 && index <= 16383){
                    //pw.println("//PUSH THAT");
                    pw.println("@"+(index));
                    pw.println("D=A");
                    pw.println("@THAT");
                    pw.println("A=M+D");
                    pw.println("D=M");
                    pw.println("@SP");
                    pw.println("M=M+1");
                    pw.println("A=M-1");
                    pw.println("M=D");
                }
            }else if(segmento.equals("temp")){
                if(index>=0 && index<=7){
                    //pw.println("//PUSH TEMP");
                    pw.println("@"+(index + 5));
                    pw.println("D=M");
                    pw.println("@SP");
                    pw.println("M=M+1");
                    pw.println("A=M-1");
                    pw.println("M=D");
                }
            }else if(segmento.equals("pointer")){
                if(index == 0 || index == 1){
                    //pw.println("//PUSH POINTER");
                    pw.println("@"+(index + 3));
                    pw.println("D=M");
                    pw.println("@SP");
                    pw.println("M=M+1");
                    pw.println("A=M-1");
                    pw.println("M=D");
                }
            }else{throw new Exception("push Error");}  
                
            
        }else if (comando == SuParser.C_POP){
            stack --;
            if(stack < 256){throw new Exception("Stack over Flow Error");}
            if(segmento.equals("static")){
                if(index >= 0 && index <= 239){
                    pw.println("@SP");
                    pw.println("AM=M-1");
                    pw.println("D=M");
                    pw.println("@"+(index + 16));
                    pw.println("M=D");
                }
            }else if(segmento.equals("local")){
                if(index >= 0 && index <= 16383){
                    pw.println("@"+(index));
                    pw.println("D=A");
                    pw.println("@LCL");
                    pw.println("D=D+M");
                    pw.println("@SP");
                    pw.println("AM=M-1");
                    pw.println("D=M+D");
                    pw.println("A=D-M");
                    pw.println("D=D-A");
                    pw.println("M=D");
                }
            }else if(segmento.equals("argument")){
                if(index >= 0 && index <= 16383){
                    pw.println("@"+(index));
                    pw.println("D=A");
                    pw.println("@ARG");
                    pw.println("D=D+M");
                    pw.println("@SP");
                    pw.println("AM=M-1");
                    pw.println("D=M+D");
                    pw.println("A=D-M");
                    pw.println("D=D-A");
                    pw.println("M=D");
                }
            }else if(segmento.equals("this")){
                if(index >= 0 && index <= 16383){
                    pw.println("@"+(index));
                    pw.println("D=A");
                    pw.println("@THIS");
                    pw.println("D=D+M");
                    pw.println("@SP");
                    pw.println("AM=M-1");
                    pw.println("D=M+D");
                    pw.println("A=D-M");
                    pw.println("D=D-A");
                    pw.println("M=D");
                }
            }else if(segmento.equals("that")){
                if(index >= 0 && index <= 16383){
                    pw.println("@"+(index));
                    pw.println("D=A");
                    pw.println("@THAT");
                    pw.println("D=D+M");
                    pw.println("@SP");
                    pw.println("AM=M-1");
                    pw.println("D=M+D");
                    pw.println("A=D-M");
                    pw.println("D=D-A");
                    pw.println("M=D");
                }
            }else if(segmento.equals("temp")){
                if(index >=0 && index <=7){
                    pw.println("@SP");
                    pw.println("AM=M-1");
                    pw.println("D=M");
                    pw.println("@"+(index +5));
                    pw.println("M=D");
                }
            }else if(segmento.equals("pointer")){
                if(index == 0 || index ==1){
                    pw.println("@SP");
                    pw.println("AM=M-1");
                    pw.println("D=M");
                    pw.println("@" + (index + 3));
                    pw.println("M=D");
                }
            }
            else{throw new Exception("pop Error");}
            
        }
    }

    public void writeInit(){
        pw.println("@256");
        pw.println("D=A");
        pw.println("@SP");
        pw.println("M=D");
        WriteCall("Sys.init",0);
    }
    /**
     * Metodo inutil que sirve para hacer etiquetas 
     * hace lo mismo que pw.println("("+ etiqueta +")");
     */

    //public void writeLabel(String label){}

    public void writeGoto(String label){}

    public void WriteIf(String label){}

    public void WriteCall(String functionName,int numArgs){
    }

    public void writeReturn(){}

    public void writeFunction(String functionName, int numLocals ){}
}