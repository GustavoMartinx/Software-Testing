package main;

public class Pad
{
    public static String leftPad(final String str, final int size, String padStr) {

        char[] leftPad = new char[size];
        char[] strArray = new char[str.length()];
        strArray = str.toCharArray();

        for(int i = size; i > 0; i--) {
            leftPad[i] = strArray[i - 1];
        }
        
        return leftPad.toString();
    }
}
