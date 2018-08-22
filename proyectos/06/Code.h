#pragma once 

#include <string>
#include <cstdint>

using namespace std;

class Code {

public:
    /*
     * Retorna el codigo binario de la nemotecnica dest
     */
     static string dest(const string &nemotec);

    /*
     * Retorna el codigo binario de la nemotecnica jump
     */
    static string jump(const string &nemotec);

    /*
     * Retorna el codigo binario de la nemotecnica comp 
     */
     static string comp(const string &nemotec);

      /*
     * Retorna el bit de un simbolo numerico , o una cadena vacia 
     * si el simbolo es un simbolo de variable
     */
     static string aSimboloNumerico(const string &symbol);

private:

    /*
     * convierte el comando actual a mayusculas
     * si el usuario realizo algo en minusculas 
     * " a=m+d"
     */
    static string aMayusculas(const string &comando);
    
   
};