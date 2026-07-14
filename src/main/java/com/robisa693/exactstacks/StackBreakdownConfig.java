package com.robisa693.exactstacks;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("exactstacks")
public interface StackBreakdownConfig extends Config
{
    @ConfigItem(
        keyName = "showInventory",
        name = "Show in inventory",
        description = "Show breakdown on items in your inventory."
    )
    default boolean showInventory()
    {
        return true;
    }

    @ConfigItem(
        keyName = "showBank",
        name = "Show in bank",
        description = "Show breakdown on items in the bank grid."
    )
    default boolean showBank()
    {
        return true;
    }

    @ConfigItem(
        keyName = "showLessThanK",
        name = "Show individual units",
        description = "Show amounts less than 1K (e.g. 640gp). Uncheck to show only K values."
    )
    default boolean showLessThanK()
    {
        return true;
    }

    @ConfigItem(
        keyName = "hideMaxStack",
        name = "Hide max stack sentinel",
        description = "Fix for inventory setups compatibility."
    )
    default boolean hideMaxStack()
    {
        return true;
    }
}
