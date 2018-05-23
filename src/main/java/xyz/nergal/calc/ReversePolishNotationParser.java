package xyz.nergal.calc;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class ReversePolishNotationParser {
    private static HashMap<String, Integer> operatorMap = new HashMap<>();

    static {
        operatorMap.put("-", 0);
        operatorMap.put("+", 0);
        operatorMap.put("/", 1);
        operatorMap.put("*", 1);
    }

    public static String createReversePolishNotation(List<String> tokens) {

        StringBuilder sb = new StringBuilder();
        Stack<String> s = new Stack<>();

        //while there are tokens to be read:
        for (String token : tokens) {
            Integer operatorPrecedence = operatorMap.get(token);
            //if the token is an operator, then:
            if (operatorPrecedence != null) {
                // while ((there is a function at the top of the operator stack)
                //               or (there is an operator at the top of the operator stack with greater precedence)
                //               or (the operator at the top of the operator stack has equal precedence and is left associative))
                //              and (the operator at the top of the operator stack is not a left bracket):
                //            pop operators from the operator stack onto the output queue.
                while (!s.isEmpty()) {
                    String op = s.peek();
                    Integer prec = operatorMap.get(op);
                    if (prec != null && prec >= operatorPrecedence) {
                        sb.append(s.pop()).append(" ");
                    } else {
                        break;
                    }
                }
                //push it onto the operator stack.
                s.push(token);
            }
            //if the token is a left bracket (i.e. "("), then:
            //        push it onto the operator stack.
            else if (token.equals("(")) {
                s.push(token);
            }
            //if the token is a right bracket (i.e. ")"), then:
            else if (token.equals(")")) {
                //while the operator at the top of the operator stack is not a left bracket:
                //            pop the operator from the operator stack onto the output queue.
                while (!s.peek().equals("(")) {
                    String op = s.pop();
                    sb.append(op).append(" ");
                }
                //pop the left bracket from the stack.
                s.pop();
            }
            //if the token is a number, then:
            //        push it to the output queue.
            else {
                sb.append(token).append(" ");
            }
            System.out.println(sb);
        }
        //pop remaining operators from stack
        while (!s.isEmpty()) {
            String op = s.pop();
            sb.append(op).append(" ");
        }
        System.out.println(sb);

        return sb.toString();
    }
}
