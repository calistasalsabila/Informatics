package model;

public class Enemy extends GameCharacter {
    private String difficulty;

    public Enemy(String name,int maxHp,int hp, int baseAttack, String difficulty){
        super(name, maxHp, hp, baseAttack);
        this.difficulty = difficulty;
    }

    public String getDifficulty() {
        return difficulty;
    }
    
}
