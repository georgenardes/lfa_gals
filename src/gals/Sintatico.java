package gals;

import static gals.Constants.DOLLAR;
import static gals.ParserConstants.ACCEPT;
import static gals.ParserConstants.ACTION;
import static gals.ParserConstants.ERROR;
import static gals.ParserConstants.FIRST_SEMANTIC_ACTION;
import static gals.ParserConstants.PARSER_ERROR;
import static gals.ParserConstants.PARSER_TABLE;
import static gals.ParserConstants.PRODUCTIONS;
import static gals.ParserConstants.REDUCE;
import static gals.ParserConstants.SHIFT;
import java.util.Stack;

public class Sintatico implements Constants
{
    private Stack stack = new Stack();
    private Token currentToken;
    private Token previousToken;
    private Lexico scanner;
    private Semantico semanticAnalyser;

    public void parse(Lexico scanner, Semantico semanticAnalyser) throws LexicalError, SyntaticError, SemanticError
    {
        this.scanner = scanner;
        this.semanticAnalyser = semanticAnalyser;
        
        //Limpa pilha
        stack.clear();
        
        //Adiciona 0 a pillha
        stack.push(new Integer(0));

        //Pega o primeiro caracter do scanner
        currentToken = scanner.nextToken();

        while ( ! step() )
            ;
    }

    private boolean step() throws LexicalError, SyntaticError, SemanticError
    {
        //Se o token for null,  token = "$" na ultima posição
        if (currentToken == null)
        {
            int pos = 0;
            if (previousToken != null)
                pos = previousToken.getPosition()+previousToken.getLexeme().length();

            currentToken = new Token(DOLLAR, "$", pos);
        }

        int token = currentToken.getId();
        int state = ((Integer)stack.peek()).intValue();
        
        //Vetor de ações
        int[] cmd = PARSER_TABLE[state][token-1];

        switch (cmd[0])
        {
            case SHIFT:
                stack.push(new Integer(cmd[1]));
                previousToken = currentToken;
                currentToken = scanner.nextToken();
                return false;

            case REDUCE:
                int[] prod = PRODUCTIONS[cmd[1]];

                for (int i=0; i<prod[1]; i++)
                    stack.pop();

                int oldState = ((Integer)stack.peek()).intValue();
                stack.push(new Integer(PARSER_TABLE[oldState][prod[0]-1][1]));
                return false;

            case ACTION:
                int action = FIRST_SEMANTIC_ACTION + cmd[1] - 1;
                stack.push(new Integer(PARSER_TABLE[state][action][1]));
                semanticAnalyser.executeAction(cmd[1], previousToken);
                return false;

            case ACCEPT:
                return true;

            case ERROR:
                throw new SyntaticError(PARSER_ERROR[state], currentToken.getPosition());
        }
        return false;
    }

}
