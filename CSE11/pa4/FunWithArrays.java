///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:              FunWithArrays
// Files:              FunWithArrays.java
// Quarter:            CSE 11, Fall Quarter 2024
//
// Author:             Maxime Vergnet
// Email:              mvergnet@ucsd.edu
// Instructor's Name:  Paul Cao
//
///////////////////////////////////////////////////////////////////////////////

import java.util.Arrays;



/**
 * A list of methods which manipulate arrays. Contains a tester method
 * which provides three test cases per function
 *
 * @author Maxime Vergnet
 */
public class FunWithArrays {

    // Feel free to add more constants
    private static final int HALFDIVISOR = 2;
    private static final int TWO = 2;


    /**
     * Finds the shorest unique string in the array
     * 
     * @param array of strings
     * 
     * @return the index of the shortest unique string
     */
    public static int findShortestUniquePosition(String[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }

        String[] black = new String[array.length];
        int index = 0;
        for(int i = 0; i < array.length ; ++i){
            for(int j = i+1; j < array.length; ++j){
                if(array[i].equals(array[j])){
                    black[index] = array[i];
                    index++;
                }
            }
        }
        int temp = 0;
        String temp1 = null;
        for(int i = 0; i < array.length; ++i){//checks for first unique
            int x = 0;
            temp = 0;
            while(black[x] != null){
                if(array[i].equals(black[x])){
                    temp = 1;
                }
                ++x;
            }
            if(temp != 1){
                temp1 = array[i];
                index = i;
                break;
            }    
        }
        if(temp1 == null){//no uniques in array
            return -1;
        }
        int min = temp1.length();
        for(int i = 0; i < array.length; ++i){
            int x = 0;
            temp = 0;
            while(black[x] != null){
                if(array[i].equals(black[x])){
                    temp = 1;
                }
                ++x;
            }
            if(temp != 1){
                if(array[i].length() < min){
                    index = i;
                    min = array[i].length();
                }
            }    
        }
        return index;
    }

    /**
     * Creates a deep copy of the inputted array
     * 
     * @param array of ints
     * 
     * @return new array with the same values as input
     */
    public static int[] arrayCopy(int[] array) {
        if(array == null) return null;
        int[] newArr = new int[array.length];
        
        for(int i = 0; i<array.length; i++){
            newArr[i] = array[i];
        }
        return newArr;
    }

    /**
     * calculates the longes sequence of integeres with alternating sequence
     * which alternates between increasing and decreasing
     * 
     * @param array of ints
     * 
     * @return int which represents the longest alternating sequence
     */    
    public static int maxAlternatingIntegerSequence(int[] array) {
        int len = array.length;
        if(len == 0 || array == null){
            return 0;
        }
        if(array.length == 1) return 1;

        int max = 1;
        int count = 1;
        for(int i = 1; i < len; ++i){
            if((array[i] > array[i-1] && (i == 1 ||
                array[i-1] < array[i-HALFDIVISOR]))||
                (array[i] < array[i-1] && (i == 1 ||
                array[i-1] > array[i-HALFDIVISOR]))){
                count++;
            }else{
                count = TWO;
            }
            if(count > max){
                max = count;
            }   
        }
        return max;
    }

    /**
     * Reverses the values inside the array in place
     * 
     * @param array of strings
     */        
    public static void reverseArray(String[] array) {
        int len = array.length;
        String[] newArr = new String[len];
        for(int i = 0; i<len; i++){
            newArr[i] = array[i];
        }
        int i = len - 1;
        for(String x: newArr){
            array[i] = x;
            i--;
        }
    }

    /**
     * Updates the location array based on the movements array. Wraps the
     * position based on the worldsize
     * 
     * @param locations arrays of locations in the 1D word
     * @param movements arrays of movements to be added to locations
     * @param worldSize size of the world. if movement exceeds, the locations
     *                  will wrap
     *  
     */ 
    public static void updateLocations(int[] locations, int[] movements,
        int worldSize) {
        if(locations == null) return;
        if(movements == null) return;
        if(movements.length != locations.length) return;
        if(worldSize <= 0) return;
        for(int i = 0; i < locations.length; ++i){
            if(locations[i] < 0) return;
            if(locations[i] >= worldSize) return;
        }

        for(int i = 0; i < locations.length; ++i){
            locations[i] = locations[i] + movements[i];
            locations[i] = locations[i]%worldSize;
            if (locations[i] < 0)
                locations[i] += worldSize;
        }

    }

    /**
     * Computes the sum of values on the main diagonal
     * 
     * @param matrix a square matrix
     * 
     * @return the sum of values
     */ 
    public static int sumMainDiagonal(int[][] matrix) {
        if(matrix == null) return -1;
        if(matrix.length == 0) return -1;
        if(matrix.length != matrix[0].length) return -1;
        int sum = 0;
        for(int i = 0; i < matrix.length; ++i){
            sum += matrix[i][i];
        }
        return sum;
    }

