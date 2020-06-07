package app;

import io.DataReader;
import io.file.BarSerializable;
import model.Drink;

import java.io.IOException;

public class BarApp {
    private final int MAX_DRINK = 10;
    private Drink drink [] = new Drink[MAX_DRINK];
    private DataReader dataReader = new DataReader();
    private BarSerializable serializable = new BarSerializable();
    private int drinkCount = 0;

    public void controlLoop(){
        int choose;
        try {
            drink = serializable.importData();
            for(Drink drunk : drink){
                if(drunk != null){
                    drinkCount++;
                }
            }

        }catch (IOException ex){
            System.out.println("New DB!");
        }
        do{
            printOptions();
            choose = dataReader.getInteger();

            switch (choose){
                case 1:
                    drink [drinkCount]= dataReader.createDrink();
                    break;
                case 2:
                    printAllDrinks();
                    break;
                case 0:
                    dataReader.close();
                    serializable.exportData(drink);
                    break;
                default:
                    System.out.println("We don't have that option!");
            }
        }while(choose != 0);
    }

    private void printOptions(){
        System.out.println("0 - EXIT");
        System.out.println("1 - ADD Drink");
        System.out.println("2 - ShowDrinks");
    }
    private void printAllDrinks(){
        for(int i = 0 ; i<drinkCount;i++){
            System.out.println(drink[i]);
        }
    }

}
