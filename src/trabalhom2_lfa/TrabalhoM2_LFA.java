/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhom2_lfa;

import gals.LexicalError;
import gals.Lexico;
import gals.SemanticError;
import gals.Semantico;
import gals.Sintatico;
import gals.SyntaticError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 *
 * @author teddy
 */
public class TrabalhoM2_LFA { 
    
    public static void main(String[] args) throws IOException {
        
        while(true){
            System.out.println("Digite a Expressão: (Show com S maiúsculo)");

            LineNumberReader in = new LineNumberReader(new InputStreamReader(System.in));
            String line = in.readLine(); 

            try {
                Lexico lexico = new Lexico(line);
                Semantico semantico = new Semantico();
                Sintatico sintatico = new Sintatico();

                sintatico.parse(lexico, semantico);


            } catch (LexicalError | SyntaticError | SemanticError ex ) {
                System.out.println("Expressão Inválida."); 
            }
        }                
    }
}

