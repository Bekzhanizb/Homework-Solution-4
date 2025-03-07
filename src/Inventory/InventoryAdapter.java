package Inventory;

import java.util.HashMap;
import java.util.Map;

public class InventoryAdapter implements Inventory {

    private final OldInventory oldInventory;
    private final Map<String, Integer> newInventory = new HashMap<>();

    public InventoryAdapter(OldInventory inventory) {
        this.oldInventory = inventory;
        for (String item : oldInventory.getInventory()) {
            newInventory.put(item, newInventory.getOrDefault(item, 0) + 1);
        }
    }

    @Override
    public void addItem(String name) {
        addItem(name, 1);
    }

    @Override
    public void addItem(String item, int quantity) {
        if (quantity <= 0) return;
        newInventory.put(item, newInventory.getOrDefault(item, 0) + quantity);
        for(int i = 0; i<quantity; i++) {
            oldInventory.addItem(item);
        }
    }

    @Override
    public Map<String, Integer> getItems() {
        return Map.of();
    }

    @Override
    public void removeItem(String item) {
        if (!newInventory.containsKey(item)) {
            System.out.println("Item not found: " + item);
            return;
        }

        int count = newInventory.get(item);
        if (count > 1) {
            newInventory.put(item, count - 1);
        } else {
            newInventory.remove(item);
        }
        oldInventory.removeItem(item);
    }

    @Override
    public void checkInventory() {
        if (newInventory.isEmpty()) {
            System.out.println("Your inventory is empty.");
            return;
        }

        System.out.println("Your inventory:");
        for (Map.Entry<String, Integer> entry : newInventory.entrySet()) {
            System.out.println("- " + entry.getKey() + " (x" + entry.getValue() + ")");
        }
    }
}
