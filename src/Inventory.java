import java.util.*;

public class Inventory {

    // --- Private fields ---
    private final Map<String, Integer> rawMaterials = new HashMap<>();
    private final List<CraftedItem> craftedItems = new ArrayList<>();
    private final Set<String> uniqueDeepSeaItems = new HashSet<>();

    private boolean doubleEffect = false;
    private boolean hasFurnace = false;
    private boolean hasAlchemyTable = false;

    private int fullnessLevel = 0;

    private final GameState gameState;
    private final Scanner sc = new Scanner(System.in);
    private final Random random = new Random();

    public Inventory(GameState gameState) {
        this.gameState = gameState;
    }

    public GameState getGameState() {
        return gameState;
    }

    // ---------- Added for FileHandler ----------
    public Map<String, Integer> getRawMaterials() {
        return rawMaterials;
    }

    public List<CraftedItem> getCraftedItems() {
        return craftedItems;
    }

    public void setFullnessLevel(int value) {
        this.fullnessLevel = value;
    }

    // ---------- Deep Sea ----------
    public void addDeepSeaItemFound(String item) {
        uniqueDeepSeaItems.add(item.toLowerCase());
    }

    public int getUniqueDeepSeaItemsCount() {
        return uniqueDeepSeaItems.size();
    }

    public void resetDeepSeaItemTracker() {
        uniqueDeepSeaItems.clear();
    }

    // ---------- Raw Materials ----------
    public void addRawMaterial(String name, int quantity) {
        String key = name.toLowerCase();

        if (key.equals("map fragment") && !gameState.hasMapFragment()) {
            gameState.setHasMapFragment(true);
            System.out.println("\n*** LOCATION UNLOCKED! You found a Map Fragment revealing the CAVE! ***");
        }

        rawMaterials.put(key, rawMaterials.getOrDefault(key, 0) + quantity);
    }

    public boolean hasMaterial(String name) {
        return rawMaterials.getOrDefault(name.toLowerCase(), 0) > 0;
    }

    public int getMaterialCount(String name) {
        return rawMaterials.getOrDefault(name.toLowerCase(), 0);
    }

    public boolean useMaterial(String name) {
        return useMaterial(name, 1);
    }

    public boolean useMaterial(String name, int quantity) {
        String key = name.toLowerCase();

        if (rawMaterials.getOrDefault(key, 0) >= quantity) {
            rawMaterials.put(key, rawMaterials.get(key) - quantity);

            if (rawMaterials.get(key) == 0) {
                rawMaterials.remove(key);
            }
            return true;
        }
        return false;
    }

    // ---------- Crafted Items ----------
    public void addCraftedItem(CraftedItem ci) {
        craftedItems.add(ci);
    }

    public int getCraftedItemCount() {
        return craftedItems.size();
    }

    public void removeRandomCraftedItem() {
        if (!craftedItems.isEmpty()) {
            craftedItems.remove(random.nextInt(craftedItems.size()));
        }
    }

    // ---------- Structures ----------
    public void registerStructure(String name) {
        switch (name.toLowerCase()) {
            case "furnace" -> hasFurnace = true;
            case "alchemy table" -> hasAlchemyTable = true;
        }
    }

    public boolean hasFurnace() { return hasFurnace; }
    public boolean hasAlchemyTable() { return hasAlchemyTable; }

    public boolean hasWoodenBatea() {
        return craftedItems.stream()
                .anyMatch(t -> t.getName().equalsIgnoreCase("Wooden Batea"));
    }

    // ---------- Display ----------
    public void showInventory() {
        System.out.println("=== Raw Materials Gathered ===");

        if (fullnessLevel > 0) {
            System.out.println("Status: Full (Gold Panning Multiplier: "
                    + gameState.getPlatinumChance() + "x, Lasts " + fullnessLevel + " explorations)");
        } else {
            System.out.println("Status: Hungry (Gold Panning Multiplier: "
                    + gameState.getPlatinumChance() + "x)");
        }

        if (rawMaterials.isEmpty()) {
            System.out.println("Empty.");
        } else {
            rawMaterials.forEach((name, count) ->
                    System.out.println("- " + capitalize(name) + " x" + count));
        }

        System.out.println("\n=== Crafted Items ===");
        if (craftedItems.isEmpty()) {
            System.out.println("Empty.");
        } else {
            for (int i = 0; i < craftedItems.size(); i++) {
                System.out.println((i + 1) + ". " + craftedItems.get(i).getName());
            }
        }

        System.out.println("\n=== Permanent Structures ===");
        System.out.println("- Furnace: " + (hasFurnace ? "Ready" : "Not Built"));
        System.out.println("- Alchemy Table: " + (hasAlchemyTable ? "Ready" : "Not Built"));
    }

    // ---------- Crafted Item Use ----------
    public void useCraftedItem(int index) {
        try {
            CraftedItem item = craftedItems.get(index);

            if (!item.getName().equalsIgnoreCase("Wooden Batea")) {
                craftedItems.remove(index);
            }

            useItemLogic(item);

        } catch (IndexOutOfBoundsException e) {
            System.out.println("No item found at that slot!");
        }
    }

