import java.util.Arrays;

/**
 * This class is the calculations and data of the Mob Battles Project
 *
 * @author Ryan Li
 */
public class MobBattles {
    // Variables for the Mobs // mN = Mob Name | hp = Hit Points |
    // mp = Magic Points | df = Defense | sd = Speed | ad = Attack Bonus
    /** Creation of the player class for the user to initiate */
    private Player player;
    private Player player2;

    // The list of Mobs // Name|HP|MP (Maybe)|DEFENSE|ATTACK Damage/BONUS (help simplify the attacks)
    /** A String array that stores all the mobs and their stats */
    private String[][] mobs = {{"Zombie", "100", "200", "20", "6"}, {"Golem", "140", "100", "30", "2"}, {"Goblin", "80", "200", "10", "12"}, {"Orc", "200", "50", "0", "16"}};
    // List of moves // Name | MP cost | attack type
    /** A multidimensional String array that stores the list of moves for each mob */
    private String[][][] moves = {
            {{"Strike", "20", "single"}, {"Spit", "20", "multi"}, {"Lunge", "50", "heavy"}, {"Meditate", "0", "mpIncrease"}},
            {{"Smash", "20", "single"}, {"Stone Rain", "20", "multi"}, {"Boulder Bash", "50", "heavy"}, {"Meditate", "0", "mpIncrease"}},
            {{"Slash", "20", "single"}, {"Multi Thrusts", "25", "multi"}, {"Stab", "60", "heavy"}, {"Meditate", "0", "mpIncrease"}},
            {{"Bash", "20", "single"}, {"Stomp", "20", "single"}, {"Club Swing", "50", "heavy"}, {"Meditate", "0", "mpIncrease"}}};
    // List of People you can encounter
    /** The list of people you can possibly encounter when battling */
    private String[] people = {"Sam", "Tom", "Timmy", "Jill", "Max", "Toby", "Samantha", "Jerry", "Sally", "Mary", "Luke", "Brock", "Jake"};

    /** Sets up the player object and allocates the stats and moves for the mob
     *
     * @param mobNum the mob that will be selected based on the user's input
     */
    public MobBattles(int mobNum, String name) {
        player = new Player(mobs[mobNum - 1], moves[mobNum - 1]);
        player.setName(name);
    }
    /** Sets up the player object and allocates the stats and moves for the mob in the case that the user wants a random mob */
    public MobBattles(String name) {
        int mobNum =  (int) (Math.random() * mobs.length) - 1;
        player = new Player(mobs[mobNum], moves[mobNum]);
        player.setName(name);
    }

    // Getters / Setters
    public Player getPlayer() {
        return player;
    }
    public Player getPlayer2() {
        return player2;
    }

    /**
     *
     * @return returns the array mobs for the use of the Player class
     */
    public String[][] getMobs() {
        return mobs;
    }

    // Methods

    /** prints the name of the mobs */
    public void printMobNames() {
        for (int i = 0; i < mobs.length; i++) {
            System.out.println(i + 1 + ". " + Arrays.toString(mobs[i]));
        }
    }

    /** starts the battle with another player (ai) */
    public void battle() {
        opponentSetUp((int) (Math.random() * mobs.length), people[(int) (Math.random() * people.length)]);
        System.out.println("You have entered the battle arena!");
        System.out.println("You will be facing " + player2.getName() + "!");
        System.out.println(player2.getName() + "'s mob is a " + player2.getmN());
        System.out.println("It is level " + player2.getLvl());
    }
    public void opponentSetUp(int mobNum, String name) {
        int level = (int) (Math.random() * 3) + player.getLvl();
        player2 = new Player(mobs[mobNum], moves[mobNum], name, level);
        player2.statIncrease("" + (level - 1));
    }

