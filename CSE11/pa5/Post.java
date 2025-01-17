//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:              Post
// Files:              Post.java
// Quarter:            CSE 11, Fall Quarter 2024
//
// Author:             Maxime Vergnet
// Email:              mvergnet@ucsd.edu
// Instructor's Name:  Paul Cao
//
///////////////////////////////////////////////////////////////////////////////


/**
 * Creates a post object which contains all the information about a post and 
 * holds methods to retrieve or set the information about the posts
 *
 * @author Maxime Vergnet
 */
public class Post {

    // Instance variables for Post
    private String author;
    private String summary;
    private String details;
    private boolean resolved;

    // Formatted string for toString()
    private final static String FORMATTED_STRING = "Author:\t%s\n" +
        "Summary:\t%s\n" + "Details:\t%s\n" + "Resolved?:\t%b\n";

    /**
     * Constructor for the class Post. Initializes the instance 
     * variables to null and false
     */
    public Post() {
        author = null;
        summary = null;
        details = null;
        resolved = false;

    }

    /**
     * Second constructor for the class post. Initializes the instance
     * variables to the input parameter
     * 
     * @param author name of the author
     * @param summary summary of the post
     * @param details specific details of the post
     * @param resolved a boolean to determine if the post is resolved
     */
    public Post(String author, String summary, String details, 
            boolean resolved) {
        this.author = author;
        this.summary = summary;
        this.details = details;
        this.resolved = resolved;
    }

    /**
     * Getter method to get the author name 
     * 
     * @return the name of the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Getter method to get the post summary 
     * 
     * @return the summary of the post
     */
    public String getSummary() {
        return summary;
    }

    /**
     * Getter method to get the details of the post 
     * 
     * @return the post details
     */
    public String getDetails() {
        return details;
    }

    /**
     * Getter method to get the resolved state of the post 
     * 
     * @return a boolean for the resolved state of the post
     */
    public boolean isResolved() {
        return resolved;
    }

    /**
     * Sets the author name to the input variable
     * 
     * @param author new name of the author 
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Sets the post summary to the input variable
     * 
     * @param summary new post summary 
     */
    public void setSummary(String summary) {
        this.summary = summary;
    }

    /**
     * Sets the post details to the input variable
     * 
     * @param details new post details 
     */
    public void setDetails(String details) {
        this.details = details;
    }

    /**
     * Changes the resolved state of the post
     * 
     * @param resolved boolean of the resolved state 
     */
    public void setResolved(boolean resolved) {
        this.resolved = resolved;
    }

    /**
     * Prints the post information in a formated way
     * 
     * @return the formatted information
     */
    public String toString() {
        return String.format(FORMATTED_STRING, author, summary, details, 
                                                                resolved);
    }
    
    /**
     * Creates and checks tests for the post class
     * 
     * @return boolean wether the tests passed
     */
    @SuppressWarnings("checkstyle:MagicNumber") // DO NOT CHANGE THIS LINE!!!
    public static boolean unitTests() { 
        // example test case: tests correctness of default constructor. 
        Post post = new Post();
        if (post.author != null || post.summary != null ||
                post.details != null || post.resolved != false) {
            return false;
        }

        post = new Post("Maxime Vergnet", "Help", "I need help", false);
        if(!post.getDetails().equals("I need help")){
            return false;
        }
        post.setDetails("Help is no longer needed");
        post.setResolved(true);
        if(!post.getDetails().equals("Help is no longer needed")){
            return false;
        }
        System.out.println(post.toString());
        if(!post.toString().equals("Author:\tMaxime Vergnet\n" +
            "Summary:\tHelp\n" + "Details:\tHelp is no longer needed\n" 
            + "Resolved?:\ttrue\n")){
            return false;
        }
        return true;
    }

    /**
     * Main method to run the tests for the Post class
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
