package gals;

import trabalhom2_lfa.TrabalhoM2_LFA;

public class Semantico implements Constants {

    public void executeAction(int action, Token token) throws SemanticError {
        //System.out.println("acao " + action + " -> token " + token.getLexeme());

        Integer a, b;
        switch (action) {
            case 1:     /** EMPILHA UM NUMERO DO TOKEN**/
                trabalhom2_lfa.TrabalhoM2_LFA.stack.push(Integer.parseInt(token.getLexeme(), 2));
                break;
                
                
            case 2: //SOMA
                a = trabalhom2_lfa.TrabalhoM2_LFA.stack.pop();
                b = trabalhom2_lfa.TrabalhoM2_LFA.stack.pop();
                trabalhom2_lfa.TrabalhoM2_LFA.stack.push(a + b);
                break;
                
                
            case 3: //MULTIPLICAÇÃO
                a = trabalhom2_lfa.TrabalhoM2_LFA.stack.pop();
                b = trabalhom2_lfa.TrabalhoM2_LFA.stack.pop();
                trabalhom2_lfa.TrabalhoM2_LFA.stack.push(a * b);
                break;
                
                
            case 4: //EMPILHA UMA VARIAVEL
                TrabalhoM2_LFA.stack.push(TrabalhoM2_LFA.vars.get(token.getLexeme()));
                break;
                        
                        
            case 5: //SUBTRAÇÃO
                a = trabalhom2_lfa.TrabalhoM2_LFA.stack.pop();
                b = trabalhom2_lfa.TrabalhoM2_LFA.stack.pop();
                trabalhom2_lfa.TrabalhoM2_LFA.stack.push(b - a);
                break;
                
                
            case 6: //DIVISÃO
                a = trabalhom2_lfa.TrabalhoM2_LFA.stack.pop();
                b = trabalhom2_lfa.TrabalhoM2_LFA.stack.pop();
                trabalhom2_lfa.TrabalhoM2_LFA.stack.push(b / a);
                break;
                
                
            case 7: //FUNÇÃO SHOW
                System.out.print("Resultado: "+Integer.toBinaryString(TrabalhoM2_LFA.vars.get(TrabalhoM2_LFA.ultimaVariavel))+"\n");
                break;
                
                
            case 8: //FUNÇÃO DE EXPONENCIAÇÃO
                a = trabalhom2_lfa.TrabalhoM2_LFA.stack.pop();
                b = trabalhom2_lfa.TrabalhoM2_LFA.stack.pop();

                Double A = Math.pow(b, a);
                trabalhom2_lfa.TrabalhoM2_LFA.stack.push(A.intValue());
                break;
                
                
                
            case 9: //ATRIBUI NO MAP O NOME DA VARIAVEL E SEU VALOR.
                TrabalhoM2_LFA.vars.put(TrabalhoM2_LFA.ultimaVariavel, TrabalhoM2_LFA.stack.pop());
                break;
                
                
            case 10:    //USADO PARA SABER QUAL VARIAVEL ESTA SENDO USADA
                TrabalhoM2_LFA.ultimaVariavel = token.getLexeme();
                break;
        }
    }
}
