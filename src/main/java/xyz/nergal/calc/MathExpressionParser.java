package xyz.nergal.calc;

import java.util.ArrayList;
import java.util.List;

public class MathExpressionParser {

    public static List<String> parse(String mathExpression) {
        List<String> retval = new ArrayList<>();
        String num = "";
        for (int i = 0; i < mathExpression.length(); i++) {
            char token = mathExpression.charAt(i);
            switch (token) {
                case '(':
                case ')':
                case '+':
                case '-':
                case '/':
                case '*':
                    if (num.length() > 0) {
                        retval.add(String.valueOf(num));
                        num = "";
                    }
                    retval.add(String.valueOf(token));
                    break;
                case ' ':
                    break;
                default:
                    num += token;
            }
        }
        if (num.length() > 0) {
            retval.add(String.valueOf(num));
        }
        return retval;
    }
}
