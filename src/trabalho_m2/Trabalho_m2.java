/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho_m2;

import gals.LexicalError;
import gals.Lexico;
import gals.SemanticError;
import gals.Semantico;
import gals.Sintatico;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.Reader;
import java.util.Scanner;

/**
 *
 * @author 6473091
 */
public class Trabalho_m2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {               
        System.out.println("Digite a expressão: ");              
        
        Lexico lexico = new Lexico();
        Sintatico sintatico = new Sintatico();
        Semantico semantico = new Semantico();

        LineNumberReader in = new LineNumberReader(new InputStreamReader(System.in));
        String line = in.readLine();
        
        lexico.setInput( line );

        try
        {
          sintatico.parse(lexico, semantico);
          System.out.println(" = ");
          System.out.println(trans.getResult());
        }
        catch ( LexicalError e )
        {
          e.printStackTrace();
        }
        catch ( SintaticError e )
        {
          e.printStackTrace();
        }
        catch ( SemanticError e )
        {
          e.printStackTrace();
        }
        
        
    }
    
}
