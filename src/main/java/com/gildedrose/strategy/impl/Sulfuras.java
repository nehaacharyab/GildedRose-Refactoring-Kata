package com.gildedrose.strategy.impl;
import com.gildedrose.model.Item;
import com.gildedrose.strategy.ItemUpdateStrategy;

/**
 * Strategy for updating the quality of "Sulfuras" items.
 * "Sulfuras", being a legendary item, does not change in quality or sellIn value over time.
 * This class implements the ItemUpdateStrategy interface to define the update behavior for "Sulfuras" items.
 */
public class Sulfuras implements ItemUpdateStrategy {

    /**
     * Overrides the updateQuality method for "Sulfuras" items.
     * Since "Sulfuras" items do not change in quality, this method does not perform any operations.
     *
     * @param item The "Sulfuras" item whose quality and sellIn values are to be updated.
     */
    @Override
    public void updateQuality(Item item) {
        item.quality = SULFURAS_QUALITY; // Explicitly set "Sulfuras" quality to 80 to ensure it remains constant.
    }
}
