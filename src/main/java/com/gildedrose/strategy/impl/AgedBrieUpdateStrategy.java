package com.gildedrose.strategy.impl;

import com.gildedrose.exception.HordeException;
import com.gildedrose.model.Item;
import com.gildedrose.strategy.ItemUpdateStrategy;

/**
 * Strategy for updating the quality of "Aged Brie" items.
 * Implements the ItemUpdateStrategy interface to provide a specific
 * algorithm for increasing the quality of "Aged Brie" items as they age.
 *
 * @author Neha B Acharya
 */
public class AgedBrieUpdateStrategy implements ItemUpdateStrategy {

    private static final int MAX_QUALITY = 50;

    /**
     * Updates the quality of an "Aged Brie" item.
     * The quality of "Aged Brie" increases by 1 each day before the sell by date passes,
     * and by 2 each day after the sell by date has passed.
     * The quality of the item never increases above 50.
     *
     * @param item The "Aged Brie" item whose quality is to be updated.
     */
    @Override
    public void updateQuality(Item item) throws HordeException {
        checkQualityAboveMax(item);
        decrementSellIn(item);
        int increment = item.sellIn < 0 ? INCREASED_CHANGE : BASE_CHANGE;
        item.quality = Math.min(MAX_QUALITY, item.quality + increment);
    }
}
