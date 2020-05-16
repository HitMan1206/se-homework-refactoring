import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class MovieTest {

    public static Movie movie;
    public static Movie movie2;

    @BeforeAll
    public static void setUp() {
        movie = new Movie("Avatar", 0);
        movie2 = new Movie("Avatar 2", 1);
    }

    @Test
    void getPriceCode() {
        Assertions.assertEquals(0, movie.getPriceCode());
        Assertions.assertEquals(1, movie2.getPriceCode());
    }

    @Test
    void getTitle() {
        Assertions.assertEquals("Avatar", movie.getTitle());
        Assertions.assertEquals("Avatar 2", movie2.getTitle());
    }
}