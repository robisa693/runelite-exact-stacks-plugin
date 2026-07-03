package com.robisa693.exactstacks;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("exactstacks")
public interface StackBreakdownConfig extends Config
{
    @ConfigItem(
        keyName = "showLessThanK",
        name = "Show individual units",
        description = "Show amounts less than 1K (e.g. 640gp). Uncheck to show only K values."
    )
    default boolean showLessThanK()
    {
        return true;
    }
}
