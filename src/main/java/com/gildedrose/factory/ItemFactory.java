package com.gildedrose.factory;

import com.gildedrose.model.Item;
import com.gildedrose.strategy.*;
import com.gildedrose.strategy.impl.*;

import static com.gildedrose.enums.ItemType.fromName;

/**
 * Factory class for creating ItemUpdateStrategy instances.
 * This class is responsible for determining the appropriate update strategy
 * for an item based on its name.
 *
 * @author Neha B Acharya
 */
public class ItemFactory {

    private ItemFactory() {}

    /**
     * Creates and returns an ItemUpdateStrategy instance appropriate for the given item.
     * The strategy is determined based on the item's name.
     * @param item The item for which to create the update strategy.
     * @return An instance of ItemUpdateStrategy specific to the item type.
     */
    public static ItemUpdateStrategy createItemBehavior(Item item) {
        switch (fromName(item.name)) {
            case AGED_BRIE:
                return new AgedBrieUpdateStrategy();
            case BACKSTAGE_PASSES:
                return new BackstagePasses();
            case SULFURAS:
                return new Sulfuras();
            case CONJURED:
                return new ConjuredItem();
            default:
                return new StandardItem();
        }
    }
}
