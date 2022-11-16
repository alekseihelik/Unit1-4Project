import java.util.Scanner;
public class Adventure {
    public static void main(String[] args) {
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
        System.out.println("Your adventure will be in the " + yourCharacter.location());
    }
}
