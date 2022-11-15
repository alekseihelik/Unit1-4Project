public class Character {
    private String chosenClass = "";
    private String chosenName = "";
    private String yourLocation = "";

    public Character(int yourClass , String name){
        chosenName = name;
        if (yourClass == 1){
            chosenClass = "Warrior";
        }
        else if (yourClass == 2){
            chosenClass = "Mage";
        }
    }
    public Character(){
        int classPick = (int)(Math.random()*2)+1;
        if(classPick == 1){
            chosenClass = "Warrior";
        }
        else{
            chosenClass = "Mage";
        }
        int namePick = (int)(Math.random()*10)+1;
        if (namePick == 1){
            chosenName = "John";
        }
        if (namePick == 2){
            chosenName = "Joanna";
        }
        if (namePick == 3){
            chosenName = "Quinn";
        }
        if (namePick == 4){
            chosenName = "Steven";
        }
        if (namePick == 5){
            chosenName = "Eddy";
        }
        if (namePick == 6){
            chosenName = "Leon";
        }
        if (namePick == 7){
            chosenName = "Claire";
        }
        if (namePick == 8){
            chosenName = "Rachel";
        }
        if (namePick == 9){
            chosenName = "Flora";
        }
        if (namePick == 10){
            chosenName = "Rosa";
        }
    }
    public String info(){
        return "Your character's name is " + chosenName + ", and your class is " + chosenClass;
    }
    public String location(){
        String thisLocation;
        int picker = ((int)Math.random()*3)+1;
        if (picker == 1){
            thisLocation = "forest";
        }
        else if(picker == 2){
            thisLocation = "cave";
        }
        else {
            thisLocation = "desert";
        }
        return thisLocation;
    }
}
