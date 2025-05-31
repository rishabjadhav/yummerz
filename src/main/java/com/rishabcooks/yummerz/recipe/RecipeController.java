package com.rishabcooks.yummerz.recipe;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
// Annotation that creates expectation that this Class has controller functionality
// In essence, it says "I am a controller, I receive requests, and return responses"

@RequestMapping("/api/recipes")
// Annotation that specifies the base URI for all endpoints in this controller
public class RecipeController {

    private final RecipeRepository recipeRepository;
    private final CommandLineRunner runner;

    // Our constructor for a RecipeController takes in an instance of RecipeRepository
    // This is called DEPENDENCY INJECTION, whereby we can handle dependencies by including them as a parameter for a component

    public RecipeController(RecipeRepository recipeRepository, CommandLineRunner runner) {
        this.recipeRepository = recipeRepository;
        this.runner = runner;
    }
    // We do this rather than making a new RecipeRepository, as we don't want to make many copies of the same repo.

    // By annotating this class and our RecipeRepository, Spring can autowire dependencies (in this case, the repo)
    // into this RecipeController bean, which is done specifically by the constructor.


    @GetMapping("/ping") // test endpoint "ping" will return pong.
    String ping() {
        return "pong";
    }

    @GetMapping("")
    List<Recipe> findAll() {
        return recipeRepository.findAll();
    }

    // GET method
    @GetMapping("/{id}")
    Recipe findById(@PathVariable Integer id) {
        // @PathVariable allows us to extract the value from the URI and pass it as a parameter to the method

        Optional<Recipe> recipe = recipeRepository.findByID(id);
        if (recipe.isPresent()) {
            // If the recipe exists, we return it
            return recipe.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    // POST method to create/add a new recipe
    // The endpoint is "/api/recipes", and it expects a JSON body that matches the Recipe record structure
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED) // Returns a 201 Created rather than a 200 OK
    void create(@RequestBody Recipe recipe) {
        // This method will add a recipe to the in-memory repository
        recipeRepository.create(recipe);
    }
}
