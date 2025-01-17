import java.io.File;
import java.io.PrintWriter;

///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:              GraduateNode
// Files:              GraduateNode.java
// Quarter:            CSE 11, Fall Quarter 2024
//
// Author:             Maxime Vergnet
// Email:              mvergnet@ucsd.edu
// Instructor's Name:  Paul Cao
//
///////////////////////////////////////////////////////////////////////////////

public class GraduateNode extends StudentNode {

    private String specialization;
    private boolean isNSFFellow;

    private static final String TO_FORMAT = "Graduate Student\n" + 
                                            "Name:\t%s\n" + 
                                            "Courses:\t%s\n" + 
                                            "Specialization:\t%s\n" +
                                            "NSFFellow:\t%s\n";

    public GraduateNode(){
        specialization = null;
        isNSFFellow = false;
    }

    public GraduateNode(String name, String[] courses, String specialization,
                                                        boolean isNSFFellow){
        super(name, courses);
        this.specialization = specialization;
        this.isNSFFellow = isNSFFellow;
    }
    
    public String getSpecialization(){
        return specialization;
    }

    public void setSpecialization(String specialization){
        this.specialization = specialization;
    }

    public boolean isNSFFellow(){
        return isNSFFellow;
    }

    public void setIsNSFFellow(boolean NSFFellow){
        this.isNSFFellow = NSFFellow;
    }

    @Override
    public boolean equals(Object obj){
        if(obj == null) return false;
        if(!(obj instanceof GraduateNode)) return false;

        boolean superEquals = super.equals(obj);
        GraduateNode graduateNode = (GraduateNode) obj;
        if(specialization == null) return false;
        if(graduateNode.getSpecialization() == null) return false;
        boolean specialEqual = specialization
                                    .equals(graduateNode.getSpecialization());
        boolean NSFFEqual = isNSFFellow == graduateNode.isNSFFellow();
        return superEquals && specialEqual && NSFFEqual;
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
        return String.format(TO_FORMAT, nameString, courseString, 
                                                specialization, isNSFFellow);
    }

    @Override
    public void writeStudentToFile(String fileName) throws Exception{
        try{
            File file = new File(fileName);
            PrintWriter output = new PrintWriter(file);
            if(specialization == null || specialization.equals("")){
                output.close();
                throw new Exception("Uninitialized graduate student.");
            }
            output.println(toString());
            output.close();
        } catch(Exception e){
            System.out.println(e);
        }
    }

}
