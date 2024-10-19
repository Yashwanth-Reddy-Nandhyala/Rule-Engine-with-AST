package SourceCode;

import java.sql.SQLException;

public class RuleEngineApp {

    public static void main(String[] args) {
        try {
            RuleEngine ruleEngine = new RuleEngine();
            RuleDatabase ruleDatabase = new RuleDatabase();

            // Insert a rule into the database (simulated)
            String ruleString = "(age > 30 AND department == 'Sales') OR (experience > 5 AND salary > 50000)";
            ruleDatabase.insertRule(1, "Eligibility Rule", ruleString);

            // Retrieve the rule from the DB and create the AST
            String dbRuleString = ruleDatabase.getRule(1);
            Node ruleAST = ruleEngine.createRule(dbRuleString);

            // Create user attributes (data)
            UserAttributes user = new UserAttributes();
            user.addAttribute("age", 35);                   // Numeric attribute
            user.addAttribute("department", "Sales");        // String attribute
            user.addAttribute("experience", 6);              // Numeric attribute
            user.addAttribute("salary", 60000);              // Numeric attribute

            // Evaluate the rule against the user data
            boolean isEligible = ruleEngine.evaluateRule(ruleAST, user);
            System.out.println("User eligibility: " + isEligible);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
