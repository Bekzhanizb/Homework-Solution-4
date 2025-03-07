package Prototype;

import java.util.ArrayList;
import java.util.List;

public class Room implements ClonableGameEntity {
    private String name;

    private final List<String> items;
    private final List<String> enemies;

    public Room(String name) {
        this.name = name;

        this.items = new ArrayList<>();
        this.enemies = new ArrayList<>();
    }


    public void addItem(String item) {
        items.add(item);
    }

    public void removeItem(String item) {
        items.remove(item);
    }

    public void addEnemy(String enemy) {
        enemies.add(enemy);
    }

    public List<String> getItems() {
        return items;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public ClonableGameEntity clone() {
        Room clonedRoom = new Room(this.name);

        clonedRoom.items.addAll(this.items);

        // Глубокое копирование списка врагов
        clonedRoom.enemies.addAll(this.enemies);

        return clonedRoom;
    }

    @Override
    public String toString() {
        return "Room: " + name+"\nItems: " + items+"\nEnemies: " + enemies;

    }
}