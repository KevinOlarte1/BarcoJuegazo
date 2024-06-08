package barcojuego.game.gameentities;

import java.util.ArrayList;
import java.util.List;

import barcojuego.engine.entities.PlayableEntity;
import barcojuego.engine.input.KeyboardManager;
import barcojuego.game.config.Settings;
import barcojuego.game.input.BarcoKeyBoarManager;
import barcojuego.game.math.Coordinates;

public class BarcoPlayer extends PlayableEntity{
    
    private List<Barco> ships;
    private List<Coordinates> disparos;
    private int hp;
  
    private int rows;
    private int cols;

    private String selectPositionX;
    private String selectPositionY;

    private boolean isHorizontal;

    public BarcoPlayer(float x, float y, float width, float height, float hp, KeyboardManager keyboardManager, int rows, int cols) {
        super(x, y, width, height, hp, Settings.PLAYER_DAMAGE, 0, 0, 0, 0, keyboardManager);

        this.ships = new ArrayList<>((int) hp);
        this.disparos = new ArrayList<>();
        this.hp = (int) hp;
        this.rows = rows;
        this.cols = cols;
    }

    
    public boolean isHitBoard(float x, float y) {
        for (Barco ship : ships) {
            if (ship.isHitPosition(x, y)) {
                return true;
            }
        }
        return false;
    }

    public int barcosHundidos() {
        int count = 0;
        for (Barco ship : ships) {
            if (ship.isSunk()) {
                count++;
            }
        }
        return count;
    }

    public boolean addShip(Barco ship) {
        return ships.add(ship);
    }

    public void addDisparo(int x, int y) {
        //TODO: Implementar disparos
    }

    @Override
    public void processInput() {
        this.selectPositionX = ((BarcoKeyBoarManager)getKeyboardManager()).getPosX();
        this.selectPositionY = ((BarcoKeyBoarManager)getKeyboardManager()).getPosY();
        this.isHorizontal = ((BarcoKeyBoarManager)getKeyboardManager()).isHorizontal();
        System.out.println("X: " + selectPositionX + " Y: " + selectPositionY + " Horizontal: " + isHorizontal);
    }

    @Override
    public void lastUpdate(double deltaTime) {
       
    }

    @Override
    public void postUpdate(double deltaTime) {
        
    }

    @Override
    public void update(double deltaTime) {
        
    }

    public List<Barco> getShips() {
        return ships;
    }


    public String getSelectPositionX() {
        return selectPositionX;
    }


    public String getSelectPositionY() {
        return selectPositionY;
    }


    public boolean isHorizontal() {
        return isHorizontal;
    }
    

    
}
