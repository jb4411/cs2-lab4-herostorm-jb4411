package heroes;

import game.Team;

/**
 * Our glass cannon damage class, the berserker. Berserkers have a low amount
 * of hit points but deal the most amount of damage (in comparison to the other
 * roles).
 *
 * @author Jesse Burdick-Pless jb4411@g.rit.edu
 */

public class Berserker extends Hero{
    /** the berserker's initial (and maximum) hit points */
    protected static final int BERSERKER_HIT_POINTS = 30;
    /** the amount of damage a berserker does when attacking */
    protected static final int DAMAGE_AMOUNT = 20;

    /**
     * Create a berserker.
     *
     * @param team berserker's team
     */
    protected Berserker(Team team) {
        super(Heroes.getName(team, Heroes.Role.BERSERKER), BERSERKER_HIT_POINTS);
    }

    /**
     * Get this heroes role.
     *
     * @return the role
     */
    @Override
    public Heroes.Role getRole() {
        return Heroes.Role.BERSERKER;
    }

    /**
     * A hero attacks an enemy. How this is done depends on the type of hero
     * doing the attacking.
     *
     * @param enemy the enemy to attack
     */
    @Override
    public void attack(Hero enemy) {
        enemy.takeDamage(DAMAGE_AMOUNT);
    }
}
