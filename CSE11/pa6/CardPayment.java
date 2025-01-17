///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:              CardPayment
// Files:              CardPayment.java
// Quarter:            CSE 11, Fall Quarter 2024
//
// Author:             Maxime Vergnet
// Email:              mvergnet@ucsd.edu
// Instructor's Name:  Paul Cao
//
///////////////////////////////////////////////////////////////////////////////

/**
 * Subclass of payment. Holds methods to specific card payment methods.
 *
 * @author Maxime Vergnet
 */
public class CardPayment extends Payment {
    private String cardNumber;
    private int expiryMonth;
    private int expiryYear;

    private static final String HIGH_LEVEL_TYPE = "CardPayment";
    private static final String TYPE = "Untyped CardPayment";

    /**
     * No arguments constructor of the CardPayment class
     */ 
    public CardPayment() {}

    /**
     * Constructor which assigns the parameter to the instance variables
     * 
     * @param transactionName name of the transaction
     * @param amount of the transaction
     * @param timestamp When the transaction was made
     * @param cardNumber the card number
     * @param expiryMonth the month that the card expires
     * @param expiryYear The year that the card expires
     */ 
    public CardPayment(String transactionName, double amount,
                             String timestamp, String cardNumber,
                             int expiryMonth, int expiryYear) {
        super(transactionName, amount, timestamp);
        this.cardNumber = cardNumber;
        this.expiryMonth = expiryMonth;
        this.expiryYear = expiryYear;

    }

    /**
     * The number associated with the card 
     * 
     * @return the card number
     */ 
    @Override
    public String getCardNumber() {
        return cardNumber;
    }

    /**
     * The month that the card expires
     * 
     * @return expiry month
     */ 
    @Override
    public int getExpiryMonth() {
        return expiryMonth;
    }

    /**
     * The year that the card expires
     * 
     * @return expiry year
     */ 
    @Override
    public int getExpiryYear() {
        return expiryYear;
    }

    /**
     * This class has a high level type of card payment
     * 
     * @return the high level type of the payment
     */ 
    @Override
    public String getHighLevelType() {
        return HIGH_LEVEL_TYPE;
    }

    /**
     * Gets the type of payment that is below card payment 
     * 
     * @return the type of payment
     */
    @Override
    public String getType() {
        return TYPE;
    }

    /**
     * Deep comparison between the two payment objects
     * 
     * @param object the inputted payment object
     * 
     * @return True if the values of the object are equal. False if otherwise
     */ 
    @Override
    public boolean equals(Object object) {
        if (object == null) return false;
        
        CardPayment cardPayment = (CardPayment) object;

        boolean superEquals = super.equals(cardPayment);
        boolean cardNumberEqual = this.cardNumber
                                    .equals(cardPayment.getCardNumber());
        boolean expiryMonthEqual = this.expiryMonth == 
                                    cardPayment.getExpiryMonth();
        boolean expiryYearEqual = this.expiryYear == 
                                    cardPayment.getExpiryYear();
        return superEquals && cardNumberEqual && expiryMonthEqual && 
                                                            expiryYearEqual;
    }

    /**
     * Nicely formats the CardPayment object
     * 
     * @return string of the formatted information
     */ 
    @Override
    public String toString() {
        return "CardPayment (" + getTransactionName() +
            ") cardNumber: " + getCardNumber() + ", expiryMonth: " +
                getExpiryMonth() + ", expiryYear: " + getExpiryYear();
    }
}
