package heroes;

import game.Team;

/**
 * Represents a virtuous hero in the venerable game of storms.
 *
 * @author Jesse Burdick-Pless jb4411@g.rit.edu
 */

public abstract class Hero {
    /** hero name */
    String name;
    /** hero hit points */
    int hitPoints;
    /** hero max hit points */
    int maxHP;

    /**
     * Create a new hero. This routine is protected so that only the subclasses
     * (the real heroes) may call it when being created.
     *
     * @param name hero name
     * @param hitPoints hero hit points
     */
    protected Hero(String name, int hitPoints) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.maxHP = hitPoints;
    }

    /**
     * Create a hero of a particular role for a certain team. This is an
     * example of a factory method pattern. It is a static method that creates
     * and constructs the actual hero without the caller having to worry about
     * the details of the Hero constructor that is hidden from them.
     *
     * @param role hero role
     * @param team the hero's team
     * @param party the hero's party (only used by healer for healing)
     * @return a new Hero of the correct kind
     */
    public static Hero create​(Heroes.Role role, Team team, Party party) {
        if (role == Heroes.Role.BERSERKER) {
            return new Berserker(team);
        } else if (role == Heroes.Role.HEALER) {
            return new Healer(team, party);
        } else {
            return null;
        }
    }

    /**
     * Get this heroes role.
     *
     * @return the role
     */
    public abstract Heroes.Role getRole();

    /**
     * A hero attacks an enemy. How this is done depends on the type of hero
     * doing the attacking.
     *
     * @param enemy the enemy to attack
     */
    public abstract void attack(Hero enemy);

    /**
     * Get the name of the hero.
     *
     * @return hero name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Heal an individual hero by an amount (but do not exceed the maximum hit
     * points). All heroes heal the same way. It should print a message:
     * {name} heals # points
     *
     * Where name is the hero name and # is the total number of points that
     * were attempted to heal this hero.
     *
     * @param amount amount to heal
     */
    public void heal(int amount) {
        System.out.println(this.name + " heals " + amount + " points");
        if (this.hitPoints + amount > this.maxHP) {
            this.hitPoints = maxHP;
        } else {
            this.hitPoints += amount;
        }
    }

    /**
     * Our hero takes some damage. Generally when this happens, the hit points
     * of the hero are reduced by the amount, but do not drop below 0. It
     * should print a message:
     * {name} takes # damage
     * Where name is the hero name and # is the total amount of damage that was
     * attempted to be applied to this hero.
     *
     * @param amount the amount of damage to take
     */
    public void takeDamage(int amount) {
        System.out.println(this.name + " takes " + amount + " damage");
        this.hitPoints -= amount;
        if (this.hitPoints < 0) {
            this.hitPoints = 0;
        }
    }

    /**
     * A hero has sadly fallen when their hit points are 0.
     *
     * @return whether they are fallen or not
     */
    public boolean hasFallen() {
        return this.hitPoints <= 0;
    }

    /**
     * Return a string representation of the hero in the form:
     * {name}, {ROLE}, #/#
     *
     * Here, name is the hero name, role is their role, and #/# is the current
     * hit points followed by the max hit points.
     *
     * @return the string formatted as described above
     */
    @Override
    public String toString() {
        return this.name + ", " + getRole().toString() + ", " + this.hitPoints + "/" + this.maxHP;
    }
}
