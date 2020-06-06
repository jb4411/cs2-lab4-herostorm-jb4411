package heroes;

/**
 * Our glass cannon damage class, the berserker. Berserkers have a low amount
 * of hit points but deal the most amount of damage (in comparison to the other
 * roles).
 *
 * @author Jesse Burdick-Pless jb4411@g.rit.edu
 */

public class Healer extends Hero {
    /** the amount a healer damages an enemy when attacking */
    protected static final int DAMAGE_AMOUNT = 10;
    /** the amount a healer heals an ally for when attacking */
    protected static final int HEAL_AMOUNT = 10;
    /** the healer's initial (and maximum) hit points */
    protected static final int HEALER_HIT_POINTS = 35;

    /**
     * Create a healer.
     *
     * @param team healer's team
     * @param party the healer's party
     */
    protected Healer(Team team, Party party) {

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
     * When a healer attacks, they first heal themselves, then the rest of
     * their party, and then they attack the enemy with their maximum damage.
     *
     * @param enemy the enemy to attack
     * @rit.pre this hero has not fallen yet, the healer has a party
     */
    @Override
    public void attack​(Hero enemy) {
        enemy.takeDamage​(DAMAGE_AMOUNT);

    }
}
