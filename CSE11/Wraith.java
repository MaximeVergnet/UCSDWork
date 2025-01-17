///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:              Wraith
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
 * Subclass of Monster, implements Winged and Undead
 *
 * @author Maxime Vergnet
 */
public class Wraith extends Monster implements Undead, Winged{
    private final static double ADD_POWER = 10.0;
    private final static double FOURTH = 4;
    private final static double TWENTY_PERCENT = 0.4;

    /**
     * No args constructor for the WraithS class
     */
    public Wraith(){
        super();
    }
    
    /**
     * Constructor for the Wraith class. Assigns the parameter to the instance
     * variables
     * @param age The age of the monster
     * @param vitality The remaining health
     * @param power How much damage the monster can do
     */
    public Wraith(int age, double vitality, double power){
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
        setPower(getPower() + monster.getPower()/FOURTH);
    }

    /**
     * Has a probability to drain the oponent's life forces. If it activates,
     * the oponent will die at the end of the match no matter the outcome
     * @return true or false whether the life was drained
     */
    @Override
    public boolean drainLife(){
        double randomNum = Math.random();
        return TWENTY_PERCENT > randomNum;
    }
}
