///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:              Payment
// Files:              Payment.java
// Quarter:            CSE 11, Fall Quarter 2024
//
// Author:             Maxime Vergnet
// Email:              mvergnet@ucsd.edu
// Instructor's Name:  Paul Cao
//
///////////////////////////////////////////////////////////////////////////////

/**
 * Superclass for the other payment related classes. Contains basic methods
 * which will get overriden by subclasses
 *
 * @author Maxime Vergnet
 */
public class Payment {
    private String transactionName;
    private double amount;
    private String timestamp;

    private static final String HIGH_LEVEL_TYPE = "Untyped High Level Payment";
    private static final String TYPE = "Untyped Payment";

    /**
     * No-arg constructor of the Payment class
     */
    public Payment() {}

    /**
     * Constructor which sets the parameters to the instance variables
     * 
     * @param transactionName name of the transaction
     * @param amount of the transaction
     * @param timestamp When the transaction was made
     */ 
    public Payment(String transactionName, double amount, String timestamp) {
        this.transactionName = transactionName;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    /**
     * Name linked to the transaction
     * 
     * @return the transaction name
     */ 
    public String getTransactionName() {
        return transactionName;
    }

    /**
     * Amount of money linked to the transaction
     * 
     * @return the amount of the transaction
     */ 
    public double getAmount() {
        return amount;
    }

    /**
     * Time linked to the transaction
     * 
     * @return the time the transaction was made
     */ 
    public String getTimestamp() {
        return timestamp;
    }

    /**
     * Between Electronic Payment or Card Payment
     * 
     * @return the high level type of the payment
     */ 
    public String getHighLevelType() {
        return HIGH_LEVEL_TYPE;
    }

    /**
     * More specific type of payment such as debit, credit, mobile, or digital
     * wallet 
     * 
     * @return the type of payment
     */ 
    public String getType() {
        return TYPE;
    }

    /**
     * Sets the amount of the transaction to the specified amount
     * 
     * @param amount of money
     */ 
    public void setAmount(double amount) {
        this.amount = amount;
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
        if (object == null) {
            return false;
        }
        Payment payment = (Payment) object;
        boolean namesEqual = this.transactionName
                                        .equals(payment.getTransactionName());
        boolean amountsEqual = this.amount == payment.getAmount();
        boolean timestampsEqual = this.timestamp
                                        .equals(payment.getTimestamp());

        return namesEqual && amountsEqual && timestampsEqual;
    }

    /**
     * Nicely formats the payment object
     * 
     * @return string of the formatted information
     */ 
    @Override
    public String toString() {
        return "Payment (" + getTransactionName() +
            ") amount: " + getAmount() + ", timestamp: " + getTimestamp();
    }

    /**
     * Card number of a CardPayment instance
     * @return the String representation of the card number
     */
    public String getCardNumber() {
        return null;
    }

    /**
     * Expiry month of a card of a CardPayment instance
     * @return the month of the card's expiration date
     */
    public int getExpiryMonth() {
        return 0;
    }

    /**
     * Expiry year of a card of a CardPayment instance
     * @return the year of the card's expiration date
     */
    public int getExpiryYear() {
        return 0;
    }

    /**
     * Account ID of an ElectronicPayment instance
     * @return the long representation of the account ID
     */
    public long getAccountId() {
        return 0;
    }

    /**
     * Email address of an ElectronicPayment instance
     * @return the String representation of the email
     */
    public String getEmailAddress() {
        return null;
    }

    /**
     * Bank balance of a bank account linked to a DebitPayment
     * @return the double representation of the bank balance
     */
    public double getBankBalance() {
        return 0;
    }

    /**
     * Credit limit of a card linked to a CreditPayment
     * @return the double representation of the credit limit
     */
    public double getCreditLimit() {
        return 0;
    }

    /**
     * Outstanding balance of a card linked to a CreditPayment
     * @return the double representation of the outstanding balance
     */
    public double getCardBalance() {
        return 0;
    }

    /**
     * Phone number linked to a MobilePayment
     * @return the String representation of the phone number
     */
    public String getPhoneNumber() {
        return null;
    }

    /**
     * From 1 to 5 stars, the star rating of the user of the MobilePayment
     * @return the integer representation of the star rating
     */
    public int getStarRating() {
        return 0;
    }

    /**
     * The digital wallet ID linked to the DigitalWalletPayment
     * @return the String representation of the wallet ID
     */
    public String getWalletId() {
        return null;
    }

    /**
     * The number of previous transactions made by the digital wallet
     * of the DigitalWalletPayment
     * @return the integer representation of the number of previous transactions
     */
    public int getPreviousNumTransactions() {
        return 0;
    }

    /**
     * The risk associated with an instance of a CardPayment
     * @return the risk represented as a double
     */
    public double calculateCardRisk() {
        return 0;
    }

    /**
     * The risk associated with an instance of an ElectronicPayment
     * @return the risk represented as a double
     */
    public double calculateDigitalRisk() {
        return 0;
    }
}
