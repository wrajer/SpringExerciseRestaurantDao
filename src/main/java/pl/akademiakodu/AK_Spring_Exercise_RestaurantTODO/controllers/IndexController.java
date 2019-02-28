package pl.akademiakodu.AK_Spring_Exercise_RestaurantTODO.controllers;

/**
 * Imports section
 */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Control index page
 */
@Controller
public class IndexController {

    /**
     * Method responsible for loading requested index template
     * @return index template
     */
    @GetMapping("/") public String indexGet(){
        return "index";
    }

}
