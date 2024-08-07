package main;

public class Pad
{
    public static String leftPad(final String str, final int size, String padStr) throws Exception {
        
        if (str == null) {
            return null;
        }

        if(size < 0) {
            throw new Exception("Error: 'size' parameter cannot be negative.");
        }

        if (padStr == null || padStr.isEmpty()) {
            padStr = " ";
        }
        
        if (padStr.length() > size || str.length() == size) {
            return str;
        }

        // caso a string original seja maior que o tamanho final, exception
        if(str.length() > size) {
            throw new Exception("Error: 'str' length cannot be greater than size.");
        }

        // instanciando a string final preenchida a ser retornada
        StringBuilder padded = new StringBuilder(size);

        // calcula o tamanho da string de preenchimento
        int padSize = size - str.length();
        
        char[] padChars = padStr.toCharArray();
        int padIndex = 0;

        while (padded.length() < padSize) {
            // adiciona o próximo caractere de padChars no início da string final
            padded.insert(padIndex, padChars[padIndex]);
            
            // incrementa o índice para obter o próximo caractere de padChars
            padIndex = (padIndex + 1) % padChars.length;
        }
        
        // adiciona a string original na string final após o preenchimento
        padded.append(str);

        return padded.toString();
    }
}
