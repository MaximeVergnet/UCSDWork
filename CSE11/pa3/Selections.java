///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:              Selection
// Files:              Selection.java
// Quarter:            CSE 11, Fall Quarter 2024
//
// Author:             Maxime Vergnet
// Email:              mvergnet@ucsd.edu
// Instructor's Name:  Paul Cao
//
///////////////////////////////////////////////////////////////////////////////
//
// Persons:          Alexis Vergnet (Brother)
//                   avergnet@ucsd.edu
//                   Went over my coding style to make sure it is in accordance
//                   with the guidelines
//
//////////////////////////// 80 columns wide //////////////////////////////////

/**
 * A list of methods for UCSD to help calculate the cost of appartments,
 * password registration, and the yearly bonuses of professors
 *
 * @author Maxime Vergnet
 */
public class Selections {

    // Feel free to create extra variables if necessary.
    private static double increase = 0;
    private final static int MIN_NUM_BEDROOM = 1;
    private final static double NO_COST = 0.0;
    private final static int COST_OF_ROOM = 100;
    private final static int COST_OF_GARAGE = 75;
    private final static int COST_OF_PATIO = 50;

    /* Variables used for registerPasswordAndSecret */
    private final static int MIN_PASSWORD_LEN = 8;
    private final static int MIN_SECRET_LEN = 1;
    private final static int MAX_SECRET_LEN = 1000;
    private final static String REGISTRATION_ERR_BASE = 
                                        "Password cannot be registered for ";
    private final static String REGISTRATION_SUC_BASE = 
                                        "Password registered for ";

    /* Variables used for calculateYearlyBonus */
    private final static String BELOW_STRONG_RATING = "below strong";
    private final static String STRONG_RATING = "strong";
    private final static double STRONG_MULTIPLIER = 0.10;
    private final static String ABOVE_STRONG_RATING = "above strong";
    private final static double ABOVE_STRONG_MULTIPLIER = 0.15;
    private final static double TENURE_BONUS = 5000.0;
    private static double bonus = 0;


  
    /**
     * calculates the monthly cost of a UCSD appartment based 
     * on its commodities
     *
     * @param baseRent The initial cost of rent
     * @param numBedrooms The number of bedrooms
     * @param hasGarage A boolean of whether it has a garage
     * @param hasPatio A boolean of wether it has a Patio
     * @return the cost of the appartment plus the cost of commodities
     */
    public static double calculateApartmentCost(double baseRent,
            int numBedrooms, boolean hasGarage, boolean hasPatio) {

        if(baseRent < NO_COST){
            return NO_COST;
        }
        if(numBedrooms < MIN_NUM_BEDROOM){
            return NO_COST;
        }
        increase = (numBedrooms - 1) * COST_OF_ROOM;
        if(hasGarage){
            increase += COST_OF_GARAGE;
        }
        if(hasPatio){
            increase += COST_OF_PATIO;
        }
        return baseRent + increase;
    }

    /**
     * Trys to register the password based for username if the password is 
     * greater than 8 characters and secret is between 1 and 1000
     * 
     * @param username of who is trying to register their password
     * @param password to be registered
     * @param secret to be registered
     * @return a message indicating if the registration was successful or not
     */
    public static String registerPasswordAndSecret(String username,
            String password, int secret) {
        int len = password.length();     
        if(len >= MIN_PASSWORD_LEN && secret >= MIN_SECRET_LEN 
                                            && secret <= MAX_SECRET_LEN){
            return REGISTRATION_SUC_BASE + username;
        }    
        return REGISTRATION_ERR_BASE + username;
    }


    /**
     * Calculates the yearly bonus to the salary of the professor based on 
     * their rating and their tenure status
     * 
     * @param salary of the professor
     * @param rating of the professor van be below strong, strong, 
     *               and above strong
     * @param isTenured boolean of whether the professor is tenured
     * @return the bonus to the salary that the professor will receive
     */
    public static double calculateYearlyBonus(int salary, String rating,
            boolean isTenured) {
        if(rating.equals(BELOW_STRONG_RATING)){
            bonus = salary * 0;
        }
        else if(rating.equals(STRONG_RATING)){
            bonus = salary * STRONG_MULTIPLIER;
        }
        else if (rating.equals(ABOVE_STRONG_RATING)){
            bonus = salary * ABOVE_STRONG_MULTIPLIER;
        }
        if(isTenured){
            bonus += TENURE_BONUS;
        }
        return bonus;
    }

