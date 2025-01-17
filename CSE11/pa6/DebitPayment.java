///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:              DebitPayment
// Files:              DebitPayment.java
// Quarter:            CSE 11, Fall Quarter 2024
//
// Author:             Maxime Vergnet
// Email:              mvergnet@ucsd.edu
// Instructor's Name:  Paul Cao
//
///////////////////////////////////////////////////////////////////////////////

/**
 * Subclass of the card payment class. Holds methods specific to payments using
 * debit
 *
 * @author Maxime Vergnet
 */
public class DebitPayment extends CardPayment {
    private double bankBalance;

    private static final String TYPE = "DebitPayment";

    /**
     * No-arg constructor of the DebitPayment class
     */
    public DebitPayment() {}

    /**
     * Constructor which assigns the parameter to the instance variables
     * 
     * @param transactionName name of the transaction
     * @param amount of the transaction
     * @param timestamp When the transaction was made
     * @param cardNumber the card number
     * @param expiryMonth the month that the card expires
     * @param expiryYear The year that the card expires
     * @param bankBalance The amount of money on the card
     */ 
    public DebitPayment(String transactionName, double amount,
                                String timestamp, String cardNumber,
                                int expiryMonth, int expiryYear,
                                double bankBalance) {
        super(transactionName, amount, timestamp, cardNumber, expiryMonth, 
                                                                expiryYear);
        this.bankBalance = bankBalance;
    }

    /**
     * The amount of money on the card
     * 
     * @return the bank balance
     */
    @Override
    public double getBankBalance() {
        return bankBalance;
    }

    /**
     * This class is of type debit
     * 
     * @return the Type of the class
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
        if(object == null) return false;

        DebitPayment debitPayment = (DebitPayment) object;

        boolean superEquals = super.equals(debitPayment);
        boolean bankBalanceEquals = bankBalance == 
                                                debitPayment.getBankBalance();
        return superEquals && bankBalanceEquals;
    }

    /**
     * The card risk is the amount - bank balance
     * 
     * @return the card risk
     */
    @Override
    public double calculateCardRisk() {
        return super.getAmount() - bankBalance;
    }

    /**
     * Nicely formats the payment object
     * 
     * @return string of the formatted information
     */ 
    @Override
    public String toString() {
        return "DebitPayment (" + getTransactionName() +
            ") bankBalance: " + getBankBalance();
    }
}
