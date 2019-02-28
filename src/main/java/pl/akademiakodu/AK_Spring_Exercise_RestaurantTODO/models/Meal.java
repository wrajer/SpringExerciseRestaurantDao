package pl.akademiakodu.AK_Spring_Exercise_RestaurantTODO.models;

/**
 * Class for holding meals as object.
 */
public class Meal {

    /**
     * Variables declarations
     */
    private String name;
    private int price;

    /**
     * Constructors
     */
    public Meal() {
    }

    public Meal(String name, int price) {
        this.name = name;
        this.price = price;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return getName() + "($" + getPrice() + ")";
    }
}