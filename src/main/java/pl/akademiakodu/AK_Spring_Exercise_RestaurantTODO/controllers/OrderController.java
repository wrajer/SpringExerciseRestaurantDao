package pl.akademiakodu.AK_Spring_Exercise_RestaurantTODO.controllers;

/**
 * Imports section
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.akademiakodu.AK_Spring_Exercise_RestaurantTODO.models.*;
import pl.akademiakodu.AK_Spring_Exercise_RestaurantTODO.models.services.dao.OrderDao;
import pl.akademiakodu.AK_Spring_Exercise_RestaurantTODO.models.OrderR;
import pl.akademiakodu.AK_Spring_Exercise_RestaurantTODO.models.services.Restaurant;

/**
 * Control restaurant page with exercise
 */
@Controller
public class OrderController {

    /**
     * Declaration services and variables
     */
    @Autowired
    private OrderDao orderDao;
    @Autowired private Restaurant restaurant;
    private OrderR ourOrderR;

    /**
     * Method responsible for loading requested order template also get user inputs and stored it into given model
     * @param model stored user inputs as order request
     * @return ready order template
     */
    @GetMapping("/order") public String orderGet(Model model){
        model.addAttribute("welcome", "Please place order and wait for preparing it");
        model.addAttribute("menu", "Our Menu: " + restaurant.getMenu().toString());
        orderDao.addOrder(new OrderR());
        ourOrderR = orderDao.getAllOrders().get(0);
        model.addAttribute("userRequest", new UserRequest());
        return "order";
    }

    /**
     * Method responsible for getting indicate meal by user to later on adding it to order in restaurant
     * @param userRequest stored user inputs as order request
     * @param model holding calculations
     * @return update order template
     */
    @RequestMapping(params = "addOrder", method = RequestMethod.POST) public String orderAdd(
            @ModelAttribute("userRequest") UserRequest userRequest, Model model){
        model.addAttribute("welcome", "Please place order and wait for preparing it");
        model.addAttribute("menu", "Our Menu: " + restaurant.getMenu().toString());
        if (ourOrderR.getOrderOwner()==null && !userRequest.getName().equals("")){
            ourOrderR.setOrderOwner(userRequest.getName());
        }
        if (ourOrderR.getOrderOwner()!=null){
            model.addAttribute("userName", "OrderR placing by: " + ourOrderR.getOrderOwner());
        }
        if (restaurant.checkIfMealExist(userRequest.getMealName())){
            orderDao.addMealToOrder(ourOrderR, restaurant.getMeal(userRequest.getMealName()));
        }
        if (ourOrderR.getMealList().size()>0){
            model.addAttribute("currentOrder", "Your Current OrderR: " + ourOrderR.getMealList().toString());
        }
        return "order";
    }

    /**
     * Method responsible for getting indicate meal by user to later on removing it from order in restaurant
     * @param userRequest stored user inputs as order request
     * @param model holding calculations
     * @return update order template
     */
    @RequestMapping(params = "removeOrder", method = RequestMethod.POST) public String orderRemove(
            @ModelAttribute("userRequest") UserRequest userRequest, Model model){
        model.addAttribute("welcome", "Please place order and wait for preparing it");
        model.addAttribute("menu", "Our Menu: " + restaurant.getMenu().toString());
        if (ourOrderR.getOrderOwner()==null && !userRequest.getName().equals("")){
            ourOrderR.setOrderOwner(userRequest.getName());
        }
        if (ourOrderR.getOrderOwner()!=null){
            model.addAttribute("userName", "OrderR placing by: " + ourOrderR.getOrderOwner());
        }
        if (orderDao.checkIfMealAppearInOurOrder(ourOrderR, restaurant.getMeal(userRequest.getMealName()))){
            orderDao.removeMealFromOrder(ourOrderR, restaurant.getMeal(userRequest.getMealName()));
        }

        if (ourOrderR.getMealList().size()>0){
            model.addAttribute("currentOrder", "Your Current OrderR: " + ourOrderR.getMealList().toString());
        }
        return "order";
    }

    /**
     * Method responsible for send request to service about calculating total order cost and time. .
     * @param userRequest stored user inputs as order request
     * @param model holding calculations
     * @return update order template
     */
    @RequestMapping(params = "placeOrder", method = RequestMethod.POST) public String orderPlace(
            @ModelAttribute("userRequest") UserRequest userRequest, Model model){
        model.addAttribute("welcome", "Please place order and wait for preparing it");
        model.addAttribute("menu", "Our Menu: " + restaurant.getMenu().toString());
        if (ourOrderR.getMealList().size()>0){
            model.addAttribute("currentOrder", "Your Current OrderR: " +
                    ourOrderR.getMealList().toString());
            model.addAttribute("message", "OrderR Total: $" +
                    restaurant.calculateOrderPrice(ourOrderR));
        } else {
            model.addAttribute("message", "OrderR has been cancelled..");
        }
        orderDao.removeOrder(ourOrderR);
        orderDao.addOrder(new OrderR());
        return "order";
    }

}
