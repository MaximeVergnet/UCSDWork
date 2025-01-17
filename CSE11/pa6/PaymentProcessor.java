///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:              PaymentProcessor
// Files:              PaymentProcessor.java
// Quarter:            CSE 11, Fall Quarter 2024
//
// Author:             Maxime Vergnet
// Email:              mvergnet@ucsd.edu
// Instructor's Name:  Paul Cao
//
///////////////////////////////////////////////////////////////////////////////
import java.util.ArrayList;

/**
 * Stores the payment class in an arraylist and contains functions to process
 * the payments
 *
 * @author Maxime Vergnet
 */
public class PaymentProcessor {
    private ArrayList<Payment> paymentList;

    private static final int MAX_EXPIRY_MONTH = 12;
    private static final int MIN_EXPIRY_YEAR = 2025;
    private static final int MAX_STARS = 5;
    private static final String UCSD_EMAIL = "@ucsd.edu";
    private static final int EMAIL_LENGTH = 9;
    private static final String CARD_PAYMENT = "CardPayment";
    private static final String ELECTRONIC_PAYMENT = "ElectronicPayment";
    private static final String DEBIT_PAYMENT = "DebitPayment";
    private static final String CREDIT_PAYMENT = "CreditPayment";
    private static final String MOBILE_PAYMENT = "MobilePayment";
    private static final String DIGITAL_WALLET_PAYMENT = "DigitalWalletPayment";

    /**
     * Constructor for PaymentProcessor
     */ 
    public PaymentProcessor() {
        paymentList = new ArrayList<Payment>();
    }

    /**
     * Adds a payment object to the arrayList
     * 
     * @param payment a payment object
     */ 
    public void addToPaymentList(Payment payment) {
        paymentList.add(payment);
    }

    /**
     * Adds an array of payments to the arrayList
     * 
     * @param payments a list of payments
     */ 
    public void addToPaymentList(Payment[] payments) {
        for(Payment x : payments){
            paymentList.add(x);
        }
    }

    /**
     * Checks if the inputed transaction name matches any transaction names in
     * the arrayList of payments
     * 
     * @param paymentTransactionName name of the transaction that is checked
     * 
     * @return True if the name was found. False if otherwise
     */ 
    public boolean hasPayment(String paymentTransactionName) {
        for(Payment x : paymentList){
            if(x.getTransactionName().equals(paymentTransactionName)){
                return true;
            }
        }
        return false;
    }

    /**
     * Finds and removes the first occurence of the of the transaction name in
     * the arraylist
     * 
     * @param paymentTransactionName Name of the transaction
     * 
     * @return payment object which was removed
     */ 
    public Payment getAndRemovePayment(String paymentTransactionName) {
        for(Payment x : paymentList){
            if(x.getTransactionName().equals(paymentTransactionName)){
                paymentList.remove(x);
                return x;
            }
        }
        return null;
    }

    /**
     * Compares the risk of a purchase between payments between two transaction
     * 
     * @param paymentOne the first payment
     * @param paymentTwo the second payment
     * 
     * @return a -1 if the risk of 1 is less than 2. 0 if they are the same
     * and 1 if the risk of 1 is greater than the risk of 2
     */ 
    public static int compareRisk(Payment paymentOne, Payment paymentTwo) {
        double value1 = 0.0;
        double value2 = 0.0;
        if(paymentOne.getHighLevelType().equals(CARD_PAYMENT)){
            value1 = paymentOne.calculateCardRisk();
        }else{
            value1 = paymentOne.calculateDigitalRisk();
        }
        if(paymentTwo.getHighLevelType().equals(CARD_PAYMENT)){
            value2 = paymentTwo.calculateCardRisk();
        }else{
            value2 = paymentTwo.calculateDigitalRisk();
        }

        if(value1 < value2) return -1;
        if(value1 == value2) return 0;
        return 1;
    }

    /**
     * Picks a random payment in the arrayList and multiplies it by the 
     * increase rate
     * 
     * @param increaseRate the rate at which the chosen amount is increased
     * 
     * @return the index of the chosen payment
     */ 
    public int applyPaymentSurge(double increaseRate) {
        int index = (int)(Math.random() * paymentList.size());
        if(increaseRate < 1) return index;
        double newProduct = paymentList.get(index).getAmount() * increaseRate;
        paymentList.get(index).setAmount(newProduct);
        return index;
    }

    /**
     * Checks if the payment is valid by checking if its values are within a 
     * specific scope
     * 
     * @param payment The inputed payment object
     * 
     * @return True if all of the tests passed. False if otherwise
     */ 
    public static boolean processPayment(Payment payment) {
        if(payment.getAmount() < 0) return false;

        if(payment.getHighLevelType().equals(CARD_PAYMENT)){
            int month = payment.getExpiryMonth();
            if(month < 1 || month > MAX_EXPIRY_MONTH) return false;
            int year = payment.getExpiryYear();
            if(year < MIN_EXPIRY_YEAR) return false;
        }else if(payment.getHighLevelType().equals(ELECTRONIC_PAYMENT)){
            String email = payment.getEmailAddress();
            if(email.length() < EMAIL_LENGTH) return false;
            if(!email.substring(email.length() - EMAIL_LENGTH, email.length())
                                                        .equals(UCSD_EMAIL)){
                return false;
            }
            if(email.substring(0, email.length() - EMAIL_LENGTH)
                                                        .contains(UCSD_EMAIL)){
                return false;
            }
        }
        if(payment.getType().equals(DEBIT_PAYMENT)){
            if(payment.getBankBalance() < 0) return false;
        }
        else if(payment.getType().equals(CREDIT_PAYMENT)){
            if(payment.getCardBalance() < 0) return false;
            if(payment.getCreditLimit() < 0) return false;
            if(payment.getCreditLimit() < payment.getCardBalance())
                return false;
        }
        else if(payment.getType().equals(MOBILE_PAYMENT)){
            int stars = payment.getStarRating();
            if(stars < 0 || stars > MAX_STARS) return false;
        }
        else if(payment.getType().equals(DIGITAL_WALLET_PAYMENT)){
            if(payment.getPreviousNumTransactions() < 0) return false;
        }
        return true;
    }

    /**
     * The getter method of the paymentList member variable
     * @return the paymentList of the PaymentProcessor instance
     */
    public ArrayList<Payment> getPaymentList() {
        return this.paymentList;
    }
}
