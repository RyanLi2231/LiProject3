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

    // The list of Mobs // Name|HP|MP (Maybe)|DEFENSE|SPEED|ATTACK Damage/BONUS (help simplify the attacks)
    /** A String array that stores all the mobs and their stats */
    private String[][] mobs = {{"Zombie", "100", "200", "20", "30", "2"}};
    // List of moves // Name | MP cost | attack type /| accuracy Down
    /** A multidimensional String array that stores the list of moves for each mob */
    private String[][][] moves = {{{"Strike", "0", "single"}, {"Spit", "20", "gradual"}, {"Lunge", "30", "heavy"}, {"Taunt", "10", "accDown"}}};
    // List of People you can encounter
    /** The list of people you can possibly encounter when battling */
    private String[] people = {"Sam", "Tom", "Timmy", "Jill", "Max", "Toby", "Samantha", "Jerry", "Sally", "Mary", "Luke", "Brock", "Jake"};

    /** Sets up the player object and allocates the stats and moves for the mob */
    public MobBattles(int mobNum) {
        player = new Player(mobs[mobNum - 1], moves[mobNum - 1]);
    }
    /** Sets up the player object and allocates the stats and moves for the mob in the case that the user wants a random mob */
    public MobBattles() {
        int mobNum =  (int) (Math.random() * mobs.length) - 1;
        player = new Player(mobs[mobNum], moves[mobNum]);
    }

    // Getters / Setters

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
        String battler = people[(int) (Math.random() * people.length)] ;
        int mobNum = (int) (Math.random() * mobs.length);
        Player player2 = new Player(mobs[mobNum], moves[mobNum], 0);
        int tempHp = player.getHp();
        System.out.println("You have entered the battle arena!");
        System.out.println("You will be facing " + battler + "!");
        System.out.println(battler + "'s mob is a " + player2.getmN());
        int roundNum = 1;
        while (tempHp > 0 && player2.getHp() > 0) {

            // Maybe add board design
            System.out.println("These are your moves");
            battleMenu();
            roundNum++;
            break;
        }
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

    /**
     * Prints the Hp & mp of the user's mob & the opponent's mob
     * @param currentHP the current hp of the user's mob
     * @param currentHP2 the current hp of the opponent's mob
     * @param currentMP the current mp of the user's mob
     * @param currentMP2 the current mp of the opponent's mob
     */
    public void battleTable(int currentHP, int currentMP, int currentHP2, int currentMP2) {

    }

    /** Prints the user's mob's stats */
    public void printMobStats() {
        String[] statNames = {"Level: " + player.getLvl(), "Hp: " + player.getHp(), "Mp: " + player.getMp(), "Defense: " + player.getDf(), "Speed: " + player.getSd(), "Attack: " + player.getAd()};
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
    public int single() {
        return 20 * (1 + (player.getAd() / 100));
    }

    /**
     * Deals heavy damage to the opposer
     * @return returns the damage dealt
     */
    public int heavy() {
        return 20 * (1 + (player.getAd() / 10));
    }

    /**
     * Deals damage overtime
     * @return returns the damage dealt overtime
     */
    public int gradual() {
        return 0;
    }

    // Damage Taken

    /**
     * Damage that's taken from the opposer by factoring the defense of the taker
     * @param damage Damage that is taken from single or heavy damage
     * @return returns the damage taken
     */
    public int damageTaken(int damage) {
        int trueDamage = (int) (damage - (player.getDf() / 5));
        if (trueDamage < 0) {
            return 0;
        } else {
            return trueDamage;
        }
    }
}