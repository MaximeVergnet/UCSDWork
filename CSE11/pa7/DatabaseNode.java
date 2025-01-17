///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:              DatabaseNode
// Files:              DatabaseNode.java
// Quarter:            CSE 11, Fall Quarter 2024
//
// Author:             Maxime Vergnet
// Email:              mvergnet@ucsd.edu
// Instructor's Name:  Paul Cao
//
///////////////////////////////////////////////////////////////////////////////

//
// NOTE: YOU SHOULD NOT HAVE TO IMPORT ANY OTHER PACKAGES TO COMPLETE THIS
// ASSIGNMENT.
//
// If you add extraneous packages (intentionally or not), then your
// code might fail Gradescope compilation.
//

/**
 * Highest class of the hierarchy. Contains methods to alter nodes in the 
 * database
 *
 * @author Maxime Vergnet
 */
public abstract class DatabaseNode {
    
    // Constants
    private static final String TO_STRING_FORMAT = "Name:\t%s\n";

    // Instance variables for DatabaseNode
    private String name;
    
    /**
     * No args constructor of the database node class
     */ 
    protected DatabaseNode(){
        // does nothing
    }

    /**
     * Constructor of the database node class. Sets the inputted name to 
     * the instance variable name
     */ 
    protected DatabaseNode(String name){
        this.name = name;
    }
    
    /**
     * Retreives the name of the node
     * 
     * @return name
     */ 
    public String getName(){
        return this.name;
    }

    /**
     * Sets the name of the node to the inputted variable
     * 
     * @param name the new name
     */ 
    public void setName(String name){
        this.name = name;
    }
    
    /**
     * Nicely formats the information of the class 
     * 
     * @return the formatted information
     */ 
    public String toString(){
        return String.format(TO_STRING_FORMAT, this.name);
    }

    /**
     * DescriptionOfMethod
     * 
     * @param 
     * @param 
     * 
     * @return 
     */ 
    public abstract boolean isStudentNode();

    /**
     * DescriptionOfMethod
     * 
     * @param 
     * @param 
     * 
     * @return 
     */ 
    public abstract boolean isFacultyNode();
    
    /**
     * DescriptionOfMethod
     * 
     * @param 
     * @param 
     * 
     * @return 
     */ 
    @Override
    public boolean equals(Object obj){
        if(obj == null) return false;
        if(obj instanceof DatabaseNode == false) return false;
        DatabaseNode databaseNode = (DatabaseNode) obj;
        if(databaseNode.getName() == null) return false;
        if(name == null) return false;
        return name.equals(databaseNode.getName());
    }
}
