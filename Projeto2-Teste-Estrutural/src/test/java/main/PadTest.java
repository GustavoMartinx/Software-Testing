package main;

import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class PadTest 
{
    /*****************************
     * Specification Based Tests *
    *****************************/

    // T01
    @Test
    public void testStrNull()
    {
        String padded;
        String str = null;
        int size = 4;
        String padStr = "-";

        try {
            padded = Pad.leftPad(str, size, padStr);
            assertTrue(padded == null);
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    // T02
    @Test
    public void testSizeNegative()
    {
        String padded;
        String str = "asdf";
        int size = -1;
        String padStr = "-";

        try {
            padded = Pad.leftPad(str, size, padStr);
            assertTrue(false);
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    // T03
    @Test
    public void testStrLengthGreaterThanSize()
    {
        String padded;
        String str = "asdf";
        int size = 3;
        String padStr = "-";

        try {
            padded = Pad.leftPad(str, size, padStr);
            assertTrue(false);
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    // T04
    @Test
    public void testAllParamsAsOne() 
    {
        String padded;
        String str = "a";
        int size = 1;
        String padStr = "-";

        try {
            padded = Pad.leftPad(str, size, padStr);
            assertTrue(padded.equals(str));
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    // T05
    @Test
    public void testStringsAsOneAndSizeGreaterThanOne() 
    {
        String padded;
        String str = "a";
        int size = 2;
        String padStr = "-";

        try {
            padded = Pad.leftPad(str, size, padStr);
            assertTrue(padded.equals("-a"));
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    // T06
    @Test
    public void testStrAndSizeAsOneAndPadStrGeaterThanOne() 
    {
        String padded;
        String str = "a";
        int size = 1;
        String padStr = "--";

        try {
            padded = Pad.leftPad(str, size, padStr);
            assertTrue(padded.equals(str));
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    // T07
    @Test
    public void testStrAsOneAndPadStrAndSizeGreaterThanOne() 
    {
        String padded;
        String str = "a";
        int size = 2;
        String padStr = "--";

        try {
            padded = Pad.leftPad(str, size, padStr);
            assertTrue(padded.equals("-a"));
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    // T08
    @Test
    public void testStrAndSizeGreaterThanOneAndPadStrAsOne()
    {
        String padded;
        String str = "asdf";
        int size = 5;
        String padStr = "-";

        try {
            padded = Pad.leftPad(str, size, padStr);
            assertTrue(padded.equals("-asdf"));
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    // T09
    @Test
    public void testAllParamsGreaterThanOne()
    {
        String padded;
        String str = "asdf";
        int size = 6;
        String padStr = "#-";

        try {
            padded = Pad.leftPad(str, size, padStr);
            assertTrue(padded.equals("#-asdf"));
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    // T10
    @Test
    public void testAllParamsGreaterThanOneWithSizeGratherThanStr()
    {
        String padded;
        String str = "asdf";
        int size = 6;
        String padStr = "$--";

        try {
            padded = Pad.leftPad(str, size, padStr);
            assertTrue(padded.equals("$-asdf"));
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    // T11
    @Test
    public void testAllParamsGreaterThanOneWithSizeEqualToStr()
    {
        String padded;
        String str = "asdf";
        int size = 4;
        String padStr = "$";

        try {
            padded = Pad.leftPad(str, size, padStr);
            assertTrue(padded.equals(str));
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    // T12
    @Test
    public void testStrEmptyAndSizeGreaterThanPadStr()
    {
        String padded;
        String str = "";
        int size = 4;
        String padStr = "><";

        try {
            padded = Pad.leftPad(str, size, padStr);
            assertTrue(padded.equals("><><"));
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    // T13
    @Test
    public void testStrEmptyAndSizeSmallerThanPadStr()
    {
        String padded;
        String str = " ";
        int size = 1;
        String padStr = "><";

        try {
            padded = Pad.leftPad(str, size, padStr);
            assertTrue(padded.equals(str));
        } catch (Exception e) {
            assertTrue(false);
        }
    }


    /***************
     * MC/DC Tests *
    ****************/

    // T15
    @Test
    public void testStrNotNull()
    {
        String padded;
        String str = " ";
        int size = 3;
        String padStr = "><";

        try {
            padded = Pad.leftPad(str, size, padStr);
            assertTrue(padded.equals(">< "));
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    // T17
    @Test
    public void testSizeNotNegative()
    {
        String padded;
        String str = "a";
        int size = 0;
        String padStr = "-";

        try {
            padded = Pad.leftPad(str, size, padStr);
            assertTrue(padded.equals(str));
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    // T19
    @Test
    public void testPadStrNullAndPadStrNotEmpty()
    {
        String padded;
        String str = "a";
        int size = 1;
        String padStr = null;

        try {
            padded = Pad.leftPad(str, size, padStr);
            assertTrue(padded.equals(str));
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    // T21
    @Test
    public void testPadStrNotNullAndPadStrNotEmpty()
    {
        String padded;
        String str = "a";
        int size = 4;
        String padStr = "-";

        try {
            padded = Pad.leftPad(str, size, padStr);
            assertTrue(padded.equals("---a"));
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    // T23
    @Test
    public void testPadStrGreaterThanSizeAndStrLengthDiffToSize()
    {
        String padded;
        String str = "DB";
        int size = 3;
        String padStr = "asdf";

        try {
            padded = Pad.leftPad(str, size, padStr);
            assertTrue(padded.equals(str));
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    // T25
    @Test
    public void testPadStrSmallerThanSizeAndStrLengthDiffToSize()
    {
        String padded;
        String str = "S3";
        int size = 6;
        String padStr = "asdf";

        try {
            padded = Pad.leftPad(str, size, padStr);
            assertTrue(padded.equals("asdfS3"));
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    // T27
    @Test
    public void testStrLengthSmallerOrEqualToSize()
    {
        String padded;
        String str = "A";
        int size = 4;
        String padStr = "asdf";

        try {
            padded = Pad.leftPad(str, size, padStr);
            assertTrue(padded.equals("asdA"));
        } catch (Exception e) {
            assertTrue(false);  
        }
    }
}
