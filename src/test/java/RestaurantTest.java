import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;




class RestaurantTest {
    Restaurant restaurant;
    //REFACTOR ALL THE REPEATED LINES OF CODE

    //>>>>>>>>>>>>>>>>>>>>>>>>>OPEN/CLOSED<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    //-------FOR THE 2 TESTS BELOW, YOU MAY USE THE CONCEPT OF MOCKING, IF YOU RUN INTO ANY TROUBLE

    @BeforeEach
    public void setUp() {
        restaurant = new Restaurant("Camelia", "Downtown", LocalTime.of(11, 0), LocalTime.of(23, 0));
    }
    @Test
    public void is_restaurant_open_should_return_true_if_time_is_between_opening_and_closing_time(){
        //WRITE UNIT TEST CASE HERE
        Restaurant restaurant = mock(Restaurant.class);

        // Set opening and closing time
        LocalTime openingTime = LocalTime.of(9, 0);  // 9:00 AM
        LocalTime closingTime = LocalTime.of(22, 0); // 10:00 PM

        // Create a time that is between the opening and closing times
        LocalTime testTime = LocalTime.of(15, 0);    // 3:00 PM

        // Set up the mock to use the test time
        when(restaurant.getCurrentTime()).thenReturn(testTime);
        when(restaurant.isRestaurantOpen()).thenCallRealMethod();

        // Now, set the actual opening and closing time of the restaurant
        restaurant.openingTime = openingTime;
        restaurant.closingTime = closingTime;

        // Assert that the restaurant is open
        assertTrue(restaurant.isRestaurantOpen());
    }

    @Test
    public void is_restaurant_open_should_return_false_if_time_is_outside_opening_and_closing_time(){
        //WRITE UNIT TEST CASE HERE
        // Mock the Restaurant class
        Restaurant restaurant = mock(Restaurant.class);

        // Set opening and closing time
        LocalTime openingTime = LocalTime.of(9, 0);  // 9:00 AM
        LocalTime closingTime = LocalTime.of(22, 0); // 10:00 PM

        // Create a time that is outside the opening and closing times
        LocalTime testTime = LocalTime.of(23, 0);    // 11:00 PM

        // Set up the mock to use the test time
        when(restaurant.getCurrentTime()).thenReturn(testTime);
        when(restaurant.isRestaurantOpen()).thenCallRealMethod();

        // Now, set the actual opening and closing time of the restaurant
        restaurant.openingTime = openingTime;
        restaurant.closingTime = closingTime;

        // Assert that the restaurant is closed
        assertFalse(restaurant.isRestaurantOpen());
    }

    //<<<<<<<<<<<<<<<<<<<<<<<<<OPEN/CLOSED>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


    //>>>>>>>>>>>>>>>>>>>>>>>>>>>MENU<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    @Test
    public void adding_item_to_menu_should_increase_menu_size_by_1(){
        LocalTime openingTime = LocalTime.parse("10:30:00");
        LocalTime closingTime = LocalTime.parse("22:00:00");
        restaurant =new Restaurant("Amelie's cafe","Chennai",openingTime,closingTime);
        restaurant.addToMenu("Sweet corn soup",119);
        restaurant.addToMenu("Vegetable lasagne", 269);

        int initialMenuSize = restaurant.getMenu().size();
        restaurant.addToMenu("Sizzling brownie",319);
        assertEquals(initialMenuSize+1,restaurant.getMenu().size());
    }
    @Test
    public void removing_item_from_menu_should_decrease_menu_size_by_1() throws itemNotFoundException {
        LocalTime openingTime = LocalTime.parse("10:30:00");
        LocalTime closingTime = LocalTime.parse("22:00:00");
        restaurant =new Restaurant("Amelie's cafe","Chennai",openingTime,closingTime);
        restaurant.addToMenu("Sweet corn soup",119);
        restaurant.addToMenu("Vegetable lasagne", 269);

        int initialMenuSize = restaurant.getMenu().size();
        restaurant.removeFromMenu("Vegetable lasagne");
        assertEquals(initialMenuSize-1,restaurant.getMenu().size());
    }
    @Test
    public void removing_item_that_does_not_exist_should_throw_exception() {
        LocalTime openingTime = LocalTime.parse("10:30:00");
        LocalTime closingTime = LocalTime.parse("22:00:00");
        restaurant =new Restaurant("Amelie's cafe","Chennai",openingTime,closingTime);
        restaurant.addToMenu("Sweet corn soup",119);
        restaurant.addToMenu("Vegetable lasagne", 269);

        assertThrows(itemNotFoundException.class,
                ()->restaurant.removeFromMenu("French fries"));
    }
    //<<<<<<<<<<<<<<<<<<<<<<<MENU>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
}