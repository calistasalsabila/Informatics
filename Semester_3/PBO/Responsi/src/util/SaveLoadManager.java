package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import model.Player;


public class SaveLoadManager {
    
    public void save(Player p) {
        try (PrintWriter writer = new PrintWriter(new File(Constant.save_file))) {
            writer.println(p.getName() + "," + p.getHp() + "," + p.getMaxHp() + "," + 
                           p.getBaseAttack() + "," + p.getLevel() + "," + p.getExp());
            System.out.println("Game saved!");
        } catch (FileNotFoundException e) {
            System.out.println("Failed to save file.");
        }
    }

    public Player load() {
        try (Scanner scanner = new Scanner(new File(Constant.save_file))) {
            if(scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(",");
                
                String name = data[0];
                int curHp = Integer.parseInt(data[1]);
                int maxHp = Integer.parseInt(data[2]);
                int atk = Integer.parseInt(data[3]);
                int lvl = Integer.parseInt(data[4]);
                int xp = Integer.parseInt(data[5]);
                
                Player p = new Player(name, maxHp, curHp, atk);
                
                p.setLevel(lvl);
                p.setExp(xp);
                
                return p; 
            }
        } catch (FileNotFoundException e) {
            System.out.println("nothing saved file.");
        } catch (Exception e) {
            System.out.println("Save file error.");
        }
        return null;
    }
}
