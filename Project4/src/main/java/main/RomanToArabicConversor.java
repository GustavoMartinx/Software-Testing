package main;

import java.util.Scanner;

import main.java.main.Simbols;

/**
 * Programa que recebe um algarismo romano (como uma string) e retorna sua representação no sistema
 * de algarismos arábicos (como um inteiro).
 *
 */
public class RomanToArabicConversor 
{
    public static int romanToArabic(String romanSymbol) {
        switch (romanSymbol) {
            case Simbols.one:
                return 1;

            case Simbols.five:
                return 5;

            case Simbols.ten:
                return 10;

            case Simbols.fifty:
                return 50;

            case Simbols.oneHundred:
                return 100;

            case Simbols.fiveHundred:
                return 500;

            case Simbols.oneThousand:
                return 1000;

            default:
                throw new IllegalArgumentException("Invalid Roman symbol: " + romanSymbol);
        }
    }
    
    static int conversor(String romanSymbol) throws IllegalArgumentException {
        int arabicAlgarism = 0;
        int bigger = 0;
        int current;
        int previous;

        for(Character algarism : romanSymbol.toCharArray()) {
            current = romanToArabic(algarism);

            if (current > bigger) {
                bigger = current;
            } else {
                arabicAlgarism += current;
            }

            previous = current;
        }
        
        return arabicAlgarism;
    }
    
    public static void main( String[] args )
    {
        try (Scanner reader = new Scanner(System.in)) {
            System.out.println("Informe um algarismo romano: ");
            String romanSymbol = reader.nextLine();

            int arabicAlgarism = conversor(romanSymbol);
            System.out.println("Sua representação arábica é: " + arabicAlgarism);
        }
    }
}
