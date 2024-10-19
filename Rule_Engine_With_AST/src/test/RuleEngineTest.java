package test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import SourceCode.Node;
import SourceCode.RuleDatabase;
import SourceCode.RuleEngine;
import SourceCode.UserAttributes;

public class RuleEngineTest {

    private RuleEngine ruleEngine;
    private RuleDatabase ruleDatabase;
    
    @BeforeEach
    public void setUp() {
        ruleEngine = new RuleEngine();
        ruleDatabase = Mockito.mock(RuleDatabase.class);  // Mocking the database for testing
    }
    
    // Test Case 1: Create individual rules and verify AST structure
    @Test
    public void testCreateRule() {
        String ruleString = "(age > 30 AND department == 'Sales') OR (experience > 5 AND salary > 50000)";
        Node ruleAST = RuleEngine.createRule(ruleString);

        assertNotNull(ruleAST, "AST should not be null");
        assertEquals("OR", ruleAST.getValue(), "Root node should be an OR operator");

        Node left = ruleAST.getLeft();
        Node right = ruleAST.getRight();

        assertNotNull(left, "Left child of root should not be null");
        assertEquals("AND", left.getValue(), "Left child should be an AND operator");

        assertNotNull(right, "Right child of root should not be null");
        assertEquals("AND", right.getValue(), "Right child should be an AND operator");
    }
    
 // Test Case 2: Combine rules and ensure combined AST reflects logic
    @Test
    public void testCombineRules() {
        // Define two rule strings
        String rule1 = "(age > 30 AND department == 'Sales')";
        String rule2 = "(experience > 5 AND salary > 50000)";

        // Create a list of rules to combine
        List<String> rules = Arrays.asList(rule1, rule2);

        // Combine the rules using the "OR" operator
        Node combinedAST = ruleEngine.combineRules(rules);

        // Assert that the combined AST is not null
        assertNotNull(combinedAST);

        // Assert the combined AST root node has "OR" as the operator
        assertEquals("OR", combinedAST.getValue());

        // You can add more assertions to verify the structure of the AST
        assertNotNull(combinedAST.getLeft());
        assertNotNull(combinedAST.getRight());
    }
    
 // Test Case 3: Evaluate rule using sample JSON data
    @Test
    public void testEvaluateRule() {
        String ruleString = "(age > 30 AND department == 'Sales')";
        Node ruleAST = ruleEngine.createRule(ruleString);

        UserAttributes user = new UserAttributes();
        user.addAttribute("age", 35);
        user.addAttribute("department", "Sales");

        boolean result = ruleEngine.evaluateRule(ruleAST, user);
        assertTrue(result, "User should be eligible based on the rule");

        // Test with non-eligible data
        UserAttributes user2 = new UserAttributes();
        user2.addAttribute("age", 25);
        user2.addAttribute("department", "Marketing");

        boolean result2 = ruleEngine.evaluateRule(ruleAST, user2);
        assertFalse(result2, "User should not be eligible based on the rule");
    }

    // Test Case 4: Combine additional rules and test functionality
    @Test
    public void testCombineAdditionalRules() {
        String rule1 = "(age > 30 AND department == 'Sales')";
        String rule2 = "(salary > 50000 OR experience > 5)";
        String rule3 = "(age < 25 AND department == 'Marketing')";

        // Create a list of rule strings
        List<String> rules = Arrays.asList(rule1, rule2, rule3);

        // Pass the list of rules to the combineRules method
        Node combinedAST = ruleEngine.combineRules(rules);

        assertNotNull(combinedAST, "Combined AST should not be null");

        // Evaluating for a user who matches one of the rules
        UserAttributes user = new UserAttributes();
        user.addAttribute("age", 35);
        user.addAttribute("department", "Sales");
        user.addAttribute("salary", 60000);

        // Evaluate the combined rule
        boolean isEligible = ruleEngine.evaluateRule(combinedAST, user);

        // Assert that the user is eligible based on the combined rule
        assertTrue(isEligible, "User should be eligible based on the combined rule");
    }
   
}
