public class Monster {
    private int health = 0;
    private boolean dead = false;
    public Monster(){
        health = (int)(Math.random()*7)+6;
    }

    public Monster(int level){
        health = (int)(Math.random()*7)+9;
    }

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

    public String takeDmg(int damageTaken){
        health = health - damageTaken;
        return "The enemy has taken " + damageTaken + " damage! It has " + health + " health left!";
    }

    public boolean isDead(){
        if (health <= 0){
            return true;
        }
        else {
            return false;
        }
    }

    public int attack(){
        int damage = (int)(Math.random()*3)+2;
        return damage;
    }

    public String firstMonsterAppears(){
        return "A monster has appeared! Fight it!";
    }
}
