package Inventory;

import java.util.ArrayList;
import java.util.List;

public class OldInventory {
    private final List<String> inventory = new ArrayList<String>();

    public void addItem(String name) {
        inventory.add(name);
    }

    public void removeItem(String name) {
        inventory.remove(name);
    }

    public void checkInventory() {
        for (int i = 0; i < inventory.size(); i++) {
            System.out.println(i+". "+inventory.get(i));
        }
    }

    public List<String> getInventory() {
        return inventory;
    }
}
