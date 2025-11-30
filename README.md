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

<h2>🏛️ Object-oriented Principles</h2>

<h3>🛡️ Encapsulation</h3>
Encapsulation is the practice of restricting direct access to an object's state and accessing it only through a controlled set of public methods.<br>

<b>Implementation:</b> 

- All internal state variables are hidden. For example, ```currentDay```, ```rawMaterials``` map, and ```hasFurnace``` status are private.<br>

<b>Controlled Access:</b>

- The core logic relies on public accessors like ```getCurrentDay()``` and ```hasFurnace().```

- The FileHandler needs to save this private data. Instead of making the fields public, new dedicated access methods were created: ```getRawMaterials()```, ```getCraftedItems()```, ```setFullnessLevel()```, and various setters in ```GameState``` ```(e.g., setDay(), setExplorationsLeft()). ```
<h3>✨ Abstraction</h3>
Abstraction focuses on simplifying complexity by hiding low-level details and presenting a clean, easy-to-use interface.<br>

<b>File Handling Abstraction:</b> 

- The ```FileHandler``` class completely hides the complexities of Java's file I/O (handling try-catch blocks, FileWriter, parsing text lines).

- The Main class only interacts with the methods ```FileHandler.saveGame(gameState)``` and ```FileHandler.loadGame(gameState).``` The complex process of converting the entire game state into a structured text file and reading it back is entirely abstracted away.
  
<b>Game Logic Abstraction:</b>

- The Explore class delegates probability calculation to the ```DropTable.``` When Explore calls ```dropTable.getMaterials(...)```, it only cares about the final list of items returned, not the intricate math involving weather multipliers and base success rates that runs internally in the ```DropTable.```
- The Inventory class abstracts item usage; when an item is used, the main code calls ```useItemLogic(item)```, hiding the specific implementation details like decreasing fullness, resetting exploration limits, or granting raw meat.

<h3>🧬 Inheritance</h3>
Inheritance allows classes to inherit fields and methods from a parent class, promoting code reuse and establishing an "is-a" relationship.<br>
<b>Item Hierarchy:</b>

- The concrete ```CraftedItem``` class inherits from the Item abstract class. This ensures all crafted items automatically have a name field and access to the ```getName()``` method without redefining that common data.
- The ```PlaceNotFoundException``` class extends the standard Java Exception class, demonstrating how to specialize built-in functionality.

<h3>🔄 Polymorphism</h3>
Polymorphism allows a single action (method call) to behave differently depending on the object it is acting upon, achieving a "many forms" capability.

<b>Interface Implementation:</b> 

- This is achieved through the Usable interface, which defines the contract ```useItem(Inventory inventory).``` The ```CraftedItem``` implements this contract.
- The Inventory's ```useItemLogic()``` method takes a generic ```CraftedItem.``` The logic uses a switch statement on the item's name (e.g., "revival potion" vs. "spear") to execute unique, specific behavior at runtime.

<h2>Example Output</h2>

```plaintext
Welcome to Project Lithos!


Over the horizon, a vast blue light swelled and crept across the land.

When it finally reached you !BOOM! everything changed. The moment it touched your skin, you turned to stone. Every conscious being did.
Civilization shattered. Time washed over the world like a tidal wave.

Dot... Dot... Dot... Dot... CRACK

3,000 years later, you awaken.

Alone.

All around you stand the petrified faces of the past.
Kino, your high-school best friend, a genius in geography.
Bem, the master craftsman of your class.
Akio, the athletic, ambitious senior who never backed down from a challenge.
They're frozen, waiting.

Humanity has fallen silent and you are its first voice in millennia.
Your mission: restore civilization's greatest weapons; knowledge, technology, and HOPE.
Your choices will determine the future.
--------------------------

Press ENTER to begin Day 1...

--- (Day 1) ---
1. Explore [10 attempts left]
2. Create
3. Inventory & Tools
4. Guide Book
5. Alchemy
6. Sleep
7. Save Game
8. Load Game
9. Exit
Enter your choice: 1

--- Exploration (Day 1: 10 attempts left) ---
Weather: Normal Day (Exploration yields are standard.)
Available Places: 1. River  2. Forest  3. Rocky Beach
Enter place (Name/Number) or 'back': 2

Exploring the Forest...
Oh no! You encountered a hazard.
You narrowly escaped, but are exhausted (Fullness reset).

--- Exploration (Day 1: 9 attempts left) ---
Weather: Normal Day (Exploration yields are standard.)
Available Places: 1. River  2. Forest  3. Rocky Beach
Enter place (Name/Number) or 'back':
```

<h2>projectlithos.txt Snippet</h2>

```plaintext
day=1
explorationsLeft=6
hasMapFragment=false
fullness=0
platinumChance=1
furnace=false
alchemy=false
revivedKino=false
revivedBem=false
revivedAkio=false
weather=NORMAL
rawMaterials:
wood=2
clay=1
END_RAW
craftedItems:
END_CRAFTED
```
<h2>Contributors</h2>

<table>
  <tr>
    <th> </th>
    <th>Name</th>
    <th>Role</th>
  </tr>

  <tr>
    <td>
      <img src="static/446d46fb-dee0-4a53-bfee-2d288dcbe5d9.jpg" width="120" />
    </td>
    <td>
      <strong>Haidie N. Fanoga</strong><br>
      <a href="(https://github.com/Haidonuts)">
        <img src="https://img.shields.io/badge/GitHub-100000?logo=github&logoColor=white">
      </a>
    </td>
    <td>Project Leader / System Architect</td>
  </tr>
  
  <tr>
    <td>
      <img src="static/1d2ce21e-58b2-4c5f-ada2-62d5f72dd384.jpg" width="120" />
    </td>
    <td>
      <strong>Kate Hannah Bem P. De leon</strong><br>
      <a href="(https://github.com/kateehannah)">
        <img src="https://img.shields.io/badge/GitHub-100000?logo=github&logoColor=white">
      </a>
    </td>
    <td>Feature Developer</td>
  </tr>

  <tr>
    <td>
      <img src="static/1dd80d10-3b34-431e-929e-3028481cca24.jpg" width="120" />
    </td>
    <td>
      <strong>Tremonti C. Canatuan</strong><br>
      <a href="(https://github.com/tremonts)">
        <img src="https://img.shields.io/badge/GitHub-100000?logo=github&logoColor=white">
      </a>
    </td>
    <td>Feature Developer</td>
  </tr>
</table>
<h2>Acknowledgement</h2>
We sincerely express our deep gratitude to Ms. Fatima Marie P. Agdon for her insightful guidance and steadfast support provided throughout the completion of Project Lithos. We also extend our appreciation to our Classmates and Peers for their invaluable cooperation, encouragement, and helpful discussions during the entire development process.

<h2>Disclaimer</h2>
Project Lithos is a demonstration of Object-Oriented Programming (OOP) concepts in Java and is intended for educational purposes only. This is a text-based, command-line game prototype and does not represent a full, commercial software product. While we have implemented error handling, the stability of the game may depend on the successful compilation and proper execution environment (e.g., Java Runtime Environment).
