public class GameState {  

    // Flags for companion revival states
    private boolean kinoRevived = false;
    private boolean bemRevived = false;
    private boolean akioRevived = false;

    // Crafting success buff from Bem
    private boolean alwaysSuccessfulCraft = false;  

    // Reference to player's inventory
    private Inventory inventory;

    // Chance multiplier for gold/platinum panning
    private int platinumChance = 1;

    // Unlocks Cave
    private boolean hasMapFragment = false;

    // Day counter
    private int currentDay = 1;

    // Exploration attempts left per day
    private int explorationsLeft = 10;

    // Daily max explorations
    private final int MAX_EXPLORATIONS = 10;

    // Weather system
    private Weather todayWeather = Weather.NORMAL;


    // Constructor 
    public GameState(Inventory inventory) {
        this.inventory = inventory;
    }


    // Inventory Setter 
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }


    // Weather Getters
    public Weather getTodayWeather() { return todayWeather; }


    // Sleep / Day System
    public void sleep() {
        currentDay++;
        explorationsLeft = MAX_EXPLORATIONS;
        todayWeather = Weather.generate();

        System.out.println("\n--- Day " + currentDay + " ---");
        System.out.println("The weather is: " + todayWeather.description + ". " + todayWeather.flavorText);
        System.out.println("You rested well. Exploration limit reset to " + MAX_EXPLORATIONS + ".");
    }


    public void decrementExploration() {
        if (explorationsLeft > 0) {
            explorationsLeft--;
        }
    }

    public void resetExplorationLimit() {
        explorationsLeft = MAX_EXPLORATIONS;
        System.out.println("You feel completely re-energized! Exploration limit reset to " + MAX_EXPLORATIONS + ".");
    }


    //REVIVE METHODS 


    public void reviveKino() {
        kinoRevived = true;
        alwaysSuccessfulCraft = false;
        inventory.setDoubleEffect(true);
        System.out.println("Kino revived! Your raw materials will double each exploration.");
    }

    public void reviveBem() {
        bemRevived = true;
        alwaysSuccessfulCraft = true;
        inventory.setDoubleEffect(false);
        System.out.println("Bem revived! She stabilizes your crafting. All crafts will now be 100% successful!");
    }

    public void reviveAkio() {
        akioRevived = true;
        alwaysSuccessfulCraft = false;
        inventory.setDoubleEffect(false);

        inventory.clearInventory();
        System.out.println("Akio revived! He stole everything and ran... Inventory reset.");
    }


    // Basic Getters 
    public int getCurrentDay() { return currentDay; }
    public int getExplorationsLeft() { return explorationsLeft; }

    public void setPlatinumChance(int multiplier) { this.platinumChance = multiplier; }
    public int getPlatinumChance() { return platinumChance; }

    public void setHasMapFragment(boolean value) { this.hasMapFragment = value; }
    public boolean hasMapFragment() { return hasMapFragment; }

    public boolean isCraftAlwaysSuccessful() { return alwaysSuccessfulCraft; }

    public boolean isKinoRevived() { return kinoRevived; }
    public boolean isBemRevived() { return bemRevived; }
    public boolean isAkioRevived() { return akioRevived; }

    public Inventory getInventory() { return inventory; }


    // GAME WIN CONDITION 
    public boolean allCompanionsRevived() {
        return kinoRevived && bemRevived && akioRevived;
    }


    // REQUIRED SETTERS (FileHandler)

    public void setDay(int day) {
        this.currentDay = day;
    }

    public void setExplorationsLeft(int explorations) {
        this.explorationsLeft = explorations;
    }

    public void setTodayWeather(Weather weather) {
        this.todayWeather = weather;
    }
}

