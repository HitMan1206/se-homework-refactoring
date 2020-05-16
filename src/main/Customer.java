import java.lang.*;
import java.util.*;

class Customer {
    private String name;
    private Vector _rentals = new Vector();

    Customer (String newname){
        name = newname;
    }

    void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    String getName (){
        return name;
    }

    String statement() {
        Enumeration enum_rentals = _rentals.elements();
        String completeStatement = "main.Rental Record for " + this.getName() + "\n";
        completeStatement += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

        while (enum_rentals.hasMoreElements()) {
            Rental actualRental = (Rental) enum_rentals.nextElement();
            //show figures for this rental
            completeStatement += "\t" + actualRental.getMovie().getTitle()+ "\t" + "\t" + actualRental.getDaysRented() + "\t" + (actualRental.getCharge()) + "\n";
        }
        //add footer lines
        completeStatement += "Amount owed is " + (getTotalCharge()) + "\n";
        completeStatement += "You earned " + (getTotalFrequentRenterPoints()) + " frequent renter points";
        return completeStatement;
    }

    private double getTotalCharge(){
        double totalCharge = 0;
        Enumeration rentals = _rentals.elements();
        while(rentals.hasMoreElements()){
            Rental actualRental = (Rental) rentals.nextElement();
            totalCharge += actualRental.getCharge();
        }
        return totalCharge;
    }

    private int getTotalFrequentRenterPoints(){
        int totalFrequentRenterPoints = 0;
        Enumeration rentals = _rentals.elements();
        while(rentals.hasMoreElements()){
            Rental actualRental = (Rental) rentals.nextElement();
            totalFrequentRenterPoints += actualRental.getFrequentRenterPoints();
        }
        return totalFrequentRenterPoints;
    }
}
    