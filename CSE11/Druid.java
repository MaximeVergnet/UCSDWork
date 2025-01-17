///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:              Druid
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
 * Subclass of Monster, implements Shapeshifter
 *
 * @author Maxime Vergnet
 */
public class Druid extends Monster implements Shapeshifter{

    private final static double ADD_POWER = 10.0;
    private final static double MAX_INCREASE = 40.0;

    /**
     * No args constructor for the Druid class
     */
    public Druid(){
        super();
    }
    
    /**
     * Constructor for the Druid class. Assigns the parameter to the instance
     * variables
     * @param age The age of the monster
     * @param vitality The remaining health
     * @param power How much damage the monster can do
     */
    public Druid(int age, double vitality, double power){
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
        double randomNum = (Math.random()*(MAX_INCREASE + 1));
        if(randomNum >= MAX_INCREASE) randomNum = MAX_INCREASE;
        setPower(getPower() + randomNum);
    }
    
}