    /**
     * Calculates the difference between each input in two matrices, takes the
     * absolute value, and if the value is odd, adds 1
     * 
     * @param matrixOne the first matrix 
     * @param matrixTwo the second matrix
     * 
     * @return a new matrix with the new operations applied
     */ 
    public static int[][] calculateMatrixDifference(int[][] matrixOne,
        int[][] matrixTwo) {
        if(matrixOne == null || matrixTwo == null) return null;
        if(matrixOne.length == 0 || matrixTwo.length == 0) return null;
        if(matrixOne.length != matrixTwo.length) return null;
        if(matrixOne[0].length != matrixTwo[0].length) return null;

        int[][] newMatrix = new int[matrixOne.length][matrixOne[0].length];

        for(int i = 0; i < matrixOne.length; ++i){
            for(int j = 0; j < matrixOne[0].length; j++){
                newMatrix[i][j] = matrixOne[i][j]-matrixTwo[i][j];
                if(newMatrix[i][j] < 0) newMatrix[i][j] *= -1;
                if(newMatrix[i][j] % HALFDIVISOR == 1) newMatrix[i][j] +=1;
            }
        }
        return newMatrix;
    }

    /**
     * Creates and uses 3 test cases per function created above
     * 
     * @return a boolean based on whether all of the test cases succeeded
     */ 
    @SuppressWarnings("checkstyle:MagicNumber") // DO NOT CHANGE THIS LINE!!!
    public static boolean unitTests() {
        // findShortestUniquePosition tests
        // test case 1:
        String[] uniqueStrings = {"cat", "mouse", "bear", "horse", "dog"};
        if (findShortestUniquePosition(uniqueStrings) != 0) {
            System.out.println("findShortestUniquePosition test 1 failed");
            return false;
        }

	    
        String[] uniqueStrings1 = {"aa", "ff", "a", "a", "dd","e"};
        if (findShortestUniquePosition(uniqueStrings1) != 5) {
            System.out.println("findShortestUniquePosition test 2 failed");
            return false;
        }
	    
        String[] uniqueStrings2 = {"a", "a"};
        if (findShortestUniquePosition(uniqueStrings2) != -1) {
            System.out.println("findShortestUniquePosition test 3 failed");
            return false;
        }

        // arrayCopy tests
        // test case 1:
        int[] arrayCopyArray = {1, 2, 3, 4, 5};
        int[] copy = arrayCopy(arrayCopyArray);
        if (copy.length != arrayCopyArray.length) {
            System.out.println("arrayCopy test 1 failed");
            return false;
        }
        for (int i = 0; i < copy.length; i++) {
            if (copy[i] != arrayCopyArray[i]) {
                System.out.println("arrayCopy test 1 failed");
                return false;
            }
        }
        if (copy == arrayCopyArray) {
            System.out.println("arrayCopy test 1 failed");
            return false;
        }

        // test case 2:
        int[] arrayCopyArray1 = {0, 0, 1, 0, 0};
        int[] copy1 = arrayCopy(arrayCopyArray1);
        if (copy1.length != arrayCopyArray.length) {
            System.out.println("arrayCopy test 2 failed");
            return false;
        }
        for (int i = 0; i < copy1.length; i++) {
            if (copy1[i] != arrayCopyArray1[i]) {
                System.out.println("arrayCopy test 2 failed");
                return false;
            }
        }
        if (copy1 == arrayCopyArray1) {
            System.out.println("arrayCopy test 2 failed");
            return false;
        }
        // test case 3:
        int[] arrayCopyArray2 = {};
        int[] copy2 = arrayCopy(arrayCopyArray2);
        if (copy2.length != arrayCopyArray2.length) {
            System.out.println("arrayCopy test 3 failed");
            return false;
        }
        for (int i = 0; i < copy2.length; i++) {
            if (copy2[i] != arrayCopyArray2[i]) {
                System.out.println("arrayCopy test 3 failed");
                return false;
            }
        }
        if (copy2 == arrayCopyArray2) {
            System.out.println("arrayCopy test 3 failed");
            return false;
        }

        // maxAlternatingIntegerSequence tests
        // test case 1:
        int[] maxAlternatingIntegerSequenceArray = {0, 3, 1};
        if (maxAlternatingIntegerSequence(maxAlternatingIntegerSequenceArray)
                                                                        != 3) {
            System.out.println("maxAlternatingIntegerSequence test 1 failed");
            return false;
        }

        // test case 2:
        int[] maxAlternatingIntegerSequenceArray1 = {0, 1, 3};
        if (maxAlternatingIntegerSequence(maxAlternatingIntegerSequenceArray1)
                                                                        != 2) {
            System.out.println("maxAlternatingIntegerSequence test 2 failed");
            return false;
        }
        // test case 3:
        int[] maxAlternatingIntegerSequenceArray2 = {0};
        if (maxAlternatingIntegerSequence(maxAlternatingIntegerSequenceArray2)
                                                                        != 1) {
            System.out.println("maxAlternatingIntegerSequence test 3 failed");
            return false;
        }

        // reverseArray tests
        // test case 1:
        String[] arr2 = {"red", "green", "blue", "purple"};
        String[] reversedArr2 = {"purple", "blue", "green", "red"};
        reverseArray(arr2);
        for (int i = 0; i < arr2.length; i++) {
            if (arr2[i] != reversedArr2[i]) {
                return false;
            }
        }

        // test case 2:
        String[] arr4 = {};
        String[] reversedArr4 = {};
        reverseArray(arr4);
        for (int i = 0; i < arr4.length; i++) {
            if (arr2[i] != reversedArr4[i]) {
                return false;
            }
        }
        // test case 3:
        String[] arr5 = {"red", "green"};
        String[] reversedArr5 = {"green", "red"};
        reverseArray(arr5);
        for (int i = 0; i < arr5.length; i++) {
            if (arr5[i] != reversedArr5[i]) {
                return false;
            }
        }

        // updateLocations tests
        // test case 1:
        int[] locations = {1, 0, 1, 2, 4, 1, 3, 2, 1};
        int[] movements = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int worldSize = 10;
        updateLocations(locations, movements, worldSize);
        int[] newLocations = {2, 2, 4, 6, 9, 7, 0, 0, 0};
        if (!Arrays.equals(locations, newLocations)){
            System.out.println("updateLocations test 1 failed");
            return false;
        }

        // test case 2:
        int[] locations1 = {3, 0, 9};
        int[] movements1 = {-1, -5, -12};
        int worldSize1 = 10;
        updateLocations(locations1, movements1, worldSize1);
        int[] newLocations1 = {2, 5, 7};
        if (!Arrays.equals(locations1, newLocations1)){
            System.out.println("updateLocations test 2 failed");
            return false;
        }
        // test case 3:
        int[] locations2 = {0};
        int[] movements2 = {21};
        int worldSize2 = 10;
        updateLocations(locations2, movements2, worldSize2);
        int[] newLocations2 = {1};
        if (!Arrays.equals(locations2, newLocations2)){
            System.out.println("updateLocations test 3 failed");
            return false;
        }

        // sumMainDiagonal tests
        // test case 1:
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int expectedSum = 15;
        if (sumMainDiagonal(matrix) != expectedSum) {
            System.out.println("sumMainDiagonal test 1 failed");
            return false;
        }

        // test case 2:
        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9},{6,7,8}};
        int expectedSum1 = -1;
        if (sumMainDiagonal(matrix1) != expectedSum1) {
            System.out.println("sumMainDiagonal test 1 failed");
            return false;
        }
        // test case 3:
        int[][] matrix2 = {{}};
        int expectedSum2 = -1;
        if (sumMainDiagonal(matrix2) != expectedSum2) {
            System.out.println("sumMainDiagonal test 1 failed");
            return false;
        }

        // calculateMatrixDifference tests
        // test case 1:
        int [][] calculateMatrixDifferenceInput1 = {{1, 0, 1},
                                                    {2, 4, 1},
                                                    {3, 2, 1}};
        int [][] calculateMatrixDifferenceInput2 = {{1, 2, 5},
                                                    {6, 3, 1},
                                                    {1, 1, 8}};
        int [][] calculateMatrixDifferenceAnswer = {{0, 2, 4},
                                                    {4, 2, 0},
                                                    {2, 2, 8}};
        int[][] calculateMatrixDifferenceActual =
            calculateMatrixDifference(calculateMatrixDifferenceInput1,
                                        calculateMatrixDifferenceInput2);
        if (!Arrays.deepEquals(calculateMatrixDifferenceAnswer,
                                            calculateMatrixDifferenceActual)) {
            System.out.println("calculateMatrixDifference test 1 failed");
            return false;
        }

        // test case 2:
        int [][] calculateMatrixDifferenceInput11 = {{-3, 0, -7}, {4, -6, 1}};
        int [][] calculateMatrixDifferenceInput21 = {{2, 0, -8}, {-5, 6, -1}};
        int [][] calculateMatrixDifferenceAnswer1 = {{6, 0, 2},{10, 12, 2}};
        int[][] calculateMatrixDifferenceActual1 =
            calculateMatrixDifference(calculateMatrixDifferenceInput11,
                                        calculateMatrixDifferenceInput21);
        if (!Arrays.deepEquals(calculateMatrixDifferenceAnswer1,
                                            calculateMatrixDifferenceActual1)) {
            System.out.println("calculateMatrixDifference test 2 failed");
            return false;
        }
        // test case 3:
        int [][] calculateMatrixDifferenceInput12 = {{9}};
        int [][] calculateMatrixDifferenceInput22 = {{5}};
        int [][] calculateMatrixDifferenceAnswer2 = {{4}};
        int[][] calculateMatrixDifferenceActual2 =
            calculateMatrixDifference(calculateMatrixDifferenceInput12,
                                        calculateMatrixDifferenceInput22);
        if (!Arrays.deepEquals(calculateMatrixDifferenceAnswer2,
                                            calculateMatrixDifferenceActual2)) {
            System.out.println("calculateMatrixDifference test 3 failed");
            return false;
        }

        return true;
    }

    /**
     * Runs the entire program to check and test the created functions
     * 
     * @param args arguments
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
