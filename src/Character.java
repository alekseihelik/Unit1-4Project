public class Character {
    private String chosenClass = "";
    private String chosenName = "";
    private String yourLocation = "";
    private int currentHealthbar;
    private int level = 1;
    private int expbar = 100;
    private int expgained = 0;
    private int totalHealthbar;

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

    public String info() {
        return "Your character's name is " + chosenName + ", and your class is " + chosenClass;
    }

    public String location() {
        int picker = (int) (Math.random() * 3) + 1;
        if (picker == 1) {
            yourLocation = "forest.";
        } else if (picker == 2) {
            yourLocation = "cave.";
        } else {
            yourLocation = "desert.";
        }
        return "forest";
    }

    public int healthbar() {
        if (chosenClass.equals("Warrior")) {
            totalHealthbar = 15;
        } else if (chosenClass.equals("Mage")) {
            totalHealthbar = 7;
        }
        currentHealthbar = totalHealthbar;
        return currentHealthbar;
    }

    public int level() {
        if ((expbar - expgained) <= 0) {
            level++;
            expgained = expgained - expbar;
            expbar += 50;
            totalHealthbar += 2;
            currentHealthbar = totalHealthbar;
        }
        return level;
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
        return 1;
    }
}
