package heroes;

import game.Team;

/**
 * Our ruggedly reliable damage sponge class. A tank has the most hitpoints and
 * deal a moderate amount of damage. When a tank is damaged by an enemy, the
 * mitigate 10% of the damage they would normally take with their shield.
 *
 * @author Jesse Burdick-Pless jb4411@g.rit.edu
 */
public class Tank extends Hero {
    /** the amount of damage a tank inflicts on an enemy when attacking */
    protected static final int DAMAGE_AMOUNT = 15;
    /** The amount the incoming damage is multiplied by to compute the actual
     *  damage the tank will take. */
    protected static final double SHIELD_DMG_MULTIPLIER = 0.9;
    /** the tank's initial and maximum hit points */
    protected static final int TANK_HIT_POINTS = 40;

    /**
     * Create a tank.
     *
     * @param team tank's team
     */
    protected Tank(Team team) {
        super(Heroes.getName(team, Heroes.Role.TANK), TANK_HIT_POINTS);
    }

    /**
     * Get this heroes role.
     *
     * @return the role
     */
    @Override
    public Heroes.Role getRole() {
        return Heroes.Role.TANK;
    }

    /**
     * Unlike the other classes, the tank mitigates the damage the are about to
     * take by using their shield. Once this amount is adjusted, they should
     * take damage in the same manner as the other classes, e.g. calling
     * Hero::takeDamage. The mitigation amount is multiplied by the
     * SHIELD_DMG_MULTIPLIER and then truncated to an integer.
     *
     * @param amount the initial amount of damage the tank will take
     */
    @Override
    public void takeDamage(int amount) {
        int adjustedAmount = (int) (amount * SHIELD_DMG_MULTIPLIER);
        super.takeDamage(adjustedAmount);
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
