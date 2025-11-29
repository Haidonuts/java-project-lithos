<h1 align="center">·༻𐫱༺·<br>
    ˗ˋˏ 𝐏𝐑𝐎𝐉𝐄𝐂𝐓 𝐋𝐈𝐓𝐇𝐎𝐒 ˎˊ-
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
    <b>Users Can</b><br>
    <br>
    🗺️Explore to find loots<br>
    🛠️Create items<br>
    🧪Experiment using the Alchemy Table<br>
    🧺Open Inventory and Select Items<br>
    💤Sleep to advance the day<br>
    📜Open Guidebook<br>
    <br>
    <b>Game Storage</b><br>
    <br>
    All game state, item inventory, and character data are handled through structured Java objects and persisted via file handling to ensure seamless continuation between play sessions.
</p>
<h2 align="left">݁☘︎Project Structure</h1>

- 📁 [`src/`](./src)
  - 📄 [`Main.java`](./src/Main.java) - Entry point of the program...
  - 📄 [`Explore.java`](./src/Explore.java)
  - 📄 [`AlchemyTable.java`](./src/AlchemyTable.java)
  - 📄 [`CraftedItem.java`](./src/CraftedItem.java)
  - 📄 [`GameState.java`](./src/GameState.java)
  - 📄 [`Guidebook.java`](./src/Guidebook.java)
  - 📄 [`Inventory.java`](./src/Inventory.java)
  - 📄 [`Item.java`](./src/Item.java)
  - 📄 [`Place.java`](./src/Place.java)
  - 📄 [`PlaceNotFound.java`](./src/PlaceNotFound.java)
  - 📄 [`TextUtil.java`](./src/TextUtil.java)
  - 📄 [`Usable.java`](./src/Usable.java)
  - 📄 [`Weather.java`](./src/Weather.java)
  - 📄 [`Create.java`](./src/Create.java)

* [`Main.java`](./src/Main.java) - Entry point of the program. Initializes all core systems, manages the main game loop, displays the user menu, and handles primary user interactions (choosing actions).
