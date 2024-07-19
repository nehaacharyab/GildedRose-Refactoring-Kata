package com.gildedrose.exception;

/**
 * Represents exceptions specific to the Gilded Rose application.
 * This exception is used throughout the application to indicate when an operation on an item
 * violates the business rules, such as attempting to update an item with a quality value that
 * exceeds the maximum allowed limit.
 *
 * @author Neha B Acharya
 */
public class HordeException extends RuntimeException {
    public HordeException(String message) {
        super(message);
    }
}
