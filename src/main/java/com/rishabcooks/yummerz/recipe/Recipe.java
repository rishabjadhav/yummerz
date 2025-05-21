package com.rishabcooks.yummerz.recipe;

import java.util.List;

// A record allows us to create an immutable data type, in this case, a Recipe, without having to add boilerplate
// Getters, toString, hashcode, equals, and constructors are all taken care of implicitly.

public record Recipe(
        Integer id,
        String dish,
        List<String> ingredients,
        List<String> instructions,
        int cookTime,
        String cuisine
) {
}
