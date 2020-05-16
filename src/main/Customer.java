import java.lang.*;
import java.util.*;

class Customer {
    private String name;
    private Vector rentals = new Vector();

    Customer (String newname){
        name = newname;
    }

    void addRental(Rental arg) {
        rentals.addElement(arg);
    }

    String getName (){
        return name;
    }

    String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration enum_rentals = rentals.elements();
        String completeStatement = "main.Rental Record for " + this.getName() + "\n";
        completeStatement += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

        while (enum_rentals.hasMoreElements()) {
            Rental actualRental = (Rental) enum_rentals.nextElement();
            frequentRenterPoints += actualRental.getFrequentRenterPoints();
            //show figures for this rental
            completeStatement += "\t" + actualRental.getMovie().getTitle()+ "\t" + "\t" + actualRental.getDaysRented() + "\t" + (actualRental.getCharge()) + "\n";
            totalAmount += actualRental.getCharge();
        }
        //add footer lines
        completeStatement += "Amount owed is " + (totalAmount) + "\n";
        completeStatement += "You earned " + (frequentRenterPoints) + " frequent renter points";
        return completeStatement;
    }
}
    