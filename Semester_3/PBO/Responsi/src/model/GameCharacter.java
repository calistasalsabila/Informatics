package model;

public abstract class GameCharacter {
    protected String name;
    protected int maxHp;
    protected int hp;
    protected int baseAttack;

    public GameCharacter(String name, int maxHp, int hp, int baseAttack){
        this.name = name;
        this.maxHp = maxHp;
        this.hp = hp;
        this.baseAttack = baseAttack;
    }

    public String getName() {
        return name;
    }
    public int getMaxHp() {
        return maxHp;
    }
    public int getHp() {
        return hp;
    }
    public int getBaseAttack() {
        return baseAttack;
    }

    public boolean isAlive(){
        return this.hp > 0;
    }

    public void setHp(int hp){
        this.hp = hp;

        if(this.hp < 0){
            this.hp = 0;
        }
        if(this.hp > this.maxHp){
            this.hp = this.maxHp;
        }
    }

    public void setBaseAttack(int baseAttack){
        this.baseAttack = baseAttack;
    }    
}
