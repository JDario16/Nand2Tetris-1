#pragma once

#include <map>
#include <string>

using namespace std;


class SymbolTable{

public:

    SymbolTable();

    /*
     * Añade la tupla (symbol, address) a la tabla
     */
    void addEntry(const string &symbol, int address);

    /*
     * ¿ la tabla de simbolos contiene el simbolo dado ? 
     */

    bool contains(const string &symbol) const;


    /*
     * Retorna la direccions asociada al simbolo
     */
    
    int getAddress(const string &symbol) const;

private:

    map<string, int> entradas;

};