package pl.akademiakodu.AK_Spring_Exercise_RestaurantTODO.models.services.dao;

/**
 * Imports section
 */
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import pl.akademiakodu.AK_Spring_Exercise_RestaurantTODO.models.Meal;
import pl.akademiakodu.AK_Spring_Exercise_RestaurantTODO.models.OrderR;

import java.util.List;

/**
 * Class responsible for order logic
 */
@Repository
@Service
public interface OrderDao {
    /**
     * Getter for all stored orders
     * @return order list
     */
    List<OrderR> getAllOrders();

    /**
     * Method responsible for adding order to order list
     * @param order
     */
    void addOrder(OrderR order);

    /**
     * Method responsible for removing order from order lsit
     * @param order
     */
    void removeOrder(OrderR order);

    /**
     * Method responsible for adding meal for specified order
     * @param order
     * @param meal
     */
    void addMealToOrder(OrderR order, Meal meal);

    /**
     * Method responsible for removing meal from specified order
     * @param order
     * @param meal
     */
    void removeMealFromOrder(OrderR order, Meal meal);

    /**
     * Method responsible for checking if given meal is appear in specified order, return true if so.
     * @param order
     * @param meal
     */
    boolean checkIfMealAppearInOurOrder(OrderR order, Meal meal);
}