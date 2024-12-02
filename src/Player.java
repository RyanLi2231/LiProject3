public class Player {
    // Variables for the Mobs // mN = Mob Name | hp = Hit Points |
    // mp = Magic Points | df = Defense | sd = Speed | ad = Attack Bonus
    private String mN;
    private boolean opp = false;
    private int lvl = 1;
    private int hp;
    private int mp;
    private int df;
    private int sd;
    private int ad;
    private String[][] moves;

    public Player(String[] mob, String[][] moves) {
        mN = mob[0];
        hp = Integer.parseInt(mob[1]);
        mp = Integer.parseInt(mob[2]);
        df = Integer.parseInt(mob[3]);
        sd = Integer.parseInt(mob[4]);
        ad = Integer.parseInt(mob[5]);
        this.moves = moves;
    }

    // For creating the opponent /the int opp isn't used
    public Player(String[] mob, String[][] moves, int opponent) {
        opp = true;
        mN = mob[0];
        hp = Integer.parseInt(mob[1]);
        mp = Integer.parseInt(mob[2]);
        df = Integer.parseInt(mob[3]);
        sd = Integer.parseInt(mob[4]);
        ad = Integer.parseInt(mob[5]);
        this.moves = moves;
    }

    // Get Methods
    public String getmN() {
        return mN;
    }
    public int getLvl() {
        return lvl;
    }
    public int getHp() {
        return hp;
    }
    public int getMp() {
        return mp;
    }
    public int getDf() {
        return df;
    }
    public int getSd() {
        return sd;
    }
    public int getAd() {
        return ad;
    }

    // Methods to increase stats based off levels
}
