package com.gildedrose.strategy.impl;


import com.gildedrose.model.Item;
import com.gildedrose.strategy.ItemUpdateStrategy;

public class BackstagePasses implements ItemUpdateStrategy {


    @Override
    public void updateQuality(Item item) {
        checkQualityAboveMax(item);
        int increment;
        if (item.sellIn < SELL_IN_THRESHOLD_FOR_TRIPLE_INCREMENT) {
            increment = TRIPLE_QUALITY_INCREMENT;
        } else if (item.sellIn < SELL_IN_THRESHOLD_FOR_DOUBLE_INCREMENT) {
            increment = INCREASED_CHANGE;
        } else {
            increment = BASE_CHANGE;
        }
        item.quality = Math.min(item.quality + increment, MAX_QUALITY);
        decrementSellIn(item);
        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }
}
