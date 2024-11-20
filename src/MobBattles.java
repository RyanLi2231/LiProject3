public class MobBattles {
    // Variables for the Mobs // mN = Mob Name | hp = Hit Points |
    // mp = Magic Points | df = Defense | sd = Speed | ad = Attack Bonus
    private String mN;
    private int hp;
    private int mp;
    private int df;
    private int sd;
    private int ad;

    // The list of Mobs && Moves // HP|MP (Maybe)|DEFENSE|SPEED|ATTACK Damage/BONUS (help simplify the attacks)
    private String[][] mobs = {{"Zombie", "100", "200", "20", "30", "1.5"}};
    private String[][] moves = {{}};

    public MobBattles(int mobNum) {
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
    public void printMobStats() {
        String[][] statNames = {{"Hp: ", Integer.toString(hp)}, {"Mp: "}, {"Defense: "}, {"Speed: "}, {"Attack: "}};
        System.out.println(mN);
        for (int i = 0; i < statNames.length; i++) {
            int count = 20;
            System.out.print("|" + statNames[i] + );
            for(int j = 1; j <= count; j++) {

            }
        }
    }
}
