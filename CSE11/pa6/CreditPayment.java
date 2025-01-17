///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:              CreditPayment
// Files:              CreditPayment.java
// Quarter:            CSE 11, Fall Quarter 2024
//
// Author:             Maxime Vergnet
// Email:              mvergnet@ucsd.edu
// Instructor's Name:  Paul Cao
//
///////////////////////////////////////////////////////////////////////////////

/**
 * Subclass of the card payment class. Holds methods specific to payments using
 * credit
 *
 * @author Maxime Vergnet
 */
public class CreditPayment extends CardPayment {
    private double creditLimit;
    private double cardBalance;

    private static final String TYPE = "CreditPayment";

    /**
     * No-arg constructor of the CreditPayment class
     */
    public CreditPayment() {}

    /**
     * Constructor which assigns the parameter to the instance variables
     * 
     * @param transactionName name of the transaction
     * @param amount of the transaction
     * @param timestamp When the transaction was made
     * @param cardNumber the card number
     * @param expiryMonth the month that the card expires
     * @param expiryYear The year that the card expires
     * @param creditLimit the credit limit
     * @param cardBalance the card balance
     */ 
    public CreditPayment(String transactionName, double amount,
                            String timestamp, String cardNumber,
                            int expiryMonth, int expiryYear,
                            double creditLimit, double cardBalance) {
        super(transactionName, amount, timestamp, cardNumber, expiryMonth, 
                                                                expiryYear);
        this.creditLimit = creditLimit;
        this.cardBalance = cardBalance;
    }

    /**
     * The credit limit on the card
     * 
     * @return the credit limit
     */
    @Override
    public double getCreditLimit() {
        return creditLimit;
    }

    /**
     * The balance on the card
     * 
     * @return the card balance
     */
    @Override
    public double getCardBalance() {
        return cardBalance;
    }

    /**
     * The type is Credit payment
     * 
     * @return payment type
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

        CreditPayment creditPayment = (CreditPayment) object;
        boolean superEquals = super.equals(creditPayment);
        boolean creditEquals = creditLimit == creditPayment.getCreditLimit();
        boolean balanceEquals = cardBalance == creditPayment.getCardBalance();
        return superEquals && creditEquals && balanceEquals;
    }

    /**
     * The card risk is the amount - (credit limit - card balance)
     * 
     * @return the card risk
     */
    @Override
    public double calculateCardRisk() {
        return super.getAmount() - (creditLimit - cardBalance);
    }

    /**
     * Nicely formats the CreditPayment object
     * 
     * @return string of the formatted information
     */ 
    @Override
    public String toString() {
        return "CreditPayment (" + getTransactionName() +
            ") creditLimit: " + getCreditLimit() + ", cardBalance: " +
                getCardBalance();
    }
}
