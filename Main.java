public class Main {
    public Main() { // Constructor
        System.out.println("Welcome to the GTA Character Simulator!");
    }

    public static void main(String[] args) {
        new Main();  // Create an instance of Main to run the constructor

        // Step 1: Creating an instance of GTACharacter
        GTACharacter character = new GTACharacter();

        // Step 2: Test grabbing and dropping items
        character.grab("pistol");
        character.grab("health pack");
        character.drop("pistol");
        character.drop("shield");  // Testing drop with an item not in inventory

        // Step 3: Test examining and using items
        character.examine("health pack");  // Should be in inventory
        character.use("health pack");
        character.examine("grenade");  // Not in inventory

        // Step 4: Test walking and flying
        character.walk("north"); // Walks north, decreasing stamina
        character.walk("east"); // Walks east, further decreasing stamina
        character.fly(10, 5);  // Fly to specific coordinates

        // Step 5: Test shrinking and growing (simulating health change)
        character.shrink();  // Shrinks (damages health)
        character.grow();  // Grows (restores health)

        // Step 6: Test resting and undoing actions
        character.rest();
        character.undo();
    }
}
