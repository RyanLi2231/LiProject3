public class MobBattles {
    // Variables for the Mobs // mN = Mob Name | hp = Hit Points |
    // mp = Magic Points | df = Defense | sd = Speed | ad = Attack Bonus
    private Player player;

    // The list of Mobs // HP|MP (Maybe)|DEFENSE|SPEED|ATTACK Damage/BONUS (help simplify the attacks)
    private String[][] mobs = {{"Zombie", "100", "200", "20", "30", "2"}};
    // List of moves // Name | MP cost | attack type /| accuracy Down
    private String[][][] moves = {{{"Strike", "0", "single"}, {"Spit", "20", "gradual"}, {"Lunge", "30", "heavy"}, {"Taunt", "10", "accDown"}}};
    // List of People you can encounter
    private String[] people = {"Sam", "Tom", "Timmy", "Jill", "Max", "Toby", "Samantha", "Jerry", "Sally", "Mary", "Luke", "Brock", "Jake"};

    public MobBattles(int mobNum) {
        player = new Player(mobs[mobNum - 1], moves[mobNum - 1]);
    }
    public MobBattles() {
        int mobNum =  (int) (Math.random() * mobs.length) - 1;
        player = new Player(mobs[mobNum], moves[mobNum]);
    }

    // Getters / Setters

    public String[][] getMobs() {
        return mobs;
    }

    // Methods
    public void printMobNames() {
        for (int i = 0; i < mobs.length; i++) {
            System.out.println(i + 1 + ". " + mobs[i][0]);
        }
    }
    public void battle() {
        String battler = people[(int) (Math.random() * people.length)] ;
        int mobNum = (int) (Math.random() * mobs.length) - 1;
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
        }
    }
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
    public void battleMenu() {
        String[] moves =
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
    public int single() {
        return 20 * (1 + (player.getAd() / 100));
    }

    public int heavy() {
        return 20 * (1 + (player.getAd() / 10));
    }

    public int gradual
}