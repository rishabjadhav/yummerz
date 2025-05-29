package com.rishabcooks.yummerz.recipe;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// Will encapsulate data CRUD functionality for in-memory recipes stored here
// Intentionally separated from RecipeController, as controllers should not contain any logic

@Repository
public class RecipeRepository {
    private static final Logger log = LoggerFactory.getLogger(RecipeRepository.class);
    private List<Recipe> recipes = new ArrayList<>();

    // Retrieves all recipes
    List<Recipe> findAll() {
        return recipes;
    }

    // GET helper method
    Optional<Recipe> findByID(Integer id) {
        return recipes.stream()
                .filter(recipe -> recipe.id().equals(id))
                .findFirst();
    }

    void create (Recipe recipe) {
        // Adds a recipe to the in-memory list
        recipes.add(recipe);
    }

    @PostConstruct
    public void init() {
        recipes.add(new Recipe(
                1,
                "Thai Coconut Chicken Curry",
                List.of("chicken", "coconut milk", "curry paste", "vegetables"),
                List.of("slice chicken", "add salt", "add coconut milk", "add curry paste", "add vegetables"),
                20,
                "Thai"
        ));
        recipes.add(new Recipe(
                2,
                "Spaghetti Bolognese",
                List.of("spaghetti", "ground beef", "tomato sauce", "onion", "garlic"),
                List.of("boil spaghetti", "cook beef", "add onion and garlic", "add tomato sauce"),
                30,
                "Italian"
        ));
    }
}
