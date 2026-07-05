package com.robisa693.exactstacks;

import org.junit.Test;
import java.util.Arrays;
import java.util.Collections;
import static org.junit.Assert.assertEquals;

public class DenominationFormatterTest
{
    @Test
    public void testZero()
    {
        assertEquals(Collections.emptyList(), DenominationFormatter.remainderLines(0));
    }

    @Test
    public void testNegative()
    {
        assertEquals(Collections.emptyList(), DenominationFormatter.remainderLines(-1));
    }

    @Test
    public void testBelowKDisplayShowsNothing()
    {
        // Game shows the exact quantity below 100K
        assertEquals(Collections.emptyList(), DenominationFormatter.remainderLines(99_999));
    }

    @Test
    public void testExact100K()
    {
        // Game shows "100K", no remainder
        assertEquals(Collections.emptyList(), DenominationFormatter.remainderLines(100_000));
    }

    @Test
    public void testKDisplayRangeShowsOnlyUnits()
    {
        // Game shows "101K"; only the 123 is hidden
        assertEquals(Arrays.asList("123"), DenominationFormatter.remainderLines(101_123));
    }

    @Test
    public void testMillionsStillInKDisplayRange()
    {
        // Game shows "5250K" — the K part is already visible, only units are hidden
        assertEquals(Arrays.asList("640"), DenominationFormatter.remainderLines(5_250_640));
    }

    @Test
    public void testJustBelowMDisplay()
    {
        // Game shows "9999K"
        assertEquals(Arrays.asList("999"), DenominationFormatter.remainderLines(9_999_999));
    }

    @Test
    public void testExact10M()
    {
        // Game shows "10M", no remainder
        assertEquals(Collections.emptyList(), DenominationFormatter.remainderLines(10_000_000));
    }

    @Test
    public void testMDisplayUnitsOnly()
    {
        assertEquals(Arrays.asList("303"), DenominationFormatter.remainderLines(10_000_303));
    }

    @Test
    public void testMDisplayKAndUnits()
    {
        assertEquals(Arrays.asList("205K", "303"), DenominationFormatter.remainderLines(11_205_303));
    }

    @Test
    public void testMDisplayKOnly()
    {
        assertEquals(Arrays.asList("205K"), DenominationFormatter.remainderLines(11_205_000));
    }

    @Test
    public void testMaxCashStack()
    {
        // Game shows "2147M"
        assertEquals(Arrays.asList("483K", "647"), DenominationFormatter.remainderLines(2_147_483_647));
    }

    @Test
    public void testExactThousandInMRange()
    {
        assertEquals(Arrays.asList("483K"), DenominationFormatter.remainderLines(2_147_483_000));
    }

    @Test
    public void testRoundBillion()
    {
        // Game shows "1000M", no remainder
        assertEquals(Collections.emptyList(), DenominationFormatter.remainderLines(1_000_000_000));
    }
}
