import java.lang.*;
import java.util.*;

class Customer {
    private String name;
    private Vector rentals = new Vector();

    public Customer (String newname){
        name = newname;
    }

    public void addRental(Rental arg) {
        rentals.addElement(arg);
    }

    public String getName (){
        return name;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration enum_rentals = rentals.elements();
        String completeStatement = "main.Rental Record for " + this.getName() + "\n";
        completeStatement += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

        while (enum_rentals.hasMoreElements()) {
            double thisAmount = 0;
            Rental actualRental = (Rental) enum_rentals.nextElement();
            //determine amounts for each line
            thisAmount = amountFor(actualRental);
            // add frequent renter points
            frequentRenterPoints ++;
            // add bonus for a two day new release rental
            if ((actualRental.getMovie().getPriceCode() == Movie.NEW_RELEASE) && actualRental.getDaysRented() > 1)
                frequentRenterPoints ++;
            //show figures for this rental
            completeStatement += "\t" + actualRental.getMovie().getTitle()+ "\t" + "\t" + actualRental.getDaysRented() + "\t" + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }
        //add footer lines
        completeStatement += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        completeStatement += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return completeStatement;
    }

    private double amountFor(Rental oneRental) {
        double thisAmount = 0;
        switch (oneRental.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                thisAmount += 2;
                if (oneRental.getDaysRented() > 2)
                    thisAmount += (oneRental.getDaysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                thisAmount += oneRental.getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                thisAmount += 1.5;
                if (oneRental.getDaysRented() > 3)
                    thisAmount += (oneRental.getDaysRented() - 3) * 1.5;
                break;
        }
        return thisAmount;
    }

}
    