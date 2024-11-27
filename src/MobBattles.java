public class MobBattles {
    // Variables for the Mobs // mN = Mob Name | hp = Hit Points |
    // mp = Magic Points | df = Defense | sd = Speed | ad = Attack Bonus
    private String mN;
    private int lvl = 1;
    private int hp;
    private int mp;
    private int df;
    private int sd;
    private int ad;

    // The list of Mobs // HP|MP (Maybe)|DEFENSE|SPEED|ATTACK Damage/BONUS (help simplify the attacks)
    private String[][] mobs = {{"Zombie", "100", "200", "20", "30", "2"}};
    // List of moves // Name | MP cost | attack type /| accuracy Down
    private String[][][] moves = {{{"Strike", "0", "single"}, {"Spit", "20", "gradual"}, {"Lunge", "30", "heavy"}, {"Taunt", "10", "accDown"}}};
    // List of People you can encounter
    private String[] people = {"Sam", "Tom", "Timmy", "Jill", "Max", "Toby", "Samantha", "Jerry", "Sally", "Mary", "Luke", "Brock", "Jake"};

    public MobBattles(int mobNum) {
        mN = mobs[mobNum - 1][0];
        hp = Integer.parseInt(mobs[mobNum - 1][1]);
        mp = Integer.parseInt(mobs[mobNum - 1][2]);
        df = Integer.parseInt(mobs[mobNum - 1][3]);
        sd = Integer.parseInt(mobs[mobNum - 1][4]);
        ad = Integer.parseInt(mobs[mobNum - 1][5]);
    }
    public MobBattles() {
        int mobNum = (int) (Math.random() * mobs.length);
        mN = mobs[mobNum - 1][0];
        hp = Integer.parseInt(mobs[mobNum - 1][1]);
        mp = Integer.parseInt(mobs[mobNum - 1][2]);
        df = Integer.parseInt(mobs[mobNum - 1][3]);
        sd = Integer.parseInt(mobs[mobNum - 1][4]);
        ad = Integer.parseInt(mobs[mobNum - 1][5]);
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
        System.out.println("You have entered the battle arena!");
        System.out.println("You will be facing " + battler + "!");

        System.out.println(battler + "'s mob is a");
    }
    public void printMobStats() {
        String[] statNames = {"Level: " + lvl, "Hp: " + hp, "Mp: " + mp, "Defense: " + df, "Speed: " + sd, "Attack: " + ad};
        System.out.println(mN);
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
    // Opponent Creator

    //Attack Types
    public void single() {

    }
}