package io;

import model.Drink;
import model.Ingredient;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DataReader {
    private Scanner scanner = new Scanner(System.in);

    public int getInteger(){
        int intValue = scanner.nextInt();
        scanner.nextLine();
        return intValue;
    }

    public Drink createDrink(){

            String name;
            System.out.println("Drink Name: ");
            name = scanner.nextLine();
            System.out.println("Ingredients count");
            int ingredient = scanner.nextInt();
            scanner.nextLine();
            Ingredient ingredientTable[] = createIngredient(ingredient);
            return new Drink(name, ingredientTable);

    }
    private Ingredient [] createIngredient(int ingredientAmount){
        Ingredient [] ingredients = new Ingredient[ingredientAmount];
        String name;
        int ml;
        for(int i = 0 ; i<ingredients.length; i ++){
            System.out.println("Set name: ");
            name = scanner.nextLine();
            System.out.println("Set ml: ");
            ml = scanner.nextInt();
            scanner.nextLine();
            ingredients[i] = new Ingredient(name,ml);
        }
        return ingredients;
    }

    public void close(){
        scanner.close();
    }
}
