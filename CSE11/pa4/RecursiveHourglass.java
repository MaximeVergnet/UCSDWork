///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:              RecursiveHourglass
// Files:              RecursiveHourglass.java
// Quarter:            CSE 11, Fall Quarter 2024
//
// Author:             Maxime Vergnet
// Email:              mvergnet@ucsd.edu
// Instructor's Name:  Paul Cao
//
///////////////////////////////////////////////////////////////////////////////

/**
 * Holds functions which are used to recurcively create a hourglass in the 
 * terminal
 *
 * @author Maxime Vergnet
 */
public class RecursiveHourglass {

    public static int recursionCallCount = 0; // WARNING: DO NOT MODIFY THIS
    // LINE FOR STAFF TO TEST RECURSIVE CALLS
    // Feel free to add more constants
    private static final int MIRROR_COEFF = 2;

    /**
     * Creates the middle line for the hourglass
     * 
     * @param c the characters used to draw the hourglass
     * @param totalWidth the width of the hourglass
     * 
     * @return A string with totalWidth * characters
     */ 
    private static String getMiddleRow(char c, int totalWidth) {
        // This is the middle row
        return String.valueOf(c).repeat(totalWidth) + '\n';
    }

    /**
     * Creates the other rows for the hourglass shapes by printing the
     * specified charactes with spaces in the middle
     * 
     * @param c the character used to draw the hourglass
     * @param sideWidth the amount of characters on each side
     * @param totalWidth the width of the hourglass
     * 
     * @return A string with sideWidth * characters and spaces in the middle
     */ 
    private static String getOtherRow(char c, int sideWidth, int totalWidth) {
        int spaces = totalWidth - (sideWidth * MIRROR_COEFF);
        return String.valueOf(c).repeat(sideWidth) + " ".repeat(spaces) +
            String.valueOf(c).repeat(sideWidth) + '\n';
    }

    /**
     * Recursively creates an hourglass shape using the two functions above
     * 
     * @param c the character used to draw the hourglass
     * @param sideWidth the amount of characters on each side
     * @param totalWidth the width of the hourglass
     * 
     * @return an hourglass in the terminal
     */ 
    public static String recursiveSideHourglass(char c, int sideWidth,
        int totalWidth) {
        recursionCallCount++; // WARNING: DO NOT MODIFY THIS LINE, FOR STAFF
        // TO TEST RECURSIVE CALLS
 
        String hGlass = "";

        if (sideWidth == (totalWidth + 1) / MIRROR_COEFF) {
            hGlass = getMiddleRow(c, totalWidth);
        } else {
            hGlass = getOtherRow(c, sideWidth, totalWidth) +
                    recursiveSideHourglass(c, sideWidth + 1, totalWidth) +
                    getOtherRow(c, sideWidth, totalWidth);
        }

        return hGlass;
    }
        
    /**
     * Creates 3 test cases for the hourglass method above
     * 
     * @return a boolean whether the tests passes
     */     
    @SuppressWarnings("checkstyle:MagicNumber") // DO NOT CHANGE THIS LINE!!!
    public static boolean unitTests() {
        // Test Case 1:
        String heightThreeHourglass = "* *\n***\n* *\n";
        if (!recursiveSideHourglass('*', 1, 3).equals(heightThreeHourglass)) {
            return false;
        }

        // Test Case 2:
        String heightOneHourglass = "a\n";
        if (!recursiveSideHourglass('a', 1, 1).equals(heightOneHourglass)) {
            return false;
        }
        // Test Case 3:
        String heightFiveHourglass = "4   4\n44 44\n44444\n44 44\n4   4\n";
        if (!recursiveSideHourglass('4', 1, 5).equals(heightFiveHourglass)) {
            return false;
        }
        return true;
    }
    /**
     * runs the methods above to test and create the hourglass
     * 
     * @param args arguments
     */ 
    @SuppressWarnings("checkstyle:MagicNumber") // DO NOT CHANGE THIS LINE!!!
    public static void main(String[] args) {
        System.out.println(
            RecursiveHourglass.recursiveSideHourglass('/', 1, 5));
        System.out.println(
            RecursiveHourglass.recursiveSideHourglass('@', 1, 7));
        if (unitTests()) {
            System.out.println("All unit tests passed.\n");
        } else {
            System.out.println("ERROR: Failed test.\n");
            return;
        }
    }
}