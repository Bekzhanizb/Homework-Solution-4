import java.util.List;

import Inventory.OldInventory;
import Prototype.Room;

public class Player {
    private OldInventory inventory;

    public Player() {
        this.inventory = new OldInventory();
    }

    public List<String> getInventory() {
        return inventory.getInventory();
    }
    public OldInventory getOldInventory() {
        return inventory;
    }
    public void addItem (String item) {
        inventory.addItem(item);
    }
    public void removeItem (String item) {
        inventory.removeItem(item);
    }
    public void checkInventory() {
        inventory.checkInventory();
    }

}
