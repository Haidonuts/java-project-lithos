public class CraftedItem extends Item implements Usable {
    private final String description;

    public CraftedItem(String name, String description) {
        super(name);
        this.description = description;
    }
    public String getDescription() { return description; }

    @Override
    public void useItem(Inventory inventory) { 
    }
}