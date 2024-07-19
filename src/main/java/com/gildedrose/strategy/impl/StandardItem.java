package com.gildedrose.strategy.impl;

import com.gildedrose.model.Item;
import com.gildedrose.strategy.ItemUpdateStrategy;

import static java.lang.Math.max;

/**
 * Strategy for updating the quality of "Default" items.
 * This class implements the ItemUpdateStrategy interface to provide a specific
 * algorithm for updating the quality of items that do not fall into any special category.
 */
public class StandardItem implements ItemUpdateStrategy {

    /**
     * Updates the quality of a default item.
     * The quality of a default item decreases by 1 before the sell by date, and decreases by 2 after the sell by date has passed.
     * The sellIn value is decremented regardless of its current value.
     * The quality of the item is never reduced below 0.
     *
     * @param item The item whose quality is to be updated.
     */

    @Override
    public void updateQuality(Item item) {
        checkQualityAboveMax(item);
        decrementSellIn(item);
        int decrement = item.sellIn < 0 ? INCREASED_CHANGE : BASE_CHANGE;
        item.quality = max(0, item.quality - decrement);

    }
}
