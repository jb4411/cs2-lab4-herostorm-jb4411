package heroes;

import game.Team;

/**
 * Our dependable medic healing class. Healers have a moderate amount of hit
 * points, but do the least amount of damage. When attacking, however, the
 * healer will heal all non-defeated party members for a decent amount
 * (including themselves).
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

    private Party party;

    /**
     * Create a healer.
     *
     * @param team healer's team
     * @param party the healer's party
     */
    protected Healer(Team team, Party party) {
        super(Heroes.getName(team, Heroes.Role.HEALER), HEALER_HIT_POINTS);
        this.party = party;
    }

    /**
     * Get this heroes role.
     *
     * @return the role
     */
    @Override
    public Heroes.Role getRole() {
        return Heroes.Role.HEALER;
    }

    /**
     * When a healer attacks, they first heal themselves, then the rest of
     * their party, and then they attack the enemy with their maximum damage.
     *
     * @param enemy the enemy to attack
     * @rit.pre this hero has not fallen yet, the healer has a party
     */
    @Override
    public void attack(Hero enemy) {
        this.heal(HEAL_AMOUNT);
        for (Hero hero : this.party.getHeroes()) {
            hero.heal(HEAL_AMOUNT);
        }
        enemy.takeDamage(DAMAGE_AMOUNT);
    }
}
