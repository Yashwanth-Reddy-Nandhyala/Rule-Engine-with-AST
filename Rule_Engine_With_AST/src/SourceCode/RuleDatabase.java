package SourceCode;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import java.sql.*;

public class RuleDatabase {

    private Connection conn;

    // Establish connection to the Oracle database
    public RuleDatabase() throws SQLException {
        String jdbcUrl = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
        String username = "DEMO";
        String password = "demo";  
        conn = DriverManager.getConnection(jdbcUrl, username, password);
    }

    // Insert a rule into the database
    public void insertRule(int ruleId, String ruleName, String ruleString) throws SQLException {
        String query = "INSERT INTO RULES (RULE_ID, RULE_NAME, RULE_STRING) VALUES (?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, ruleId);
        stmt.setString(2, ruleName);
        stmt.setString(3, ruleString);
        stmt.executeUpdate();
        stmt.close();
    }

    // Retrieve a rule string from the database
    public String getRule(int ruleId) throws SQLException {
        String query = "SELECT RULE_STRING FROM RULES WHERE RULE_ID = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, ruleId);
        ResultSet rs = stmt.executeQuery();

        String ruleString = null;
        if (rs.next()) {
            ruleString = rs.getString("RULE_STRING");
        }
        rs.close();
        stmt.close();
        return ruleString;
    }
}
