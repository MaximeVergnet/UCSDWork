///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:              FacultyNode
// Files:              FacultyNode.java
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

// TODO: Class Header
public abstract class FacultyNode extends DatabaseNode {
    
    // Constants
    private static final String TO_STRING_FORMAT = "%sDepartment:\t%s\n";
    
    // Instance variables for FacultyNode
    private String department;

    /**
     * DescriptionOfMethod
     * 
     * @param 
     * @param 
     * 
     * @return 
     */ 
    protected FacultyNode(){
        super(null);
        this.department = null;
    }

    /**
     * DescriptionOfMethod
     * 
     * @param 
     * @param 
     * 
     * @return 
     */ 
    protected FacultyNode(String name, String department){
        super(name);
        this.department = department;
    }

    /**
     * DescriptionOfMethod
     * 
     * @param 
     * @param 
     * 
     * @return 
     */ 
    public String getDepartment(){
        return this.department;
    }

    /**
     * DescriptionOfMethod
     * 
     * @param 
     * @param 
     * 
     * @return 
     */ 
    public void setDepartment(String department){
        this.department = department;
    }

    /**
     * Nicely formats the information of the class 
     * 
     * @return the formatted information
     */  
    public String toString(){
        return String.format(TO_STRING_FORMAT, super.toString(), 
            this.department);
    }

    /**
     * DescriptionOfMethod
     * 
     * @param 
     * @param 
     * 
     * @return 
     */ 
    @Override
    public boolean isStudentNode(){
        return !(this instanceof FacultyNode);
    }

    /**
     * DescriptionOfMethod
     * 
     * @param 
     * @param 
     * 
     * @return 
     */ 
    @Override
    public boolean isFacultyNode(){
        return this instanceof FacultyNode;
    }

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
        if(!isFacultyNode()) return false;

        boolean superEquals = super.equals(obj);
        FacultyNode facultyNode = (FacultyNode) obj;
        if(department == null) return false;
        if(facultyNode.getDepartment() == null);
        boolean compareDepartment = facultyNode.getDepartment()
                                                        .equals(department);
        return superEquals && compareDepartment;
    }

    /**
     * DescriptionOfMethod
     * 
     * @param 
     * @param 
     * 
     * @return 
     */ 
    public abstract void writeFacultyToFile(String fileName) throws Exception;
}
