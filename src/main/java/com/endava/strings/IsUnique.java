package com.endava.strings;

import java.util.HashSet;
import java.util.Set;

public class IsUnique {
    static boolean isUniqueCharactersIn(String s) {
        char[] chars = s.toCharArray();
        Set<Character> characters = new HashSet<>();
        for (char aChar : chars) {
            characters.add(aChar);
        }

        return characters.size() == chars.length;    }
}
