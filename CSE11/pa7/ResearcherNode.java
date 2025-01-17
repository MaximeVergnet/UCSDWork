import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:              ResearcherNode
// Files:              ResearcherNode.java
// Quarter:            CSE 11, Fall Quarter 2024
//
// Author:             Maxime Vergnet
// Email:              mvergnet@ucsd.edu
// Instructor's Name:  Paul Cao
//
///////////////////////////////////////////////////////////////////////////////

public class ResearcherNode extends FacultyNode {
    private ArrayList<StudentNode> students;
    private static final String TO_FORMAT = "Researcher Faculty\n" + 
                                            "Name:\t%s\n" +
                                            "Department:\t%s\n" + 
                                            "Students:\n" +
                                            "%s\n";
    private static final int CAPACITY = 10;


    public ResearcherNode(){
        students = new ArrayList<StudentNode>(CAPACITY);
    }

    public ResearcherNode(String name, String department, 
                                                    StudentNode[] students){
        super(name, department);
        this.students = new ArrayList<StudentNode>();
        for(StudentNode x : students){
            this.students.add(x);
        }
    }

    public ArrayList<StudentNode> getStudents(){
        return students;
    }

    public void setStudents(StudentNode[] students){
        this.students = new ArrayList<>();
        for(StudentNode x : students){
            this.students.add(x);
        }
    }

    public boolean appendStudent(StudentNode student){
        if(student == null) return false;
        for(StudentNode x : students){
            if(x.equals(students)){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean equals(Object obj){
        if(obj == null) return false;
        if(!(obj instanceof ResearcherNode)) return false;

        boolean superEquals = super.equals(obj);
        ResearcherNode researcherNode = (ResearcherNode) obj;
        boolean studentEqual = students.equals(researcherNode.getStudents());
        return superEquals && studentEqual;
    }

    @Override
    public String toString(){
        String nameString = super.getName();
        String studentString = "[";
        for(int i = 0; i < getStudents().size(); ++i){
            studentString = studentString + getStudents().get(i);
            if(i < getStudents().size() - 1){
                studentString = studentString + ", ";
            }
        }
        studentString = studentString + "]";
        return String.format(TO_FORMAT, nameString, getDepartment(), 
                                                                studentString);
    }

    @Override
    public void writeFacultyToFile(String fileName) throws Exception{
        try{
            File file = new File(fileName);
            PrintWriter output = new PrintWriter(file);
            if(students == null || students.size() == 0){
                output.close();
                throw new Exception("Uninitialized researcher faculty.");
            }
            output.println(toString());
            output.close();
        } catch(Exception e){
            System.out.println(e);
        }
    }

}
