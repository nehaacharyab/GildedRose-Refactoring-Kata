package com.gildedrose;

import com.gildedrose.exception.HordeException;
import com.gildedrose.model.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GildedRoseTest {

    @ParameterizedTest
    @MethodSource("provideItemsForQualityUpdate")
    void testItemQualityUpdate(String itemName, int sellIn, int quality, int expectedQuality) throws HordeException {
        Item[] items = new Item[]{new Item(itemName, sellIn, quality)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Assertions.assertEquals(expectedQuality, app.items[0].quality);
    }

    static Stream<Arguments> provideItemsForQualityUpdate() {
        return Stream.of(
                Arguments.of("standard", 10, 20, 19),
                Arguments.of("standard", 0, 20, 18),
                Arguments.of("standard", 10, 0, 0),
                Arguments.of("standard", 2, 1, 0),
                Arguments.of("standard", 1, 2, 1),
                Arguments.of("Aged Brie", 10, 20, 21),
                Arguments.of("Aged Brie", 0, 20, 22),
                Arguments.of("Aged Brie", 10, 50, 50),
                Arguments.of("Conjured Mana Cake", 2, 20, 18),
                Arguments.of("Conjured Mana Cake", 0, 18, 14),
                Arguments.of("Conjured Mana Cake", 0, 1, 0),
                Arguments.of("Conjured Mana Cake", 1, 6, 4),
                Arguments.of("Conjured Mana Cake", 0, 6, 2),
                Arguments.of("Sulfuras, Hand of Ragnaros", 0, 80, 80),
                Arguments.of("Backstage passes to a TAFKAL80ETC concert", 11, 20, 21),
                Arguments.of("Backstage passes to a TAFKAL80ETC concert", 9, 20, 22),
                Arguments.of("Backstage passes to a TAFKAL80ETC concert", 10, 20, 22),
                Arguments.of("Backstage passes to a TAFKAL80ETC concert", 1, 20, 23),
                Arguments.of("Backstage passes to a TAFKAL80ETC concert", 10, 50, 50),
                Arguments.of("Backstage passes to a TAFKAL80ETC concert", 0, 50, 0),
                Arguments.of("Backstage passes to a TAFKAL80ETC concert", 5, 49, 50),
                Arguments.of("Backstage passes to a TAFKAL80ETC concert", 10, 48, 50),
                Arguments.of("Invalid Item", 5, -1, 0)
        );
    }

    @Test
    void testQualityAbove50ThrowsHordeException() {
        Item[] items = new Item[]{new Item("Invalid Item", 5, 55)};
        GildedRose app = new GildedRose(items);
        Exception exception = assertThrows(HordeException.class, app::updateQuality);
        assertTrue(exception.getMessage().contains("Item quality is already above 50"));
    }

}
