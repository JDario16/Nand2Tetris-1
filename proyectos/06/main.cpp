#include <iostream>
#include <sstream>
#include <bitset>
#include <fstream>

#include "Parser.h"
#include "Code.h"
#include "SymbolTable.h"

using namespace std;

static bool primeraRotacion(const string &asmFile, SymbolTable &symbolTable){
   
    bool rotado;

    Parser parser(asmFile);
    int romAddress = 0;
    if(parser.abrir()==true){

        while(parser.hasMoreCommands()){
            parser.advance();

            switch(parser.commandType()){
                
            case Parser::C_COMMAND:
                romAddress++;
                break;

            case Parser::A_COMMAND:
                romAddress++;
                break;

            case Parser::L_COMMAND:

                symbolTable.addEntry(parser.symbol(),romAddress);
                break;
            }
        }
        rotado = true;
    }
    else{
        cerr << "Fallo al abrir el archivo :" << asmFile << endl;
        rotado = false;
    }
    return rotado;
}

static bool segundaRotacion(const string &asmFile,const string &hackFile,SymbolTable &symbolTable){
    
    bool rotado;
    int siguienteDireccion = 16;

    ofstream ofs;
    ofs.open(hackFile.c_str());
    

    if(!ofs.is_open()){
        cerr << "Fallo al abrir el archivo" << hackFile << endl;
        return false;
    }

    Code c;

    Parser parser(asmFile);
    if(parser.abrir()){
        
        while(parser.hasMoreCommands()){
            parser.advance();
            
            if(parser.commandType()==Parser::C_COMMAND){
                ofs << "111" << c.comp(parser.comp()) << c.dest(parser.dest()) << c.jump(parser.jump()) << endl;
        
            }
            else if(parser.commandType()== Parser::A_COMMAND) {

                string bits = c.aSimboloNumerico(parser.symbol());
            

                if(bits.empty()){

                    /*
                     * busca la direccion de un simbolo no numerico en la 
                     * tabla
                     */

                     int romAddress = symbolTable.getAddress(parser.symbol());
                     if(romAddress >= 0){
                         ostringstream os;
                         bitset<15> symbolBits(romAddress);
                         os << symbolBits;
                         bits = os.str();
                     }
                     else{
                         /*
                          * Añade una nueva variable a la tabla
                          */
                        
                          symbolTable.addEntry(parser.symbol(),siguienteDireccion);
                          ostringstream os;
                          bitset<15> symbolBits(siguienteDireccion);
                          os << symbolBits;
                          bits = os.str();

                          siguienteDireccion++;
                     }
                }
                ofs << "0" << bits << endl;


            }
        }

        rotado =  true;
    }
    else {
        cerr << "Fallo al abrir el archivo :" << asmFile << endl;
        rotado = false;
    }

    ofs.close();

    return rotado;
}

int main(int argc, char *argv[]){

    string asmFile;
    string hackFile;
    size_t lastPos;
    SymbolTable symbolTable;
    int state = 1;

    

    if(argc != 2){
        cerr << "ingresar un archivo .asm" << endl;
        cerr << "para generar su respectiva traduccion" << endl;
        goto LIMPIAR;
    }

    asmFile = argv[1];
    hackFile = argv[1];

    /*
     * toma el nombre del archivo, y le ubica el ".hack "
     */
    lastPos=hackFile.find_last_of('.');
    if(lastPos != string::npos){
        hackFile=hackFile.substr(0,lastPos);
    }
    hackFile.append(".hack");

    /*
     * Pasa por todo el codigo sin generar traduccion alguna
     * si encuentra alguna (tag) la guarda en la tabla de simbolos
     * <tag,n>
     */
    if(!primeraRotacion(asmFile, symbolTable)){
        //cerr << "primera rotacion fallo" <<endl;
        goto LIMPIAR;
    }

    /*
     * Pasa por todo el codigo y empieza a hacer las traducciones correspondientes
     */
    if(!segundaRotacion(asmFile, hackFile, symbolTable)){
        //cerr << "segunda rotacion fallo" <<endl;
        goto LIMPIAR;
    }
    state = 0;

LIMPIAR:
    return state;
}
