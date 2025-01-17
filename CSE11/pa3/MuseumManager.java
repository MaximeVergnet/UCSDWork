///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:              MuseumManager
// Files:              MuseumManager.java
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
 * This class manages the schedule for the museum by creating a day by day
 * schedule and having a method to lookup tours.
 *
 * @author Maxime Vergnet
 */
public class MuseumManager {

    // Feel free to create extra variables if necessary.
    private static final int MIN_DAY_OF_WEEK = 0;
    private static final int MAX_DAY_OF_WEEK = 6;
    private static final int MIN_HOUR_DAY = 0;
    private static final int MAX_HOUR_DAY = 23;
    private static final String PAINTING_SCULPTURE="paintings and sculptures";
    private static final String PHOTO_RELIC = "photographs and relics";
    private static final int MIN_PAINTING_SCULP = 10;
    private static final int MAX_PAINTING_SCULP = 12;
    private static final int MIN_PHOTO_RELIC = 14;
    private static final int MAX_PHOTO_RELIC = 16;
    private static final int EVEN = 2;



    /* Variables used for museumSchedule */
    private static final String BAROQUE = "baroque";
    private static final String IMPRESSIONISM = "impressionism";
    private static final String ROMANTICISM = "romanticism";
    private static final String RENAISSANCE = "renaissance";
    private final static String INVALID_DAY = "Invalid day of the week";
    private final static String HOLIDAY = "Museum is closed due to holiday";
    private final static String EXHIBITS_HEADER = "Today's exhibits:";

    /* Variables used for tourLookup */
    private final static String INVALID_INPUT = "Invalid input provided";
    private final static String NO_TOURS = "No tours scheduled at this time";
    private final static String TOUR_HEADER = "Available tours: ";

    /**
     * Prints out the schedule of the art expositions if the input day is 
     * valid and it is not a holiday
     *
     * @param dayOfWeek What day of the week it is
     * @param isHoliday Boolean to determine if it is a holiday
     */
    public static void museumSchedule(int dayOfWeek, boolean isHoliday){
        if(dayOfWeek >= MIN_DAY_OF_WEEK && dayOfWeek <= MAX_DAY_OF_WEEK){
            if(!isHoliday){//not a holiday
                System.out.println(EXHIBITS_HEADER);
                if(dayOfWeek % EVEN == 0){
                    System.out.println(BAROQUE);
                    System.out.println(IMPRESSIONISM);
                }else{
                    System.out.println(ROMANTICISM);
                    System.out.println(RENAISSANCE);
                }
            }else{
                System.out.println(HOLIDAY);
            }
        }else{
            System.out.println(INVALID_DAY);
        }
    }

    /**
     * if day of the week is between 0 and 6 and hour of the day 
     * is between 0 and 23, it will check if there is a tour at the
     * given hour and return that String
     *
     * @param dayOfWeek What day of the week it is
     * @param hourOfDay What hour of the day is it
     * @return a String with the information of what tours are available
     */
    public static String tourLookup(int dayOfWeek, int hourOfDay){
        if(dayOfWeek < MIN_DAY_OF_WEEK || dayOfWeek > MAX_DAY_OF_WEEK){
            return INVALID_INPUT;
        }
        if(hourOfDay < MIN_HOUR_DAY || hourOfDay > MAX_HOUR_DAY){
            return INVALID_INPUT;
        }
        if(hourOfDay >= MIN_PAINTING_SCULP && hourOfDay <= MAX_PAINTING_SCULP){
            return TOUR_HEADER + PAINTING_SCULPTURE;
        }else if(hourOfDay >= MIN_PHOTO_RELIC && hourOfDay <= MAX_PHOTO_RELIC){
            return TOUR_HEADER + PHOTO_RELIC;
        }
        return NO_TOURS;
    }

    /**
     * Excecutes the functions museumSchedule, and tourLookup and tests to see
     * if they work as intended. Contains 3 test cases per function
     *
     * @return true if all the tests succeed or false if at least one fails
     */    
    @SuppressWarnings("checkstyle:MagicNumber")
    public static boolean unitTests() {
        System.out.println();

        // Test(s) for museumSchedule
        // Test case 1: dayOfWeek = 3, isHoliday = false
        int day1 = 3;
        boolean holiday1 = false;
        String expectedSched1 = "Today's exhibits:\nromanticism\n" +
                "renaissance\n";
        System.out.println("Expected museumSchedule Output 1:\n");
        System.out.println(expectedSched1);
        System.out.println("-----------------");
        System.out.println("museumSchedule Output 1:\n");
        museumSchedule(day1, holiday1);

        // Test case 2: dayOfWeek = 1, isHoliday = true
        day1 = 1;
        holiday1 = true;
        expectedSched1 = "Museum is closed due to holiday";
        System.out.println("Expected museumSchedule Output 2:\n");
        System.out.println(expectedSched1);
        System.out.println("-----------------");
        System.out.println("museumSchedule Output 2:\n");
        museumSchedule(day1, holiday1);

        // Test case 3: dayOfWeek = 7, isHoliday = false
        day1 = 7;
        holiday1 = false;
        expectedSched1 = "Invalid day of the week";
        System.out.println("Expected museumSchedule Output 3:\n");
        System.out.println(expectedSched1);
        System.out.println("-----------------");
        System.out.println("museumSchedule Output 3:\n");
        museumSchedule(day1, holiday1);


        System.out.println();



        // Test(s) for tourLookup
        // Test case 1: dayOfWeek = 5, hourOfDay = 11
        String actualTour1 = tourLookup(5, 11);
        System.out.println("tourLookup Output 1: " + actualTour1);
        if (!actualTour1.equals(
                "Available tours: paintings and sculptures")) {
            System.out.println("FAILED: tourLookup 1");
            return false;
        }

        // Test case 2: dayOfWeek = 0, hourOfDay = 23
        actualTour1 = tourLookup(0, 23);
        System.out.println("tourLookup Output 2: " + actualTour1);
        if (!actualTour1.equals(
                "No tours scheduled at this time")) {
            System.out.println("FAILED: tourLookup 2");
            return false;
        }

        // Test case 3: dayOfWeek = 3, hourOfDay = 24
        actualTour1 = tourLookup(3, 24);
        System.out.println("tourLookup Output 3: " + actualTour1);
        if (!actualTour1.equals(
                "Invalid input provided")) {
            System.out.println("FAILED: tourLookup 3");
            return false;
        }

        // All test cases passed
        return true;
    }

    /**
     * Excecutes the unitTest methods which runs and checks the methods
     * described above. Prints out a success message if all tests are 
     * successful and an error message if at least one fails
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
