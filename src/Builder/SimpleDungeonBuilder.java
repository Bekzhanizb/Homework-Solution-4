package Builder;

import Prototype.Room;

public class SimpleDungeonBuilder implements IDungeonBuilder {
    private final Dungeon dungeon;

    public SimpleDungeonBuilder() {
        this.dungeon = new Dungeon();
    }

    @Override
    public void buildName() {
        dungeon.setName("Simple Dungeon");
    }

    @Override
    public void buildRooms() {
        Room entrance = new Room("Entrance");
        Room mainHall = (Room) entrance.clone();
        Room treasureRoom = (Room) entrance.clone();

        mainHall.setName("Main Hall");
        treasureRoom.setName("Treasure Room");

        entrance.addItem("Sword");
        entrance.addEnemy("Goblin");

        mainHall.addItem("Shield");
        mainHall.addEnemy("Skeleton");

        treasureRoom.addItem("Gold");
        treasureRoom.addEnemy("Dragon");

        dungeon.addRoom(entrance);
        dungeon.addRoom(mainHall);
        dungeon.addRoom(treasureRoom);

        dungeon.connectRooms(entrance, "north", mainHall);
        dungeon.connectRooms(mainHall, "south", entrance);
        dungeon.connectRooms(mainHall, "east", treasureRoom);
        dungeon.connectRooms(treasureRoom, "west", mainHall);
    }

    @Override
    public Dungeon getDungeon() {
        return dungeon;
    }
}