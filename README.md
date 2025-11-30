<h1 align="center">𓆩༺✧༻𓆪<br>
    ꧁‿̩͙‿୨ 𝐏𝐑𝐎𝐉𝐄𝐂𝐓 𝐋𝐈𝐓𝐇𝐎𝐒 ୧‿̩͙‿꧂<br>
    ݁</h1>
<p align="center">
    A console-based rpg where you restore humanity's greatest tools from scratch<br>
    <br>
    <b>CS 2103</b><br>
    Haidie N. Fanoga<br>
    Kate Hannah Bem P. De Leon<br>
    Tremonti C. Canatuan
</p>
<h2 align="left">݁☘︎Overview</h2>
<p align="left">
    Project lithos is a console-based Role-Playing Game (RPG) built in Java, designed to challenge the player's knowledge of resource management and chemical logic. The core premise involves the player awakening in a world where humanity has been turned to stone, tasking   them with gathering elements and recreating the tools of civilization.<br>
    <br>
    <h3>Users Can</h3>
    🗺️Explore to find loots<br>
    🛠️Create items<br>
    🧪Experiment using the Alchemy Table<br>
    🧺Open Inventory and Select Items<br>
    💤Sleep to advance the day<br>
    📜Open Guidebook<br>
    <br>
    <h3>Game Storage</h3>
    All game state, item inventory, and character data are handled through structured Java objects and persisted via file handling to ensure seamless continuation between play sessions.
</p>
<h2 align="left">݁☘︎Project Structure</h2>

