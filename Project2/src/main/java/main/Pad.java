package main;

public class Pad
{
    public static String leftPad(final String str, final int size, String padStr) throws Exception {
        
        if (str == null) {
            return null;
        }

        if (padStr == null || padStr.isEmpty()) {
            padStr = " ";
        }
        
        if (padStr.length() >= size || str.length() == size) {
            return str;
        }

        // caso a string original seja maior que o tamanho final, exception
        if(str.length() > size) {
            throw new Exception("Error: Size can not be grater than str length.");
        }

        // instanciando a string final preenchida a ser retornada
        StringBuilder padded = new StringBuilder(size);

        // calcula o tamanho da string de preenchimento
        int padSize = size - str.length();
        
        char[] padChars = padStr.toCharArray();
        int padIndex = 0;

        while (padded.length() < padSize) {
            // adiciona o próximo caractere de padChars no início da string final
            padded.insert(0, padChars[padIndex]);
            
            // incrementa o índice para obter o próximo caractere de padChars
            padIndex = (padIndex + 1) % padChars.length;
        }
        
        // adiciona a string original na string final após o preenchimento
        padded.append(str);

        return padded.toString();
    }

    public static void main(String[] args) {
        String str = "ana";
        String padStr = "jao";
        int size = 16;

        try {
            System.out.println(leftPad(str, size, padStr));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
