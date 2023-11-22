import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        Restaurant camelia = RestaurantService.addRestaurant("Camelia", "Downtown", LocalTime.of(11, 0), LocalTime.of(23, 0));
        Restaurant tiramisu = RestaurantService.addRestaurant("Tiramisu", "Business Bay", LocalTime.of(9,30), LocalTime.of(21,0));
        Restaurant omega = RestaurantService.addRestaurant("Omega", "Financial Center", LocalTime.of(15,0), LocalTime.of(2,0));

        camelia.addToMenu("Mixed salad", 90);
        camelia.addToMenu("Chicken with garlic sauce", 89);
        camelia.addToMenu("Mango Smoothies", 38);
        camelia.addToMenu("Dining set", 168);
        camelia.addToMenu("Desert with cake", 45);

        Item mixedSalad = new Item("Mixed Salad", 90);
        Item chickenGarlic = new Item("Chicken with garlic sauce", 89);
        Item mangoSmoothies = new Item("Mango Smoothies", 38);
        Item diningSet = new Item ("Dining set", 168);
        Item desert = new Item("Desert with cake", 45);

        tiramisu.addToMenu("Chicken soup", 30);
        tiramisu.addToMenu("Mixed salmon salad", 50);
        tiramisu.addToMenu("Shrimp with garlic sauce", 85);
        tiramisu.addToMenu("Fried rice with mixed seafood", 68);
        tiramisu.addToMenu("Family set", 268);

        Item chickenSoup = new Item ("Chicken soup", 30);
        Item salmonSalad = new Item ("Mixed salmon salad", 50);
        Item shrimpGarlic = new Item ("Shrimp with garlic sauce", 85);
        Item friedRice = new Item ("Fried rice with mixed seafood", 68);
        Item familySet = new Item ("Family set", 268);

        omega.addToMenu("Sunset cocktail", 90);
        omega.addToMenu("Mixed shrimp salad", 180);
        omega.addToMenu("Season fruits", 685);
        omega.addToMenu("Beer tower", 868);
        omega.addToMenu("Luxury set", 1998);

        Item sunsetCocktail = new Item("Sunset cocktail", 90);
        Item shrimpSalad = new Item("Mixed shrimp salad", 180);
        Item seasonFruits = new Item("Season fruits", 685);
        Item beer = new Item("Beer tower", 868);
        Item luxurySet = new Item("Luxury set", 1998);


        tiramisu.displayDetails();
        System.out.println("Your order cost will be "+ omega.selectItem(sunsetCocktail));


    }

}
