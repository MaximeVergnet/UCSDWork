///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:              Werewolf
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
public class Werewolf extends Monster implements Shapeshifter {

    private final static double ADD_POWER = 15.0;
    private final static double MAX_INCREASE = 25.0;

    /**
     * No args constructor for the Werewolf class
     */
    public Werewolf(){
        super();
    }
    
    /**
     * Constructor for the Werewolf class. Assigns the parameter to the instance
     * variables
     * @param age The age of the monster
     * @param vitality The remaining health
     * @param power How much damage the monster can do
     */
    public Werewolf(int age, double vitality, double power){
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
