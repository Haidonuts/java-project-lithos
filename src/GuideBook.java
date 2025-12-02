public class GuideBook {
    public void displayGuideBook() {
        System.out.println("\n--- GUIDE BOOK ---");
        displayCraftingList();
        displayCharacters();
        displayPlacesAndMaterials();
    }

    private void displayCraftingList() {
        System.out.println("\n=== Crafting List (70% Base Success) ===");
        System.out.println("1. Furnace");
        System.out.println("  Recipe: 3 Stone = Permanent Structure");
        System.out.println("2. Wooden Batea");
        System.out.println("  Recipe: 3 Wood = Reusable Tool");
        System.out.println("3. Spear");
        System.out.println("  Recipe: Wood + Stone = Consumable Weapon");
        System.out.println("\n=== Multi-Step Processing ===");
        System.out.println("4. Glass");
        System.out.println("  Recipe: Sand + Limestone (Must be done in Furnace)");
        System.out.println("5. Alchemy Table");
        System.out.println("  Recipe: Wood + Stone + Painite = Permanent Structure"); 
        System.out.println("6. Alcohol");
        System.out.println("  Recipe: Grapes (Must be done in Alchemy Table Menu)");
        System.out.println("7. Revival Potion");
        System.out.println("  Recipe: Nitric Acid + Alcohol (Must be done in Alchemy Table Menu)");
        System.out.println("    BONUS: Add Platinum (consumed) for 2x Potion yield!"); 
        System.out.println("---");
    }

    private void displayCharacters() {
        System.out.println("\n=== Characters ===");
        System.out.println("Kino: Doubles materials found during exploration.");
        System.out.println("Bem: Makes all crafting 100% successful.");
        System.out.println("Akio: Stole all your items and fled (if revived).");
        System.out.println("---");
    }

    private void displayPlacesAndMaterials() {
        System.out.println("\n=== Places and Raw Materials ===");
        System.out.println("Places to explore:");
        System.out.println("1. River (Common finds: Wood, Stone. Intermediate: Grapes, Map Fragment)");
        System.out.println("2. Forest (Common finds: Wood, Clay. Intermediate: Grapes, Map Fragment)");
        System.out.println("3. Cave (Common finds: Stone. Intermediate: Nitric Acid)");
        System.out.println("4. Rocky Beach (Common finds: Sand. Intermediate: Limestone)");
        System.out.println("5. Deep Sea Shore (Unlock Day 5. Low chance for Gold, Platinum, Nitric Acid, Limestone. Guaranteed **Painite** after 3 unique drops.)");
        System.out.println("\nSpecial Materials and Derivatives:");
        System.out.println("- Painite (Ultra Rare mineral from Deep Sea Shore)");
        System.out.println("- Platinum, Gold (Obtained via Wooden Batea panning, selected from Crafted Items)");
        System.out.println("- Map Fragment (Unlocks Cave)");
        System.out.println("- Raw Meat (from Spear), Cooked Meat (from Furnace), Glass, Alcohol");
    }

}