    /**
     * Creates and uses test cases for the methods calculateApartmentCost, 
     * registerPasswordAndSecret, and calculateYearlyBonus
     * Creates 3 test cases per method
     * 
     * @return true if all test cases pass and false if at least one fails
     */
    @SuppressWarnings("checkstyle:MagicNumber")    
    public static boolean unitTests() {
        System.out.println();

        // Test(s) for calculateApartmentCost
        // Test case 1: baseRent = 1200, numBedrooms = 2,
        // hasGarage = true, hasPatio = false
        double baseRent1 = 1200;
        int numBedrooms1 = 2;
        boolean hasGarage1 = true;
        boolean hasPatio1 = false;
        double expectedCost1 = 1375.0;
        double actualCost1 = calculateApartmentCost(baseRent1, numBedrooms1,
                hasGarage1, hasPatio1);

        System.out.println("calculateApartmentCost Output 1: " + actualCost1);

        if (actualCost1 != expectedCost1) {
            System.out.println("FAILED: calculateApartmentCost 1");
            return false;
        }

        // Test case 2: baseRent = 1, numBedrooms = 16,
        // hasGarage = false, hasPatio = false
        baseRent1 = 1;
        numBedrooms1 = 16;
        hasGarage1 = false;
        hasPatio1 = false;
        expectedCost1 = 1501;
        actualCost1 = calculateApartmentCost(baseRent1, numBedrooms1,
                hasGarage1, hasPatio1);

        System.out.println("calculateApartmentCost Output 2: " + actualCost1);

        if (actualCost1 != expectedCost1) {
            System.out.println("FAILED: calculateApartmentCost 2");
            return false;
        }

        // Test case 3: baseRent = -500, numBedrooms = 6,
        // hasGarage = true, hasPatio = true        
        baseRent1 = -500;
        numBedrooms1 = 6;
        hasGarage1 = true;
        hasPatio1 = true;
        expectedCost1 = 0.0;
        actualCost1 = calculateApartmentCost(baseRent1, numBedrooms1,
                hasGarage1, hasPatio1);

        System.out.println("calculateApartmentCost Output 3: " + actualCost1);

        if (actualCost1 != expectedCost1) {
            System.out.println("FAILED: calculateApartmentCost 3");
            return false;
        }

        System.out.println();


        // Test(s) for registerPasswordAndSecret
        // Test case 1: username = "Caleb", password = "Frumpkin",
        // secret = 10
        String username1 = "Caleb";
        String password1 = "Frumpkin";
        int secret1 = 10;
        String expectedReg1 = "Password registered for Caleb";
        String actualReg1 = registerPasswordAndSecret(username1,   
                                                        password1, secret1);

        System.out.println("registerPasswordAndSecret Output 1: " 
                                                        + actualReg1);

        if (!actualReg1.equals(expectedReg1)) {
            System.out.println("FAILED: registerPasswordAndSecret 1");
            return false;
        }

        // Test case 2: username = "", password = "Caramel Cookie",
        // secret = 1        
        username1 = "";
        password1 = "Caramel Cookie";
        secret1 = 1;
        expectedReg1 = "Password registered for ";
        actualReg1 = registerPasswordAndSecret(username1, password1, secret1);

        System.out.println("registerPasswordAndSecret Output 2: " 
                                                        + actualReg1);

        if (!actualReg1.equals(expectedReg1)) {
            System.out.println("FAILED: registerPasswordAndSecret 2");
            return false;
        }

        // Test case 3: username = "12345!@#$\n", password = "totem",
        // secret = 1000         
        username1 = "12345!@#$\n";
        password1 = "totem";
        secret1 = 1000;
        expectedReg1 = "Password cannot be registered for 12345!@#$\n";
        actualReg1 = registerPasswordAndSecret(username1, password1, secret1);

        System.out.println("registerPasswordAndSecret Output 3: " 
                                                        + actualReg1);

        if (!actualReg1.equals(expectedReg1)) {
            System.out.println("FAILED: registerPasswordAndSecret 3");
            return false;
        }


        System.out.println();


        // Test(s) for calculateYearlyBonus
        // Test case 1: salary = 150.0, rating = "below strong",
        // isTenured = true
        int salary1 = 100000;
        String rating1 = BELOW_STRONG_RATING;
        boolean isTenured1 = true;
        double expectedBonus1 = 5000.0;
        double actualBonus1 = calculateYearlyBonus(salary1, rating1,
                isTenured1);

        System.out.println("calculateYearlyBonus Output 1: " + actualBonus1);

        if (actualBonus1 != expectedBonus1) {
            System.out.println("FAILED: calculateYearlyBonus 1");
            return false;
        }

        // Test case 2: salary = 500, rating = "strong",
        // isTenured = false
        salary1 = 500;
        rating1 = STRONG_RATING;
        isTenured1 = false;
        expectedBonus1 = 50.0;
        actualBonus1 = calculateYearlyBonus(salary1, rating1,
                isTenured1);

        System.out.println("calculateYearlyBonus Output 1: " + actualBonus1);

        if (actualBonus1 != expectedBonus1) {
            System.out.println("FAILED: calculateYearlyBonus 1");
            return false;
        }

        // Test case 3: salary = 0, rating = "above strong",
        // isTenured = true
        salary1 = 0;
        rating1 = ABOVE_STRONG_RATING;
        isTenured1 = true;
        expectedBonus1 = 5000.0;
        actualBonus1 = calculateYearlyBonus(salary1, rating1,
                isTenured1);

        System.out.println("calculateYearlyBonus Output 3: " + actualBonus1);

        if (actualBonus1 != expectedBonus1) {
            System.out.println("FAILED: calculateYearlyBonus 3");
            return false;
        }
        

        // All test cases passed!
        return true;
    }

    /**
     * Excecutes the method unitTest which is used to run and check the methods
     * created above. Prints out a success message if all tests are successful
     * and an error message if at least one fails
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        if (unitTests()) {
            System.out.println("All unit tests passed.\n");
        } else {
            System.out.println("ERROR: Failed test.\n");
            return;
        }
    }
}
