package game;

import heroes.Hero;
import heroes.Heroes;
import heroes.Party;

import java.util.*;

/**
 * A party is a collection of non-fallen allies that represent a team. The
 * behavior of this collection is FIFO (a queue). The hero at the front of the
 * queue is next up for a battle round. If a hero is not defeated when battling
 * in a round, they will be added to the back of the queue so they may combat
 * again in the future.
 *
 * @author Jesse Burdick-Pless jb4411@g.rit.edu
 */
public class HeroParty implements Party {
    Party party;
    Team team;
    private LinkedList<Hero> heroes;

    /**
     * Create the party. Here we associate the team with the party. We then add
     * the heroes in the following order: Berserker, Healer and Tank. The
     * collection is then shuffled using the random number generator seed
     * value. To shuffle the collection of heroes (assumed to be either an
     * ArrayList or LinkedList):
     *
     * Collections.shuffle(this.heroes, new Random(seed));
     *
     * @param team the team
     * @param seed the random number generator seed
     */
    public HeroParty(Team team, int seed) {
        this.team = team;

        this.heroes = new LinkedList<>();
        this.heroes.add(Hero.create(Heroes.Role.BERSERKER, team, this));
        this.heroes.add(Hero.create(Heroes.Role.HEALER, team, this));
        this.heroes.add(Hero.create(Heroes.Role.TANK, team, this));

        Collections.shuffle(this.heroes, new Random(seed));
    }

    /**
     * Add a hero to the back of the collection.
     *
     * @param hero the new hero
     */
    @Override
    public void addHero(Hero hero) {
        this.heroes.add(hero);
    }

    /**
     * Remove the hero at the front of the collection.
     *
     * @return the hero at the front
     */
    @Override
    public Hero removeHero() {
        return this.heroes.pollFirst();
    }

    /**
     * Get the number of non-fallen heroes.
     *
     * @return number of heroes in the party
     */
    @Override
    public int numHeroes() {
        int result = 0;
        for (Hero hero : this.heroes) {
            if (!hero.hasFallen()) {
                result++;
            }
        }
        return result;
    }

    /**
     * The team which this party is affiliated with.
     *
     * @return the team
     */
    @Override
    public Team getTeam() {
        return this.team;
    }

    /**
     * Get all the undefeated heroes in the party.
     *
     * @return the party
     */
    @Override
    public List<Hero> getHeroes() {
        return this.heroes;
    }

    /**
     * Returns a string representation of the party.
     *
     * {Dragons|Lions}:
     * Hero1, Role, currentHP/maxHP
     * ...
     *
     * To get the hero string details you should call Hero::toString.
     *
     * @return the string
     */
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder(this.getTeam().toString() + ":\n");
        for (Hero hero :this.heroes) {
            string.append(hero.toString()).append("\n");
        }
        return string.toString();
    }
}
