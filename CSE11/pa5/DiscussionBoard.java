///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:              DiscussionBoard
// Files:              DiscussionBoard.java
// Quarter:            CSE 11, Fall Quarter 2024
//
// Author:             Maxime Vergnet
// Email:              mvergnet@ucsd.edu
// Instructor's Name:  Paul Cao
//
///////////////////////////////////////////////////////////////////////////////


/**
 * Holds the dynamic array of all discussion posts for a certain course
 *
 * @author Maxime Vergnet
 */
public class DiscussionBoard {

    // Instance variables for DiscussionBoard
    private String courseName;
    private DynamicArray posts;

    /**
     * Constructor for the discussion board class. Assigns the course name
     * and creates a new DynamicArray
     * 
     * @param courseName name of the course
     * @param boardCapacity the initial capacity of the board 
     */
    public DiscussionBoard(String courseName, int boardCapacity) {
        this.courseName = courseName;
        posts = new DynamicArray(boardCapacity);
    }

    /**
     * Creates a new post and adds it to the dynamic array
     * 
     * @param post the post to be added to the dynamic array
     */
    public void submitPost(Post post) {
        if(post == null) return;
        posts.append(post);
    }

    /**
     * Deletes and returns the post at the specified index
     * 
     * @param index of the post
     * 
     * @return the post which was deleted
     */
    public Post deletePost(int index) {
        if(index < 0 || index >= posts.size()) return null;
        
        return posts.remove(index);
    }

    /**
     * Changes the resolved state of the post at the index to true 
     * 
     * @param index of the post
     * 
     * @return the post with the updated resolved state
     */
    public Post resolvePost(int index) {
        if(index < 0 || index >= posts.size()) return null;
        if(posts.get(index).isResolved()) return null;

        posts.get(index).setResolved(true);

        return posts.get(index);
    }

    /**
     * Counts how many unresolved posts there are in the dynamic array
     * 
     * @return the number of unresolved posts
     */
    public int countUnresolvedPosts() {
        int count = 0;
        for(int i = 0; i < posts.size(); ++i){
            if(!posts.get(i).isResolved()){
                ++count;
            }
        }
        return count;
    }

    /**
     * Determines if a certain author has exceedsed the amount of 
     * posts available
     * 
     * @param author name of the author
     * @param postThreshold the amount of posts an author can make
     * 
     * @return a boolean of wether they have made too many posts
     */
    public boolean exceedsPostThreshold(String author, int postThreshold) {
        int count = 0;
        for(int i = 0; i < posts.size(); ++i){
            if(posts.get(i).getAuthor().equals(author)){
                ++count;
            }
        }
        if(count > postThreshold) return true;
        return false;
    }

    /**
     * Searches and returns a list of all posts with the specific query
     * 
     * @param query the string searched in the posts
     * 
     * @return a new dynamic array with posts that contain the query
     */
    public DynamicArray getQueryMatchingPosts(String query) {
        if (query == null) return null;
        DynamicArray tempDynamicArray = new DynamicArray(0);
        int count = 0;
        for(int i = 0; i < posts.size(); ++i){
            if (posts.get(i).getDetails().contains(query) ||
                posts.get(i).getSummary().contains(query)){
                tempDynamicArray.append(posts.get(i));
                ++count;
            }
        }
        if(count == 0) return null;
        return tempDynamicArray;
    }

    /**
     * Creates and uses test cases for the above methods
     * 
     * @return a boolean of whether the tests passed
     */
    @SuppressWarnings("checkstyle:MagicNumber") // DO NOT CHANGE THIS LINE!!!
    public static boolean unitTests() { 
        // example test case: tests correctness of constructor. Note, this
        // test assumes your implementation of size() and getCapcity() for
        // DynamicArray is correct.
        DiscussionBoard board = new DiscussionBoard("cse 11", 5);
        if (!board.courseName.equals("cse 11") || 
                board.posts.size() != 0 || board.posts.getCapacity() != 5) {
            return false;
        }
        board = new DiscussionBoard(null, 0);
        for(int i = 0; i < 7; ++i){
            board.submitPost(new Post(Integer.toString(i),Integer.toString(i),
                                        Integer.toString(i),false));
        }
        board.resolvePost(4);
        board.submitPost(new Post(Integer.toString(1),Integer.toString(1),
                            Integer.toString(1),true));
        
        if(board.countUnresolvedPosts() != 6){
            return false;
        } 

        if (board.exceedsPostThreshold("1", 2)){
            return false;
        }

        DynamicArray temp = board.getQueryMatchingPosts("1");

        Post query1 = board.posts.get(1);
        Post query2 = board.posts.get(7);

        if(!temp.get(0).equals(query1)){
            return false;
        }

        if(!temp.get(1).equals(query2)){
            return false;
        }

        for(int i = 0; i < temp.size(); ++i){
            System.out.println(temp.get(i).toString());
        }

        return true;
    }

    /**
     * Main method to run the tests for the DiscussionBoard class
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
