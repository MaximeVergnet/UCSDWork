///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:              MonsterActivities
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
 * Contains methods of the actions that the monsters can take
 *
 * @author Maxime Vergnet
 */
public class MonsterActivities {

    // Necessary constants
    private final static int TWO = 2;
    private final static int MIN_AGE = 5;
    private final static int SPACING = 17;
    private final static String LEFT = "Left";
    private final static String RIGHT = "Right";
    private final static int BASE_VITALITY = 100;

    /**
     * No args constructor for the MonsterActivities class
     */
    private MonsterActivities(){

    }

    /**
     * Method for the gameplay. Checks if any of the monsters can drain the
     * life of the others. The monsters then attack each other until one or
     * both are dead. Once the game is over, applies the life drain to the 
     * subjected oponent. Determines who wins and the winner will either strafe
     * or transform
     * @param monster1 the left monster in the fight
     * @param monster2 the right monster in the fight
     * @return 0 if the game is a tie, 1 if monster1 wins and 2 if monster2 won
     */
    public static int fight(Monster monster1, Monster monster2){
        boolean canDrain1 = false;
        boolean canDrain2 = false;
        if(monster1 instanceof Wraith){
            Wraith wraith = (Wraith) monster1;
            canDrain1 = wraith.drainLife();
        }
        else if(monster1 instanceof Vampire){
            Vampire vampire = (Vampire) monster1;
            canDrain1 = vampire.drainLife();
        }
        else if(monster2 instanceof Wraith){
            Wraith wraith = (Wraith) monster2;
            canDrain2 = wraith.drainLife();
        }
        else if(monster2 instanceof Vampire){
            Vampire vampire = (Vampire) monster2;
            canDrain2 = vampire.drainLife();
        }

        int round = 0;
        while(monster1.getVitality() > 0 && monster2.getVitality() > 0){
            printRound(round);
            printBothMonsters(monster1, monster2);
            printAttack(LEFT, monster1.attack(monster2));
            printAttack(RIGHT, monster2.attack(monster1));
            ++round;
        }
        printFinalStats(monster1, monster2, canDrain2 || canDrain1);
        boolean monster1Win = false;
        boolean monster2Win = false;
        if(monster1.getVitality() > 0 && !canDrain2){
            monster1Win = true;
        }
        if(monster2.getVitality() > 0 && !canDrain1){
            monster2Win = true;
        }
        if(!monster1Win && !monster2Win){
            printTieGame();
            return 0;
        }
        if(monster1Win){
            if(monster1 instanceof Wraith){
                Wraith wraith = (Wraith) monster1;
                wraith.strafe(monster2);
            }
            else if(monster1 instanceof Phoenix){
                Phoenix phoenix = (Phoenix) monster1;
                phoenix.strafe(monster2);
            }
            else if(monster1 instanceof Gryphon){
                Gryphon gryphon = (Gryphon) monster1;
                gryphon.strafe(monster2);             
            }
            if(monster1 instanceof Vampire){
                Vampire vampire = (Vampire) monster1;
                vampire.transform();
            }
            else if(monster1 instanceof Druid){
                Druid druid = (Druid) monster1;
                druid.transform();
            }
            else if(monster1 instanceof Werewolf){
                Werewolf werewolf = (Werewolf) monster1;
                werewolf.transform();
            }
            printWinner(LEFT);
            return 1;
        }
        else if(monster2Win){
            if(monster2 instanceof Wraith){
                Wraith wraith = (Wraith) monster2;
                wraith.strafe(monster1);
            }
            else if(monster2 instanceof Phoenix){
                Phoenix phoenix = (Phoenix) monster2;
                phoenix.strafe(monster1);
            }
            else if(monster2 instanceof Gryphon){
                Gryphon gryphon = (Gryphon) monster2;
                gryphon.strafe(monster1);             
            }
            if(monster2 instanceof Vampire){
                Vampire vampire = (Vampire) monster2;
                vampire.transform();
            }
            else if(monster2 instanceof Druid){
                Druid druid = (Druid) monster2;
                druid.transform();
            }
            else if(monster2 instanceof Werewolf){
                Werewolf werewolf = (Werewolf) monster2;
                werewolf.transform();
            }
            printWinner(RIGHT);
            return TWO;
        }
        return -1;
    }

