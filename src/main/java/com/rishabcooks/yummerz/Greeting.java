package com.rishabcooks.yummerz;

import org.springframework.stereotype.Component;

// This is an annotation. It adds this class to Spring's application context, making it available to Spring.
@Component
public class Greeting {
    public String greet() {
        return "Howdy! Let's shake and bake!";
    }
}
