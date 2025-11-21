package controller;


import model.Item;
import model.Player;
import util.Constant;
import exception.GameException;
import java.util.ArrayList;



public class InventoryController {
    private ArrayList<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        try {
            if (items.size() >= Constant.max_inventory) {
                throw new GameException("Inventory Full.");
            }
            items.add(item);
            System.out.println("Dapat Item: " + item.getName());
        } catch (GameException e) {
            System.out.println(e.getMessage());
        }
    }

    public void showAndUseItem(Player player, int indexInput) {
        if (indexInput < 0 || indexInput >= items.size()) {
            System.out.println("Item invalid.");
            return;
        }

        Item item = items.get(indexInput);
        
        if (item.getType().equalsIgnoreCase("Heal")) {
            System.out.println("use " + item.getName() + "...");
            int oldHp = player.getHp();
            player.setHp(player.getHp() + item.getValue());
            System.out.println("   HP right now: " + oldHp + " -> " + player.getHp());
            items.remove(indexInput);

        } else if (item.getType().equalsIgnoreCase("Attack")) {
            System.out.println("Use " + item.getName() + "...");
            int oldAtk = player.getBaseAttack();
            player.setBaseAttack(player.getBaseAttack() + item.getValue());
            System.out.println("   Attack now: " + oldAtk + " -> " + player.getBaseAttack());
            items.remove(indexInput);

        } else {
            System.out.println("This item cant be used.");
        }
    }

    public void showItems() {
        System.out.println("\nInventory");
        if (items.isEmpty()) {
            System.out.println("(empty)");
        } else {
            for (int i = 0; i < items.size(); i++) {
                Item it = items.get(i);
                System.out.println((i + 1) + ". " + it.getName() + " (" + it.getType() + " +" + it.getValue() + ")");
            }
        }
    }

    public boolean isEmpty() {
        return items.isEmpty(); 
    }
}
