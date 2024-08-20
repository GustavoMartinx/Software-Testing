package main;

import static org.junit.Assert.assertTrue;

import net.jqwik.api.*;
import net.jqwik.api.constraints.Positive;
import net.jqwik.api.constraints.Size;


public class PadTest 
{
    // T01
    @Property
    public void PBtest(
        @ForAll
        String str,

        @ForAll
        @Positive
        int size,

        @ForAll
        @Size(max = 5)
        String padStr
        
    ) throws Exception
    {
        String padded;
        str = null;
        
        padded = Pad.leftPad(str, size, padStr);
        assertTrue(padded == null);
    }
}
