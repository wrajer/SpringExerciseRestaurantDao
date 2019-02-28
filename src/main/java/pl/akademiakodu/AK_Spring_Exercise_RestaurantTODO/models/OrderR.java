package pl.akademiakodu.AK_Spring_Exercise_RestaurantTODO.models;

/**
 * Imports section
 */
import java.util.ArrayList;
import java.util.List;

/**
 * Class for holding results as object.
 */
public class OrderR {

    /**
     * Variables declarations
     */
    private String orderOwner;
    private List<Meal> mealList;

    /**
     * Constructors
     */
    public OrderR() {
        mealList = new ArrayList<>();
    }

    public OrderR(String orderOwner, List<Meal> mealList) {
        this.orderOwner = orderOwner;
        this.mealList = mealList;
    }

    /**
     * Getters and setters section
     */
    public String getOrderOwner() {
        return orderOwner;
    }

    public void setOrderOwner(String orderOwner) {
        this.orderOwner = orderOwner;
    }

    public List<Meal> getMealList() {
        return mealList;
    }

    public void setMealList(List<Meal> mealList) {
        this.mealList = mealList;
    }

}

