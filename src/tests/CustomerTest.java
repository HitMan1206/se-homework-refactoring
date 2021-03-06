import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CustomerTest {

    private static Customer customer;
    private static String customerName;

    @BeforeAll
    public static void setUp() {
        customerName = "Pascal";
        customer = new Customer(customerName);

        Movie m1 = new Movie("Fluch der Karibik 1", 0);
        Movie m2 = new Movie("Fluch der Karibik 2", 1);

        Rental r1 = new Rental(m1, 10);
        Rental r2 = new Rental(m2, 18);

        customer.addRental(r1);
        customer.addRental(r2);
    }

    @Test
    void getName() {
        Assertions.assertEquals(customerName, customer.getName());
    }

    @Test
    void statement() {
        String expected = "Rental Record for Pascal\n" +
                "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n" +
                "\t" + "Fluch der Karibik 1" + "\t" + "\t" + "10" + "\t" + "14.0" + "\n" +
                "\t" + "Fluch der Karibik 2" + "\t" + "\t" + "18" + "\t" + "54.0" + "\n" +
                "Amount owed is " + "68.0" + "\n" +
                "You earned " + "3" + " frequent renter points";

        Assertions.assertEquals(expected, customer.statement());
    }

    @Test
    void htmlStatement() {
        String expected = "<H1>Rentals for <EM>Pascal</EM></ H1><P>\n" +
                "Fluch der Karibik 1: 14.0<BR>\n" +
                "Fluch der Karibik 2: 54.0<BR>\n" +
                "<P>You owe <EM>68.0</EM><P>\n" +
                "On this rental you earned <EM>3</EM> frequent renter points<P>";
        Assertions.assertEquals(expected, customer.htmlStatement());

    }
}