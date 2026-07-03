package com.robisa693.exactstacks;

import java.util.ArrayList;
import java.util.List;

public class DenominationFormatter
{
    private static final long MILLION = 1_000_000L;
    private static final long THOUSAND = 1_000L;

    public static List<String> format(long quantity)
    {
        List<String> parts = new ArrayList<>(3);
        if (quantity <= 0)
        {
            return parts;
        }

        long remaining = quantity;

        if (remaining >= MILLION)
        {
            long m = remaining / MILLION;
            parts.add(m + "M");
            remaining %= MILLION;
        }

        if (remaining >= THOUSAND)
        {
            long k = remaining / THOUSAND;
            parts.add(k + "K");
            remaining %= THOUSAND;
        }

        if (remaining > 0)
        {
            parts.add(String.valueOf(remaining));
        }

        return parts;
    }
}
