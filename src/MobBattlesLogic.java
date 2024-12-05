import java.util.Scanner;

public class MobBattlesLogic {
    private Scanner scan = new Scanner(System.in);
    private boolean repeat = true;
    private MobBattles infoObj = new MobBattles(1);
    private MobBattles play;

    public MobBattlesLogic() {}

    public void start() {
        System.out.println("Hello!! Welcome to Mob Battles!");
        intro();
        while (repeat) {
            mainMenu();
            decider();
        }
        System.out.println("Thank you for playing Mob Battles!!");
    }

    public void intro() {
        System.out.println("Please pick your mob using a number (ex: 1): ");
        infoObj.printMobNames();
        int mobNum = scan.nextInt();
        while (mobNum < 1 && mobNum >= infoObj.getMobs().length) {
            scan.nextLine();
            System.out.println("Pick a valid mob");
            mobNum = scan.nextInt();
        }
        play = new MobBattles(mobNum);
    }

    public void mainMenu() {
        System.out.println("1. Battle (Fight against another person (ai))");
        System.out.println("2. Stats  (Look at your mobs' statistics)");
        System.out.println("3. Distribute Status Points");
        System.out.println("4. Mobs   (View all mobs)" );
        System.out.println("5. End    (End your game)");
    }

    public void decider() {
        int choice = scan.nextInt();
        scan.nextLine();
        if (choice == 1) {
            battling();
        }
        if (choice == 2) {
            play.printMobStats();
            cont();
        }
        if (choice == 3) {
            statsDistribute();
        }
    }

    public void battling() {
        play.battle();
    }

    public void statsDistribute() {
        if (play.getPlayer().getStatPoints() > 0) {
            System.out.println("You have " + play.getPlayer().getStatPoints() + " stat points. Which stats would you like in increase? :");
            statsDistributeHelp();
            int statIncrease = scan.nextInt();
            scan.nextLine();
            boolean valid = play.getPlayer().statIncrease(statIncrease);
            while (valid) {
                statsDistributeHelp();
                System.out.println("Choose a valid stat to increase (1 - 5):");
                statIncrease = scan.nextInt();
                scan.nextLine();
                valid = play.getPlayer().statIncrease(statIncrease);
            }
            System.out.println("Your stat has been increase!!. Check your stats in the menu");
            cont();
        } else {
            System.out.println("You don't have any stat points :(");
        }
    }
    public void statsDistributeHelp() {
        System.out.println("1. Hit Points (HP)");
        System.out.println("2. Mana Points (MP)");
        System.out.println("3. Defense");
        System.out.println("4. Speed");
        System.out.println("5. Attack Damage");
    }

    // Method so i don't have to use the same thing over and over again
    // stops the program and makes user press enter, so they have time to read.
    public void cont() {
        System.out.println("Press enter to continue");
        String temp = scan.nextLine();
    }
}
