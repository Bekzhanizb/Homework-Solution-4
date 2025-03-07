import Builder.Dungeon;
import Builder.IDungeonBuilder;
import Builder.SimpleDungeonBuilder;

public class MUDCombined {
    private static MUDCombined instance;
    private final Player player;
    private final MUDController controller;

    private MUDCombined() {
        this.player = new Player();
        IDungeonBuilder builder = new SimpleDungeonBuilder();
        builder.buildName();
        builder.buildRooms();
        Dungeon dungeon = builder.getDungeon();
        this.controller = new MUDController(player, dungeon);
    }

    public static MUDCombined getInstance() {
        if(instance == null) {
            instance = new MUDCombined();
        }
        return instance;
    }

    public void startGame() {
        controller.runGameLoop();
    }

    public static void main(String[] args) {
        MUDCombined game = getInstance();
        game.startGame();
    }
}