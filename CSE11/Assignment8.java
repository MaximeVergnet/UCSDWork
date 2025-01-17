///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:              Assignment8
// Files:              Assignment8, Druid, Gryphon, Monster, MonsterActivities,
//                     Phoenix, Shapeshifter, Undead, Vampire, Werewolf,
//                     Winged, Wraith
// Quarter:            CSE 11, Fall Quarter 2024
//
// Author:             Maxime Vergnet
// Email:              mvergnet@ucsd.edu
// Instructor's Name:  Paul Cao
//
///////////////////////////////////////////////////////////////////////////////

/**
 * Creates and runs tests for the monster game. Contains the runner method
 *
 * @author Maxime Vergnet
 */
public class Assignment8 {
    /**
     * Creates and checks tests for the monster game
     * @return true if all of the tests passed
     */
    @SuppressWarnings("checkstyle:MagicNumber")
    public boolean unitTests(){

        //Test case for reproduce
        Phoenix phoenix1 = new Phoenix(10, 100, 100);
        Monster phoenix2 = new Phoenix(10, 100, 50);
        Monster babyPhoenix = MonsterActivities.reproduce(phoenix1, phoenix2);
        if(babyPhoenix.getAge() != 0) return false;
        if(babyPhoenix.getVitality() != 100) return false;
        if(babyPhoenix.getPower() != 37.5) return false;

        //Test case for strafe
        phoenix1.strafe(babyPhoenix);
        if(phoenix1.getPower() != 112.5) return false;

        //Test case for rest
        phoenix1.rest();
        if(phoenix1.getPower() != 127.5) return false;
        
        //Test case for drain life
        Vampire vampire1 = new Vampire(10, 100, 50);
        int trueCount = 0;
        for(int i = 0; i < 10000; i++){
            if(vampire1.drainLife()) ++trueCount;
        }
        if(trueCount < 3750 || trueCount > 4250) return false;

        //Test case for fight
        Monster vampire = new Vampire(10, 100, 50);
        Monster gryphon = new Gryphon(10, 100, 1);
        int result = MonsterActivities.fight(vampire, gryphon);
        if(result != 1) return false;
        
        return true;
    }
    /**
     * Runner for the monster game
     * @param args the passed in arguments
     */
    public static void main(String[] args){
        Assignment8 runner = new Assignment8();
        if(runner.unitTests()){
            System.out.println("All tests passed");
        }else{
            System.out.println("Unit test failed");
        }
    }
}
