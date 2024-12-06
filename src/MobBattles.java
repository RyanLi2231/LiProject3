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
    Player player2;

    // The list of Mobs // Name|HP|MP (Maybe)|DEFENSE|SPEED|ATTACK Damage/BONUS (help simplify the attacks)
    /** A String array that stores all the mobs and their stats */
    private String[][] mobs = {{"Zombie", "100", "200", "20", "2"}};
    // List of moves // Name | MP cost | attack type /| accuracy Down
    /** A multidimensional String array that stores the list of moves for each mob */
    private String[][][] moves = {{{"Strike", "0", "single"}, {"Spit", "20", "gradual"}, {"Lunge", "50", "heavy"}, {"Meditate", "0", "mpIncrease"}}};
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
            System.out.println(i + 1 + ". " + mobs[i][0]);
        }
    }

    /** starts the battle with another player (ai) */
    public void battle() {
        opponentSetUp((int) (Math.random() * mobs.length), people[(int) (Math.random() * people.length)]);
        System.out.println("You have entered the battle arena!");
        System.out.println("You will be facing " + player2.getName() + "!");
        System.out.println(player2.getName() + "'s mob is a " + player2.getmN());
    }
    public void opponentSetUp(int mobNum, String name) {
        player2 = new Player(mobs[mobNum], moves[mobNum], name);
    }
    public void battleMenu(int hp, int mp, Player player) {
        System.out.println();
        System.out.println(player.getName() + ": " + player.getmN());
        System.out.println("﹎﹎﹎﹎﹎﹎﹎﹎﹎﹎﹎");

        for (int i = 1; i <= 18 - (player.getHp() - hp); i++) {
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
    public int battleHelp(Player player, int attkChoice) {
        String attkChoice2 = player.getMoves()[attkChoice - 1][2];
        String attkMpCost = player.getMoves()[attkChoice - 1][1];
        int damage = 0;

        if (attkChoice2.equals("single")) {
            damage = damageTaken(single(player), player);
            System.out.println(player.getName() + " has dealt " + damage + " damage ");
        } else if (attkChoice2.equals("heavy")) {

        } else if (attkChoice2.equals("gradual")) {

        } else if (attkChoice2.equals("mpIncrease")) {

        }
    }

    /**
     * Prints the Hp and mp of the user's mob and the opponent's mob
     * @param currentHP the current hp of the user's mob
     * @param currentHP2 the current hp of the opponent's mob
     * @param currentMP the current mp of the user's mob
     * @param currentMP2 the current mp of the opponent's mob
     */
    public void battleTable(int currentHP, int currentMP, int currentHP2, int currentMP2) {
        System.out.println("");
    }

    /** Prints the user's mob's stats */
    public void printMobStats() {
        String[] statNames = {"Level: " + player.getLvl(), "Hp: " + player.getHp(), "Mp: " + player.getMp(), "Defense: " + player.getDf(), "Attack: " + player.getAd()};
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
            }

        }
    }

    //Attack Types

    /**
     * Deals damage to the opposer
     * @return returns the damage dealt
     */
    public int single(Player player) {
        return 20 * (1 + (player.getAd() / 100));
    }
    /**
     * Deals heavy damage to the opposer
     * @return returns the damage dealt
     */
    public int heavy(Player player) {
        return 20 * (1 + (player.getAd() / 10));
    }
    /**
     * Deals damage overtime
     * @return returns the damage dealt overtime
     */
    public int gradual(Player player) {
        return (10 * (1 + (player.getAd() / 120)));
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
        int trueDamage = (int) (damage - (player.getDf() / 5));
        if (trueDamage < 0) {
            return 0;
        } else {
            return trueDamage;
        }
    }
}
