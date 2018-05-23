package xyz.nergal.calc;

import java.util.Stack;

public class ReversePolishNotationProcessor {

    /**
     * for each token in the postfix expression:
     *  if token is an operator:
     *      operand_2 ← pop from the stack
     *      operand_1 ← pop from the stack
     *      result ← evaluate token with operand_1 and operand_2
     *      push result back onto the stack
     *  else if token is an operand:
     *      push token onto the stack
     *  result ← pop from the stack
     *
     * @param rpnString
     * @return
     */
    public static Double process(String rpnString) {
        Double retval;
        Stack<Double> stack = new Stack<>();


        for (String token : rpnString.split(" ")) {
            if (token != null) {
                Double num = null;
                try {
                    num = Double.parseDouble(token);
                } catch (NumberFormatException e) {
                }

                if (num != null) {
                    stack.push(num);
                } else {
                    double val2 = stack.pop();
                    double val1 = stack.pop();
                    Double result = evaluate(val1, val2, token);
                    stack.push(result);
                }
            }
        }
        retval = stack.pop();
        return retval;
    }

    private static Double evaluate(double val1, double val2, String token) {
        Double retval = null;
        switch (token) {
            case "*":
                retval = val1 * val2;
                break;
            case "/":
                retval = val1 / val2;
                break;
            case "-":
                retval = val1 - val2;
                break;
            case "+":
                retval = val1 + val2;
                break;
        }
        return retval;
    }
}
