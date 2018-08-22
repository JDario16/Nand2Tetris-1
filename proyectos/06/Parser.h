#pragma once

#include <string>
#include <fstream>


using namespace std;

class Parser
{
public:
    enum COMMAND_TYPE
    {
        A_COMMAND,      //@Xxx donde Xxx es un simbolo y a su vez es un numero decimal
        C_COMMAND,      // para dest=comp;jump
        L_COMMAND       //Pseudocomando, donde el comando (Xxx) es un simbolo Xxx
    };

    Parser(const string &filename);
   
    ~Parser();
     
     /*
      *abre el file/stream y se prepara para hacerle el parse
      */

      bool abrir();

      /*
        * Hay mas comandos en la entrada?
        */
      bool hasMoreCommands();

      /*
       * Lee el siguiente comando de la entrada y lo vuelve el comando actual.
       * solo debe ser llamado si el metodo hasMoreCommands() retorna un true.
       * Inicialmente no hay un comando actual
       */
      void advance();

      /*
       * retorna el tipo del comando actual
       */

       enum Parser::COMMAND_TYPE commandType();

       /*
        * Retorna el simbolo o decimal del comando actual @Xxx o (Xxx).
        * Solo debe ser llamado cuando commandType() retorne A_COMMAND o L_COMMAND
        */

        string symbol();

        /*
         * Retorna el nemotecnico dest del comando C actual (8 posibilidades)
         * solo debe ser llamado cuando commandType() retorne C_COMMAND
         */

         string dest();

         /*
          * Retorna el nemotecnico comp del comando C actual (28 posibilidades)
          * solo debe ser llamado cuando commandType() retorne C_COMMAND
          */

          string comp(); 

          /*
           * Retorna el nemotecnico jump del comando c actual(8 posibilidades)
           * solo debe ser llamado cuando commandType() retorne C_COMMAND
           */

           string jump();

private:

    string m_filename;
    ifstream m_fs;
    COMMAND_TYPE m_currentCommandType;
    string m_currentSymbol;
    string m_currentDest;
    string m_currentComp;
    string m_currentJump;

};