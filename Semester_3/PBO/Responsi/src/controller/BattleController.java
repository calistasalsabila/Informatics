package controller;

import model.Player;
import model.Enemy;
import view.GameView;
import util.InputHandler;
import java.util.Random;

public class BattleController {
    private GameView view = new GameView();
    private Random rand = new Random();

    public void startBattle(Player p, Enemy e, InputHandler input, InventoryController inventory) {
        view.printEnemyStatus(e);
        
        while (p.isAlive() && e.isAlive()) {
            System.out.println("Your Turn! (HP: " + p.getHp() + ")");
            System.out.println("1. Attack");
            System.out.println("2. Use Item");            
            int choice = input.getInt("Aksi");
            boolean playerHasActed = false; 

            switch (choice) {
                case 1: 
                    int dmg = p.getBaseAttack() + rand.nextInt(6);
                    assert dmg >= 0 : "Damage Error"; 
                    
                    e.setHp(e.getHp() - dmg);
                    view.printBattleLog(p.getName(), e.getName(), dmg);
                    playerHasActed = true; 
                    break;

                case 2: 
                    if (inventory.isEmpty()) {
                        System.out.println("Inventory Empty!");
                    } else {
                        inventory.showItems();
                        int idx = input.getInt("Pilih No Item (0 for cancel)") - 1;
                        
                        if (idx != -1) {
                            int oldHp = p.getHp();
                            int oldAtk = p.getBaseAttack();
                            
                            inventory.showAndUseItem(p, idx);
                            
                            if (p.getHp() != oldHp || p.getBaseAttack() != oldAtk) {
                                playerHasActed = true; 
                            }
                        }
                    }
                    break;
                    
                default:
                    System.out.println("Invalid input.");
            }

            if (!e.isAlive()) {
                view.printMsg("Enemy Defeat! (+45 XP)");
                p.addExp(45);
                return;
            }

            if (playerHasActed && e.isAlive()) {
                System.out.println("\n--- Enemy Turn ---");
                try { Thread.sleep(800); } catch (InterruptedException ex) {} 

                int enemyDmg = e.getBaseAttack() + rand.nextInt(3);
                p.setHp(p.getHp() - enemyDmg);
                view.printBattleLog(e.getName(), p.getName(), enemyDmg);
                
                if (!p.isAlive()) {
                    view.printMsg("Defeat.");
                }
            }
        }
    }
}
