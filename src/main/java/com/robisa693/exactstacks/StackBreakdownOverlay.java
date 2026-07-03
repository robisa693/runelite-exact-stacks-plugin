package com.robisa693.exactstacks;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.List;
import javax.inject.Inject;
import net.runelite.api.ItemID;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.WidgetItemOverlay;
import net.runelite.client.ui.overlay.components.TextComponent;

class StackBreakdownOverlay extends WidgetItemOverlay
{
    private final StackBreakdownConfig config;
    private final ItemManager itemManager;

    @Inject
    StackBreakdownOverlay(StackBreakdownConfig config, ItemManager itemManager)
    {
        this.config = config;
        this.itemManager = itemManager;
        showOnInventory();
    }

    @Override
    public void renderItemOverlay(Graphics2D graphics, int itemId, WidgetItem widgetItem)
    {
        if (config.coinsOnly() && itemId != ItemID.COINS)
        {
            return;
        }

        if (!config.coinsOnly())
        {
            var comp = itemManager.getItemComposition(itemId);
            if (comp == null || !comp.isStackable())
            {
                return;
            }
        }

        int quantity = widgetItem.getQuantity();
        if (quantity <= 1)
        {
            return;
        }

        List<String> lines = DenominationFormatter.format(quantity, itemId == ItemID.COINS);
        if (lines.isEmpty())
        {
            return;
        }

        graphics.setFont(FontManager.getRunescapeSmallFont());

        Rectangle bounds = widgetItem.getCanvasBounds();
        Color color = config.textColor();

        int lineHeight = graphics.getFontMetrics().getHeight();
        int totalHeight = lines.size() * lineHeight;
        int startY = bounds.y + bounds.height - 4;

        for (int i = lines.size() - 1; i >= 0; i--)
        {
            String line = lines.get(i);

            TextComponent text = new TextComponent();
            text.setText(line);
            text.setColor(color);
            text.setPosition(new Point(bounds.x + bounds.width - 2, startY));
            text.render(graphics);

            startY -= lineHeight;
        }
    }
}
