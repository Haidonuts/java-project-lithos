<h1 align="center">·༻𐫱༺·<br>
    ꧁‿̩͙‿୨𝐏𝐑𝐎𝐉𝐄𝐂𝐓 𝐋𝐈𝐓𝐇𝐎𝐒 ୧‿̩͙‿꧂<br>
    ݁</h1>
<p align="center">
    A console-based rpg where you restore humanity's greatest tools from scratch<br>
    <br>
    CS 2103<br>
    Haidie N. Fanoga<br>
    Kate Hannah Bem P. De Leon<br>
    Tremonti C. Canatuan
</p>
<h2 align="left">݁☘︎Overview</h1>
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
    <br>
    All game state, item inventory, and character data are handled through structured Java objects and persisted via file handling to ensure seamless continuation between play sessions.
 </p>
<h2 align="left">݁☘︎Project Structure</h1>

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
