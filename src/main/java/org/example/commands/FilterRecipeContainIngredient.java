package org.example.commands;

import org.example.StrategyPattern.IngredientStrategy;
import org.example.objects.GlobalDescription;
import org.example.objects.InputGetter;
import org.example.objects.Recipe;
import org.example.objects.RecipeMenu;

import java.util.ArrayList;
import java.util.Scanner;

public class FilterRecipeContainIngredient implements ICommand{
    Scanner scanner;
    InputGetter inputGetter = new InputGetter();
    private ArrayList<Recipe> recipes;
    /* To have the same correct reference value. */
    private RecipeMenu recipeMenu;

    public FilterRecipeContainIngredient(RecipeMenu recipeMenu) {
        /* To have the same correct reference value. */
        this.recipeMenu = recipeMenu;
        this.scanner = recipeMenu.getScanner();
        this.recipes = recipeMenu.getRecipes();
    }
    @Override
    public void runCommand() {
        // Check if there is any recipes in the list.
        if(!recipes.isEmpty()) {
            // Get which ingredient user want to filter recipes by.
            String containIngredient = inputGetter.getStringInput("Which ingredient must be in the recipes?");
            IngredientStrategy ingredientFilter = new IngredientStrategy(recipeMenu);
            // Filter recipes.
            ingredientFilter.filterByIngredient(containIngredient);
            // Inform user.
            System.out.println(GlobalDescription.filterDone);
        }
        else {
            // Inform user.
            System.out.println(GlobalDescription.noRecipesToFilter);
        }
    }
}
