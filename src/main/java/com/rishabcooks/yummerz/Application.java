package com.rishabcooks.yummerz;

import com.rishabcooks.yummerz.recipe.Recipe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class Application {

	// Below we initialize our Logger. This allows us to record messages about our application status.
	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		// SpringApplication.run(Application.class, args);

		// RULE 1: Code does NOT go outside the main package (com.rishabcooks.yummerz). While accessible in Java, this is out of scope to Spring.

		// Here we print our Greeting. However, we should rely on Spring to handle instances for us.
		// var g = new Greeting();
		// System.out.println(g.greet());

		// It is bad practice to use "new" ourselves.

		/*
		To access a Class in Spring, we must annotate the Class, and then retrieve it as a bean from our application context.

		A bean is just an instance of a class (with metadata), that the Spring application context is managing for us.
		In other words, it's what Spring's large container of objects calls one instance of a class.

		Below, we establish the context and get the Greeting instance as a bean, then run greet().
		 */

		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		Greeting g = (Greeting) context.getBean(Greeting.class);
		System.out.println(g.greet());


		// Here we add to our log, indicating our greeting has successfully been delivered.
		log.info("Greeting delivered.");
	}


	@Bean
	CommandLineRunner runner() {
		return args -> {
			ArrayList<String> ingredients = new ArrayList<>();
			ingredients.add("chicken");
			ArrayList<String> instructions = new ArrayList<>();
			instructions.add("slice chicken");
			instructions.add("add salt");
			Recipe recipe = new Recipe(1, "Thai Coconut Chicken Curry", ingredients, instructions, 20, "Thai");
			log.info("Recipe :" + recipe.toString());
		};
	}
}
