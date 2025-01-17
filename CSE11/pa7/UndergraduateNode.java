
//TODO file and class header

import java.io.File;
import java.io.PrintWriter;

///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:              UndergraduateNode
// Files:              UndergraduateNode.java
// Quarter:            CSE 11, Fall Quarter 2024
//
// Author:             Maxime Vergnet
// Email:              mvergnet@ucsd.edu
// Instructor's Name:  Paul Cao
//
///////////////////////////////////////////////////////////////////////////////

public class UndergraduateNode extends StudentNode{
    private String college;
    private boolean isRegentsScholar;

    private static final String TO_FORMAT = "Undergraduate Student\n" + 
                                            "Name:\t%s\n" + 
                                            "Courses:\t%s\n" + 
                                            "College:\t%s\n" +
                                            "Regents:\t%s\n";

    public UndergraduateNode(){
        college = null;
        isRegentsScholar = false;
    }

    public UndergraduateNode(String name, String[] courses, String college,
                                                    boolean isRegentsScholar){
        super(name, courses);
        this.college = college;
        this.isRegentsScholar = isRegentsScholar;
    }

    public String getCollege(){
        return college;
    }

    public void setCollege(String college){
        this.college = college;
    }

    public boolean isRegentsScholar(){
        return isRegentsScholar;
    }

    public void setIsRegentsScholar(boolean regentsScholar){
        isRegentsScholar = regentsScholar;
    }

    @Override
    public boolean equals(Object obj){
        if(obj == null) return false;
        if(!(obj instanceof UndergraduateNode)) return false;
        boolean superEquals = super.equals(obj);

        UndergraduateNode undergraduateNode = (UndergraduateNode) obj;
        if(college == null) return false;
        if(undergraduateNode.getCollege() == null) return false;
        boolean collegeEquals = college.equals(undergraduateNode.getCollege());
        boolean regentsEquals = isRegentsScholar == undergraduateNode
                                                        .isRegentsScholar();
        return superEquals && collegeEquals && regentsEquals;
    }

    @Override
    public String toString(){
        String nameString = super.getName();
        String courseString = "[";
        for(int i = 0; i < super.getCourses().size(); ++i){
            courseString = courseString + super.getCourses().get(i);
            if(i < super.getCourses().size() - 1){
                courseString = courseString + ", ";
            }
        }
        courseString = courseString + "]";
        return String.format(TO_FORMAT, nameString, courseString, college, 
                                                            isRegentsScholar);
    }

    @Override
    public void writeStudentToFile(String fileName) throws Exception{
        try{
            File file = new File(fileName);
            PrintWriter output = new PrintWriter(file);
            if(college == null || college.equals("")){
                output.close();
                throw new Exception("Uninitialized undergraduate student.");
            }
            output.println(toString());
            output.close();
        } catch(Exception e){
            System.out.println(e);
        }
    }
}
