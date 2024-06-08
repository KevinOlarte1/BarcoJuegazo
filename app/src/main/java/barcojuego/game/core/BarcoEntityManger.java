package barcojuego.game.core;

import barcojuego.engine.core.AssetManager;
import barcojuego.engine.core.EntityManager;
import barcojuego.engine.entities.Entity;
import barcojuego.engine.input.KeyboardManager;
import barcojuego.game.config.Settings;
import barcojuego.game.gameentities.BarcoPlayer;
import barcojuego.game.gameentities.Barco;

public class BarcoEntityManger extends EntityManager {

    private final Barco[] ships;
    private int shipIndex;

    public BarcoEntityManger(int maxEntities) {
        super(maxEntities);
        this.ships = new Barco[maxEntities * Settings.NUM_SHIPS];
        this.shipIndex = 0;
        //TODO Auto-generated constructor stub
    }

    /**
     * Creates a player entity and adds it to the entity manager.
     *
     * @param x               The x-coordinate where the player will be spawned.
     * @param y               The y-coordinate where the player will be spawned.
     * @param keyboardManager The keyboard manager that will be used by the player.
     * @param rows            The number of rows on the game board.
     * @param cols            The number of columns on the game board.
     * @return The created player entity.
     */
    public BarcoPlayer creatPlayer(float x, float y, KeyboardManager keyboardManager, int rows, int cols) {
        BarcoPlayer player = new BarcoPlayer(x, y, Settings.WIDTH, Settings.HEIGHT,
                            Settings.PLAYER_HP, keyboardManager, rows, cols);

        addEntity(player);

        return player;
    }
    /**
     * Adds an entity to the entity manager. If the entity is a Ship, it will be added to the ships array.
     * Otherwise, it will be added to the entities array.
     *
     * @param entity The entity to be added.
     * @return True if the entity was added successfully, false otherwise.
     */
    @Override
    public boolean addEntity(Entity entity) {
        if (entity instanceof Barco) {
            
            if (shipIndex < ships.length) {
                ships[shipIndex++] = (Barco) entity;
                return true;
            }
            return false;
        }
        return super.addEntity(entity);
    }

    /**
     * Spawns a Ship entity at the specified coordinates and adds it to the entity manager.
     *
     * @param x            The x-coordinate where the ship will be spawned.
     * @param y            The y-coordinate where the ship will be spawned.
     * @param size         The size of the ship.
     * @param isHorizontal True if the ship is placed horizontally, false if vertically.
     * @return The spawned Ship entity, or null if spawning failed due to collision.
     */
    public Barco spawnShip(float x, float y, int size, boolean isHorizontal) {
        Barco fleet = new Barco(x, y, size, x, size, isHorizontal, y, size);
        for (int i = 0; i < shipIndex; i++) {
            if (ships[i].collides(fleet)) {
                return null;
            }
        }
        addEntity(fleet);
        return fleet;
    }

    @Override
    public AssetManager createAssetManager() {
        return new BarcoAssetManager();
    }
    
}
