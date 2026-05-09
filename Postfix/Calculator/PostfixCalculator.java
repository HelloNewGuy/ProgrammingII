package Postfix.Calculator;

import java.util.Stack;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PostfixCalculator {

    //Function to evaluate a postfix expression
    public static int evaluatePostfix (String expression) {
        Stack<Integer> stack = new Stack<>();

        // Split input byt spaces to handle multi-digit numbers
        String[] tokens = expression.split(" ");

        try {
            for (String token : tokens) {

                // Check if number (supports multi-digit)
                if (token.matches("-?\\d+")) {
                    stack.push(Integer.parseInt(token));
                }
                // Check for operator
                else if (token.matches("[+\\-*/%]")) {

                    if (stack.size() < 2) {
                        throw new IllegalArgumentException("Invalid expression: not enough operands.");
                    }

                    int b = stack.pop();
                    int a = stack.pop();

                    switch (token) {
                        case "+":
                            stack.push(a + b);
                            break;
                        case "-":
                            stack.push(a - b);
                            break;
                        case "*":
                            stack.push(a * b);
                            break;
                        case "/":
                            if (b == 0) {
                                throw new ArithmeticException("Division by zero.");
                            }
                            stack.push(a / b);
                            break;
                        case "%":
                            if (b == 0) {
                                throw new ArithmeticException("Modulo by zero.");
                            }
                            stack.push(a % b);
                            break;
                    }
                } else {
                    throw new IllegalArgumentException("Invalid token: " + token);
                }
            }
            if (stack.size() != 1) {
                throw new IllegalArgumentException("Invalid expression: too many operands.");
            }

            return stack.pop();

        } catch (Exception e) {
            System.out.println("Error in expression [" + expression + "]: " + e.getMessage());
            return Integer.MIN_VALUE;
        }
    }

    // Function to read expressions from file
    public static void readFromFile(String fileName) {
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            String line;
            while ((line = reader.readLine()) != null) {

                // Skip empty lines
                if (line.trim().isEmpty()) continue;

                System.out.println("Expression: " + line);

                int result = evaluatePostfix(line);

                if (result != Integer.MIN_VALUE) {
                    System.out.println("Result: " + result);
                }

                System.out.println("-------------------------");
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // File name (make sure it is the same directory or give full path
        String fileName = "D:\\github learn\\practice 2\\Programming  II\\Postfix\\Calculator\\expressions.txt";

        readFromFile(fileName);
    }
}