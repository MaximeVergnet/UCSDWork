///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:              ElectronicPayment
// Files:              ElectronicPayment.java
// Quarter:            CSE 11, Fall Quarter 2024
//
// Author:             Maxime Vergnet
// Email:              mvergnet@ucsd.edu
// Instructor's Name:  Paul Cao
//
///////////////////////////////////////////////////////////////////////////////

/**
 * Subclass of payment. Holds methods to specific electronic payment methods.
 *
 * @author Maxime Vergnet
 */
public class ElectronicPayment extends Payment {
    private long accountId;
    private String emailAddress;

    private static final String HIGH_LEVEL_TYPE = "ElectronicPayment";
    private static final String TYPE = "Untyped ElectronicPayment";

    /**
     * No-arg constructor of the ElectronicPayment class
     */
    public ElectronicPayment() {}

    /**
     * Constructor which sets the parameters to the instance variables
     * 
     * @param transactionName name of the transaction
     * @param amount of the transaction
     * @param timestamp When the transaction was made
     * @param accountId the number referencing the account
     * @param emailAddress the email address
     */ 
    public ElectronicPayment(String transactionName, double amount,
                             String timestamp, long accountId,
                             String emailAddress) {
        super(transactionName, amount, timestamp);
        this.accountId = accountId;
        this.emailAddress = emailAddress;
    }

    /**
     * The number referencing the account
     * 
     * @return the account ID
     */
    @Override
    public long getAccountId() {
        return accountId;
    }

    /**
     * The email address linked to the payment
     * 
     * @return the email address
     */
    @Override
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * This class has a high level type of electronic payment
     * 
     * @return the high level type of the payment
     */ 
    @Override
    public String getHighLevelType() {
        return HIGH_LEVEL_TYPE;
    }

    /**
     * Gets the type of payment that is below electronic payment 
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
        if(object == null) return false;

        ElectronicPayment electronicPayment = (ElectronicPayment) object;
        boolean superEquals = super.equals(electronicPayment);
        boolean accountIdEquals = accountId
                                == electronicPayment.getAccountId();
        boolean emailAddressEquals = emailAddress
                                .equals(electronicPayment.getEmailAddress());
        return superEquals && accountIdEquals && emailAddressEquals;
    }

    /**
     * Nicely formats the payment object
     * 
     * @return string of the formatted information
     */ 
    @Override
    public String toString() {
        return "ElectronicPayment (" + getTransactionName() +
            ") accountId: " + getAccountId() + ", emailAddress: " +
                getEmailAddress();
    }

}