    public void battleMenu(int hp, int mp, Player player) {
        System.out.println();
        System.out.println(player.getName() + ": " + player.getmN());
        System.out.println(hp); // Temporary!!
        System.out.println("﹎﹎﹎﹎﹎﹎﹎﹎﹎﹎﹎");
        for (int i = 1; i <= (int) (18 * ((double) hp / player.getHp())); i++) {
            System.out.print("|");
        }
        System.out.println();
        System.out.println("﹊﹊﹊﹊﹊﹊﹊﹊﹊﹊﹊");
        System.out.println(mp + "/" + player.getMp());
    }
    /** Prints the movies for the user's mobs so they can battle */
    public void battleMenu() {
        String[][] moves = player.getMoves();
        for (int i = 0; i < moves.length; i++) {
            int count = 20;
            System.out.print((i + 1) + ". " + Arrays.toString(moves[i]));
            count -= Arrays.toString(moves[i]).length() - 2;
            for(int j = 1; j <= count; j++) {
                System.out.print(" ");
            }
            i++;
            if (i < moves.length) {
                System.out.println((i + 1) + ". " + Arrays.toString(moves[i]));
            }

        }
    }
    public int battleHelp(Player player, Player player2, int attkChoice) {
        String attkChoice2 = player.getMoves()[attkChoice - 1][2];
        int damage;

        if (attkChoice2.equals("single")) {
            damage = damageTaken(single(player), player2);
            System.out.println(player.getName() + "'s " + player.getmN() + " has dealt " + damage + " damage ");
            return damage;
        } else if (attkChoice2.equals("heavy")) {
            damage = damageTaken(heavy(player), player2);
            System.out.println(player.getName() + "'s " + player.getmN() + " has dealt " + damage + " damage ");
            return damage;
        } else if (attkChoice2.equals("multi")) {
            damage = damageTaken(multi(player), player2);
            System.out.println(player.getName() + "'s " + player.getmN() + " has dealt " + damage + " damage ");
            return damage;
        } else if (attkChoice2.equals("mpIncrease")) {
            return -1;
        }
        return 0;
    }

    /** Prints the user's mob's stats */
    public void printMobStats() {
        String[] statNames = {"Level: " + player.getLvl(), "Hp: " + player.getHp(), "Mp: " + player.getMp(), "Defense: " + player.getDf(), "Attack: " + player.getAd(), "EXP: " + player.getExp(), "Free Stat Points: " + player.getStatPoints()};
        System.out.println(player.getmN());
        for (int i = 0; i < statNames.length; i++) {
            int count = 20;
            System.out.print("|" + statNames[i] + "|");
            count -= statNames[i].length() - 2;
            for(int j = 1; j <= count; j++) {
                System.out.print(" ");
            }
            i++;
            if (i < statNames.length) {
                System.out.println("|" + statNames[i] + "|");
            } else {
                System.out.println();
            }
        }
    }

    //Attack Types

    /**
     * Deals damage to the opposer
     * @return returns the damage dealt
     */
    public int single(Player player) {
        return (int) (20 * (1 + ((double) player.getAd() / 35)));
    }
    /**
     * Deals heavy damage to the opposer
     * @return returns the damage dealt
     */
    public int heavy(Player player) {
        return (int) (20 * (1 + (player.getAd() / 10.0)));
    }
    /**
     * Deals damage overtime
     * @return returns the damage dealt overtime
     */
    public int multi(Player player) {
        int rand = (int) (Math.random() * 5 + 1);
        System.out.println(player.getName() + "'s " + player.getmN() + " hits " + rand + " times!");
        return rand * (int) (9 * (1 + ((double) player.getAd() / 50)));
    }
    public int mpIncrease() {
        return 100;
    }
    // Damage Taken

    /**
     * Damage that's taken from the opposer by factoring the defense of the taker
     * @param damage Damage that is taken from single or heavy damage
     * @return returns the damage taken
     */
    public int damageTaken(int damage, Player player) {
        int trueDamage = (int) (damage - ((double) player.getDf() / 5));
        if (trueDamage < 0) {
            return 0;
        } else {
            return trueDamage;
        }
    }
}
