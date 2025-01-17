///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:              DigitalWalletPayment
// Files:              DigitalWalletPayment.java
// Quarter:            CSE 11, Fall Quarter 2024
//
// Author:             Maxime Vergnet
// Email:              mvergnet@ucsd.edu
// Instructor's Name:  Paul Cao
//
///////////////////////////////////////////////////////////////////////////////

/**
 * Subclass of the electronic payment class. Holds methods specific to digital
 * wallet payment
 *
 * @author Maxime Vergnet
 */
public class DigitalWalletPayment extends ElectronicPayment {
    private String walletId;
    private int previousNumTransactions;

    private static final String TYPE = "DigitalWalletPayment";

    /**
     * No-arg constructor of the DigitalWalletPayment class
     */
    public DigitalWalletPayment() {}

    /**
     * Constructor which sets the parameters to the instance variables
     * 
     * @param transactionName name of the transaction
     * @param amount of the transaction
     * @param timestamp When the transaction was made
     * @param accountId the number referencing the account
     * @param emailAddress the email address
     * @param walletId the identification string of the wallet
     * @param previousNumTransactions the number of previous transaction
     */ 
    public DigitalWalletPayment(String transactionName, double amount,
                                String timestamp, long accountId,
                                String emailAddress, String walletId,
                                int previousNumTransactions) {
        super(transactionName, amount, timestamp, accountId, emailAddress);
        this.walletId = walletId;
        this.previousNumTransactions = previousNumTransactions;
    }

    /**
     * The identification string of the wallet
     * 
     * @return the wallet ID
     */
    @Override
    public String getWalletId() {
        return walletId;
    }

    /**
     * The number of previous transaction
     * 
     * @return the previous transaction number
     */
    @Override
    public int getPreviousNumTransactions() {
        return previousNumTransactions;
    }

    /**
     * This class is of type digital wallet
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

        DigitalWalletPayment digital = (DigitalWalletPayment) object;

        boolean superEquals = super.equals(digital);
        boolean walletIdEqual = walletId
                                    .equals(digital.getWalletId());
        boolean previousTransacEquals = previousNumTransactions 
                                    == digital.getPreviousNumTransactions();
        return superEquals && walletIdEqual && previousTransacEquals;
    }

    /**
     * The card risk is the amount / previous number of transactions
     * 
     * @return the digital payment risk
     */
    @Override
    public double calculateDigitalRisk() {
        return super.getAmount()/previousNumTransactions;
    }

    /**
     * Nicely formats the payment object
     * 
     * @return string of the formatted information
     */ 
    @Override
    public String toString() {
        return "DigitalWalletPayment (" + getTransactionName() +
            ") walletId: " + getWalletId() + ", previousNumTransactions: " +
                getPreviousNumTransactions();
    }
}
