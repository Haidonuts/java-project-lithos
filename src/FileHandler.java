import java.io.*;
import java.util.List;
import java.util.Map;

public class FileHandler {
    
    private static final String SAVE_FILE = "projectlithos.txt";

    // ===================== SAVE GAME =====================
    public static void saveGame(GameState gameState) {
        // Use try-with-resources for PrintWriter and FileWriter
        try (PrintWriter out = new PrintWriter(new FileWriter(SAVE_FILE))) {

            Map<String, Integer> rawMaterials = gameState.getInventory().getRawMaterials();
            List<CraftedItem> craftedItems = gameState.getInventory().getCraftedItems();

            // --- Basic Game State ---
            out.println("day=" + gameState.getCurrentDay());
            out.println("explorationsLeft=" + gameState.getExplorationsLeft());
            out.println("hasMapFragment=" + gameState.hasMapFragment());

            // --- Inventory State ---
            out.println("fullness=" + gameState.getInventory().getFullnessLevel());
            out.println("platinumChance=" + gameState.getPlatinumChance());
            out.println("furnace=" + gameState.getInventory().hasFurnace());
            out.println("alchemy=" + gameState.getInventory().hasAlchemyTable());

            // --- Companion State ---
            out.println("revivedKino=" + gameState.isKinoRevived());
            out.println("revivedBem=" + gameState.isBemRevived());
            out.println("revivedAkio=" + gameState.isAkioRevived());

            // --- Weather State (Crucial) ---
            // Save the enum name for the current weather
            out.println("weather=" + gameState.getTodayWeather().name()); 

            // --- Raw materials ---
            out.println("rawMaterials:");
            for (String key : rawMaterials.keySet()) {
                // Save name and quantity
                out.println(key + "=" + rawMaterials.get(key));
            }
            out.println("END_RAW");

            // --- Crafted Items ---
            out.println("craftedItems:");
            for (CraftedItem item : craftedItems) {
                // Only save the item's name
                out.println(item.getName());
            }
            out.println("END_CRAFTED");

            System.out.println("\nGame saved successfully!");

        } catch (IOException e) {
            System.out.println("Error saving game: " + e.getMessage());
        }
    }

    //LOAD GAME
    public static GameState loadGame(GameState gameState) {
        File file = new File(SAVE_FILE);
        if (!file.exists()) {
            System.out.println("No save file found.");
            return null; // Return null so Main knows to start a new game
        }

        Inventory inv = gameState.getInventory();
        inv.clearInventory(); 

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            boolean readingRaw = false;
            boolean readingCrafted = false;

            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;

                if (line.equals("rawMaterials:")) {
                    readingRaw = true;
                    continue;
                }
                if (line.equals("END_RAW")) {
                    readingRaw = false;
                    continue;
                }

                if (line.equals("craftedItems:")) {
                    readingCrafted = true;
                    continue;
                }
                if (line.equals("END_CRAFTED")) {
                    readingCrafted = false;
                    continue;
                }

                if (readingRaw) {
                    String[] split = line.split("=");
                    // Ensure we have two parts before parsing
                    if (split.length == 2) {
                        // Inventory.addRawMaterial is assumed to exist
                        inv.addRawMaterial(split[0], Integer.parseInt(split[1]));
                    }
                    continue;
                }

                if (readingCrafted) {
                    // CraftedItem constructor and Inventory.addCraftedItem are assumed to exist
                    inv.addCraftedItem(new CraftedItem(line, "Loaded from save"));
                    continue;
                }

                // Parse key=value lines
                if (line.contains("=")) {
                    String[] split = line.split("=");
                    if (split.length != 2) continue; // Skip malformed lines
                    
                    String key = split[0];
                    String value = split[1];
                    int intValue;
                    boolean boolValue;

                    switch (key) {
                        case "day" -> {
                            intValue = Integer.parseInt(value);
                            gameState.setDay(intValue); 
                        }
                        case "explorationsLeft" -> {
                            intValue = Integer.parseInt(value);
                            gameState.setExplorationsLeft(intValue);
                        }
                        case "hasMapFragment" -> {
                            boolValue = Boolean.parseBoolean(value);
                            gameState.setHasMapFragment(boolValue); 
                        }
                        case "fullness" -> {
                            intValue = Integer.parseInt(value);
                            inv.setFullnessLevel(intValue);
                        }
                        case "platinumChance" -> {
                            intValue = Integer.parseInt(value);
                            gameState.setPlatinumChance(intValue);
                        }
                        case "furnace" -> { 
                            boolValue = Boolean.parseBoolean(value);
                            // Inventory.registerStructure is assumed to exist
                            if (boolValue) inv.registerStructure("Furnace"); 
                        }
                        case "alchemy" -> { 
                            boolValue = Boolean.parseBoolean(value);
                            if (boolValue) inv.registerStructure("Alchemy Table"); 
                        }
                        case "revivedKino" -> { 
                            boolValue = Boolean.parseBoolean(value);
                            // Only call revive if the state is true
                            if (boolValue) gameState.reviveKino(); 
                        }
                        case "revivedBem" -> { 
                            boolValue = Boolean.parseBoolean(value);
                            if (boolValue) gameState.reviveBem(); 
                        }
                        case "revivedAkio" -> { 
                            boolValue = Boolean.parseBoolean(value);
                            if (boolValue) gameState.reviveAkio(); 
                        }
                        case "weather" -> {
                            gameState.setTodayWeather(Weather.valueOf(value)); 
                        }
                    }
                }
            }

            System.out.println("\nGame loaded successfully!");
            return gameState;

        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading game: " + e.getMessage());
            return null; // Return null if loading or parsing fails
        }
    }

    // ===================== CHECK SAVE EXISTS =====================
    public static boolean saveExists() {
        return new File(SAVE_FILE).exists();
    }

}



