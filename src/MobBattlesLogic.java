import java.util.Scanner;

public class MobBattlesLogic {
    private Scanner scan = new Scanner(System.in);
    private boolean repeat = true;
    private MobBattles infoObj = new MobBattles(1, "");
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
        System.out.println("What is your name?");
        String name = scan.nextLine();
        System.out.println("Please pick your mob using a number (ex: 1) or type -1 if you want a random mob: ");
        System.out.println("[Name, HP, MP, DF, AD (attack damage)]");
        infoObj.printMobNames();
        int mobNum = scan.nextInt();
        while (mobNum != -1 && mobNum < 1 && mobNum >= infoObj.getMobs().length) {
            scan.nextLine();
            System.out.println("Pick a valid mob");
            mobNum = scan.nextInt();
        }
        if (mobNum == -1) {
            play = new MobBattles(name);
        } else {
            play = new MobBattles(mobNum, name);
        }
    }

    public void mainMenu() {
        System.out.println("1. Battle (Fight against another person (ai))");
        System.out.println("2. Stats  (Look at your mobs' statistics)");
        System.out.println("3. Distribute Stat(us) Points");
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
        if (choice == 4) {
            play.printMobNames();
            cont();
        }
        if (choice == 5) {
            repeat = false;
        }
    }

    public void battling() {
        play.battle();
        Player player1 = play.getPlayer();
        Player player2 = play.getPlayer2();
        int p1Hp = player1.getHp();
        int p1Mp = player1.getMp();
        int p2Hp = player2.getHp();
        int p2Mp = player2.getMp();
        while (p1Hp > 0 && p2Hp > 0) {
            play.battleMenu(p1Hp, p1Mp, player1);
            play.battleMenu(p2Hp, p2Mp, player2);
            cont();
            play.battleMenu();
            System.out.print("Pick an attack to use against your opponent (1 - 4) :");
            int attkChoice = scan.nextInt();
            while (!(attkChoice > 0 && attkChoice < 5)) {
                play.battleMenu();
                System.out.print("Pick a valid attack! (1 - 4): ");
                attkChoice = scan.nextInt();
            }
            while (Integer.parseInt(player1.getMoves()[attkChoice - 1][1]) > p1Mp) {
                System.out.println("Not enough mana! Use MEDITATE to regain mana! :(");
                play.battleMenu();
                attkChoice = scan.nextInt();
                while (!(attkChoice > 0 && attkChoice < 5)) {
                    play.battleMenu();
                    System.out.print("Pick a valid attack! (1 - 4): ");
                    attkChoice = scan.nextInt();
                }
            }
            scan.nextLine();
            int damage;
            if (attkChoice == 4) {
                int temp = p1Mp + play.mpIncrease();
                if (temp >= player1.getMp()) {
                    System.out.println("Your mob's MP increased by " + (Math.abs(player1.getMp() - p1Mp)) + "!");
                    p1Mp = player1.getMp();
                } else  {
                    System.out.println("Your mob's MP increased by 100!");
                    p1Mp = temp;
                }
            } else {
                System.out.println("You attack your opponent with " + player1.getMoves()[attkChoice - 1][0] + "!");
                damage = play.battleHelp(player1, player2, attkChoice);
                p2Hp -= damage;
                p1Mp -= Integer.parseInt(player1.getMoves()[attkChoice - 1][1]);
            }
            if (p2Hp <= 0) {
                int exp = (int) Math.round(Math.pow(1.1, player2.getLvl()) * 18);
                System.out.println(player2.getName() + "'s mob has fainted!");
                System.out.println("You have beaten " + player2.getName() + "!");
                player1.setExp(exp);
                System.out.println("You gained " + (exp) + " EXP!");
                if (player1.getExp() >= player1.getMaxExp()) {
                    System.out.println("You have gained " + player1.levelUp() + " stat point(s)!");
                }

            } else {
                int rand = (int) (Math.random() * 3 + 1);
                System.out.println(player2.getName() + " attacks with " + player2.getMoves()[rand - 1][0] + "!");
                damage = play.battleHelp(player2, player1, rand);
                p1Hp -= damage;
                if (p1Hp <= 0) {
                    System.out.println("Your mob has fainted!");
                    System.out.println("You lose! :(");
                }
            }
            // Continue
            cont();
        }
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
        System.out.println("4. Attack Damage");
    }

    // Method so i don't have to use the same thing over and over again
    // stops the program and makes user press enter, so they have time to read.
    public void cont() {
        System.out.println("Press enter to continue");
        String temp = scan.nextLine();
    }
}
