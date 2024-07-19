package com.gildedrose.enums;

import java.util.Arrays;

/**
 * Enum representing the different types of items managed by the Gilded Rose application.
 * This enum provides a convenient way to work with item types through named constants.
 *
 * @author Neha B Acharya
 */

public enum ItemType {
    AGED_BRIE("Aged Brie"),
    BACKSTAGE_PASSES("Backstage passes to a TAFKAL80ETC concert"),
    SULFURAS("Sulfuras, Hand of Ragnaros"),
    CONJURED("Conjured Mana Cake"),
    DEFAULT("");

    private final String name;

    ItemType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * Converts a string name to an ItemType enum constant.
     * If the name does not match any of the defined item types, it defaults to DEFAULT.
     *
     * @param name The name of the item to convert to an ItemType.
     * @return The corresponding ItemType enum constant.
     */
    public static ItemType fromName(String name) {
        return Arrays.stream(ItemType.values())
                .filter(itemType -> itemType.getName().equals(name))
                .findFirst()
                .orElse(DEFAULT);
    }

}
