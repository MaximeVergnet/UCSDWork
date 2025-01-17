///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:              Assignment6
// Files:              Assignment6.java
// Quarter:            CSE 11, Fall Quarter 2024
//
// Author:             Maxime Vergnet
// Email:              mvergnet@ucsd.edu
// Instructor's Name:  Paul Cao
//
///////////////////////////////////////////////////////////////////////////////

import java.util.ArrayList;

/**
 * Creates functions to test the all of the payment related classes
 *
 * @author Maxime Vergnet
 */
public class Assignment6 {

    /**
     * Print the payment array in a readable format. Optional to use
     * @param paymentArr An array of Payment instances
     */
    public static void printPaymentArray(Payment[] paymentArr) {
        System.out.println('[');
        for (int i = 0; i < paymentArr.length; i++) {
            System.out.print("  " + paymentArr[i]);
            System.out.println(',');
        }
        System.out.println(']');
    }

    /**
     * Print the payment arraylist in a readable format. Optional to use
     * @param paymentArr An arraylist of Payment instances
     */
    public static void printPaymentArray(ArrayList<Payment> paymentArr) {
        System.out.println('[');
        for (int i = 0; i < paymentArr.size(); i++) {
            System.out.print("  " + paymentArr.get(i));
            System.out.println(',');
        }
        System.out.println(']');
    }

    /**
     * Creates tests for the payment related classes and tests them
     * 
     * @return True if the tests passed. False if otherwise
     */     
    @SuppressWarnings("checkstyle:MagicNumber")
    public static boolean unitTests() {
        // SETUP
        PaymentProcessor proc = new PaymentProcessor();

        // Add payments to a PaymentProcessor object
        MobilePayment m1 = new MobilePayment("Dinner", 10.0, "12/25", 0,
                                        "sumu@ucsd.edu", "4445556666", 4);
        proc.addToPaymentList(m1);
        Payment[] paymentsToAdd = {
            new CreditPayment("Groceries", 42.5, "9/9",
                                "4444 5555 6666 7777", 12, 2025, 1200, 100),
            new DigitalWalletPayment("Forex", 3.0, "4/1", 1,
                                        "sumu@ucsd.edu", "0x0002", 10),
            new DebitPayment("Pharmacy", 4.77, "2/2/2024",
                                "1111 2222 3333 4444", 1, 2027, 4000)
       	};
        proc.addToPaymentList(paymentsToAdd);

        // feel free to add more payments to PaymentProcessor!

        // TEST CASE 1
        // We provide a test case for applyPaymentSurge
        // Save all the original amounts of the payments
        double[] originalPrices = new double[proc.getPaymentList().size()];
        for (int i = 0; i < proc.getPaymentList().size(); i++) {
            originalPrices[i] = proc.getPaymentList().get(i).getAmount();
        }

        // Apply payment increases
        double increaseRate = 1.5;
	    int increaseIndex = proc.applyPaymentSurge(increaseRate);

        // Check paymentList amounts
        for (int i = 0; i < proc.getPaymentList().size(); i++) {
            Payment payment = proc.getPaymentList().get(i);
            if (i != increaseIndex || increaseRate < 1) {
                // Check that the Payment at this index is still the same
                if (payment.getAmount() != originalPrices[i]) {
                    // Payment has changed unexpectedly
                    System.out.println("applyPaymentSurge 1" +
                        " - Payment unexpectedly changed " +
                        "at index: " + i);
                    System.out.println(proc.getPaymentList());
                    return false;
                }
            } else {
                // Check that the Payment has the expected discounted amount
                double actualPrice = originalPrices[i] * increaseRate;
                if (payment.getAmount() != actualPrice) {
                    System.out.println("applyPaymentSurge 1" +
                        " - Payment does not have expected increased amount");
                    System.out.println(payment.getAmount());
                    System.out.println(actualPrice);
                    System.out.println(proc.getPaymentList());
                    return false;
                }
            }
        }
        // TODO: write more test cases HERE!!!!!!

        PaymentProcessor list1 = new PaymentProcessor();
        PaymentProcessor list2 = new PaymentProcessor(); 
        Payment[] payments1 = {
            new MobilePayment("Dinner", 10.0, "12/25", 0,
                                        "sumu@ucsd.edu", "4445556666", 4),
            new CreditPayment("Groceries", 42.5, "9/9",
                                "4444 5555 6666 7777", 12, 2025, 1200, 100),
            new DigitalWalletPayment("Forex", 3.0, "4/1", 1,
                                        "sumu@ucsd.edu", "0x0002", 10),
            new DebitPayment("Pharmacy", 4.77, "2/2/2024",
                                "1111 2222 3333 4444", 1, 2027, 4000)
       	};

        Payment[] payments = {
            new MobilePayment("Dinner", 10.0, "12/25", 0,
                                        "sumu@ucsd.edu", "4445556666", 4),
            new CreditPayment("Groceries", 42.5, "9/9",
                                "4444 5555 6666 7777", 12, 2025, 1200, 100),
            new DigitalWalletPayment("Forex", 3.0, "4/1", 1,
                                        "sumu@ucsd.edu", "0x0002", 10),
            new DebitPayment("Pharmacy", 4.77, "2/2/2024",
                                "1111 2222 3333 4444", 1, 2027, 4000)
       	};
        list2.addToPaymentList(payments);
        list1.addToPaymentList(payments1);

        // Deep equality of list1 and list2
        for(int i = 0; i < list1.getPaymentList().size(); i++){
            if(!list1.getPaymentList().get(i).
                                        equals(list2.getPaymentList().get(i)))
                return false;
        }        

        // TEST CASE 2
        for(Payment x : proc.getPaymentList()){
            if(!PaymentProcessor.processPayment(x)) return false;
        }
        // TEST CASE 3
        if(PaymentProcessor.compareRisk(list1.getPaymentList().get(0), 
                    list1.getPaymentList().get(0)) != 0) return false;

        // TEST CASE 4
        double increase = 2;
        int index = list1.applyPaymentSurge(increase);
        if(list1.getPaymentList().equals(list2.getPaymentList()))
            return false;
        if(list1.getPaymentList().get(index).getAmount() !=
                    list2.getPaymentList().get(index).getAmount() * increase)
            return false;
      
        // Optional: TEST CASE 5

        return true;
    }

    /**
     * Runner for the unitTest method
     * 
     * @param args arguments
     */ 
    public static void main(String[] args) {
        // Perform unitTests
        if(unitTests()) {
            System.out.println("All unit tests passed.\n");
        } else {
            System.out.println("Failed test.\n");
            return;
        }

        // Don't need to write code in main!
    }
}
