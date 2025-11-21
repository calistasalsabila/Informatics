package view;
import model.Player;
import model.Enemy;

public class GameView {

    public void printTitle(){
        System.out.println("Welcome to JavaG");
    }

    public void printMainMenu(){
        System.out.println("Main Menu");
        System.out.println("1. Start Battle");
        System.out.println("2. Player Status");
        System.out.println("3. Inventory");
        System.out.println("4. Save Game");
        System.out.println("5. Load Game");
        System.out.println("Exit");
    }

    public void printPlayerStatus(Player p){
        System.out.println("Status Player");
        System.out.println("Nama: " + p.getName());
        System.out.println("Level: " + p.getLevel());
        System.out.println("Hp: " + p.getHp() + " and max Hp: " + p.getMaxHp());
        System.out.println("Attack: " + p.getBaseAttack());
        System.out.println("Xp: " + p.getExp());
    }

    public void printEnemyStatus(Enemy e){
        System.out.println("Target: " + e.getName() + " Diff: " + e.getDifficulty());
        System.out.println("Hp: " + e.getHp() + " with Attack: " + e.getBaseAttack());
    }

    public void printBattleLog(String attacker, String defender, int dmg) {
        System.out.println(attacker + " hit " + defender + " -> " + dmg + " dmg!");
    }

    public void printMsg(String msg) {
        System.out.println("[INFO] " + msg);
    }
    
    public void printError(String err) {
        System.err.println("[ERROR] " + err);
    }
}
