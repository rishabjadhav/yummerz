package com.rishabcooks.yummerz.recipe;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController// Annotation that creates expectation that response body is in JSON
public class RecipeController {

    @GetMapping("/ping") // test endpoint "ping" will return pong.
    String ping() {
        return "pong";
    }
}
