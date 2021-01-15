import java.util.Stack;

public class ValidParenthisis {


    public boolean isValid(String s) {
        //using stack data structure
        Stack<Character> stack=new Stack<>();
        for (char c:s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[')
                stack.push(c);
            else{
                //it is closing brace
                if(stack.isEmpty())
                    return false;
                boolean validateExp = validateExp(c, stack.pop());
                if(!validateExp)
                    return false;
        }
        }
        return true;
    }

    private boolean validateExp(char c, Character pop) {
        if(c==')' && pop=='(')
            return true;
        if(c=='}' && pop=='{')
            return true;
        if(c==']' && pop=='[')
            return true;
        return false;
    }

}
