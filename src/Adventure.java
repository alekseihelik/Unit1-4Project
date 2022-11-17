import javax.sound.midi.Soundbank;
import java.util.Scanner;
public class Adventure {
    public static void main(String[] args) throws InterruptedException {
        Scanner answer = new Scanner(System.in);
        String yourClass = "";
        Character yourCharacter = null;
        System.out.println("Welcome to your adventure!");
        Thread.sleep(1500);
        System.out.println("Lets create your character!");
        Thread.sleep(1500);
        System.out.println("Character options:");
        System.out.println("===================");
        Thread.sleep(1000);
        System.out.println("0. Randomized");
        Thread.sleep(1000);
        System.out.println("1. Warrior");
        Thread.sleep(1000);
        System.out.println("2. Mage");
        System.out.println("===================");
        Thread.sleep(1000);
        System.out.print("Pick your option: ");
        String input = answer.nextLine();
        while (!(input.equals("0")) && !(input.equals("1")) && !(input.equals("2"))){
            System.out.print("Only enter 1, 2, or 0.");
            input = answer.nextLine();
        }
        int classPick = Integer.parseInt(input);
        if (classPick == 0){
            Character character = new Character();
            yourCharacter = character;
        }
        else if (classPick == 1){
            System.out.print("You picked the warrior! Enter your name: ");
            String yourName = answer.nextLine();
            Character character = new Character(1, yourName);
            yourCharacter = character;
        }
        else if (classPick == 2){
            System.out.print("You picked the mage! Enter your name: ");
            String yourName = answer.nextLine();
            Character character = new Character(2, yourName);
            yourCharacter = character;
        }
        System.out.println(yourCharacter.info());
        Thread.sleep(1100);
        System.out.println("You are level " + yourCharacter.level());
        Thread.sleep(1100);
        System.out.println("You will start with " + yourCharacter.healthbar() + " health.");
        Thread.sleep(1100);
        System.out.println("Level up by killing enemies!");
        Thread.sleep(1100);
        System.out.println("Leveling up will increase your total health by 2 and heal you to full health.");
        Thread.sleep(1100);
        System.out.println("You can also use items that you find to heal yourself!");
        Thread.sleep(1100);
        System.out.println("Your adventure will be in the " + yourCharacter.location());
        Thread.sleep(1100);
        System.out.println("Good luck!");
        Thread.sleep(2000);
        if (yourCharacter.locationStart() == 1){
            System.out.println("You find yourself in a dense forest.");
            Thread.sleep(1500);
            System.out.print("You hear flowing water to your left, but on your right you can faintly make out a bright light.\nPick the direction you want to go in: ");
            input = answer.nextLine();
            while (!(input.equalsIgnoreCase("left")) && !(input.equalsIgnoreCase("right"))){
                System.out.print("Only enter left or right.");
                input = answer.nextLine();
                if (input.equalsIgnoreCase("left or right")){
                    System.out.println("You're so funny... your total health is decreased by 1.");
                }
            }
            if (input.equalsIgnoreCase("left")){
                System.out.println("You make your way towards the sound of the water.");
            }
            else if (input.equalsIgnoreCase("right")){
                System.out.println("You make your way towards the light.");
            }
        }
    }
}
