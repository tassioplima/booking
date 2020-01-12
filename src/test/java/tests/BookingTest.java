package tests;

import listener.ExecutionExtension;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import setup.SetupTest;
import steps.BookingSteps;

@ExtendWith(ExecutionExtension.class)
@DisplayName("Fill somethings in Booking Site")
public class BookingTest extends SetupTest {

    private BookingSteps bookingSteps;

    @Test
    @Tag("first_test")
    public void FindingSomeTest(){

        bookingSteps = new BookingSteps(this.caps.getDriver());

        bookingSteps.inputCity();

    }
}
