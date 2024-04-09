package edu.utfpr;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {

        List<Integer> left = new ArrayList<Integer>();
        List<Integer> right = new ArrayList<Integer>();
        List<Integer> result = new ArrayList<Integer>();
        
        left.add(1);
        right.add(2);
        
        Add sumObj = new Add();
        result = sumObj.add(left, right);

        System.out.println(result);
    }
}
