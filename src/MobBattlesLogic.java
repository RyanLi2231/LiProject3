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
        System.out.println("3. Mobs   (View all mobs)" );
        System.out.println("4. End    (End your game)");
    }

    public void decider() {
        int choice = scan.nextInt();
        scan.nextLine();
        if (choice == 1) {
            play.battle();
        }
        if (choice == 2) {
            play.printMobStats();
            System.out.println("Press enter to continue");
            String temp = scan.nextLine();
        }
    }
}
