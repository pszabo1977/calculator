package xyz.nergal.calc;

import java.util.List;

public class Calculator {

    public static void main(String[] args) {
        Calculator cal = new Calculator();
        cal.calc("-12 +\t 5 *2");
    }

    public double calc(String calculation) {
        Double result = null;

        System.out.println("\n\nexpression: >" + calculation + "<");
        if (calculation == null || calculation.length() == 0) {
            return result;
        }
        calculation = calculation.trim();
        if (calculation.startsWith("-")) {
            calculation = "0" + calculation;
        }
        List<String> tokens = MathExpressionParser.parseExpression(calculation);
        System.out.println("tokens: " + tokens);

        String rpnString = ReversePolishNotationParser.createReversePolishNotation(tokens);
        System.out.println("polish notation string: >" + rpnString + "<");

        result = ReversePolishNotationProcessor.processRPNP(rpnString);
        System.out.println("calculated result: >" + result + "<");

        return result;
    }
}
