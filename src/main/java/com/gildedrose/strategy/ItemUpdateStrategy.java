package com.gildedrose.strategy;


import com.gildedrose.exception.HordeException;
import com.gildedrose.model.Item;

/**
 * Defines the strategy for updating the quality of an item.
 * This interface is part of the Strategy design pattern, allowing for different
 * quality update algorithms to be implemented for different types of items.
 */
public interface ItemUpdateStrategy {

    int BASE_CHANGE = 1;
    int INCREASED_CHANGE = 2;
    int MAX_QUALITY = 50;
    int TRIPLE_QUALITY_INCREMENT = 3;
    int SULFURAS_QUALITY = 80;
    int SELL_IN_THRESHOLD_FOR_DOUBLE_INCREMENT = 11;
    int SELL_IN_THRESHOLD_FOR_TRIPLE_INCREMENT = 6;

    /**
     * Defines the strategy for updating the quality of an item.
     * This interface is part of the Strategy design pattern, allowing for different
     * quality update algorithms to be implemented for different types of items.
     */
    void updateQuality(Item item) throws HordeException;

    default void decrementSellIn(Item item) {
        item.sellIn--;
    }

    default void checkQualityAboveMax(Item item) throws HordeException {
        if (item.quality > MAX_QUALITY) {
            throw new HordeException("Item quality is already above " + MAX_QUALITY + ": " + item.name);
        }
    }

}
