package main;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;


public class PadTest {

    // T01
    @Test
    public void testStrNull() throws Exception
    {
        String padded;
        String str = null;
        int size = 4;
        String padStr = "-";
        
        padded = Pad.leftPad(str, size, padStr);
        assertTrue(padded == null);
    }

    // T02
    @Test
    public void testSizeNegative() {
        String str = "asdf";
        int size = -1;
        String padStr = "-";
        assertThrows(Exception.class, () -> {
            Pad.leftPad(str, size, padStr);
        });
    }

    // T03
    @Test
    public void testStrLengthGreaterThanSize() {
        String str = "asdf";
        int size = 3;
        String padStr = "-";
        assertThrows(Exception.class, () -> {
            Pad.leftPad(str, size, padStr);
        });
    }

    // T04
    @Test
    public void testAllParamsAsOne() throws Exception {
        String padded;
        String str = "a";
        int size = 1;
        String padStr = "-";

        padded = Pad.leftPad(str, size, padStr);
        assertTrue(padded.equals(str));
    }

    // T05
    @Test
    public void testStringsAsOneAndSizeGreaterThanOne() throws Exception {
        String padded;
        String str = "a";
        int size = 2;
        String padStr = "-";

        padded = Pad.leftPad(str, size, padStr);
        assertTrue(padded.equals("-a"));
    }

    // T06
    @Test
    public void testStrAndSizeAsOneAndPadStrGeaterThanOne() throws Exception {
        String padded;
        String str = "a";
        int size = 1;
        String padStr = "--";

        padded = Pad.leftPad(str, size, padStr);
        assertTrue(padded.equals(str));
    }

    // T07
    @Test
    public void testStrAsOneAndPadStrAndSizeGreaterThanOne() throws Exception {
        String padded;
        String str = "a";
        int size = 2;
        String padStr = "--";

        padded = Pad.leftPad(str, size, padStr);
        assertTrue(padded.equals("-a"));
    }

    // T08
    @Test
    public void testStrAndSizeGreaterThanOneAndPadStrAsOne() throws Exception {
        String padded;
        String str = "asdf";
        int size = 5;
        String padStr = "-";

        padded = Pad.leftPad(str, size, padStr);
        assertTrue(padded.equals("-asdf"));
    }

    // T09
    @Test
    public void testAllParamsGreaterThanOne() throws Exception {
        String padded;
        String str = "asdf";
        int size = 6;
        String padStr = "#-";

        padded = Pad.leftPad(str, size, padStr);
        assertTrue(padded.equals("#-asdf"));
    }

    // T10
    @Test
    public void testAllParamsGreaterThanOneWithSizeGratherThanStr() throws Exception {
        String padded;
        String str = "asdf";
        int size = 6;
        String padStr = "$--";

        padded = Pad.leftPad(str, size, padStr);
        assertTrue(padded.equals("$-asdf"));
    }

    // T11
    @Test
    public void testAllParamsGreaterThanOneWithSizeEqualToStr() throws Exception {
        String padded;
        String str = "asdf";
        int size = 4;
        String padStr = "$";

        padded = Pad.leftPad(str, size, padStr);
        assertTrue(padded.equals(str));
    }

    // T12
    @Test
    public void testStrEmptyAndSizeGreaterThanPadStr() throws Exception {
        String padded;
        String str = "";
        int size = 4;
        String padStr = "><";

        padded = Pad.leftPad(str, size, padStr);
        assertTrue(padded.equals("><><"));
    }

    // T13
    @Test
    public void testStrEmptyAndSizeSmallerThanPadStr() throws Exception {
        String padded;
        String str = " ";
        int size = 1;
        String padStr = "><";

        padded = Pad.leftPad(str, size, padStr);
        assertTrue(padded.equals(str));
    }

    // MC/DC Tests

    // T15
    @Test
    public void testStrNotNull() throws Exception {
        String padded;
        String str = " ";
        int size = 3;
        String padStr = "><";

        padded = Pad.leftPad(str, size, padStr);
        assertTrue(padded.equals(">< "));
    }

    // T17
    @Test
    public void testSizeNotNegative() throws Exception {
        String padded;
        String str = "a";
        int size = 0;
        String padStr = "-";

        padded = Pad.leftPad(str, size, padStr);
        assertTrue(padded.equals(str));
    }

    // T19
    @Test
    public void testPadStrNullAndPadStrNotEmpty() throws Exception {
        String padded;
        String str = "a";
        int size = 1;
        String padStr = null;

        padded = Pad.leftPad(str, size, padStr);
        assertTrue(padded.equals(str));
    }

    // T21
    @Test
    public void testPadStrNotNullAndPadStrNotEmpty() throws Exception {
        String padded;
        String str = "a";
        int size = 4;
        String padStr = "-";

        padded = Pad.leftPad(str, size, padStr);
        assertTrue(padded.equals("---a"));
    }

    // T23
    @Test
    public void testPadStrGreaterThanSizeAndStrLengthDiffToSize() throws Exception {
        String padded;
        String str = "DB";
        int size = 3;
        String padStr = "asdf";

        padded = Pad.leftPad(str, size, padStr);
        assertTrue(padded.equals(str));
    }

    // T25
    @Test
    public void testPadStrSmallerThanSizeAndStrLengthDiffToSize() throws Exception {
        String padded;
        String str = "S3";
        int size = 6;
        String padStr = "asdf";

        padded = Pad.leftPad(str, size, padStr);
        assertTrue(padded.equals("asdfS3"));
    }

    // T27
    @Test
    public void testStrLengthSmallerOrEqualToSize() throws Exception {
        String padded;
        String str = "A";
        int size = 4;
        String padStr = "asdf";

        padded = Pad.leftPad(str, size, padStr);
        assertTrue(padded.equals("asdA"));
    }
}
