///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:              Monster
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
 * Super class for the monster classes. Contains basic methods for the monsters
 *
 * @author Maxime Vergnet
 */
public abstract class Monster {
    //Instance variables
    private int age;
    private double vitality;
    private double power;

    /**
     * No args constructor for the Monster class
     */
    public Monster(){
        age = 0;
        vitality = 0;
        power = 0.0;
    }

    /**
     * Constructor for the Monster class. Assigns the parameter to the instance
     * variables
     * @param age The age of the monster
     * @param vitality The remaining health
     * @param power How much damage the monster can do
     */
    public Monster(int age, double vitality, double power){
        this.age = age;
        this.vitality = vitality;
        this.power = power;
    }

    /**
     * The age of the monster
     * @return the age
     */
    public int getAge(){
        return age;
    }

    /**
     * The remaining health of the monster
     * @return the vitality
     */
    public double getVitality(){
        return vitality;
    }

    /**
     * The strength of the monster
     * @return the power
     */
    public double getPower(){
        return power;
    }

    /**
     * Sets the vitality of the monster to the parameter
     * @param vitality the new vitality of the monster
     */
    public void setVitality(double vitality){
        this.vitality = vitality;
    }

    /**
     * Sets the power of the monster to the parameter
     * @param power the new power of the monster
     */
    public void setPower(double power){
        this.power = power;
    }

    /**
     * Checks if the input monster is the same specie as this monster
     * @param monster the monster to be compared
     * @return true if they are the same specie
     */
    public boolean sameSpecies(Monster monster){
        if(monster == null) return false;
        return this.getClass().getName().equals(monster.getClass().getName());
    }

    /**
     * Attacks the input monster based on this monster's power
     * @param monster the monster to be attacked
     * @return the damage that was done to the monster
     */
    public double attack(Monster monster){
        double randomNum = (Math.random()*power) + 1;
        if(randomNum >= power) randomNum = power;
        monster.setVitality(monster.getVitality() - randomNum);
        return randomNum;
    }

    /**
     * Nicely formats the classe's information
     * @return the formatted string
     */
    @Override
    public String toString() {
        return "(" + getClass().getName() + ")" + " age: " + getAge() +
            "; vitality: " + getVitality() + "; power: " + getPower();
    }

    /**
     * The monster rests and gains power
     */
    public abstract void rest();
}
