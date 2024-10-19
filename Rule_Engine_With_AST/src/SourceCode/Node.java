package SourceCode;

public class Node {
    private String type; // "operator" for AND/OR, "operand" for conditions
    private String value; // Used for operands
    private Node left; // Left child node
    private Node right; // Right child node

    // Constructor for operand node
    public Node(String type, String value) {
        this.type = type;
        this.value = value;
        this.left = null;
        this.right = null;
    }

    // Constructor for operator node (AND/OR)
    public Node(String type, Node left, Node right) {
        this.type = type;
        this.left = left;
        this.right = right;
    }

    // Getters and setters
    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public String getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    
}
