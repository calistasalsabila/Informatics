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

    public void addExp(int amount){
        this.exp =+ amount;

        if(this.exp >= 100){
            this.level++;
            this.exp -= 100;

            this.hp += 50;
            this.hp = this.maxHp;
            this.baseAttack += 75;

            System.out.println("lEVEL +1");
            System.out.println("Hp + 50 and  base attack + 75");
            System.out.println("Hp right now " + this.hp);
            System.out.println("Exp right now: " + this.exp);
        }
    }
}
