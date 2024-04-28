package main;

public class Pad
{
    public static String leftPad(final String str, final int size, String padStr) {
        
        if (str == null) {
            return null;
        }

        if (padStr == null || padStr.isEmpty()) {
            padStr = " ";
        } else if (padStr.length() >= size) {
            return str;
        }

        // instanciando a string final preenchida a ser retornada
        StringBuilder padded = new StringBuilder(size);

        // calcula o tamanho da string de preenchimento
        int padSize = size - str.length();
        
        while (padded.length() < padSize) {
            // adiciona o preenchimento no início da string final
            padded.append(padStr);
        }
        
        // adiciona a string original na string final após o preenchimento
        padded.append(str);

        return padded.toString();
    }
}
