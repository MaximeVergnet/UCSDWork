///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:              Undead
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
 * Interface for all Undead monsters
 *
 * @author Maxime Vergnet
 */
public interface Undead {
    /**
     * Has a probability to drain the oponent's life forces. If it activates,
     * the oponent will die at the end of the match no matter the outcome
     * @return true or false whether the life was drained
     */
    public boolean drainLife();
}
