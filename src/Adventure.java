import java.util.Scanner;
public class Adventure {
    public static void main(String[] args) throws InterruptedException {
        Scanner answer = new Scanner(System.in);
        String yourClass = "";
        Character yourCharacter = null;
        System.out.println("Welcome to your adventure!");
        System.out.println("Lets create your character!");
        System.out.println("What class do you want to pick? Enter 1 for warrior, 2 for mage, or 0 if you want character creation to be randomized.");
        String input = answer.nextLine();
        while (!(input.equals("0")) && !(input.equals("1")) && !(input.equals("2"))){
            System.out.println("Only enter 1, 2, or 0.");
            input = answer.nextLine();
        }
        int classPick = Integer.parseInt(input);
        if (classPick == 0){
            Character character = new Character();
            yourCharacter = character;
        }
        else if (classPick == 1){
            System.out.println("You picked the warrior! What do you want to be called?");
            String yourName = answer.nextLine();
            Character character = new Character(1, yourName);
            yourCharacter = character;
        }
        else if (classPick == 2){
            System.out.println("You picked the mage! What do you want to be called?");
            String yourName = answer.nextLine();
            Character character = new Character(2, yourName);
            yourCharacter = character;
        }
        System.out.println(yourCharacter.info());
        Thread.sleep(2000);
        System.out.println("You are level " + yourCharacter.level());
        Thread.sleep(2000);
        System.out.println("You will start with " + yourCharacter.healthbar() + " health.");
        Thread.sleep(2000);
        System.out.println("Level up by killing enemies!");
        Thread.sleep(2000);
        System.out.println("Leveling up will increase your total health by 2 and heal you to full health.");
        Thread.sleep(2000);
        System.out.println("You can also use items that you find to heal yourself!");
        Thread.sleep(2000);
        System.out.println("Your adventure will be in the " + yourCharacter.location());
        Thread.sleep(2000);
        System.out.println("Good luck!");
    }
}
