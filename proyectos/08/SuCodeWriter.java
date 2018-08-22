import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


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
    static String line;
    static FileWriter fichero = null;
    static PrintWriter pw = null;
    static String name;
    static int cont = 0;
    static SuParser p;
    static String outFile;
    static boolean flag = false;
    static String fileName;
   public static void main(String [] args) {

    try{
        archivo = new File (args[0]);
        if (archivo.isFile()){
            outFile = setNameFile(archivo);
            fichero = new FileWriter(outFile);
            pw = new PrintWriter(fichero);
            writeInit();
            writeFile(archivo);
            endoru();
        }else if(archivo.isDirectory()){
            String m = archivo.getName();
            String ruta = args[0].lastIndexOf("/")==args[0].length()-1 ? args[0] : args[0]+"/";
            fichero = new FileWriter(ruta + m + ".asm");
            pw = new PrintWriter(fichero);
            File arrFiles[] = archivo.listFiles();
            for(int i = 0;i<arrFiles.length;i++){
                if(arrFiles[i].getName().contains("Sys.vm")){
                    flag=true;
                    break;
                }
            }
            if(flag){
                writeInit();
                for(int i = 0; i < arrFiles.length; i++){
                    if(arrFiles[i].getName().contains(".vm")){
                        fileName = arrFiles[i].getName();
                        fileName = fileName.substring(0,fileName.indexOf('.'));
                        writeFile(arrFiles[i]);
                    }
                }
            }else{
                System.out.println("archivo Sys.vm no encontrado");
            }

        }
        

        
        endoru();
        pw.close(); 
        fichero.close();
       }catch(Exception e){     
            e.printStackTrace();
       }
       
    }
   
   /**
    * Metodo que permite encontrar el nombre del archivo .vm 
    * y crear a partir de ese nombre el archivo .asm
    */
   public static String setNameFile(File file){
    String name = file.getName();
    int stop = name.indexOf(".");
    String outFile = name.substring(0,stop) + ".asm";
    return outFile;
    }

    public static void writeFile(File filele){
        try {
            
            file = new FileReader (filele);
            p = new SuParser(filele);
            if (archivo.isFile()) {
             outFile = setNameFile(filele);
             fichero = new FileWriter(outFile); 
             pw = new PrintWriter(fichero);
            }

            
           
            while(true) {
                if(p.commandType() == -1) {
                    System.out.println(outFile +  "Contiene una instruccion invalida ");
                    return;
                }

                if(p.commandType() == SuParser.C_ARITHMETIC) {
                    writeArithmetic(p.arg1());
                } else if(p.commandType() == SuParser.C_PUSH || p.commandType() == SuParser.C_POP) {
                    writePushPop(p.commandType(), p.arg1(), p.arg2());
                } else if(p.commandType() == SuParser.C_GOTO){
                    writeGoto(p.arg1());
                }else if(p.commandType() == SuParser.C_IF){
                    writeIf(p.arg1());
                }else if(p.commandType() == SuParser.C_FUNCTION){
                    writeFunction(p.arg1(),p.arg2());
                }else if(p.commandType() == SuParser.C_CALL){
                    writeCall(p.arg1(),p.arg2());
                }else if(p.commandType() == SuParser.C_LABEL){
                    writeLabel(p.arg1());
                }else if(p.commandType() == SuParser.C_RETURN){
                    writeReturn();
                }
                if(p.hasMoreCommands()) {
                    p.advance();
                } else break;
            }
            

               
           }catch(Exception e){
             e.printStackTrace();
          }finally{
             try{
                if( null != file ){
                   file.close();

                }
             }catch (Exception e2){
                e2.printStackTrace();
             }
          }

    }
   
    /**
     * Metodo que traduce e imprime las instrucciones aritmeticas 
     * @param comando un string con el comando aritmetico
     */
    public static  void writeArithmetic(String comando) throws Exception{
        
        if(comando.equals("add")){
           pw.println("@SP");
           pw.println("AM=M-1");
           pw.println("D=M");
           pw.println("@SP");
           pw.println("A=M-1");
           pw.println("M=M+D");
        }else if(comando.equals("sub")){
            pw.println("@SP");
            pw.println("AM=M-1");
            pw.println("D=M");
            pw.println("@SP");
            pw.println("A=M-1");
            pw.println("M=M-D");
        }else if(comando.equals("neg")){
            pw.println("@SP");
            pw.println("A=M-1");
            pw.println("M=-M");
        }else if(comando.equals("not")){
            pw.println("@SP");
            pw.println("A=M-1");
            pw.println("M=!M");
        }else if(comando.equals("and")){
            pw.println("@SP");
            pw.println("AM=M-1");
            pw.println("D=M");
            pw.println("@SP");
            pw.println("A=M-1");
            pw.println("M=M&D");
        }else if(comando.equals("or")){
            pw.println("@SP");
            pw.println("AM=M-1");
            pw.println("D=M");
            pw.println("@SP");
            pw.println("A=M-1");
            pw.println("M=M|D");
       }else if(comando.equals("eq")){
            cont++;
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
            cont++;
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
            cont++;
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
            
            if(segmento.equals("static") || Integer.toString(index) == ""){
                if(flag){
                    pw.println("@"+ fileName + "." + index);
                    pw.println("D=M");
                    pw.println("@SP");
                    pw.println("M=M+1");
                    pw.println("A=M-1");
                    pw.println("M=D");
                }else{
                if(index >=0 && index <=239){
                    pw.println("@"+(index + 16));
                    pw.println("D=M");
                    pw.println("@SP");
                    pw.println("M=M+1");
                    pw.println("A=M-1");
                    pw.println("M=D");
                }
            }
            }else if(segmento.equals("constant")){
                    if(index >=-32768 && index <= 32767){
                        pw.println("@"+(index));
                        pw.println("D=A");
                        pw.println("@SP");
                        pw.println("M=M+1");
                        pw.println("A=M-1");
                        pw.println("M=D");
                    }
            }else if(segmento.equals("local")){
                    if(index>=0 && index <= 16383){
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
                    pw.println("@"+(index + 5));
                    pw.println("D=M");
                    pw.println("@SP");
                    pw.println("M=M+1");
                    pw.println("A=M-1");
                    pw.println("M=D");
                }
            }else if(segmento.equals("pointer")){
                if(index == 0 || index == 1){
                    pw.println("@"+(index + 3));
                    pw.println("D=M");
                    pw.println("@SP");
                    pw.println("M=M+1");
                    pw.println("A=M-1");
                    pw.println("M=D");
                }
            }else{throw new Exception("push Error");}  
                
            
        }else if (comando == SuParser.C_POP){
            if(segmento.equals("static")){
                if(index >= 0 && index <= 239){
                    pw.println("@SP");
                    pw.println("AM=M-1");
                    pw.println("D=M");
                    if(flag){
                        pw.println("@" + fileName + "." + index);
                    }else{
                    pw.println("@"+(index + 16));
                    }
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

    public static void writeInit(){
        pw.println("@256");
        pw.println("D=A");
        pw.println("@SP");
        pw.println("M=D");
        writeCall("Sys.init",0);
    }


    public static void writeLabel(String label){
        pw.println("("+ label + ")");
    }

    public static void writeGoto(String label){
        pw.println("@" +label);
        pw.println("0;JMP");
    }

    public static void writeIf(String label){
        pw.println("@SP");
        pw.println("AM=M-1");
        pw.println("D=M");
        pw.println("@"+ label);
        pw.println("D;JNE");

    }

    public static void writeCall(String functionName,int numArgs){
        cont++;
     pw.println("@return-address"+ cont);
     pw.println("D=A");
     pw.println("@SP");
     pw.println("M=M+1");
     pw.println("A=M-1");
     pw.println("M=D");
     pw.println("@LCL");
     pw.println("D=M");
     pw.println("@SP");
     pw.println("M=M+1");
     pw.println("A=M-1");
     pw.println("M=D");
     pw.println("@ARG");
     pw.println("D=M");
     pw.println("@SP");
     pw.println("M=M+1");
     pw.println("A=M-1");
     pw.println("M=D");
     pw.println("@THIS");
     pw.println("D=M");
     pw.println("@SP");
     pw.println("M=M+1");
     pw.println("A=M-1");
     pw.println("M=D");
     pw.println("@THAT");
     pw.println("D=M");
     pw.println("@SP");
     pw.println("M=M+1");
     pw.println("A=M-1");
     pw.println("M=D");
     pw.println("@" + numArgs);
     pw.println("D=A");
     pw.println("@5");
     pw.println("D=D+A");
     pw.println("@SP");
     pw.println("D=M-D");
     pw.println("@ARG");
     pw.println("M=D");
     pw.println("@SP");
     pw.println("D=M");
     pw.println("@LCL");
     pw.println("M=D");
     pw.println("@" + functionName);
     pw.println("0;JMP");
     pw.println("(return-address"+cont+")");
    }

    public static  void writeReturn(){
        pw.println("@LCL");
        pw.println("D=M");
        pw.println("@13");
        pw.println("M=D");
        pw.println("@5");
        pw.println("D=A");
        pw.println("@13");
        pw.println("A=M-D");
        pw.println("D=M");
        pw.println("@14");
        pw.println("M=D");
        pw.println("@SP");
        pw.println("AM=M-1");
        pw.println("D=M");
        pw.println("@ARG");
        pw.println("A=M");
        pw.println("M=D");
        pw.println("@ARG");
        pw.println("D=M+1");
        pw.println("@SP");
        pw.println("M=D");
        pw.println("@13");
        pw.println("A=M-1");
        pw.println("D=M");
        pw.println("@THAT");
        pw.println("M=D");
        pw.println("@2");
        pw.println("D=A");
        pw.println("@13");
        pw.println("A=M-D");
        pw.println("D=M");
        pw.println("@THIS");
        pw.println("M=D");
        pw.println("@3");
        pw.println("D=A");
        pw.println("@13");
        pw.println("A=M-D");
        pw.println("D=M");
        pw.println("@ARG");
        pw.println("M=D");
        pw.println("@4");
        pw.println("D=A");
        pw.println("@13");
        pw.println("A=M-D");
        pw.println("D=M");
        pw.println("@LCL");
        pw.println("M=D");
        pw.println("@14");
        pw.println("A=M");
        pw.println("0;JMP");
    }

    public static void writeFunction(String functionName, int numLocals ){
        cont++;
        pw.println("("+ functionName + ")");
        pw.println("@"+ numLocals);
        pw.println("D=A");
        pw.println("@WALLOP"+cont);
        pw.println("D;JEQ");
        pw.println("("+"NOEQUAL"+cont+")");
        pw.println("@SP");
        pw.println("M=M+1");
        pw.println("A=M-1");
        pw.println("M=0");
        pw.println("D=D-1");
        pw.println("@NOEQUAL" + cont);
        pw.println("D;JNE");
        pw.println("("+"WALLOP" + cont + ")");
    }

    public static void endoru(){
        pw.println("(END)");
        pw.println("@END");
        pw.println("0;JMP");

    }

    
}