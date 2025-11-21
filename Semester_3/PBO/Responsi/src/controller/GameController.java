package controller;


import model.*;
import view.GameView;
import util.*;
import java.util.Random;

public class GameController {
    private Player player;
    private GameView view = new GameView();
    private InputHandler input = new InputHandler();
    private BattleController battle = new BattleController();
    private InventoryController inventory = new InventoryController();
    private SaveLoadManager saveSys = new SaveLoadManager();
    private Random random = new Random();
    private boolean isRunning = true;

    private String[] enemyNames = {"Dokaebi", "Outer God", "Asmodeus", "Oldest Dream", "4th Wall"};

    private Enemy generateRandomEnemy() {
        String name = enemyNames[random.nextInt(enemyNames.length)];
        int hp = 30 + random.nextInt(51);
        int atk = 5 + random.nextInt(11);
        String diff = (atk > 50) ? "Hard" : "Normal";
        return new Enemy(name, hp, hp, atk, diff);
    }

    public void run() {
        view.printTitle();
        String name = input.getString("Enter hero name: ");
        
        this.player = new Player(name, 100, 100, 15);

        while (isRunning && player.isAlive()) {
            view.printMainMenu();
            int choice = input.getInt("Pilih");

            switch (choice) {
                case 1: 
                    Enemy e = generateRandomEnemy();
                    
                    battle.startBattle(player, e, input, inventory);
                    
                    if (player.isAlive()) {
                        int gacha = random.nextInt(100);
                        if (gacha < 40) { 
                            inventory.addItem(new Item("Health Potion", "Heal", 45));
                        } else if (gacha < 60) { 
                            inventory.addItem(new Item("Strength Elixir", "Attack", 15)); 
                        } else {
                            System.out.println("No item obtained :D, wkwkwk ga hoki.");
                        }
                    }
                    break;

                case 2: 
                    view.printPlayerStatus(player);
                    break;

                case 3: 
                    inventory.showItems();
                    if (!inventory.isEmpty()) {
                        int idx = input.getInt("Pilih No Item (0 for cancel)") - 1;
                        if (idx != -1) {
                            inventory.showAndUseItem(player, idx);
                        }
                    }
                    break;

                case 4: 
                    saveSys.save(player);
                    break;

                case 5: 
                    Player loaded = saveSys.load();
                    if (loaded != null) {
                        this.player = loaded;
                        view.printMsg("Save data last player!");
                    }
                    break;

                case 0: 
                    isRunning = false;
                    view.printMsg("See you again!");
                    break;

                default:
                    view.printError("Choose the right number.");
            }
        }
    }
}
