package game;

import heroes.Hero;

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
 * @author Jesse Burdick-Pless jb4411@g.rit.edu
 */
public class HeroStorm {
    HeroParty dragons;
    HeroParty lions;
    int roundNum;
    Team firstMove;
    Hero first;
    Hero second;

    /**
     * Create the parties and initialize the round counter.
     *
     * @param dragonSeed the seed for the dragon random number generator
     * @param lionSeed the seed for the lion random number generator
     */
    public HeroStorm(int dragonSeed, int lionSeed) {
        this.dragons = new HeroParty(Team.DRAGON, dragonSeed);
        this.lions = new HeroParty(Team.LION, lionSeed);
        this.roundNum = 1;
        this.firstMove = Team.DRAGON;
    }

    /**
     * The game is played in battle rounds. A round is one attack between the
     * "front" heroes of the two teams who are temporarily removed from the
     * party. The first hero to attack alternates by round, starting with Team
     * Dragon. If the hero who is attacked is not defeated, they can attack the
     * first hero back. Afterwards each non-defeated hero is added to the back
     * of their party. Defeated heroes merely "disappear" with a farewell
     * message about having fallen. The rounds continue until one of the teams
     * has all of their members defeated. The other team is declared the
     * winner. There is no interaction by the user in this game.
     */
    public void play() {
        while (this.dragons.numHeroes() > 0 && this.lions.numHeroes() > 0) {
            //battle info
            System.out.println("Battle #" + roundNum + "\n==========");
            System.out.println(this.dragons.toString());
            System.out.println(this.lions.toString());
            if (this.firstMove == Team.DRAGON) {
                this.first = this.dragons.removeHero();
                this.second = this.lions.removeHero();
            } else {
                this.first = this.lions.removeHero();
                this.second = this.dragons.removeHero();
            }
            System.out.println("*** " + this.first.getName() + " vs " + this.second.getName());

            //battle
            this.first.attack(second);
            if (this.second.hasFallen()) {
                System.out.println(second.getName() + " has fallen!");
            } else {
                this.second.attack(first);
                if (this.first.hasFallen()) {
                    System.out.println(first.getName() + " has fallen!");
                }
            }
            //re-add hero(s)
            if (!first.hasFallen()) {
                if (this.firstMove == Team.DRAGON) {
                    this.dragons.addHero(first);
                } else {
                    this.lions.addHero(first);
                }
            }
            if (!second.hasFallen()) {
                if (this.firstMove == Team.DRAGON) {
                    this.lions.addHero(second);
                } else {
                    this.dragons.addHero(second);
                }
            }
        }
        if (this.dragons.numHeroes() == 0) {
            System.out.println("Team Lion wins!");
        } else {
            System.out.println("Team Dragon wins!");
        }
    }

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
			HeroStorm game = new HeroStorm(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
			game.play();
        }
    }
}

