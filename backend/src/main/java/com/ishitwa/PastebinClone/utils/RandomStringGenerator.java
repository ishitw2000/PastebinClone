package com.ishitwa.PastebinClone.utils;

import java.util.UUID;

public class RandomStringGenerator {
    public static String generateUniqueRandomString() {
        // Generate a UUID
        UUID uuid = UUID.randomUUID();

        // Convert the UUID to a string and remove hyphens
        String uuidString = uuid.toString().replaceAll("-", "");

        // Return the first 7 characters of the string
        return uuidString.substring(0, 7);
    }
}

