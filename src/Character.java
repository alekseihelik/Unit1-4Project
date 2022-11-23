public class Character {
    private String chosenClass = "";
    private String chosenName = "";
    private String yourLocation = "";
    private int currentHealthbar;
    private int totalHealthbar;
    private String[] inventory = new String [10];
    private boolean necklace = false;

    public Character(int yourClass, String name) {
        chosenName = name;
        if (yourClass == 1) {
            chosenClass = "Warrior";
        } else if (yourClass == 2) {
            chosenClass = "Mage";
        }
    }

    public Character() {
        int classPick = (int) (Math.random() * 2) + 1;
        if (classPick == 1) {
            chosenClass = "Warrior";
        } else {
            chosenClass = "Mage";
        }
        int namePick = (int) (Math.random() * 10) + 1;
        if (namePick == 1) {
            chosenName = "John";
        }
        if (namePick == 2) {
            chosenName = "Joanna";
        }
        if (namePick == 3) {
            chosenName = "Quinn";
        }
        if (namePick == 4) {
            chosenName = "Steven";
        }
        if (namePick == 5) {
            chosenName = "Eddy";
        }
        if (namePick == 6) {
            chosenName = "Leon";
        }
        if (namePick == 7) {
            chosenName = "Claire";
        }
        if (namePick == 8) {
            chosenName = "Rachel";
        }
        if (namePick == 9) {
            chosenName = "Flora";
        }
        if (namePick == 10) {
            chosenName = "Rosa";
        }
    }

    public String toString() {
        return "Your character's name is " + chosenName + ", and your class is " + chosenClass;
    }

    public String location(int picker) {
        if (picker == 1) {
            yourLocation = "forest.";
        } else if (picker == 2) {
            yourLocation = "cave.";
        } else {
            yourLocation = "desert.";
        }
        if (picker == 0){
            int random = (int)(Math.random()*3)+1;
            if (random == 1) {
                yourLocation = "forest.";
            } else if (random == 2) {
                yourLocation = "cave.";
            } else {
                yourLocation = "desert.";
            }
        }
        return yourLocation;
    }

    public int healthbar() {
        if (chosenClass.equals("Warrior")) {
            totalHealthbar = 20;
        } else if (chosenClass.equals("Mage")) {
            totalHealthbar = 12;
        }
        currentHealthbar = totalHealthbar;
        return currentHealthbar;
    }

    public int locationStart() {
        int locationStarter = 0;
        if (yourLocation.equals("forest.")) {
            locationStarter = 1;
        } else if (yourLocation.equals("cave.")) {
            locationStarter = 2;
        } else if (yourLocation.equals("desert.")) {
            locationStarter = 3;
        }
        return locationStarter;
    }
    public void gameLose(){
        if (currentHealthbar == 0){
            System.exit(0);
        }
    }

    public String[] characterInventory(){
        return inventory;
    }

    public String takeDamage(int damage){
        currentHealthbar = currentHealthbar - damage;
        return "You took " + damage + " damage! You have " + currentHealthbar + " health left!";
    }

    public int attack(int attackChoice){
        int dmg = 0;
        if (chosenClass.equals("Warrior")){
            if (attackChoice == 1){
                dmg = (int)(Math.random()*4)+5;
            }
            else {
                int attacks = (int)(Math.random()*4)+2;
                dmg = 2 * attacks;
            }
        } // end of warrior attacks
        if (chosenClass.equals("Mage")){
            if (attackChoice == 1){
                dmg = (int)(Math.random()*4)+6;
            }
            else {
                int attacks = (int)(Math.random()*3)+2;
                dmg = 3 * attacks;
            }
        } // end of mage attacks
        if (necklace){
            dmg += 2;
        }
        return dmg;
    }

    public int defend(int defenseChoice, int damageTaken){
        int finalDamage = 0;
        if (chosenClass.equals("Warrior")){
            if (defenseChoice == 1){
                finalDamage = (damageTaken/2) - 2;
            }
            else {
                int dodgeChance = (int)(Math.random()*3)+1;
                if (dodgeChance == 1){
                    finalDamage = 0;
                }
                else if (dodgeChance == 2){
                    finalDamage = damageTaken/3;
                }
                else {
                    finalDamage = damageTaken;
                }
            }
        }
        if (chosenClass.equals("Mage")){
            if (defenseChoice == 1){
                finalDamage = damageTaken/3;
            }
            else {
                int dodgeChance = (int)(Math.random()*3)+1;
                if (dodgeChance == 1){
                    finalDamage = 0;
                }
                else if (dodgeChance == 2){
                    finalDamage = damageTaken/3;
                }
                else {
                    finalDamage = damageTaken;
                }
            }
        }
        if (finalDamage < 0){
            finalDamage = 0;
        }
        return finalDamage;
    }

    public String youLose(){
        String lose = "";
        if (currentHealthbar <= 0){
            lose = "You lost!";
        }
        return lose;
    }

    public void hasNecklace(boolean equipped){
        if (equipped){
            necklace = true;
        }
    }
}
