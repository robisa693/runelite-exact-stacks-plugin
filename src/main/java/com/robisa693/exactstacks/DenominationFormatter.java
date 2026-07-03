package com.robisa693.exactstacks;

import java.util.ArrayList;
import java.util.List;

public class DenominationFormatter
{
    private static final long BILLION = 1_000_000_000L;
    private static final long MILLION = 1_000_000L;
    private static final long THOUSAND = 1_000L;

    public static List<String> format(long quantity, boolean coinItem)
    {
        List<String> parts = new ArrayList<>(4);
        if (quantity <= 0)
        {
            return parts;
        }

        long remaining = quantity;

        if (remaining >= BILLION)
        {
            long b = remaining / BILLION;
            parts.add(b + "b");
            remaining %= BILLION;
        }

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
            parts.add(remaining + (coinItem ? "gp" : ""));
        }

        return parts;
    }
}
