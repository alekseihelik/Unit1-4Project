import javax.sound.midi.Soundbank;
import java.util.Scanner;
public class Adventure {
    public static void main(String[] args) throws InterruptedException {
        Scanner answer = new Scanner(System.in);
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
        while (!(input.equals("0")) && !(input.equals("1")) && !(input.equals("2"))) {
            System.out.print("Only enter 1, 2, or 0.");
            input = answer.nextLine();
        }
        int classPick = Integer.parseInt(input);
        if (classPick == 0) {
            Character character = new Character();
            yourCharacter = character;
        } else if (classPick == 1) {
            System.out.print("You picked the warrior! Enter your name: ");
            String yourName = answer.nextLine();
            Character character = new Character(1, yourName);
            yourCharacter = character;
        } else if (classPick == 2) {
            System.out.print("You picked the mage! Enter your name: ");
            String yourName = answer.nextLine();
            Character character = new Character(2, yourName);
            yourCharacter = character;
        }
        System.out.println("Where do you want your adventure to take place?");
        Thread.sleep(1000);
        System.out.println("===================");
        Thread.sleep(1000);
        System.out.println("0. Random Location");
        Thread.sleep(1000);
        System.out.println("1. Forest");
        Thread.sleep(1000);
        System.out.println("2. Cave");
        Thread.sleep(1000);
        System.out.println("3. Desert");
        System.out.println("===================");
        Thread.sleep(1000);
        System.out.print("Pick your option: ");
        String location = answer.nextLine();
        while (!(location.equals("0")) && !(location.equals("1")) && !(location.equals("2")) && !(location.equals("3"))) {
            System.out.print("Only enter 0, 1, 2, or 3.");
            location = answer.nextLine();
        }
        int chosenLocation = Integer.parseInt(location);
        System.out.println(yourCharacter.toString());
        Thread.sleep(1250);
        System.out.println("Let's begin the adventure!");
        Thread.sleep(1250);
        System.out.println("You will start with " + yourCharacter.healthbar() + " health.");
        Thread.sleep(1250);
        System.out.println("You can use items that you find to heal yourself!");
        Thread.sleep(1250);
        System.out.println("Other items can boost your stats!");
        Thread.sleep(1250);
        System.out.println("Your adventure will be in the " + yourCharacter.location(chosenLocation));
        Thread.sleep(1250);
        System.out.println("Good luck!");
        Thread.sleep(2000);
        if (yourCharacter.locationStart() == 1) {
            Monster enemyOne = new Monster();
            System.out.println("You find yourself in a dense forest.");
            Thread.sleep(1500);
            System.out.print("You hear flowing water to your left, but on your right you can faintly make out a bright light.\nPick the direction you want to go in: ");
            input = answer.nextLine();
            while (!(input.equalsIgnoreCase("left")) && !(input.equalsIgnoreCase("right"))) {
                System.out.print("Only enter left or right.");
                input = answer.nextLine();
                if (input.equalsIgnoreCase("left or right")) {
                    System.out.println("You're so funny... your total health is decreased by 1.");
                }
            }
            if (input.equalsIgnoreCase("left")) {
                System.out.println("You make your way towards the sound of the water.");
                Thread.sleep(1000);
                if (enemyOne.firstMonsterAppears().equals("A monster has appeared! Fight it!")) ;
                {
                    System.out.println(enemyOne.firstMonsterAppears());
                    Thread.sleep(1000);
                    while (!(enemyOne.isDead())) {
                        System.out.println("It's your turn! Do you want to attack or defend?");
                        Thread.sleep(1000);
                        System.out.println("===================");
                        Thread.sleep(1000);
                        System.out.println("1. Attack");
                        Thread.sleep(1000);
                        System.out.println("2. Defend");
                        System.out.println("===================");
                        Thread.sleep(1000);
                        System.out.print("Pick your option: ");
                        String choice = answer.nextLine();
                        while (!(choice.equals("1")) && !(choice.equals("2"))) {
                            System.out.print("Only pick 1 or 2.");
                            choice = answer.nextLine();
                        }
                        int battleChoice = Integer.parseInt(choice);
                        if (battleChoice == 1) {
                            System.out.println("Do you want to use a single powerful attack, or a weaker multi-hit attack?");
                            Thread.sleep(1000);
                            System.out.println("===================");
                            Thread.sleep(1000);
                            System.out.println("1. Single-hit");
                            Thread.sleep(1000);
                            System.out.println("2. Multi-hit");
                            System.out.println("===================");
                            Thread.sleep(1000);
                            System.out.print("Pick your option: ");
                            String attack = answer.nextLine();
                            while (!(attack.equals("1")) && !(attack.equals("2"))) {
                                System.out.print("Only pick 1 or 2.");
                                attack = answer.nextLine();
                            }
                            int attackChoice = Integer.parseInt(attack);
                            System.out.println("You attack!");
                            int damageDealt = yourCharacter.attack(attackChoice);
                            enemyOne.takeDmg(damageDealt);
                            System.out.println(enemyOne.status());
                            if (!(enemyOne.isDead())) {
                                int damageTaken = enemyOne.attack();
                                System.out.println(yourCharacter.takeDamage(damageTaken));
                                System.out.println(yourCharacter.youLose());
                                yourCharacter.gameLose();
                            }
                        } else if (battleChoice == 2) {
                            System.out.println("Do you want to block most of the damage, or take a chance to avoid it all?");
                            Thread.sleep(1000);
                            System.out.println("===================");
                            Thread.sleep(1000);
                            System.out.println("1. Block");
                            Thread.sleep(1000);
                            System.out.println("2. Dodge");
                            System.out.println("===================");
                            Thread.sleep(1000);
                            System.out.print("Pick your option: ");
                            String defend = answer.nextLine();
                            while (!(defend.equals("1")) && !(defend.equals("2"))) {
                                System.out.print("Only pick 1 or 2.");
                                defend = answer.nextLine();
                            }
                            int defendChoice = Integer.parseInt(defend);
                            System.out.println("You defend!");
                            System.out.println(yourCharacter.takeDamage(yourCharacter.defend(defendChoice, enemyOne.attack())));
                            System.out.println(yourCharacter.youLose());
                            yourCharacter.gameLose();
                        }
                    }
                    System.out.println("You won the battle!");
                } // end of battle
                Thread.sleep(1000);
                System.out.println("There are two paths ahead of you.");
                Thread.sleep(1000);
                System.out.println("One path goes deeper into the forest, but the other path seems to go... behind the waterfall?");
                Thread.sleep(1000);
                System.out.println("Which path do you want to go on?");
                Thread.sleep(1000);
                System.out.println("===================");
                Thread.sleep(1000);
                System.out.println("1. Forest");
                Thread.sleep(1000);
                System.out.println("2. Waterfall");
                System.out.println("===================");
                Thread.sleep(1000);
                System.out.print("Pick your option: ");
                String path = answer.nextLine();
                while (!(path.equals("1")) && !(path.equals("2"))) {
                    System.out.print("Only pick 1 or 2.");
                    path = answer.nextLine();
                }
                int pathChoice = Integer.parseInt(path);
                if (pathChoice == 1) {
                    System.out.println("You go deeper into the forest.");
                } else if (pathChoice == 2) {
                    System.out.println("You find a cave behind the waterfall! You see a treasure chest in front of you!");
                    Thread.sleep(1000);
                    System.out.println("You open the treasure chest and find a necklace.");
                    Thread.sleep(1000);
                    System.out.println("You feel stronger as you put it on.\nYour damage has increased by two!");
                    Thread.sleep(2000);
                    yourCharacter.hasNecklace(true);
                    Thread.sleep(1000);
                    System.out.println("The cave leads into a tunnel. As you walk through the tunnel, you can see a faint light at the end, leading outside.");
                    Thread.sleep(2000);
                    System.out.println("You leave the tunnel...");
                    Thread.sleep(2500);
                    String appearanceTwo = enemyOne.monsterAppears();
                    if (appearanceTwo.equals("A monster has appeared! Fight it!"))
                    {
                        System.out.println(appearanceTwo);
                        Monster enemyTwo = new Monster(1);
                        Thread.sleep(1000);
                        while (!(enemyTwo.isDead())) {
                            System.out.println("It's your turn! Do you want to attack or defend?");
                            Thread.sleep(1000);
                            System.out.println("===================");
                            Thread.sleep(1000);
                            System.out.println("1. Attack");
                            Thread.sleep(1000);
                            System.out.println("2. Defend");
                            System.out.println("===================");
                            Thread.sleep(1000);
                            System.out.print("Pick your option: ");
                            String choice = answer.nextLine();
                            while (!(choice.equals("1")) && !(choice.equals("2"))) {
                                System.out.print("Only pick 1 or 2.");
                                choice = answer.nextLine();
                            }
                            int battleChoice = Integer.parseInt(choice);
                            if (battleChoice == 1) {
                                System.out.println("Do you want to use a single powerful attack, or a weaker multi-hit attack?");
                                Thread.sleep(1000);
                                System.out.println("===================");
                                Thread.sleep(1000);
                                System.out.println("1. Single-hit");
                                Thread.sleep(1000);
                                System.out.println("2. Multi-hit");
                                System.out.println("===================");
                                Thread.sleep(1000);
                                System.out.print("Pick your option: ");
                                String attack = answer.nextLine();
                                while (!(attack.equals("1")) && !(attack.equals("2"))) {
                                    System.out.print("Only pick 1 or 2.");
                                    attack = answer.nextLine();
                                }
                                int attackChoice = Integer.parseInt(attack);
                                System.out.println("You attack!");
                                int damageDealt = yourCharacter.attack(attackChoice);
                                enemyTwo.takeDmg(damageDealt);
                                System.out.println(enemyTwo.status());
                                if (!(enemyTwo.isDead())) {
                                    int damageTaken = enemyTwo.attack();
                                    System.out.println(yourCharacter.takeDamage(damageTaken));
                                    System.out.println(yourCharacter.youLose());
                                    yourCharacter.gameLose();
                                }
                            } else if (battleChoice == 2) {
                                System.out.println("Do you want to block most of the damage, or take a chance to avoid it all?");
                                Thread.sleep(1000);
                                System.out.println("===================");
                                Thread.sleep(1000);
                                System.out.println("1. Block");
                                Thread.sleep(1000);
                                System.out.println("2. Dodge");
                                System.out.println("===================");
                                Thread.sleep(1000);
                                System.out.print("Pick your option: ");
                                String defend = answer.nextLine();
                                while (!(defend.equals("1")) && !(defend.equals("2"))) {
                                    System.out.print("Only pick 1 or 2.");
                                    defend = answer.nextLine();
                                }
                                int defendChoice = Integer.parseInt(defend);
                                System.out.println("You defend!");
                                System.out.println(yourCharacter.takeDamage(yourCharacter.defend(defendChoice, enemyTwo.attack())));
                                System.out.println(yourCharacter.youLose());
                                yourCharacter.gameLose();
                            }
                        }
                        System.out.println("You won the battle!");
                    }
                    if (appearanceTwo.equals("It seems like there are no monsters here. Let's keep going!")) {
                        System.out.println("It seems like there are no monsters here. Let's keep going!");
                    }
                    Thread.sleep(2000);
                    System.out.println("After exiting the tunnel, you find yourself in front of a large, glowing door.");
                    Thread.sleep(2000);
                    System.out.println("While you thought the tunnel lead outside, it actually just led to this bright portion of the cave.");
                    Thread.sleep(2000);
                    System.out.println("Suddenly, you hear a sound behind you, and a door that you didn't notice before closes the path behind you.");
                    Thread.sleep(2000);
                    System.out.println("Seeing no other way forward, you push open the door.");
                    Thread.sleep(2000);
                } // end of waterfall path
                else if (input.equalsIgnoreCase("right")) {
                    System.out.println("You make your way towards the source of the light.");
                    if (enemyOne.firstMonsterAppears().equals("A monster has appeared! Fight it!")) ;
                    {
                        System.out.println(enemyOne.firstMonsterAppears());
                        Thread.sleep(1000);
                        while (!(enemyOne.isDead())) {
                            System.out.println("It's your turn! Do you want to attack or defend?");
                            Thread.sleep(1000);
                            System.out.println("===================");
                            Thread.sleep(1000);
                            System.out.println("1. Attack");
                            Thread.sleep(1000);
                            System.out.println("2. Defend");
                            System.out.println("===================");
                            Thread.sleep(1000);
                            System.out.print("Pick your option: ");
                            String choice = answer.nextLine();
                            while (!(choice.equals("1")) && !(choice.equals("2"))) {
                                System.out.print("Only pick 1 or 2.");
                                choice = answer.nextLine();
                            }
                            int battleChoice = Integer.parseInt(choice);
                            if (battleChoice == 1) {
                                System.out.println("Do you want to use a single powerful attack, or a weaker multi-hit attack?");
                                Thread.sleep(1000);
                                System.out.println("===================");
                                Thread.sleep(1000);
                                System.out.println("1. Single-hit");
                                Thread.sleep(1000);
                                System.out.println("2. Multi-hit");
                                System.out.println("===================");
                                Thread.sleep(1000);
                                System.out.print("Pick your option: ");
                                String attack = answer.nextLine();
                                while (!(attack.equals("1")) && !(attack.equals("2"))) {
                                    System.out.print("Only pick 1 or 2.");
                                    attack = answer.nextLine();
                                }
                                int attackChoice = Integer.parseInt(attack);
                                System.out.println("You attack!");
                                int damageDealt = yourCharacter.attack(attackChoice);
                                enemyOne.takeDmg(damageDealt);
                                System.out.println(enemyOne.status());
                                if (!(enemyOne.isDead())) {
                                    int damageTaken = enemyOne.attack();
                                    System.out.println(yourCharacter.takeDamage(damageTaken));
                                    System.out.println(yourCharacter.youLose());
                                    yourCharacter.gameLose();
                                }
                            } else if (battleChoice == 2) {
                                System.out.println("Do you want to block most of the damage, or take a chance to avoid it all?");
                                Thread.sleep(1000);
                                System.out.println("===================");
                                Thread.sleep(1000);
                                System.out.println("1. Block");
                                Thread.sleep(1000);
                                System.out.println("2. Dodge");
                                System.out.println("===================");
                                Thread.sleep(1000);
                                System.out.print("Pick your option: ");
                                String defend = answer.nextLine();
                                while (!(defend.equals("1")) && !(defend.equals("2"))) {
                                    System.out.print("Only pick 1 or 2.");
                                    defend = answer.nextLine();
                                }
                                int defendChoice = Integer.parseInt(defend);
                                System.out.println("You defend!");
                                System.out.println(yourCharacter.takeDamage(yourCharacter.defend(defendChoice, enemyOne.attack())));
                                System.out.println(yourCharacter.youLose());
                                yourCharacter.gameLose();
                            }
                        }
                        System.out.println("You won the battle!");
                    } // end of battle
                    Thread.sleep(1000);
                    System.out.println("You're in a clearing. It's foggy...");
                    Thread.sleep(1000);
                    System.out.println("Do you want to go further into the clearing, or go right on a path deeper into the forest?");
                    Thread.sleep(1000);
                    System.out.println("===================");
                    Thread.sleep(1000);
                    System.out.println("1. Forest");
                    Thread.sleep(1000);
                    System.out.println("2. Clearing");
                    System.out.println("===================");
                    Thread.sleep(1000);
                    System.out.print("Pick your option: ");
                    path = answer.nextLine();
                    while (!(path.equals("1")) && !(path.equals("2"))) {
                        System.out.print("Only pick 1 or 2.");
                        path = answer.nextLine();
                    }
                    pathChoice = Integer.parseInt(path);
                    if (pathChoice == 1) {
                        System.out.println("You go deeper into the forest.");
                    } else if (pathChoice == 2) {
                        System.out.println("You venture further into the clearing.");
                    }
                } // end of clearing path
            } // end of forest exploration
        }
    }
}

