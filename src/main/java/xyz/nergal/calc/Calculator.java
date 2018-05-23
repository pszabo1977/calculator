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
        List<String> tokens = MathExpressionParser.parse(calculation);
        System.out.println("tokens: " + tokens);

        String rpnString = ReversePolishNotationParser.parse(tokens);
        System.out.println("reverse polish notation string: >" + rpnString + "<");

        result = ReversePolishNotationProcessor.process(rpnString);
        System.out.println("calculated result: >" + result + "<");

        return result;
    }
}
