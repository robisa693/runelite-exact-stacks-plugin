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
        assertEquals(Collections.emptyList(), DenominationFormatter.format(0, true));
    }

    @Test
    public void testNegative()
    {
        assertEquals(Collections.emptyList(), DenominationFormatter.format(-1, true));
    }

    @Test
    public void test999()
    {
        assertEquals(Arrays.asList("999gp"), DenominationFormatter.format(999, true));
    }

    @Test
    public void test1000()
    {
        assertEquals(Arrays.asList("1K"), DenominationFormatter.format(1000, true));
    }

    @Test
    public void test999999()
    {
        assertEquals(Arrays.asList("999K", "999gp"), DenominationFormatter.format(999999, true));
    }

    @Test
    public void test1000000()
    {
        assertEquals(Arrays.asList("1M"), DenominationFormatter.format(1000000, true));
    }

    @Test
    public void test10000303()
    {
        assertEquals(Arrays.asList("10M", "303gp"), DenominationFormatter.format(10000303, true));
    }

    @Test
    public void test11205303()
    {
        assertEquals(Arrays.asList("11M", "205K", "303gp"), DenominationFormatter.format(11205303, true));
    }

    @Test
    public void test2147483647()
    {
        assertEquals(Arrays.asList("2b", "147M", "483K", "647gp"), DenominationFormatter.format(2147483647, true));
    }

    @Test
    public void testNonCoinNoSuffix()
    {
        assertEquals(Arrays.asList("10M", "303"), DenominationFormatter.format(10000303, false));
    }

    @Test
    public void testNonCoinSingle()
    {
        assertEquals(Arrays.asList("999"), DenominationFormatter.format(999, false));
    }

    @Test
    public void testLargeBillions()
    {
        assertEquals(Arrays.asList("1b"), DenominationFormatter.format(1000000000, true));
    }

    @Test
    public void testExactThousand()
    {
        assertEquals(Arrays.asList("2b", "147M", "483K"), DenominationFormatter.format(2147483000, true));
    }
}
