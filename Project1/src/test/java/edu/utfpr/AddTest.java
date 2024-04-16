package edu.utfpr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.util.List;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class AddTest {

    
    /**********************
     *   EXAMPLES TESTS   *
    ***********************/
    @Test
    void testAddTwoOneDigitNumbers() {
        Add add = new Add();

        List<Integer> left = Arrays.asList(1);
        List<Integer> right = Arrays.asList(1);

        List<Integer> result = add.add(left, right);

        assertEquals(Arrays.asList(2), result);        
    }

    @Test
    void testAddTwoDoubleDigitNumbers() {
        Add add = new Add();

        List<Integer> left = Arrays.asList(1,5);
        List<Integer> right = Arrays.asList(1,0);

        List<Integer> result = add.add(left, right);

        assertEquals(result, result);        
    }

    @Test
    void testAddTwoTreeDigitNumbers() {
        Add add = new Add();

        List<Integer> left = Arrays.asList(5,0,0);
        List<Integer> right = Arrays.asList(2,5,0);

        List<Integer> result = add.add(left, right);

        assertEquals(Arrays.asList(7,5,0), result);        
    }



    /**********************
     *      MY TESTS      *
    ***********************/
    @Test
    public void testNullLeft() {
        Add add = new Add();

        List<Integer> left = null;
        List<Integer> right = Arrays.asList(1, 0);
        List<Integer> result = add.add(left, right);

        assertNull(result);
    }

    @Test
    public void testNullRight() {
        Add add = new Add();

        List<Integer> left = Arrays.asList(1, 5);
        List<Integer> right = null;
        List<Integer> result = add.add(left, right);

        assertNull(result);
    }


    @Test
    public void testEmptyLeft() {
        Add add = new Add();

        List<Integer> left = Arrays.asList();
        List<Integer> right = Arrays.asList(1, 0);
        List<Integer> result = add.add(left, right);
        
        assertEquals(Arrays.asList(1, 0), result);
    }

    @Test
    public void testEmptyRight() {
        Add add = new Add();

        List<Integer> left = Arrays.asList(1, 5);
        List<Integer> right = Arrays.asList();
        List<Integer> result = add.add(left, right);
        
        assertEquals(Arrays.asList(1, 5), result);
    }

    @Test
    public void testSingleDigitLeft() {
        Add add = new Add();

        List<Integer> left = Arrays.asList(1);
        List<Integer> right = Arrays.asList(2, 3);
        List<Integer> result = add.add(left, right);
        
        assertEquals(Arrays.asList(2, 4), result);
    }

    @Test
    public void testSingleDigitRight() {
        Add add = new Add();

        List<Integer> left = Arrays.asList(1, 2);
        List<Integer> right = Arrays.asList(3);
        List<Integer> result = add.add(left, right);
        
        assertEquals(Arrays.asList(1, 5), result);
    }

    @Test
    public void testMultipleDigitsLeft() {
        Add add = new Add();

        List<Integer> left = Arrays.asList(1, 2, 3);
        List<Integer> right = Arrays.asList(4);
        List<Integer> result = add.add(left, right);
        
        assertEquals(Arrays.asList(1, 2, 7), result);
    }

    @Test
    public void testMultipleDigitsRight() {
        Add add = new Add();

        List<Integer> left = Arrays.asList(1);
        List<Integer> right = Arrays.asList(2, 3, 4);
        List<Integer> result = add.add(left, right);
        
        assertEquals(Arrays.asList(2, 3, 5), result);
    }

    @Test
    public void testNumberGreaterThan9() {
        Add add = new Add();

        List<Integer> left = Arrays.asList(10);
        List<Integer> right = Arrays.asList(1, 2, 3);
        
        try {
            add.add(left, right);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // A exceção é esperada
        }
    }

    @Test
    public void testNegativeNumber() {
        Add add = new Add();

        List<Integer> left = Arrays.asList(1, 2, 3);
        List<Integer> right = Arrays.asList(-1);

        try {
            add.add(left, right);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // A exceção é esperada
        }
    }

}
