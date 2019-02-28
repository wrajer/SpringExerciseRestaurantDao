package pl.akademiakodu.AK_Spring_Exercise_RestaurantTODO.models.services;

/**
 * Imports section
 */

import org.springframework.stereotype.Service;
import pl.akademiakodu.AK_Spring_Exercise_RestaurantTODO.models.Meal;
import pl.akademiakodu.AK_Spring_Exercise_RestaurantTODO.models.MealDatabase;
import pl.akademiakodu.AK_Spring_Exercise_RestaurantTODO.models.OrderR;

import java.util.List;

/**
 * Service responsible for restaurant logic in this exercise
 */
@Service
public class Restaurant {

    /**
     * Variables declarations and initializations
     */
    private List<Meal> menu = new MealDatabase().getMeals();

    /**
     * Method checks if given meal name exist in our meal database
     *
     * @param mealName string meal name as user input
     * @return true if given param has equivalent in database
     */
    public boolean checkIfMealExist(String mealName) {
        for (Meal meal : menu) {
            if (mealName.equals(meal.getName())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method calculate total price of order. Count every meal in order list
     *
     * @param orderR user wish list
     * @return total price for order
     */
    public int calculateOrderPrice(OrderR orderR) {
        int sum = 0;

        for (Meal m : orderR.getMealList()) {

            sum = sum + m.getPrice();

        }

        return sum;
    }

    /**
     * Methods searching database for meal object based on given meal name
     *
     * @param mealName as string
     * @return meal as object
     */
    public Meal getMeal(String mealName) {

        if (checkIfMealExist(mealName)) {

            for (Meal m : menu) {
                if (m.getName().equals(mealName)) {
                    return m;
                }
            }

        }

        return null;
    }

    /**
     * Getters section
     */
    public List<Meal> getMenu() {
        return menu;
    }
}
