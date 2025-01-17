///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:              MobilePayment
// Files:              MobilePayment.java
// Quarter:            CSE 11, Fall Quarter 2024
//
// Author:             Maxime Vergnet
// Email:              mvergnet@ucsd.edu
// Instructor's Name:  Paul Cao
//
///////////////////////////////////////////////////////////////////////////////

/**
 * Subclass of the electronic payment class. Holds methods specific to mobile
 * payment
 *
 * @author Maxime Vergnet
 */
public class MobilePayment extends ElectronicPayment {
    private String phoneNumber;
    private int starRating;

    private static final String TYPE = "MobilePayment";

    private static final double MAX_STAR_RATING = 5.0;

    /**
     * No-arg constructor for the MobilePayment class
     */
    public MobilePayment() {}

    /**
     * Constructor which sets the parameters to the instance variables
     * 
     * @param transactionName name of the transaction
     * @param amount of the transaction
     * @param timestamp When the transaction was made
     * @param accountId the number referencing the account
     * @param emailAddress the email address
     * @param phoneNumber the phone number linked to the mobile payment
     * @param starRating the star rating of the transaction
     */ 
    public MobilePayment(String transactionName, double amount,
                                String timestamp, long accountId,
                                String emailAddress, String phoneNumber,
                                int starRating) {
        super(transactionName, amount, timestamp, accountId, emailAddress);
        this.phoneNumber = phoneNumber;
        this.starRating = starRating;
    }

    /**
     * The phone number linked to the mobile payment
     * 
     * @return the phone number
     */
    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * The star rating of the transaction
     * 
     * @return the star rating
     */
    @Override
    public int getStarRating() {
        return starRating;
    }

    /**
     * This class is of type mobile payment
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

        MobilePayment mobilePayment = (MobilePayment) object;

        boolean superEquals = super.equals(mobilePayment);
        boolean phoneNumberEqual = phoneNumber
                                    .equals(mobilePayment.getPhoneNumber());
        boolean starEqual = starRating == mobilePayment.getStarRating();
        return superEquals && phoneNumberEqual && starEqual;
    }

    /**
     * The card risk is the amount / (star rating / the max star rating)
     * 
     * @return the digital payment risk
     */
    @Override
    public double calculateDigitalRisk() {
        return super.getAmount()/(starRating/MAX_STAR_RATING);
    }

    /**
     * Nicely formats the payment object
     * 
     * @return string of the formatted information
     */ 
    @Override
    public String toString() {
        return "MobilePayment (" + getTransactionName() +
            ") phoneNumber: " + getPhoneNumber() + ", starRating: " +
                getStarRating();
    }
}
