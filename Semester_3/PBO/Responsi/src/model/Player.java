package model;


public class Player extends GameCharacter {
    private int level;
    private int exp;

    public Player(String name, int maxHp, int hp, int baseAttack) {
        super(name, maxHp, hp, baseAttack);
        this.level = 1;
        this.exp = 0;
    }

    public int getLevel() {
        return level; 
    }

    public int getExp() {
        return exp; 
    }

    public void setLevel(int level) {
         this.level = level; 
    }

    public void setExp(int exp) {
         this.exp = exp; 
    }

    public void addExp(int amount) {
        this.exp += amount;
        System.out.println("get " + amount + " XP.");

        if (this.exp >= 100) {
            this.level++;
            this.exp -= 100; 

            this.maxHp += 50;
            this.hp = this.maxHp;
            this.baseAttack += 10;

            System.out.println("LEVEL UP! now level " + this.level);
            System.out.println("[Stats Up] MaxHP +50 (Full Heal), Attack +10");
        }
    }
}
