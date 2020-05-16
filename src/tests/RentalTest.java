import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


class RentalTest {

    public static Rental rental;
    public static Movie movie;

    @BeforeAll
    public static void setUp() {
        movie = new Movie("Avengers - Infinity War", 1);
        rental = new Rental(movie, 25);
    }

    @Test
    void getDaysRented() {
        Assertions.assertEquals(25, rental.getDaysRented());
    }

    @Test
    void getMovie() {
        Assertions.assertEquals(movie, rental.getMovie());
    }
}