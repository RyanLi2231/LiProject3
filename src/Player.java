public class Player {
    // oppName = opponent Name, for opponents only
    // Variables for the Mobs // mN = Mob Name | hp = Hit Points |
    // mp = Magic Points | df = Defense | sd = Speed | ad = Attack Bonus
    private boolean opp = false;
    private String Name;
    private String mN;
    private int lvl = 1;
    private int hp;
    private int mp;
    private int df;
    private int ad;
    private int exp;
    // Max Exp increases exponentially
    private int maxExp = 20;
    private String[][] moves;
    private int statPoints = 1;

    public Player(String[] mob, String[][] moves) {
        mN = mob[0];
        hp = Integer.parseInt(mob[1]);
        mp = Integer.parseInt(mob[2]);
        df = Integer.parseInt(mob[3]);
        ad = Integer.parseInt(mob[4]);
        this.moves = moves;
    }

    // For creating the opponent /the int opp isn't used
    public Player(String[] mob, String[][] moves, String opponentName) {
        Name = opponentName;
        mN = mob[0];
        hp = Integer.parseInt(mob[1]);
        mp = Integer.parseInt(mob[2]);
        df = Integer.parseInt(mob[3]);
        ad = Integer.parseInt(mob[4]);
        this.moves = moves;
        opp = true;
    }

    // Get Methods
    public boolean isOpp() {
        return opp;
    }
    public String getName() {
        return Name;
    }
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
    public int getAd() {
        return ad;
    }
    public int getStatPoints() {
        return statPoints;
    }

    public String[][] getMoves() {
        return moves;
    }
    // Set Method
    public void setName(String name) {
        Name = name;
    }
    public void setStatPoints(int statPoints) {
        this.statPoints = statPoints;
    }

    // Methods to increase stats based off levels
    public boolean statIncrease(int stat) {
        if (stat == 1) {
            hp += 20;
            statPoints--;
            return false;
        } else if (stat == 2) {
            mp += 20;
            statPoints--;
            return false;
        } else if (stat == 3) {
            df += 2;
            statPoints--;
            return false;
        } else if (stat == 4) {
            ad += 2;
            statPoints--;
            return false;
        }
        return true;
    }
    // This is for the opponent
    public void statIncrease(Player player) {

    }
}
