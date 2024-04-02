package edu.utfpr;

public class App {
    public static void main(String[] args) {
        
        Identifier id = new Identifier();

        boolean result = id.validateIdentifier("asdf");
        
        System.out.println(result);
    }
}