    // ---------- Tools & Food ----------
    public void processToolsAndFood() {

        boolean canOperate =
                hasFurnace ||
                hasWoodenBatea() ||
                hasMaterial("Raw Meat") ||
                hasMaterial("Cooked Meat") ||
                (hasFurnace && hasMaterial("Sand") && hasMaterial("Limestone"));

        if (!canOperate) return;

        System.out.println("\n--- Tool & Food Operations ---");
        int option = 1;

        if (hasFurnace && hasMaterial("Raw Meat")) {
            System.out.print(option++ + ". Cook Raw Meat? (y/n): ");
            if (sc.nextLine().trim().equalsIgnoreCase("y")) {
                if (useMaterial("Raw Meat")) {
                    addRawMaterial("Cooked Meat", 1);
                    System.out.println("You cooked Raw Meat!");
                }
            }
        }

        if (hasMaterial("Cooked Meat")) {
            System.out.print(option++ + ". Eat Cooked Meat? (y/n): ");
            if (sc.nextLine().trim().equalsIgnoreCase("y")) {
                if (useMaterial("Cooked Meat")) {
                    fullnessLevel = 5;
                    gameState.setPlatinumChance(2);
                    gameState.resetExplorationLimit();
                }
            }
        }

        if (hasFurnace && hasMaterial("Sand") && hasMaterial("Limestone")) {
            System.out.print(option++ + ". Craft Glass? (y/n): ");
            if (sc.nextLine().trim().equalsIgnoreCase("y")) {
                if (useMaterial("Sand") && useMaterial("Limestone")) {
                    addRawMaterial("Glass", 1);
                    System.out.println("You created Glass!");
                }
            }
        }

        if (option == 1) {
            System.out.println("No available operations.");
        }
    }

    // ---------- Gold Panning ----------
    private void performGoldPanning() {
        int multiplier = gameState.getPlatinumChance();
        int platChance = 1 * multiplier;
        int goldChance = 2 * multiplier;

        System.out.println("You wash the river sediment...");

        boolean found = false;

        if (random.nextInt(100) < platChance) {
            addRawMaterial("Platinum", 1);
            System.out.println("You found PLATINUM!");
            found = true;
        }

        if (random.nextInt(100) < goldChance) {
            addRawMaterial("Gold", 1);
            System.out.println("You found GOLD!");
            found = true;
        }

        if (!found) {
            System.out.println("Just mud this time...");
        }
    }

    public void decreaseFullness() {
        if (fullnessLevel > 0) {
            fullnessLevel--;

            if (fullnessLevel == 0) {
                gameState.setPlatinumChance(1);
                System.out.println("\nYou feel hungry. Gold Panning chance returned to normal.");
            }
        }
    }

    // ---------- Item Logic ----------
    private void useItemLogic(CraftedItem item) {
        String name = item.getName().toLowerCase();

        switch (name) {

            case "revival potion" -> {
                System.out.println("Revive who? 1=Kino 2=Bem 3=Akio");

                try {
                    int choice = Integer.parseInt(sc.nextLine());

                    boolean alreadyRevived = switch (choice) {
                        case 1 -> gameState.isKinoRevived();
                        case 2 -> gameState.isBemRevived();
                        case 3 -> gameState.isAkioRevived();
                        default -> false;
                    };

                    if (alreadyRevived) {
                        System.out.println("That character is already revived!");
                        craftedItems.add(item);
                        return;
                    }

                    switch (choice) {
                        case 1 -> gameState.reviveKino();
                        case 2 -> gameState.reviveBem();
                        case 3 -> gameState.reviveAkio();
                        default -> {
                            System.out.println("Invalid choice.");
                            craftedItems.add(item);
                        }
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Invalid input.");
                    craftedItems.add(item);
                }
            }

            case "spear" -> {
                System.out.println("You used the Spear for hunting. You found Raw Meat!");
                addRawMaterial("Raw Meat", 1);
            }

            case "wooden batea" -> performGoldPanning();

            default -> {
                System.out.println("The " + item.getName() + " cannot be used here.");
                craftedItems.add(item);
            }
        }
    }

    // ---------- Helpers ----------
    public void setDoubleEffect(boolean value) {
        doubleEffect = value;
    }

    public boolean getDoubleEffect() {
        return doubleEffect;
    }

    public void clearInventory() {
        rawMaterials.clear();
        craftedItems.clear();
        uniqueDeepSeaItems.clear();

        doubleEffect = false;
        hasFurnace = false;
        hasAlchemyTable = false;
        fullnessLevel = 0;

        gameState.setPlatinumChance(1);

        System.out.println("Inventory cleared!");
    }

    public int getFullnessLevel() {
        return fullnessLevel;
    }

    private static String capitalize(String s) {
        if (s == null || s.isEmpty()) return s;
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }
}
