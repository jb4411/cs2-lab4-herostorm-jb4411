package game;

/**
 * The main class for the RPG game, Super Fantasy Hero Storm.  This class
 * deals with the main game playing.  The program is run on the command line
 * as:<br>
 * <br>
 *     $ java HeroStorm dragon_seed_# lion_seed_#<br>
 * <br>
 * Here, the seeds are two integers used to seed the random number generators
 * when shuffling the two teams of 3 heroes.
 *
 * @author RIT CS
 * @author YOUR NAME HERE
 */
public class HeroStorm {
    /**
     * The main method.  It checks the number of command line arguments,
     * then creates and plays the game.
     *
     * @param args the command line arguments, two integers for the dragon
     *             and lion random number generator seeds
     */
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java HeroStorm dragon# lion#");
        } else {
			// TODO
        }
    }
}

