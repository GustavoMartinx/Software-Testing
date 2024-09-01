package main;

import static org.junit.Assert.assertTrue;

import net.jqwik.api.*;
import net.jqwik.api.Tuple.Tuple2;
import net.jqwik.api.constraints.IntRange;
import net.jqwik.api.constraints.Positive;
import net.jqwik.api.constraints.Size;


public class PadTest 
{
    // T01
    @Property
    public void testStrNull(
        @ForAll @Size(max = 7) String str,
        @ForAll @IntRange(max = 20) @Positive int size,
        @ForAll @Size(max = 5) String padStr
    ) throws Exception
    {
        String padded;
        str = null;
        
        padded = Pad.leftPad(str, size, padStr);
        assertTrue(padded == null);
    }

    // T02
    @Property
    public void testStrNotNull(
        @ForAll("strAndSize") Tuple2<String, Integer> strAndSize,
        @ForAll @Size(max = 5) String padStr
    ) throws Exception
    {
        String str = strAndSize.get1();
        int size = strAndSize.get2();

        String padded = Pad.leftPad(str, size, padStr);
        assertTrue(padded != null);
    }
    
    /**
     * Provides a tuple of a string and an integer, where the string has a length
     * less than the given integer.
     *
     * @return an arbitrary tuple of a string and an integer
     */
    @Provide
    Arbitrary<Tuple2<String, Integer>> strAndSize() {
        return Arbitraries.integers().between(2, 20)
            .flatMap(size ->
                Arbitraries.strings()
                    .withCharRange('a', 'z')
                    .ofMinLength(1)
                    .ofMaxLength(size - 1)
                    .map(str -> Tuple.of(str, size))
            );
    }
}
