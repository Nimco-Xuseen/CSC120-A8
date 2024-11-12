import java.util.ArrayList;
import java.util.List;

/**
 * GTACharacter class represents a character in a GTA-style game.
 * The character can collect items like weapons, interact with vehicles,
 * move around, and adjust health and stamina levels.
 */
public class GTACharacter implements Contract {
    private List<String> inventory = new ArrayList<>();
    private int posX = 0, posY = 0; // Starting position on the map
    private int health = 100;
    private int stamina = 100;

    @Override
    public void grab(String item) {
        inventory.add(item);
        System.out.println("You picked up a " + item + ".");
    }

    @Override
    public String drop(String item) {
        if (inventory.remove(item)) {
            System.out.println("You dropped the " + item + ".");
            return item;
        } else {
            System.out.println("You don't have a " + item + " to drop.");
            return null;
        }
    }

    @Override
    public void examine(String item) {
        if (inventory.contains(item)) {
            System.out.println("You examine the " + item + ". Looks like it could be useful.");
        } else {
            System.out.println("You don't have a " + item + " to examine.");
        }
    }

    @Override
    public void use(String item) {
        if (inventory.contains(item)) {
            if (item.equals("medkit")) {
                health = Math.min(health + 20, 100);
                System.out.println("You used a medkit. Health is now " + health + ".");
            } else if (item.equals("energy drink")) {
                stamina = Math.min(stamina + 20, 100);
                System.out.println("You used an energy drink. Stamina is now " + stamina + ".");
            } else {
                System.out.println("You use the " + item + ".");
            }
        } else {
            System.out.println("You don't have a " + item + " to use.");
        }
    }

    @Override
    public boolean walk(String direction) {
        if (stamina > 0) {
            switch (direction.toLowerCase()) {
                case "north": posY++; break;
                case "south": posY--; break;
                case "east": posX++; break;
                case "west": posX--; break;
                default:
                    System.out.println("Invalid direction!");
                    return false;
            }
            stamina -= 5;
            System.out.println("You walk " + direction + " to (" + posX + ", " + posY + "). Stamina: " + stamina);
            return true;
        } else {
            System.out.println("You're too tired to walk. Rest or use an energy drink.");
            return false;
        }
    }

    @Override
    public boolean fly(int x, int y) {
        posX = x;
        posY = y;
        System.out.println("You fly to (" + posX + ", " + posY + ").");
        return true;
    }

    @Override
    public Number shrink() {
        health -= 10;
        System.out.println("You took damage. Health is now " + health + ".");
        return health;
    }

    @Override
    public Number grow() {
        health = Math.min(health + 10, 100);
        System.out.println("You regain some health. Health is now " + health + ".");
        return health;
    }

    @Override
    public void rest() {
        stamina = Math.min(stamina + 20, 100);
        System.out.println("You rest and regain stamina. Stamina is now " + stamina + ".");
    }

    @Override
    public void undo() {
        System.out.println("You undo your last action.");
    }
}
