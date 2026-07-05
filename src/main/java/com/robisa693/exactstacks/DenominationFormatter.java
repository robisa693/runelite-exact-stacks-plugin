package com.robisa693.exactstacks;

import java.util.ArrayList;
import java.util.List;

public class DenominationFormatter
{
    private static final long MILLION = 1_000_000L;
    private static final long THOUSAND = 1_000L;

    // Game display tiers: exact below 100K, "xK" from 100K, "xM" from 10M
    private static final long K_DISPLAY_THRESHOLD = 100 * THOUSAND;
    private static final long M_DISPLAY_THRESHOLD = 10 * MILLION;

    /**
     * Returns the denomination lines the game's rounded stack display hides.
     * The game shows the exact quantity below 100K (nothing to add),
     * thousands ("5250K") from 100K (only the sub-K units are hidden),
     * and millions ("39M") from 10M (the K and sub-K remainder is hidden).
     */
    public static List<String> remainderLines(long quantity)
    {
        List<String> parts = new ArrayList<>(2);
        if (quantity < K_DISPLAY_THRESHOLD)
        {
            return parts;
        }

        if (quantity >= M_DISPLAY_THRESHOLD)
        {
            long k = (quantity % MILLION) / THOUSAND;
            if (k > 0)
            {
                parts.add(k + "K");
            }
        }

        long units = quantity % THOUSAND;
        if (units > 0)
        {
            parts.add(String.valueOf(units));
        }

        return parts;
    }
}
