class Movie {
    static final int CHILDRENS = 2;
    static final int REGULAR = 0;
    static final int NEW_RELEASE = 1;
    private String title;
    private Price _priceCode;

    Movie(String newtitle, int priceCode) {
        title = newtitle;
        setPriceCode(priceCode);
    }

    int getPriceCode() {
        return _priceCode.getPriceCode();
    }

    private void setPriceCode(int priceCode) {
        switch (priceCode) {
            case REGULAR:
                _priceCode = new RegularPrice();
                break;
            case CHILDRENS:
                _priceCode = new ChildrensPrice();
                break;
            case NEW_RELEASE:
                _priceCode = new NewReleasePrice();
                break;
            default:
                throw new IllegalArgumentException("Incorrect Price Code");
        }
    }

    String getTitle() {
        return title;
    }

    double getCharge(int daysRented) {
        return _priceCode.getCharge(daysRented);
    }

    int getFrequentRenterPoints(int daysRented) {
        return _priceCode.getFrequentRenterPoints(daysRented);
    }
}