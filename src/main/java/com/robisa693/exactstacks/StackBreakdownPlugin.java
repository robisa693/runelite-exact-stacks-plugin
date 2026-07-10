package com.robisa693.exactstacks;

import com.google.inject.Provides;
import javax.inject.Inject;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
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
    private StackBreakdownConfig config;

    private StackBreakdownOverlay overlay;

    @Provides
    StackBreakdownConfig getConfig(ConfigManager configManager)
    {
        return configManager.getConfig(StackBreakdownConfig.class);
    }

    @Override
    protected void startUp()
    {
        overlay = new StackBreakdownOverlay(config);
        overlayManager.add(overlay);
    }

    @Override
    protected void shutDown()
    {
        overlayManager.remove(overlay);
    }

    @Subscribe
    public void onConfigChanged(ConfigChanged event)
    {
        if (!event.getGroup().equals("exactstacks"))
        {
            return;
        }

        if (event.getKey().equals("showInventory") || event.getKey().equals("showBank"))
        {
            overlayManager.remove(overlay);
            overlay = new StackBreakdownOverlay(config);
            overlayManager.add(overlay);
        }
    }
}
