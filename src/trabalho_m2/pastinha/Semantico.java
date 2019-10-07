package gals;
import java.util.Stack;


public class Semantico implements Constants
{
  Stack stack = new Stack();

  public int getResult()
  {
    return ((Integer)stack.peek()).intValue();
  }

  public void executeAction(int action, Token token) throws SemanticError
  {
    Integer a, b;

    switch (action)
    {
      case 2:
        String tmp = token.getLexeme();
        if (tmp.charAt(0) == '0')
          throw new SemanticError("Números começados por 0 não são permitidos", token.getPosition());
        stack.push(Integer.valueOf(tmp));
        break;      
      case 3:
        b = (Integer) stack.pop();
        a = (Integer) stack.pop();
        stack.push(new Integer(a.intValue() + b.intValue()));
        break;
      case 4:
        b = (Integer) stack.pop();
        a = (Integer) stack.pop();
        stack.push(new Integer(a.intValue() - b.intValue()));
        break;
      case 5:
        b = (Integer) stack.pop();
        a = (Integer) stack.pop();
        stack.push(new Integer(a.intValue() * b.intValue()));
        break;
      case 6:
        b = (Integer) stack.pop();
        a = (Integer) stack.pop();
        stack.push(new Integer(a.intValue() / b.intValue()));
        break;
      case 7:
        b = (Integer) stack.pop();
        a = (Integer) stack.pop();
        stack.push(new Integer((int) Math.pow(a.intValue(), b.intValue())));
        break;  
       
    }
  }
}