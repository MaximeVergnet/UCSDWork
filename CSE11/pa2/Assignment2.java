///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:              Assignment2
// Files:              Assignment2.java
// Quarter:            CSE 11, Fall Quarter 2024
//
// Author:             Maxime Vergnet
// Email:              mvergnet@ucsd.edu
// Instructor's Name:  Paul Cao
//
///////////////////////////////////////////////////////////////////////////////


import java.util.Scanner; // Import the Scanner class
import java.lang.Math; // Import the Math class


/**
 * A list of methods which perform various calculations and string formatting
 *
 * @author Maxime Vergnet
 */
public class Assignment2 {

    // Feel free to create extra constants if necessary.
    private final static int TWO = 2;
    // Constant used for main
    private final static String PROMPT_MSG_NAME =
            "Please enter your name.";


    /**
     * calculates the surface area of a cylinder
     *
     * @param radius the radius of the cylinder
     * @param height of the cylinder
     * 
     * @return the surface area
     */
    public static double cylinderSurfaceArea(double radius, double height) {
        double surfaceArea = 0;
        double temp = radius + height;
        surfaceArea = TWO * Math.PI * radius * temp;
        return surfaceArea;
    }

    /**
     * calculates the shortest distance between two coordinates
     *
     * @param x1 first x value
     * @param x2 second x value
     * @param y1 first y value
     * @param y2 second y value
     * 
     * @return the shortest distance
     */    
    public static double manhattanDistance(double x1, double x2,
                                            double y1, double y2) {
        double distance = 0;
        distance = Math.abs(x1 - x2) + Math.abs(y1 - y2);
        return distance;
    }

    /**
     * returns the smallest division between a/b and c/d
     *
     * @param a Value for a
     * @param b value for b
     * @param c Value for c
     * @param d Value for d
     * 
     * @return the smallest number between a/b and c/d
     */
    public static double minCorrectDivision(int a, int b, int c, int d) {
        double ans = 0;
        double ab = (double)a/b;
        double cd = (double)c/d;
        ans = Math.min(ab, cd);
        return ans;
    }


    /**
     * takes the substring of num from a to b and concatenates it to the end
     * of num
     * 
     * @param num the string which will be formatted
     * @param a left most distance of substring
     * @param b right most distance of substring
     * 
     * @return the absolute difference between num and the new num
     */
    public static int concatSubIntegers(String num, int a, int b) {
        int ans = 0;
        String temp = num.substring(a, b);
        temp = num + temp;
        int temp2 = Integer.parseInt(temp);
        int temp1 = Integer.parseInt(num);
        
        ans = Math.abs(temp2 - temp1);

        return ans;

    }

  
    /**
     * concatenates word1 and word2, changes the ith and len-ith character 
     * to upper case
     * 
     * @param word1 the first word
     * @param word2 the second word
     * @param i the ith character
     * 
     * @return the concatenation of both words with the capitalizing change
     */
    public static String concatAndModify(String word1, String word2, String i){
        String word3 = word1 + word2;

    
        int j = Integer.parseInt(i);
        int len = word3.length();

        String ith = word3.substring(j, j+1).toUpperCase();
        word3 = word3.substring(0, j) + ith + word3.substring(j+1, 
                                                                          len);

        ith = word3.substring(len - j, len- j + 1).toUpperCase();
        word3 = word3.substring(0, len - j) + ith 
                        + word3.substring(len - j+1, len);

        return word3;
        
    }


    /**
     * replaces the occurence of b with the string c
     * 
     * @param a the initial string
     * @param b the substring to replace
     * @param c the change that needs to be made
     * 
     * @return the final string with the changes applied
     */
    public static String replaceSubstring(String a, String b, String c) {
        String answer = "";
        int index = a.indexOf(b);
        String first = a.substring(0, index);
        String second = a.substring(index+b.length());
        answer = first + c + second;
        return answer;
    }

    /**
     * creates an hourglass shape with 7 rows
     * 
     * @return an hourglass shape with 7 rows made from '*'
     */
    public static String createSideHourglass() {
        String res = "";
        res = 
            "*     *\n**   **\n*** ***\n*******\n*** ***\n**   **\n*     *\n";
        return res;
    }

