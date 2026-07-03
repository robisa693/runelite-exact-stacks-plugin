package com.robisa693.exactstacks;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.WidgetItemOverlay;
import net.runelite.client.ui.overlay.components.TextComponent;

class StackBreakdownOverlay extends WidgetItemOverlay
{
    private final StackBreakdownConfig config;
    private final ItemManager itemManager;

    StackBreakdownOverlay(StackBreakdownConfig config, ItemManager itemManager)
    {
        this.config = config;
        this.itemManager = itemManager;
        if (config.showInventory()) showOnInventory();
        if (config.showBank()) showOnBank();
    }

    @Override
    public void renderItemOverlay(Graphics2D graphics, int itemId, WidgetItem widgetItem)
    {
        var comp = itemManager.getItemComposition(itemId);
        if (comp == null || !comp.isStackable())
        {
            return;
        }

        long quantity = widgetItem.getQuantity();
        if (quantity < 100_000)
        {
            return;
        }

        List<String> lines = DenominationFormatter.format(quantity);
        if (lines.size() <= 1)
        {
            return;
        }
        lines = lines.subList(1, lines.size());

        List<String> filtered = new ArrayList<>(lines.size());
        for (String line : lines)
        {
            if (line.endsWith("M"))
            {
                continue;
            }
            if (!line.endsWith("K") && !config.showLessThanK())
            {
                continue;
            }
            filtered.add(line);
        }
        if (filtered.isEmpty())
        {
            return;
        }

        graphics.setFont(FontManager.getRunescapeSmallFont());

        Rectangle bounds = widgetItem.getCanvasBounds();
        var fontMetrics = graphics.getFontMetrics();
        int lineHeight = fontMetrics.getHeight() - 2;
        int leftEdge = bounds.x;
        int baseline = bounds.y + fontMetrics.getAscent() + 9;

        for (String line : filtered)
        {
            TextComponent text = new TextComponent();
            text.setText(line);
            text.setColor(Color.WHITE);
            text.setPosition(new Point(leftEdge, baseline));
            text.render(graphics);

            baseline += lineHeight;
        }
    }
}
