public class Monster {
    /**
     * The monster object represents the enemies that the user fights
     */
    private int health = 0;
    private boolean dead = false;

    /**
     * The monster constructor creates a randomized monster with health ranging from 6-14 hp
     */
    public Monster(){
        health = (int)(Math.random()*7)+6;
    }

    /**
     * The second monster constructor creates a stronger monster
     * @param level - inputs the level of the monster based on where the user is located in the story
     */
    public Monster(int level){
        health = (int)(Math.random()*7)+9;
    }

    /**
     * checks if the monster is dead or not
     * @return returns a string telling the user if the monster is dead or not. If the monster isn't dead, tells the user how much health it still has
     */
    public String status(){
        String monsterStatus = "";
        if(health <= 0){
            dead = true;
            monsterStatus = "The monster is dead! You won the battle!";
        }
        else {
            monsterStatus = "The monster still has " + health + " health! Keep fighting!";
        }
        return monsterStatus;
    }

    /**
     * creates a chance for a monster to spawn at certain locations
     * @return returns a string telling the user whether or not they have encountered a monster
     */
    public String monsterAppears(){
        int chance = (int)(Math.random()*3)+1;
        String appearance = "";
        if (chance == 1){
            appearance = "A monster has appeared! Fight it!";
        }
        else {
            appearance = "It seems like there are no monsters here. Let's keep going!";
        }
        return appearance;
    }

    /**
     * makes the monster take damage based on the user's attack
     * @param damageTaken - how much damage the user did
     * @return returns how much damage the enemy has taken and how much healh it still has
     */
    public String takeDmg(int damageTaken){
        health = health - damageTaken;
        return "The enemy has taken " + damageTaken + " damage! It has " + health + " health left!";
    }

    /**
     * Checks if the monster is dead or not
     * @return returns a boolean value based on if the monster is dead or not
     */
    public boolean isDead(){
        if (health <= 0){
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * attacking method for the monster
     * @return returns how much damage the monster has done to the user
     */
    public int attack(){
        int damage = (int)(Math.random()*3)+2;
        return damage;
    }

    /**
     * guarantees the first location to have a monster encounter
     * @return returns a string telling the user that they have to fight a monster
     */
    public String firstMonsterAppears(){
        return "A monster has appeared! Fight it!";
    }
}
