package SourceCode;

import java.util.List;
import java.util.Stack;

public class RuleEngine {

    // Method to create an AST from a rule string
    public static Node createRule(String ruleString) {
        // Simulate parsing the rule string into AST nodes
        // A real implementation would parse the rule string to create an AST
        return parseRule(ruleString);
    }

    public Node combineRules(List<String> ruleStrings) {
        // Combine rules into a single AST
        Node combinedAST = null;
        for (String rule : ruleStrings) {
            Node ruleAST = createRule(rule);
            if (combinedAST == null) {
                combinedAST = ruleAST;
            } else {
                // Combine using an OR operator (as an example)
                combinedAST = new Node("OR", combinedAST, ruleAST);
            }
        }
        return combinedAST;
    }


    // Method to evaluate the AST against user data
    public boolean evaluateRule(Node node, UserAttributes userAttributes) {
        if (node == null) {
            return false;
        }

        // If the node is an operand (condition), evaluate it
        if (node.getType().equals("operand")) {
            String condition = node.getValue();
            return evaluateCondition(condition, userAttributes);
        }

        // If the node is an operator, evaluate left and right branches
        boolean leftResult = evaluateRule(node.getLeft(), userAttributes);
        boolean rightResult = evaluateRule(node.getRight(), userAttributes);

        // Apply the operator
        if (node.getValue().equals("AND")) {
            return leftResult && rightResult;
        } else if (node.getValue().equals("OR")) {
            return leftResult || rightResult;
        }

        return false;
    }

    // Helper method to evaluate individual conditions
    private boolean evaluateCondition(String condition, UserAttributes userAttributes) {
        // Parse the condition (for example, "age > 30")
        String[] parts = condition.split(" ");
        String attribute = parts[0];
        String operator = parts[1];
        int value = Integer.parseInt(parts[2]);

        int userValue = userAttributes.getIntAttribute(attribute);

        // Apply the comparison operator
        switch (operator) {
            case ">":
                return userValue > value;
            case "<":
                return userValue < value;
            case "==":
                return userValue == value;
            default:
                return false;
        }
    }

    // Simulated method to parse the rule string and return a basic AST
    private static Node parseRule(String ruleString) {
        // This is just a placeholder for real parsing logic
        if (ruleString.contains("age > 30")) {
            return new Node("operand", "age > 30");
        } else if (ruleString.contains("department == 'Sales'")) {
            return new Node("operand", "department == 'Sales'");
        } else if (ruleString.contains("experience > 5")) {
            return new Node("operand", "experience > 5");
        } else if (ruleString.contains("salary > 50000")) {
            return new Node("operand", "salary > 50000");
        }
        return null;
    }
}
