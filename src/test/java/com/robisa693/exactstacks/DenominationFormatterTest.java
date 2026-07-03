package com.robisa693.exactstacks;

import org.junit.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class DenominationFormatterTest
{
    @Test
    public void testZero()
    {
        assertEquals(Collections.emptyList(), DenominationFormatter.format(0));
    }

    @Test
    public void testNegative()
    {
        assertEquals(Collections.emptyList(), DenominationFormatter.format(-1));
    }

    @Test
    public void test999()
    {
        assertEquals(Arrays.asList("999"), DenominationFormatter.format(999));
    }

    @Test
    public void test1000()
    {
        assertEquals(Arrays.asList("1K"), DenominationFormatter.format(1000));
    }

    @Test
    public void test999999()
    {
        assertEquals(Arrays.asList("999K", "999"), DenominationFormatter.format(999999));
    }

    @Test
    public void test1000000()
    {
        assertEquals(Arrays.asList("1M"), DenominationFormatter.format(1000000));
    }

    @Test
    public void test10000303()
    {
        assertEquals(Arrays.asList("10M", "303"), DenominationFormatter.format(10000303));
    }

    @Test
    public void test11205303()
    {
        assertEquals(Arrays.asList("11M", "205K", "303"), DenominationFormatter.format(11205303));
    }

    @Test
    public void testMaxCashStack()
    {
        assertEquals(Arrays.asList("2147M", "483K", "647"), DenominationFormatter.format(2147483647));
    }

    @Test
    public void testBillionFallsThroughToM()
    {
        assertEquals(Arrays.asList("1000M"), DenominationFormatter.format(1000000000));
    }

    @Test
    public void testExactThousand()
    {
        assertEquals(Arrays.asList("2147M", "483K"), DenominationFormatter.format(2147483000));
    }
}
