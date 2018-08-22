#include<string>
#include<sstream>

#include"SymbolTable.h"

SymbolTable::SymbolTable(){

    /*
     * añadir los simbolos predifinidos
     */

     entradas["SP"] = 0;
     entradas["LCL"] = 1;
     entradas["ARG"] = 2;
     entradas["THIS"] = 3;
     entradas["THAT"] = 4;
     for(int i = 0; i <= 15; ++i){
         ostringstream os;
         os << "R" << i;
         entradas[os.str()] = i;
     }

     entradas["SCREEN"] = 16384;
     entradas["KBD"] = 24576;
}

void SymbolTable::addEntry(const string &symbol,int address){

    entradas[symbol]=address;
}

bool SymbolTable::contains(const string &symbol) const{

    return entradas.find(symbol) != entradas.end();
}

int SymbolTable::getAddress(const string &symbol)const {

    map<string, int>::const_iterator it = entradas.find(symbol);

    if(it != entradas.end())
        return it->second;
    return -1;

}