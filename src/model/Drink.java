package model;

import java.io.Serializable;

public class Drink implements Serializable {
    private Ingredient ingredient[];

    private String drinkName;


    public Drink (String drinkName, Ingredient ingredient[]){
        this.drinkName = drinkName;
        this.ingredient = ingredient;

    }

    @Override
    public String toString() {
        String ingredientList = "";
        for(Ingredient ingredients : ingredient){
            ingredientList += ingredients;
        }
        return drinkName + ":\n"+ingredientList;
    }
}