    /**
     * Checks if the monsters are the right age to reproduce and if they are of
     * the same specie. If they are, creates a new baby with half of the
     * average power of the parents
     * @param monster1 the first parent
     * @param monster2 the second parent
     * @return the new baby monster created
     */
    public static Monster reproduce(Monster monster1, Monster monster2){
        if (monster1.getAge() < MIN_AGE || monster2.getAge() < MIN_AGE){
            return null;
        } 
        double avgPower = (monster1.getPower() + monster2.getPower())/TWO;    
        if(monster1 instanceof Wraith && monster2 instanceof Wraith){
            return new Wraith(0, BASE_VITALITY, avgPower/TWO); 
        }
        else if(monster1 instanceof Phoenix && monster2 instanceof Phoenix){
            return new Phoenix(0, BASE_VITALITY, avgPower/TWO);
        }
        else if(monster1 instanceof Gryphon && monster2 instanceof Gryphon){
            return new Gryphon(0, BASE_VITALITY, avgPower/TWO);        
        }
        if(monster1 instanceof Vampire && monster2 instanceof Vampire){
            return new Vampire(0, BASE_VITALITY, avgPower/TWO);
        }
        else if(monster1 instanceof Druid && monster2 instanceof Druid){
            return new Druid(0, BASE_VITALITY, avgPower/TWO);
        }
        else if(monster1 instanceof Werewolf && monster2 instanceof Werewolf){
            return new Werewolf(0, BASE_VITALITY, avgPower/TWO);
        }
        return null;
    }


    /* Below are helper methods to make fight() work */
    /**
     * Use this method in fight() to display the stats of both monsters together
     *
     * @param monster1 Monster on the left side to display stats
     * @param monster2 Monster on the right side to display stats
     */
    public static void printBothMonsters(Monster monster1, Monster monster2) {
        int ageSpacing = calcSpacing(Integer.toString(monster1.getAge()));
        int healthSpacing = calcSpacing(
            String.format("%.2f",monster1.getVitality()));
        int strSpacing = calcSpacing(
            String.format("%.2f",monster1.getPower()));
        int monsterSpacing = calcSpacing(monster1.getClass().getName());
        String str = String.format( "(%s) %s (%s)\n" +
            "----------" + " " + "----------\n" +
            "A: %d %s A: %d\n" +
            "V: %.2f %s V: %.2f\n" +
            "P: %.2f %s P: %.2f\n", monster1.getClass().getName(),
            " ".repeat(monsterSpacing),monster2.getClass().getName(),
            monster1.getAge()," ".repeat(ageSpacing),monster2.getAge(),
            monster1.getVitality(), " ".repeat(healthSpacing),
            monster2.getVitality(), monster1.getPower(),
            " ".repeat(strSpacing), monster2.getPower()
        );
        System.out.println(str);
    }
    /**
     * Helper method for printBothMonsters()
     *
     * @param str String on the left - used to calculate spacing
     * @return An int describing how many spaces to put between strings
     */
    public static int calcSpacing(String str) {
        int totalWidth = SPACING;
        int str1Width = str.length();
        int spacing = (totalWidth - str1Width);
        if (spacing < 0) {
            return 0;
        }
        return spacing;
    }
    /**
     * Use this method in fight() to display the current round.
     * @param round An int of the round (should start at 0)
     */
    public static void printRound(int round) {
        System.out.println();
        System.out.println("Round " + round + ":");
    }
    /**
     * Use this method in fight() to display the damage each round.
     *
     * @param side The side of the Monster that invoked the attack().
     * @param damage The int (damage) returned from an attack() call
     */
    public static void printAttack(String side, double damage) {
        System.out.printf("%s does %.2f damage!\n",side, damage);
    }
    /**
     * Use this method in fight() to display final stats and drain status.
     *
     * @param monster1 Left monster
     * @param monster2 Right monster
     * @param drained If either monster was drained
     */
    public static void printFinalStats(Monster monster1, Monster monster2,
        boolean drained) {
        System.out.println();
        printBothMonsters(monster1, monster2);
        if (drained) {
            System.out.println("An monster was drained.");
        }
    }
    /**
     * Use this method in fight() to display a tie game.
     */
    public static void printTieGame() {
        System.out.println("-------GAME OVER-------");
        System.out.println("TIE: Both monsters died!");
    }
    /**
     * Use this method in fight() to display the winner.
     * @param side The side of the Monster that won.
     */
    public static void printWinner(String side) {
        System.out.println("-------GAME OVER-------");
        System.out.println(side + " monster wins!");
    }
}
