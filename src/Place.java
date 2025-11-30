import java.util.Map;

public enum Place {
    RIVER("River", Map.of("Wood", 90, "Stone", 80, "Grapes", 30), Map.of("Map Fragment", 5)),
    FOREST("Forest", Map.of("Wood", 85, "Grapes", 25, "Clay", 80), Map.of("Map Fragment", 5)),
    CAVE("Cave", Map.of("Stone", 80, "Nitric Acid", 35), Map.of()), 
    ROCKY_BEACH("Rocky Beach", Map.of("Sand", 90, "Limestone", 40), Map.of()),
    DEEP_SEA_SHORE("Deep Sea Shore", Map.of("Platinum", 20, "Gold", 20, "Nitric Acid", 20, "Limestone", 20), Map.of()); 

    public final String name;
    public final Map<String, Integer> commonDrops; 
    public final Map<String, Integer> rareDrops; 

    Place(String name, Map<String, Integer> commonDrops, Map<String, Integer> rareDrops) {
        this.name = name;
        this.commonDrops = commonDrops;
        this.rareDrops = rareDrops;
    }
}