package com.robisa693.exactstacks;

import javax.inject.Inject;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
    name = "Exact Stacks",
    description = "Shows exact coin stack values broken down by denomination (b/m/k/gp)",
    tags = {"exact", "stacks", "coins", "gp", "value", "quantity", "count", "breakdown", "denominations"}
)
public class StackBreakdownPlugin extends Plugin
{
    @Inject
    private OverlayManager overlayManager;

    @Inject
    private StackBreakdownOverlay overlay;

    @Override
    protected void startUp()
    {
        overlayManager.add(overlay);
    }

    @Override
    protected void shutDown()
    {
        overlayManager.remove(overlay);
    }
}
