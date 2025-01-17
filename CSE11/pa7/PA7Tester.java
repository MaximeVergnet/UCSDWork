///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:              PA7Tester
// Files:              PA7Tester.java
// Quarter:            CSE 11, Fall Quarter 2024
//
// Author:             Maxime Vergnet
// Email:              mvergnet@ucsd.edu
// Instructor's Name:  Paul Cao
//
///////////////////////////////////////////////////////////////////////////////

// TODO: Class header
public class PA7Tester {
    
    // TODO: Method header
    @SuppressWarnings("checkstyle:MagicNumber")
    public static boolean unitTests() {
        // TODO: UndergraduateNode Test Cases
        UndergraduateNode undergrad1 = new UndergraduateNode();
        String[] courses = new String[]{"CSE 11", "Math 18", "CHEM 6A", 
                                                                    "COMM 40"};
        UndergraduateNode undergrad2 = new UndergraduateNode("Maxime", courses,
                                                         "7th college", false);
        System.out.println(undergrad1.toString());
        System.out.println(undergrad2.toString());

        if(undergrad1.equals(undergrad2)){
            return false;
        }

        undergrad1 = new UndergraduateNode("Maxime", courses,
                                        "7th college", false);
        if(!undergrad1.equals(undergrad2)){
            return false;
        }
        try{
            undergrad1.writeStudentToFile("underGradFile");
        } catch (Exception e){
            System.out.println(e);
        }

        // TODO: GraduateNode Test Cases
        GraduateNode grad1 = new GraduateNode();
        GraduateNode grad2 = new GraduateNode("Maxime", courses, "7th college",
                                                                     false);
        if(undergrad1.equals(grad2)) return false;
        grad2.setSpecialization("Computer Science");
        if(grad1.equals(grad2)) return false;
        grad1 = new GraduateNode("Maxime", courses, "Computer Science", false);
        if(!grad1.equals(grad2)) return false;

        try{
            grad1.writeStudentToFile("GradFile");
        } catch (Exception e){
            System.out.println(e);
        }

        // TODO: ResearcherNode Test Cases
        StudentNode[] students = new StudentNode[]{grad1, undergrad1};
        ResearcherNode research1 = new ResearcherNode();
        ResearcherNode research2 = new ResearcherNode("Maxime", 
                                                "Computer Science", students);
        if(research1.equals(research2)) return false;
        if(research1.equals(grad1)) return false;
        
        research1 = new ResearcherNode("Maxime", "Computer Science", students);

        if(!research1.equals(research2)) return false;

        try{
            research1.writeFacultyToFile("researchFile");
        } catch (Exception e){
            System.out.println(e);
        }

        return true;
    }
    
    // TODO: Method Header
    public static void main(String[] args) {
        if (unitTests()) {
            System.out.println("All unit tests passed.\n");
        } else {
            System.out.println("Failed test.\n");
            return;
        }

    }
}
