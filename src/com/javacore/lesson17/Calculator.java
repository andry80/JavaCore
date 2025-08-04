package com.javacore.lesson17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Calculator {
    public static void main(String[] args) {
        System.out.println(Calculator.MathChallenge("-2*(3+(4-1))"));                              // -12
        System.out.println(Calculator.MathChallenge("6*6*6/6"));                                   // 36
        System.out.println(Calculator.MathChallenge("2*6/3+(5*5)*2/(2*1)-(45/9*(15+4*(15-20)))")); // 54
        System.out.println(Calculator.MathChallenge("2*6+3+(5*5)*2/(2*1)-(45/9*(15+4*(15-20)))")); // 65
        System.out.println(Calculator.MathChallenge("6*(4/2)+3*1-(3*5-(7*2))"));                   // 14
        System.out.println(Calculator.MathChallenge("2(2-0)(6/2)"));
        System.out.println(Calculator.MathChallenge("2+(3-1)*3"));
    }

    public static Integer MathChallenge(String stringMathExpression) {
        Pattern pattern = Pattern.compile("\\([0-9\\*\\-\\+\\/]+\\)");
        stringMathExpression = stringMathExpression.replaceAll("\\)\\(", "\\)*\\(");
        stringMathExpression = stringMathExpression.replaceAll("(?<=\\d)\\(", "*\\(");
        while (pattern.matcher(stringMathExpression).find()) {
            String[] listStringMathExpressionInBrackets = Arrays.stream(stringMathExpression.split("^[0-9\\*\\-\\+\\/\\(]*\\(|\\)[0-9\\*\\-\\+\\/\\(]*\\(|\\).*$")).filter(t -> t.length() > 0).toArray(String[]::new);
            ArrayList<Integer> listResults = new ArrayList<>();
            for (String stringExpression : listStringMathExpressionInBrackets) {
                listResults.add(MathChallenge(stringExpression));
            }
            for (Integer i : listResults) {
                stringMathExpression = pattern.matcher(stringMathExpression).replaceFirst(i.toString());
            }
        }
        List<String> listOfCharacters = Stream.of(stringMathExpression.split("[0-9]")).filter(a -> !a.equals("")).collect(Collectors.toList());
        List<Integer> listOfExpressionElements = Stream.of(stringMathExpression.split("[+*-/]")).filter(a -> !a.equals("")).mapToInt(a -> Integer.parseInt(a)).boxed().collect(Collectors.toList());
        Pattern pattern1 = Pattern.compile("[+*-/]-");
        for (String character : listOfCharacters) {
            if (pattern1.matcher(character).matches()) {
                int indx = listOfCharacters.indexOf(character);
                listOfExpressionElements.set(indx + 1, -listOfExpressionElements.get(indx + 1));
                listOfCharacters.set(indx, character.split("")[0]);
            }
            if (listOfCharacters.get(0).equals("-") && listOfCharacters.size() == listOfExpressionElements.size()) {
                listOfExpressionElements.set(0, -listOfExpressionElements.get(0));
                listOfCharacters.remove(0);
            }
        }
        while (!listOfCharacters.isEmpty()) {
            if (listOfCharacters.contains("/")) {
                int i = listOfCharacters.indexOf("/");
                int n1 = listOfExpressionElements.remove(i);
                int n2 = listOfExpressionElements.remove(i);
                listOfExpressionElements.add(i, n1 / n2);
                listOfCharacters.remove(i);
            } else if (listOfCharacters.contains("*")) {
                int i = listOfCharacters.indexOf("*");
                int n1 = listOfExpressionElements.remove(i);
                int n2 = listOfExpressionElements.remove(i);
                listOfExpressionElements.add(i, n1 * n2);
                listOfCharacters.remove(i);
            } else if (listOfCharacters.contains("+")) {
                int i = listOfCharacters.indexOf("+");
                int n1 = listOfExpressionElements.remove(i);
                int n2 = listOfExpressionElements.remove(i);
                listOfExpressionElements.add(i, n1 + n2);
                listOfCharacters.remove(i);
            } else if (listOfCharacters.contains("-")) {
                int i = listOfCharacters.indexOf("-");
                int n1 = listOfExpressionElements.remove(i);
                int n2 = listOfExpressionElements.remove(i);
                listOfExpressionElements.add(i, n1 - n2);
                listOfCharacters.remove(i);
            }
        }
        return listOfExpressionElements.get(0);
    }
}
