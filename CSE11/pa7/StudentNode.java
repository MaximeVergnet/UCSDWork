import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:              StudentNode
// Files:              StudentNode.java
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
public abstract class StudentNode extends DatabaseNode {
    
    // Constants
    private static final String TO_STRING_FORMAT = "%sCourses:\t%s\n";

    // Instance variables for StudentNode
    private ArrayList<String> courses;

    /**
     * DescriptionOfMethod
     * 
     * @param 
     * @param 
     * 
     * @return 
     */ 
    protected StudentNode(){
        super(null);
        this.courses = new ArrayList<String>();
    }

    /**
     * DescriptionOfMethod
     * 
     * @param 
     * @param 
     * 
     * @return 
     */ 
    protected StudentNode(String name, String[] courses){
        super.setName(name);
        this.courses = new ArrayList<String>();
        for(String x : courses){
            this.courses.add(x);
        }
    }

    /**
     * DescriptionOfMethod
     * 
     * @param 
     * @param 
     * 
     * @return 
     */ 
    public ArrayList<String> getCourses(){
        return this.courses;
    }

    /**
     * DescriptionOfMethod
     * 
     * @param 
     * @param 
     * 
     * @return 
     */ 
    public void setCourses(String[] courses){
        this.courses = new ArrayList<String>();
        for (String course : courses) {
            this.courses.add(course);
        }
    }
   
    /**
     * Nicely formats the information of the class 
     * 
     * @return the formatted information
     */  
    public String toString(){
        return String.format(TO_STRING_FORMAT, super.toString(),
            this.courses.toString()); 
    }

    //TODO: Method Header
    public boolean appendCourse(String course){
        if(course == null) return false;
        for(String x : courses){
            if(x.equals(course)) return false;
        }
        courses.add(course);
        return true;
    }

    //TODO: Method Header
    @Override
    public boolean isStudentNode(){
        return this instanceof StudentNode;
    }

    //TODO: Method Header
    @Override
    public boolean isFacultyNode(){
        return !(this instanceof StudentNode);
    }

    //TODO: Method Header
    @Override
    public boolean equals(Object obj){
        if(obj == null) return false;
        if(!isStudentNode()) return false;
        boolean superEquals = super.equals(obj);
        StudentNode studentNode = (StudentNode) obj;
        boolean compareCourses = studentNode.getCourses().equals(courses);
        return superEquals && compareCourses;
    }

    //TODO: Method Header
    public void updateCoursesFromFile(String fileName) throws Exception{
        try{
            File sourceFile = new File(fileName);
            Scanner scanner = new Scanner(sourceFile);
            scanner.nextLine();
            String[] list = scanner.nextLine().split(", ");
            courses = new ArrayList<String>();
            for(String x : list){
                courses.add(x.trim());
            }
            scanner.close();
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    //TODO: method header
    public abstract void writeStudentToFile(String fileName) throws Exception;
}
