package Inventory;

import java.util.Map;

public interface Inventory {
    void addItem(String name);
    void addItem(String name, int quantity);
    Map<String, Integer> getItems();
    void removeItem(String name);
    void checkInventory();
}
