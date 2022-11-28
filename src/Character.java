public class Character {
    /**
     * The Character object represents the character that the user plays as during the game
     */
    private String chosenClass = "";
    private String chosenName = "";
    private String yourLocation = "";
    private int currentHealthbar;
    private int totalHealthbar;
    private String[] inventory = new String [10];
    private boolean necklace = false;

    /**
     * The Character constructor creates a character based on the user's inputs in the parameters
     * @param yourClass - the class that the user chooses
     * @param name - the name that the user chooses
     */
    public Character(int yourClass, String name) {
        chosenName = name;
        if (yourClass == 1) {
            chosenClass = "Warrior";
        } else if (yourClass == 2) {
            chosenClass = "Mage";
        }
    }

    /**
     * The second Character constructor creates a randomized character for the user
     */
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

    /**
     * The toString method
     * @return returns the name and class of the user
     */
    public String toString() {
        return "Your character's name is " + chosenName + ", and your class is " + chosenClass;
    }

    /**
     * This method sets the location that the user picks
     * @param picker - input of the location that the user wants to go to
     * @return returns the location that the user is in
     */
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

    /**
     * sets the healthbar of the user
     * @return returns the current health that the user has
     */
    public int healthbar() {
        if (chosenClass.equals("Warrior")) {
            totalHealthbar = 20;
        } else if (chosenClass.equals("Mage")) {
            totalHealthbar = 12;
        }
        currentHealthbar = totalHealthbar;
        return currentHealthbar;
    }

    /**
     * Tells the user where they are starting - main purpose is if the user chose random location
     * @return returns the location of the user as a string
     */
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

    /**
     * checks if the user has lost the game, and stops the game if they have
     */
    public void gameLose(){
        if (currentHealthbar == 0){
            System.exit(0);
        }
    }

    /**
     * Makes the user take a certain amount of damage
     * @param damage - the amount of the damage that the enemy dealt to them
     * @return returns the amount of damage the user took and how much health they have left
     */
    public String takeDamage(int damage){
        currentHealthbar = currentHealthbar - damage;
        return "You took " + damage + " damage! You have " + currentHealthbar + " health left!";
    }

    /**
     * Allows the user to attack the enemy
     * @param attackChoice - the user's input of what attack they want to do
     * @return returns how much damage the user did
     */
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

    /**
     * Allows the user to defend from the enemy's attack
     * @param defenseChoice - the defense option that the user picked
     * @param damageTaken - how much damage the enemy has done, which is used to calculate final damage taken
     * @return returns how much damage the user has taken
     */
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

    /**
     * Tells the user that they lost before ending the program
     * @return returns a string telling the user that they lost
     */
    public String youLose(){
        String lose = "";
        if (currentHealthbar <= 0){
            lose = "You lost!";
        }
        return lose;
    }

    /**
     * Checks if the user has gotten the necklace from the treasure chest
     * @param equipped - sets the boolean necklace value to true if the user has the necklace
     */
    public void hasNecklace(boolean equipped){
        if (equipped){
            necklace = true;
        }
    }
}
