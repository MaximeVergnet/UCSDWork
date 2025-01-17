///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:              Vampire
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
 * Subclass of Monster, implements Shapeshifter and Undead
 *
 * @author Maxime Vergnet
 */
public class Vampire extends Monster implements Shapeshifter, Undead{
    private final static double ADD_POWER = 15.0;
    private final static int DOUBLE = 2;
    private final static double FORTY_PERCENT = 0.4;

    /**
     * No args constructor for the Vampire class
     */
    public Vampire(){
        super();
    }
    
    /**
     * Constructor for the Vampire class. Assigns the parameter to the instance
     * variables
     * @param age The age of the monster
     * @param vitality The remaining health
     * @param power How much damage the monster can do
     */
    public Vampire(int age, double vitality, double power){
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
     * Causes the monster to transform and gain power
     */
    @Override
    public void transform(){
        setPower(getPower()*DOUBLE);
    }

    /**
     * Has a probability to drain the oponent's life forces. If it activates,
     * the oponent will die at the end of the match no matter the outcome
     * @return true or false whether the life was drained
     */
    @Override
    public boolean drainLife(){
        double randomNum = Math.random();
        return FORTY_PERCENT > randomNum;
    }
}
