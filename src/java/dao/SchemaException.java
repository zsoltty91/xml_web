package dao;

import java.util.ArrayList;

public class SchemaException extends Exception {
    
    public ArrayList<String> errors;
    
    public SchemaException() {        
    }
    
    public SchemaException(String msg) {
        super(msg);
    }
    
    public SchemaException(ArrayList<String> errors) {
        this.errors = errors;
    }
} 