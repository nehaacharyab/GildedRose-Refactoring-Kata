package com.gildedrose;

import com.gildedrose.exception.HordeException;
import com.gildedrose.model.Item;
import com.gildedrose.strategy.ItemUpdateStrategy;

import static com.gildedrose.factory.ItemFactory.createItemBehavior;
import static java.util.Arrays.stream;

/**
 * The GildedRose class represents a system for managing the quality of items over time.
 * Each item has a strategy associated with it that dictates how its quality is updated.
 */
public class GildedRose {
    Item[] items;

    /**
     * Constructor for GildedRose class.
     * @param items Array of Item instances.
     */
    public GildedRose(Item[] items) {
        this.items = items;
    }

    /**
     * Updates the quality of all items in GildedRose instance.
     * It delegates the responsibility of updating each item's quality to the respective
     * ItemUpdateStrategy based on the type of item.
     */
    public void updateQuality() throws HordeException {
        stream(items)
                .forEach(item -> {
                    ItemUpdateStrategy strategy = createItemBehavior(item);
                    strategy.updateQuality(item);
                });
    }

}