    /**
     * Provides 3 test cases for each methods listed above
     * 
     * @return a boolean stating whether the test cases passed or not
     */
    @SuppressWarnings("checkstyle:MagicNumber") // DO NOT CHANGE THIS LINE!!!
    public static boolean unitTests() {
        System.out.println();


        
        // Test(s) for cylinderSurfaceArea
        // Test case 1: radius = 3.0, height = 1.0
        double radius = 3.0;
        double height = 1.0;
        String expectedArea = "75.40";
        System.out.println("cylinder surface area Output 1: " +
                                        cylinderSurfaceArea(radius, height));
        if (!String.format("%.2f", cylinderSurfaceArea(radius, height))
                                                    .equals(expectedArea)) {
            System.out.println("FAILED: cylinderSurfaceArea 1");
            return false;
        }

        // Test case 2:
        radius = 1;
        height = 5;
        expectedArea = "37.70";
        System.out.println("cylinder surface area Output 2: " +
                                        cylinderSurfaceArea(radius, height));
        if (!String.format("%.2f", cylinderSurfaceArea(radius, height))
                                                    .equals(expectedArea)) {
            System.out.println("FAILED: cylinderSurfaceArea 2");
            return false;
        }

        // Test case 3: ...
        radius = 50;
        height = 43;
        expectedArea = "29216.81";
        System.out.println("cylinder surface area Output 3: " +
                                        cylinderSurfaceArea(radius, height));
        if (!String.format("%.2f", cylinderSurfaceArea(radius, height))
                                                    .equals(expectedArea)) {
            System.out.println("FAILED: cylinderSurfaceArea 3");
            return false;
        }
        
        System.out.println();
        // Test(s) for manhattanDistance
        double x1 = 2.5;
        double x2 = 5.2;
        double y1 = 3.7;
        double y2 = 7.8;
        String expectedOutput = "6.80";
        System.out.println("manhattanDistance Output 1: " +
                            manhattanDistance(x1, x2, y1, y2));
        String ans = String.format("%.2f",manhattanDistance(x1, x2,
                                                                     y1, y2));
        if (!ans.equals(expectedOutput)) {
            System.out.println("FAILED: manhattanDistance 1");
            return false;
        }

        // Test case 2: ...
        x1 = -8.9;
        x2 = 12.2;
        y1 = 0.0;
        y2 = -16.2;
        expectedOutput = "37.30";
        System.out.println("manhattanDistance Output 2: " +
                            manhattanDistance(x1, x2, y1, y2));
        ans = String.format("%.2f",manhattanDistance(x1, x2, y1, y2));
        if (!ans.equals(expectedOutput)) {
            System.out.println("FAILED: manhattanDistance 2");
            return false;
        }
        
        // Test case 3: ...
        x1 = 9.2;
        x2 = 30.0;
        y1 = 1.5;
        y2 = 80.1;
        expectedOutput = "99.40";
        System.out.println("manhattanDistance Output 3: " +
                            manhattanDistance(x1, x2, y1, y2));
        ans = String.format("%.2f",manhattanDistance(x1, x2, y1, y2));
        if (!ans.equals(expectedOutput)) {
            System.out.println("FAILED: manhattanDistance 3");
            return false;
        }

        System.out.println();
        // Test(s) for minCorrectDivision
        // Test case 1: A = 10, B = 7, C = 2, D = 3
        System.out.println("minCorrectDivision Output 1: " +
                            minCorrectDivision(10, 7, 2, 3));
        expectedOutput = "0.67";
        ans = String.format("%.2f", minCorrectDivision(10, 7, 2,
                                                                         3));
        if (!ans.equals(expectedOutput)) {
            System.out.println("FAILED: minCorrectDivision 1");
            return false;
        }

        // Test case 2: ...
        System.out.println("minCorrectDivision Output 2: " +
                            minCorrectDivision(5, 9, 6, 4));
        expectedOutput = "0.56";
        ans = String.format("%.2f", minCorrectDivision(5, 9, 6,
                                                                         4));
        if (!ans.equals(expectedOutput)) {
            System.out.println("FAILED: minCorrectDivision 2");
            return false;
        }

        // Test case 3: ...
        System.out.println("minCorrectDivision Output 1: " +
                            minCorrectDivision(-1, 6, 0, 5));
        expectedOutput = "-0.17";
        ans = String.format("%.2f", minCorrectDivision(-1, 6, 0,
                                                                         5));
        if (!ans.equals(expectedOutput)) {
            System.out.println("FAILED: minCorrectDivision 1");
            return false;
        }
        System.out.println();
        // Test(s) for concatSubIntegers
        // Test case 1: num = "56910", a = 0, b = 2
        int myAns = concatSubIntegers("56910", 0, 2);
        System.out.println("concatSubIntegers Output 1: " + myAns);
        int expectedCombinedSubIntegers = 5634146;
        if (myAns != expectedCombinedSubIntegers) {
            System.out.println("FAILED: concatSubIntegers 1");
            return false;
        }
        
        // Test case 2: ...
        myAns = concatSubIntegers("1234678", 1, 3);
        System.out.println("concatSubIntegers Output 2: " + myAns);
        expectedCombinedSubIntegers = 122233145;
        if (myAns != expectedCombinedSubIntegers) {
            System.out.println("FAILED: concatSubIntegers 2");
            return false;
        }

        // Test case 3: ...
        myAns = concatSubIntegers("48732", 2, 3);
        System.out.println("concatSubIntegers Output 3: " + myAns);
        expectedCombinedSubIntegers = 438595;
        if (myAns != expectedCombinedSubIntegers) {
            System.out.println("FAILED: concatSubIntegers 3");
            return false;
        }

        System.out.println();
        // Test(s) for concatAndModify
        // Test case 1: word1 = "hello", word2 = "world", i="3"
        String word1 = "hello";
        String word2 = "world";
        String i = "3";
        String expectedCombined = "helLowoRld";
        if (!concatAndModify(word1, word2, i).equals(expectedCombined)) {
            System.out.println("FAILED: concatAndModify 1");
            return false;
        }

        // Test case 2: ...
        word1 = "Maxime";
        word2 = "Vergnet";
        i = "2";
        expectedCombined = "MaXimeVergnEt";
        if (!concatAndModify(word1, word2, i).equals(expectedCombined)) {
            System.out.println("FAILED: concatAndModify 2");
            return false;
        }

        // Test case 3: ...
        word1 = "Ilike";
        word2 = "Pasta";
        i = "1";
        expectedCombined = "ILikePastA";
        if (!concatAndModify(word1, word2, i).equals(expectedCombined)) {
            System.out.println("FAILED: concatAndModify 3");
            return false;
        }


        // Test(s) for replaceSubstring
        String a = "helloworld";
        String b = "world";
        String c = "Sumu";
        expectedOutput = "helloSumu";
        if (!replaceSubstring(a, b, c).equals(expectedOutput)) {
            System.out.println("FAILED: replaceSubstring 1");
            return false;
        }
        // Test case 2: ...
        a = "MaximeVergnet";
        b = "gn";
        c = "abcdefg";
        expectedOutput = "MaximeVerabcdefget";
        if (!replaceSubstring(a, b, c).equals(expectedOutput)) {
            System.out.println("FAILED: replaceSubstring 2");
            return false;
        }

        // Test case 3: ...
        a = "ILikePlainPasta";
        b = "Plain";
        c = "Seasoned";
        expectedOutput = "ILikeSeasonedPasta";
        if (!replaceSubstring(a, b, c).equals(expectedOutput)) {
            System.out.println("FAILED: replaceSubstring 3");
            return false;
        }

        // All test cases passed
        return true;
    }

    /**
     * Runs the methods defined in unitTests and asks the user their name
     * 
     * @param args the arguments
     * 
     */
    public static void main(String[] args) {

        if (unitTests()) {
            System.out.println("All unit tests passed.\n");
        } else {
            System.out.println("ERROR: Failed test.\n");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println(PROMPT_MSG_NAME);

        String answer = scanner.nextLine();
        System.out.println("Hello " + answer 
                            + "! Nice to meet you and welcome to CSE 11!");

        scanner.close();
    }
}