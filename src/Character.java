public class Character {
    private String chosenClass = "";
    private String chosenName = "";
    private String yourLocation = "";

    public Character(int yourClass , String name){
        chosenName = name;
    }
    public Character(){
        int classPick = ((int)Math.random()*2)+1;
        if(classPick == 1){
            chosenClass = "Warrior";
        }
        else{
            chosenClass = "Mage";
        }
        int namePick = ((int)Math.random()*10)+1;
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
