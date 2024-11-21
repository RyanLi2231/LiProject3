import java.util.Scanner;

public class MobBattlesLogic {
    Scanner scan = new Scanner(System.in);
    boolean repeat = false;
    MobBattles infoObj = new MobBattles(1);
    MobBattles play;

    public MobBattlesLogic() {}

    public void start() {
        System.out.println("Hello!! Welcome to Mob Battles!");
        intro();
        mainMenu();
        decider();
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
        System.out.println("1. Battle (Fight against another mob)");
        System.out.println("2. Stats  (Look at your mobs' statistics)");
        System.out.println("3. Mobs   (Buy or look at your mobs' moves)" );
        System.out.println("4. End    (End your game)");
    }

    public void decider() {
        int choice = scan.nextInt();
        if (choice == 2) {
            play.printMobStats();
        }
    }
}
