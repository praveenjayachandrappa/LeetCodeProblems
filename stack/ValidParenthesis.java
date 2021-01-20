package stack;

import java.util.Stack;




public class ValidParenthesis {

    /**
     * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
     *
     * An input string is valid if:
     *
     * Open brackets must be closed by the same type of brackets.
     * Open brackets must be closed in the correct order.
     *
     *
     * Example 1:
     *
     * Input: s = "()"
     * Output: true
     * Example 2:
     *
     * Input: s = "()[]{}"
     * Output: true
     * Example 3:
     *
     * Input: s = "(]"
     * Output: false
     * Example 4:
     *
     * Input: s = "([)]"
     * Output: false
     * Example 5:
     *
     * Input: s = "{[]}"
     * Output: true
     *
     *
     * Constraints:
     *
     * 1 <= s.length <= 104
     * s consists of parentheses only '()[]{}'.
     *
     */




    public boolean isValid(String s) {
        if(s.length()==1)
            return false;


        Stack<Character> stack=new Stack();


        char[] carr=s.toCharArray();


        for(char c:carr){


            if(c=='(' || c=='[' || c=='{'){
                stack.push(c);
            }

            else {
                if(!stack.isEmpty()){
                    if(!validate(c,stack.pop()))
                        return false;
                }
                else{
                    return false;
                }


            }
        }

        return stack.isEmpty()?true:false;
    }


    private boolean validate(char closed,char open){

        if(open=='(' && closed==')')
            return true;
        else if(open=='{' && closed=='}')
            return true;
        else if(open=='[' && closed==']')
            return true;
        else
            return false;

    }

    public static void main(String[] args) {

        //String s="()[]{}";
        String s="([)]";
        ValidParenthesis validParenthesis=new ValidParenthesis();
        boolean valid = validParenthesis.isValid(s);
        System.out.println(valid);

    }
}
