package SourceCode;

import java.util.HashMap;
import java.util.Map;

public class UserAttributes {
    private Map<String, Object> attributes;

    public UserAttributes() {
        this.attributes = new HashMap<>();
    }

    // Add an attribute with an integer value
    public void addAttribute(String name, int value) {
        attributes.put(name, value);
    }

    // Add an attribute with a string value
    public void addAttribute(String name, String value) {
        attributes.put(name, value);
    }

    // Get an integer attribute (e.g., age or salary)
    public int getIntAttribute(String name) {
        Object value = attributes.get(name);
        if (value instanceof Integer) {
            return (int) value;
        }
        return 0;  // Return 0 if the value is not an integer or does not exist
    }

    // Get a string attribute (e.g., department)
    public String getStringAttribute(String name) {
        Object value = attributes.get(name);
        if (value instanceof String) {
            return (String) value;
        }
        return "";  // Return empty string if the value is not a string or does not exist
    }
}
