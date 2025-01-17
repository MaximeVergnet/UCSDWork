///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:              Phoenix
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
 * Subclass of Monster, implements Winged
 *
 * @author Maxime Vergnet
 */
public class Phoenix extends Monster implements Winged{

    private static final double ADD_POWER = 15.0;
    private static final int THIRD = 3;

    /**
     * No args constructor for the Phoenix class
     */
    public Phoenix(){
        super();
    }
    
    /**
     * Constructor for the Phoenix class. Assigns the parameter to the instance
     * variables
     * @param age The age of the monster
     * @param vitality The remaining health
     * @param power How much damage the monster can do
     */
    public Phoenix(int age, double vitality, double power){
        super(age, vitality, power);
    }

    /**
     * The monster rests and gains power
     */
    @Override
    public void rest(){
        setPower(getPower() + ADD_POWER);
    }

    /**
     * Eats the monster to take a fraction of its power
     * @param monster the monster that is being eaten
     */
    @Override
    public void strafe(Monster monster){
        setPower(getPower() + monster.getPower()/THIRD);
    }
}
