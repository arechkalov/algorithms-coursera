package com.endava.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IsUniqueTest {

    @Test
    void isUnique(){
        boolean abc = IsUnique.isUniqueCharactersIn("abc");
        boolean bbc = IsUnique.isUniqueCharactersIn("bbc");
        assertTrue(abc);
        assertFalse(bbc);
    }
}
