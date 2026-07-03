package com.robisa693.exactstacks;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import java.awt.Color;

@ConfigGroup("exactstacks")
public interface StackBreakdownConfig extends Config
{
    @ConfigItem(
        keyName = "coinsOnly",
        name = "Coins only",
        description = "Only show breakdown for coins (item ID 995). Uncheck to apply to all stackable items."
    )
    default boolean coinsOnly()
    {
        return true;
    }

    @ConfigItem(
        keyName = "textColor",
        name = "Text color",
        description = "Color of the breakdown text"
    )
    default Color textColor()
    {
        return Color.YELLOW;
    }
}
