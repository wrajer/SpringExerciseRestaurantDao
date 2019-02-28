package pl.akademiakodu.AK_Spring_Exercise_RestaurantTODO.models;

/**
 * Class for holding user request object
 */
public class UserRequest {

    /**
     * Variables declarations
     */
    private String name;
    private String mealName;

    /**
     * Constructors
     */
    public UserRequest() {
    }

    public UserRequest(String name, String mealName) {
        this.name = name;
        this.mealName = mealName;
    }

    /**
     * Getters and setters section
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }
}