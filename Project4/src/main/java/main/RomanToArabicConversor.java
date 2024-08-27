package main;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Programa que recebe um algarismo romano (como uma string) e retorna sua representação no sistema
 * de algarismos arábicos (como um inteiro).
 *
 */
public class RomanToArabicConversor 
{
    public static void mapInitialization(HashMap<Character,Integer> map) {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        // map.put(null, null);
    }
    
    static int conversor(String romanSymbol) throws IllegalArgumentException {
        int arabicAlgarism = 0;

        int current = 0;
        int previous = 0;
        
        HashMap<Character, Integer> romanToArabicMap = new HashMap<Character, Integer>();
        mapInitialization(romanToArabicMap);

        // caso simples: hashmap resolve
        
        // caso composto por mais de um algarismos (sem subtração)
        // III, VI

        // notação subtrativa simples
        // IV, IX

        // notação subtrativa complexa
        // XIV, XXIX


        for(Character algarism : romanSymbol.toCharArray()) {
            current = romanToArabicMap.get(algarism);

            // if (current == null) {
            //     throw new IllegalArgumentException("Algarismo Romano inválido: " + current);
            // }

            // veririficação em conjunto aos 4 últimos algarismos

            if (current > previous) {
                arabicAlgarism = (current - previous) + arabicAlgarism;
            } else {
                arabicAlgarism += current; // caso somposto por mais de um algarismo (sem subtração)
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
        catch(IllegalArgumentException e) {
            System.err.println(e);
        }
    }
}