```plaintext
📂 src/
├── ☕ AlchemyTable.java
├── ☕ CraftedItem.java
├── ☕ Create.java
├── ☕ Explore.java
├── ☕ GameState.java
├── ☕ Guidebook.java
├── ☕ Inventory.java
├── ☕ Item.java
├── ☕ Main.java
├── ☕ Place.java
├── ☕ PlaceNotFound.java
├── ☕ TextUtil.java
├── ☕ Usable.java
└── ☕ Weather.java
```
- ```Main.java``` - Entry point of the program. Initializes all core systems, manages the main game loop, displays the user menu, and handles primary user interactions (choosing actions).<br>
- ```Explore.java``` - Handles the Explore command, managing location selection, calculating hazard encounters, and applying resource doubling (Kino's effect).
- ```AlchemyTable.java``` - Manages the Alchemy command, handling advanced chemical experiments and recipes (e.g., Revival Potion and Platinum bonus yield).
- ```CraftedItem.java``` - Extends Item and implements Usable. Defines items that can be created by the player and includes the custom useItem logic for unique effects (e.g., Revival Potion logic).
- ```GameState.java``` - The central state manager. Tracks day count, exploration limits, current Weather, companion revival status, and permanent game effects (like Bem's 100% craft success).
- ```Guidebook.java``` - Displays helpful, static game information, including crafting recipes, character traits, and material drops by location.
- ```Inventory.java``` - Manages the player's entire resource pool, including Raw Materials, Crafted Items, permanent Structures (Furnace), and the gold panning/fullness status.
- ```Item.java``` - An abstract base class for all physical items in the game, providing a common structure for all resource types.
- ```Place.java``` - An Enum defining all explorable locations, along with their static commonDrops and rareDrops lists and associated base chances.
- ```PlaceNotFound.java``` - A custom exception class used to handle invalid location inputs during exploration.
- ```TextUtil.java``` - Utility class for text-based effects, specifically used for typing out the intro story for a dramatic terminal appearance.
- ```Usable.java``` - An interface defining the contract for any item that can be "used" by the player (e.g., CraftedItem).
- ```Weather.java``` - An Enum defining various weather conditions, their descriptions, and the multiplier they apply to the DropTable for resource chances.
- ```Create.java``` - Manages the Craft command, handling material consumption for permanent structures and basic tool construction, incorporating success rate logic.
  
<h3>How to Run the Program</h3>

Open your File Explorer and navigate into the ```java-project-lithos``` folder.

Open your terminal in the ```src/``` folder and run:
```plaintext
javac *.java
```

Run the program using:
```plaintext
java Main
```

<h2 align="left">݁☘︎Features</h1>
<p align="left">
<h3>Exploration & Gathering</h3>
<b>Daily Attempts:</b> Players have a limited number of explorations per day (default is 10).<br>
<b>Place Selection:</b> Players can choose to explore different places like River, Forest, Rocky Beach, Cave, or Deep Sea Shore to find raw materials.<br>
<b>Unlocking Locations:</b> The Cave is unlocked by finding a Map Fragment . The Deep Sea Shore is unlocked on Day 5 .<br>
<b>Weather Effects:</b> A daily weather condition is generated which applies a multiplier to drop chances.<br>
<b>Hazards:</b> Exploring has a small chance (5%) of encountering a hazard, which can be mitigated by using certain materials (Stone, Cooked Meat) or may result in loss of items/fullness.

<h3>Crafting & Structure Building</h3>
<b>Basic Crafting:</b> Players can craft items like Furnace, Alchemy Table, Spear, and Wooden Batea from raw materials.<br>
<b>Craft Success Rate:</b> Crafting has a 70% base success rate unless the special companion Bem is revived.<br>
<b>Permanent Structures:</b> Structures like the Furnace and Alchemy Table are built once and remain permanent additions to the player's capabilities.

<h3>Alchemy & Processing</h3>
<b>Furnace Operations:</b> The Furnace is used to process items like Raw Meat into Cooked Meat and Sand + Limestone into Glass.<br>
<b>Alchemy Table Operations:</b> The Alchemy Table is used for multi-step crafting, specifically fermenting Grapes into Alcohol and mixing a Revival Potion from Nitric Acid + Alcohol.<br>
<b>Potion Yield:</b> Platinum can be optionally added to the Revival Potion mix to double the yield .

<h3>Companion Revival & Effects</h3>
<b>Companion Types:</b> The game features three key companions who are initially petrified (Kino, Bem, and Akio).<br>

- Kino: Doubles raw materials found during exploration.<br>
- Bem: Guarantees 100% craft success.<br>
- Akio: Upon revival, clears the player's inventory and then occasionally steals a crafted item after successful exploration.<br>
<b>Revival Potion:</b> A Revival Potion is used to revive one of the three companions.<br>
<b>Game Goal:</b> The game is won when all three companions are revived.

<h3>Tools and Status</h3>
<b>Wooden Batea:</b> A reusable tool used for Gold Panning, which has a chance to find Gold and Platinum.<br>

<b>Fullness:</b> Eating Cooked Meat sets the ```fullnessLevel``` to 5, which resets the daily exploration limit and doubles the Platinum chance for gold panning.<br>
<b>Spear:</b> A consumable weapon used for Hunting to find Raw Meat.

<h3>Guide Book</h3>
The Guide Book is the game's in-system reference library.
<b>Function:</b> It displays essential game information when accessed via the Main Menu.

- Shows all craftable items, their recipes, and the 70% base success rate .
- Explains the unique effects of Kino, Bem, and Akio .
- Lists all explorable locations and the raw/special materials that can be found there, including unlock conditions (e.g., Map Fragment, Day 5) .

<h3>Sleep</h3>
<b>Function:</b> Sleeping advances the game to the next day and is the primary way to reset the daily exploration limit back to the maximum of 10 attempts.<br>
<b>Weather:</b> It also generates the weather condition for the new day, which impacts resource drop chances.

</p>

<h2>🏛️ OOP PRINCIPLES</h2>

<h3>1. 🛡️ Encapsulation</h3>
Encapsulation is the practice of restricting direct access to an object's state and accessing it only through a controlled set of public methods.<br>
<b>Implementation:</b> All key data in the core classes is declared as private or protected.<br>

In ```Inventory````, data like ```rawMaterials```, ```craftedItems```, ```hasFurnace```, and ```fullnessLevel``` are private.<br>

In ```GameState```, companion states ```(kinoRevived, bemRevived, etc.)``` and game stats are private.<br>

Control: The data is manipulated only via public getter and setter methods, such as ```getMaterialCount()```, ```useMaterial()```, and ```setPlatinumChance()```. This ensures that game logic (like checking for sufficient materials before using them) is always followed.
<h3>2. ✨ Abstraction</h3>
Abstraction hides the complex implementation details, showing only essential information.<br>
<b>Implementation:</b> The design uses classes and methods to represent high-level operations without exposing the underlying mechanics.<br>
<b>File I/O:</b> The main game classes don't worry about reading/writing to a file; they just call ```FileHandler.readAllLines().```<br>
<b>Drop Logic:</b> The Explore class delegates the complicated calculation of drops (including weather multipliers and base success rates) to the DropTable class by simply calling dropTable.getMaterials(...) . The Explore class only cares about the final list of found items, not the probability math involved .
3. 🧬 Inheritance
Inheritance allows a new class (subclass) to inherit properties and methods from an existing class (superclass).
Implementation: This is demonstrated through the item hierarchy.
The CraftedItem class extends the Item abstract class.
CraftedItem reuses the name field and the constructor logic from its parent class via super(name) .
The PlaceNotFoundException class extends the base Java Exception class to create a custom, domain-specific error .
4. 🔄 Polymorphism
Polymorphism allows objects of different classes to be treated as objects of a common type, leading to flexible code.
Implementation: This is achieved through the abstract Item class and the use of the Usable interface (implied by the @Override annotation).
The Inventory stores a List<CraftedItem>.
When an item is used, the Inventory calls useItemLogic(item). The switch statement inside useItemLogic then performs different actions based on the specific object's type (e.g., "revival potion" vs. "spear" vs. "wooden batea") .
The specific method that runs (the logic for using a Spear versus using a Revival Potion) is determined at runtime, which is a classic application of polymorphism .
