#include <vector>
#include <iostream>

#include "Parser.h"

using namespace std;

Parser::Parser(const string &filename){
    m_filename=filename;
}

Parser::~Parser(){
    m_fs.close();
}

bool Parser::abrir(){
    m_fs.open(m_filename.c_str());
    return m_fs.is_open();
}

bool Parser::hasMoreCommands(){
    char c;
    bool enComentario = false;
    bool enSimbolo = false;
    bool enTag = false;
    bool conJump = false;
    bool conDest = false;
    bool eol = false;
    int readCount = 0;

    string token;

    m_currentSymbol.clear();
    m_currentDest.clear();
    m_currentComp.clear();
    m_currentJump.clear();
    m_currentCommandType = C_COMMAND;
    //int state=0;

    while (eol == false && m_fs.eof() == false){
        //Lee el siguiente comando para asegurase que si hay mas comandos
        //disponibles

        m_fs.get(c);
        
            if(c == '\r' || c=='\n') {
                if(readCount > 0){
                    eol = true;
                }
                enComentario = false;
                
            } else if(enComentario){
                /*
                 * Ignora todo si esta en un comentario
                 */
             } else if(c=='/') {
                  enComentario = true;
             } else if(c=='(') {
                if(enTag && enSimbolo){
                    cerr << "Inesperado :'" << c << "'" <<endl;
                    throw 20;
                    return false;
                }
                enSimbolo=true;
                enTag=true;
                m_currentCommandType=L_COMMAND;
            } else if(c==')') {
                if(!enTag && !enSimbolo){
                    cerr <<"Inesperado: '" << c << "'" << endl;
                    throw 20;
                    return false;
                    
                }
                enSimbolo=false; 
                enTag=false;
            } else if(c=='@') {
                if(enSimbolo){
                    cerr << "Inesperado: '" << c << "'" << endl;
                    throw 20;
                    return false;
                }
                enSimbolo=true;
                m_currentCommandType=A_COMMAND;
            } else if(c=='=') {
                if(conJump || conDest){
                    cerr << "Inesperado '" << c << "'" << endl;
                    return false;
                    throw 20;
                }
                // se termina de leer el dest 
                m_currentDest=token;
                token.clear();
                conDest=true;
            } else if(c==';') {
                if(conJump){
                    cerr << "Inesperado '" << c << "'" << endl;
                    return false;
                    throw 20;
                }

                //se termina de leer comp
                m_currentComp=token;
                token.clear();
                conJump=true;
            } else if(c==' ' || c=='\t') {
                // se omiten los espacios en blanco 
                enSimbolo=false;
            } else {
                token.push_back(c);
                readCount++;
            }
    
    }

            

           

        if(m_currentCommandType==C_COMMAND){
            /*Guardamos cualquier comp o jump que aun se estuviera leyendo si
             *se alcanza el eol
             */
             if(conJump){
                 m_currentJump = token;

             } else if(!token.empty()){
                 if(!m_currentComp.empty()){
                     cerr << "Inesperado '" << token << "'" << endl;
                     return false;
                 }
                 m_currentComp=token;
            } 
        }else{
            // todo lo que leamos va a ser simbolo 
            if(!m_currentSymbol.empty()){
                cerr << "Inesperado '" << token << "'" << endl; 
                return false;
            }
            m_currentSymbol=token;
        } 


    

    return (readCount>0);

}

/*
 * No es necesario implementar este metodo, ya que 
 * en el metodo anterior ya conseguimos el siguiente comando
 */
void Parser::advance(){}

enum Parser::COMMAND_TYPE Parser::commandType(){
    return m_currentCommandType;
    cout << m_currentCommandType <<endl;
}

string Parser::symbol(){
    return m_currentSymbol;
    cout << m_currentSymbol <<endl;
}

string Parser::dest(){
    return m_currentDest;
    cout << m_currentDest << endl;
}

string Parser::comp(){
    return m_currentComp;
    cout << m_currentDest << endl;
}

string Parser::jump(){
    return m_currentJump;
    cout << m_currentJump << endl;
}


