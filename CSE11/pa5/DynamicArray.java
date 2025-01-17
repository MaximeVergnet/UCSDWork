///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:              DynamicArray
// Files:              DynamicArray.java
// Quarter:            CSE 11, Fall Quarter 2024
//
// Author:             Maxime Vergnet
// Email:              mvergnet@ucsd.edu
// Instructor's Name:  Paul Cao
//
///////////////////////////////////////////////////////////////////////////////


/**
 * Creates a dynamic array which holds Post objects. Holds methods to ensure
 * the array is dynamic
 *
 * @author Maxime Vergnet
 */
public class DynamicArray {

    // constant variables for DynamicArray
    private static final int DEFAULT_CAPACITY = 5;
    private static final int DOUBLE = 2;
    // Instance variables for DynamicArray
    private Post[] data;
    private int size;

    /**
     * Constructor for the class dynamic array. If the initial capacity
     * is 0, the initial length of the array will default to 5
     * 
     * @param initialCapacity the initial capacity of the array
     */
    public DynamicArray(int initialCapacity) {
        if (initialCapacity == 0){
            data = new Post[DEFAULT_CAPACITY];
        }else{
            data = new Post[initialCapacity];
        }
        size = 0;
    }

    /**
     * Adds a post object to the dynamic array. If the capacity of the array
     * is full, it will double the capcity then append it
     * 
     * @param post the post object which will be appended
     */
    public void append(Post post) {
        if(post == null) return;
        int length = data.length;
        if(size >= length){
            Post[] arrPosts = new Post[length * DOUBLE];
            for(int i = 0; i < length; ++i){
                arrPosts[i] = data[i];
            }
            data = arrPosts;
        }
        data[size] = post;
        ++size;
    }

    /**
     * Removes a post object at the specified index and returns the removed 
     * post. Shifts all elements to ensure there are no null spaces
     * 
     * @param index to be removed
     * 
     * @return the post object which was removed
     */
    public Post remove(int index) {
        if(index < 0 || index >= size) return null;
        Post temPost = data[index];

        for(int i = index; i < size; ++i){
            if(i+1 == size){
                data[i] = null;
                break;
            }else{
                data[i] = data[i+1];
            }
        }
        --size;
        return temPost;
    }

    /**
     * Gets the post object at the specified index
     * 
     * @param index the specified index to fetch the post
     * 
     * @return the post object at the index
     */
    public Post get(int index) {
        if(index < 0 || index >= size) return null;
        return data[index];
    }

    /**
     * Gets how many elements are in the dynamic array
     * 
     * @return size of the dynamic array
     */
    public int size() {
        return size;
    }

    /**
     * Gets the full capacity of the array
     * 
     * @return the capacity of the array
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * Creates and uses test cases for the above methods
     * 
     * @return a boolean of whether the tests passed
     */
    @SuppressWarnings("checkstyle:MagicNumber") // DO NOT CHANGE THIS LINE!!!
    public static boolean unitTests() { 
        // example test case: tests correctness of constructor
        DynamicArray array = new DynamicArray(5);
        if (array.data.length != 5 || array.size != 0) {
            return false;
        }

        array = new DynamicArray(0);
        Post newPost = new Post("Maxime", "Help",
                         "I need help testing", false);
        array.append(newPost);
        if(!array.get(0).equals(newPost)){
            return false;
        }
         
        if(!array.remove(0).equals(newPost)){
            return false;
        }

        if(array.size() != 0){
            return false;
        }

        return true;
    }

    /**
     * Main method to run the tests for the DynamicArray class
     * 
     * @param args the input parameters 
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
