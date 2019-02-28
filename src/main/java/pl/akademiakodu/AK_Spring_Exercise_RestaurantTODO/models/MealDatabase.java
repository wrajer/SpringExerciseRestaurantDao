package pl.akademiakodu.AK_Spring_Exercise_RestaurantTODO.models;

/**
 * Imports section
 */
import java.util.ArrayList;
import java.util.List;

/**
 * Class will be data storage for all meals in this exercise
 */
public class MealDatabase {

    /**
     * Method responsible fot calling all available meals in this exercise
     * @return
     */
    public List<Meal> getMeals(){
        List<Meal> mealList = new ArrayList<>();
        mealList.add(new Meal("Spagetti", 14));
        mealList.add(new Meal("Rizotto", 12));
        mealList.add(new Meal("Nalesniki", 8));
        mealList.add(new Meal("Schabowy", 14));
        mealList.add(new Meal("Pieczen", 18));
        mealList.add(new Meal("Zupa",6));
        mealList.add(new Meal("Barszcz",7));
        mealList.add(new Meal("Kluski",9));
        mealList.add(new Meal("Zapiekanka",5));
        mealList.add(new Meal("Gulasz",19));
        mealList.add(new Meal("Sok",4));
        mealList.add(new Meal("Kapusniaczek",5));
        mealList.add(new Meal("Rosol",5));
        mealList.add(new Meal("Knedle",9));
        mealList.add(new Meal("Pizza",22));
        mealList.add(new Meal("Kompot",2));
        mealList.add(new Meal("Kopytka",14));
        return mealList;
    }

}