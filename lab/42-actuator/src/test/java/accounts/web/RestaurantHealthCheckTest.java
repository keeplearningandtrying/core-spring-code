package accounts.web;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;

import rewards.internal.restaurant.JpaRestaurantRepository;
import rewards.internal.restaurant.RestaurantRepository;

/**
 * TODO-11: IMPORTANT: Stop the ActuatorApplication whilst we add new classes.
 *          <p>
 *          Modify this class to test the RestaurantHealthCheck class.
 *          This class will implement HealthCheck so a health()
 *          method will exist - use it in the tests.
 *          Code will not compile until the next step.
 */
@RunWith(JUnitPlatform.class)
public class RestaurantHealthCheckTest {
	private RestaurantHealthCheck restaurantHealthCheck;
	private RestaurantRepository restaurantRepository;

	@BeforeEach
	public void setUp() {
		restaurantRepository = mock(JpaRestaurantRepository.class);
		
		// TODO-12bc: Create an instance.
		// - Remove the two @Disabled annotations below
		// - Run the test, make sure it passes.
		restaurantHealthCheck = null;
	}

	@Test
	@Disabled
	public void testHealthReturnsUpIfThereAreRestaurants() {
		// Mock the Repository so getRestaurantCount returns 1
		doReturn(1L).when(restaurantRepository).getRestaurantCount();

		// TODO-11a: Modify to invoke the health() method on RestaurantHealthCheck
		// (which you will write in the next step)
		Health result = null;

		// Health check should return UP
		verify(restaurantRepository).getRestaurantCount();
		assert (result.getStatus()).equals(Status.UP);
	}

	@Test
	@Disabled
	public void testHealthReturnsDownIfThereAreNoRestaurants() {
		// Mock the Repository so getRestaurantCount returns 0
		doReturn(0L).when(restaurantRepository).getRestaurantCount();

		// TODO-11b: Modify to invoke the health() method
		Health result = null;

		// Health check should return DOWN
		verify(restaurantRepository).getRestaurantCount();
		assert (result.getStatus()).equals(Status.DOWN);
	}
}