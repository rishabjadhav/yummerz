package com.rishabcooks.yummerz.recipe;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RecipeNotFoundException extends RuntimeException {
    // Custom exception to handle cases where a recipe is not found
    public RecipeNotFoundException() {
        super("Recipe not found");
    }
}
