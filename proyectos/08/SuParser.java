import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Clase SuParser
 * Maneja el parsing de un solo archivo .vm y encapsula el acceso al codigo de entrada
 * Lee los comandos VM , los "parsea" y provee un conveniente acceso a sus componentes 
 * Tambien elimina los espacios en blanco y los comentarios que se puedan presentar 
 * @author David Benitez 
 */
public class SuParser {

  public int lineaAct;
  private String[] comandoAct;
  private ArrayList<String> comandos = new ArrayList<String>();
  public static final int C_ARITHMETIC = 1;
  public static final int C_PUSH = 2;
  public static final int C_POP = 3;
  public static final int C_LABEL = 4;
  public static final int C_GOTO = 5;
  public static final int C_IF = 6;
  public static final int C_RETURN = 7;
  public static final int C_CALL = 8;
  public static final int C_FUNCTION = 9;
  public ArrayList<String> arithmetic;

  /**
   * constructor de la clase parser, recibe el archivo y lo limpia de comentarios 
   * y espacios en blanco 
   * recibe un archivo 
   * @param input
   */

  public SuParser(File input) throws FileNotFoundException,Exception{

    try {

      dust(input);
      aritmetica();
      lineaAct = 0;
      if(!comandos.isEmpty()){
        comandoAct = comandos.get(lineaAct).split("\\s");
      }else{
        throw new Exception("instrucciones no validas");
      }
      

    

    }catch(FileNotFoundException fnf){
      throw new FileNotFoundException(fnf.getMessage());
    }
}


  /**
   * Metodo que garantiza el avance de lineas de comando 
   * retorna true si hay mas comandos disponibles para analizar 
   * @return true si hay mas comandos para analizar
   */

   public Boolean hasMoreCommands(){
    return(lineaAct < comandos.size() - 1);
  
  
   }

   /**
    * metodo que permite el avance de lineas de comando 
    */
   public void advance (){
      lineaAct++;
      comandoAct = comandos.get(lineaAct).split("\\s");
    }

    /**
     * Metodo que retorna el tipo de comando VM actual 
     * para todos los comandos aritmeticos se retorna el C_ARITHMETIC
     * @return C_ARITHMETIC, C_PUSH, C_POP
     */
  public int commandType(){
    String type = comandoAct[0];
    if(arithmetic.contains(type)){
      return C_ARITHMETIC;
    }
    if(type.equals("push")){
      return C_PUSH;
    }
    if(type.equals("pop")){
      return C_POP;
    }
    if(type.equals("label")){
      return C_LABEL;
    }
    if (type.equals("goto")){
      return C_GOTO;
    }
    if(type.equals("if-goto")){
      return C_IF;
    }
    if(type.equals("function")){
      return C_FUNCTION;
    }
    if(type.equals("return")){
       return C_RETURN;
    }
    if(type.equals("call")){
      return C_CALL;
    }
    return 0;
  
  }

  /**
   * Retorna el argumento del comando actual, para el caso de los 
   * comandos aritmeticos, se devuelve el comando en si 
   * @return String comando actual
   */
  public String arg1(){

    if(this.commandType() == C_ARITHMETIC){
      return comandoAct[0];
    }
    else{
      return comandoAct[1];
    }
  
  }
  /**
   * Metodo que retorna el segundo argumento del comando actual 
   * solo debe ser llamado si el comando actual es push o pop
   * @return el segundo argumento del comando , suele ser un numero
   */
  public int arg2(){
    return Integer.parseInt(comandoAct[2]);
  }
   /**
    * Metodo para la inicializacion de la lista de comandos aritmeticos 
    * permite reconocer si el comando contiene alguno de estos en el metodo CommandType()
    */
  public void aritmetica(){
    arithmetic = new ArrayList<String>();
    arithmetic.add("add");
    arithmetic.add("sub");
    arithmetic.add("eq");
    arithmetic.add("gt");
    arithmetic.add("lt");
    arithmetic.add("neg");
    arithmetic.add("and");
    arithmetic.add("or");
    arithmetic.add("not");

  }

  public void dust(File input) throws FileNotFoundException{
    try {
    Scanner sc = new Scanner(input);
    while(sc.hasNext()){
     String line = sc.nextLine();
     String[] com = line.split("\\s");
     String out = "";
      for(int j = 0;j<com.length;j++){
      if(com[j].equals("//") ){break;} 
      if(line.length() == 0){break;}
      else{
        out += com[j];
        out += " ";
      }

    }
    if(!(out.equals("") || out.equals(" "))){
      comandos.add(out.trim());
    }
  }
  sc.close();
  } catch(FileNotFoundException fnf) {
    throw new FileNotFoundException("File not found: " + fnf.getMessage());
 }
}
}