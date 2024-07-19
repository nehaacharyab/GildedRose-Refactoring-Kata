package com.gildedrose.strategy.impl;

import com.gildedrose.model.Item;
import com.gildedrose.strategy.ItemUpdateStrategy;

import static java.lang.Math.max;

/**
 * Strategy for updating the quality of "Conjured" items.
 * Implements the ItemUpdateStrategy interface to provide a specific
 * algorithm for decreasing the quality of "Conjured" items at a faster rate than normal items.
 */
public class ConjuredItem implements ItemUpdateStrategy {

    static final int BASE_DECREMENT = 2;
    static final int INCREASED_DECREMENT = 4;
    /**
     * Updates the quality of a "Conjured" item.
     * The quality of "Conjured" items decreases by 2 before the sell by date, and by 4 after the sell by date has passed.
     * The sellIn value is decremented regardless of its current value.
     * The quality of the item is never reduced below 0.
     *
     * @param item The "Conjured" item whose quality is to be updated.
     */
    @Override
    public void updateQuality(Item item) {
        checkQualityAboveMax(item);
        decrementSellIn(item);
        int decrement = item.sellIn < 0 ? INCREASED_DECREMENT : BASE_DECREMENT;
        item.quality = max(0, item.quality - decrement);

    }
}
