package barcojuego.game.graphics;

import barcojuego.engine.core.Blackboard;
import barcojuego.engine.core.ResizeListener;
import barcojuego.engine.entities.Entity;
import barcojuego.engine.entities.PlayableEntity;
import barcojuego.engine.graphics.swing.SwingRenderer;
import barcojuego.game.config.Settings;
import barcojuego.game.gameentities.Barco;
import barcojuego.game.gameentities.BarcoFragmento;
import barcojuego.game.core.BlackBoard2;
import barcojuego.game.gameentities.BarcoPlayer;
import java.util.List;

import java.awt.*;

/**
 * SnakeSwingRenderer
 * License: 🅮 Public Domain
 *
 * @author Germán Gascón <ggascon@gmail.com>
 * @version 0.1, 2024-05-16
 * @since 0.1, 2024-05-16
 **/
public class BarcoSwingRenderer extends SwingRenderer {

    private Color backgroundColor1;
    private Color backgroundColor2;
    private Barco currentPlayer;
   // private Scene currentScene;

    public BarcoSwingRenderer(int width, int height, ResizeListener resizeListener, Color backgroundColor1, Color backgroundColor2) {
        super(width, height, resizeListener);
        this.backgroundColor1 = backgroundColor1;
        this.backgroundColor2 = backgroundColor2;
    }

    /**
     * Paints the component.
     *
     * @param g The Graphics object.
     */
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        
        drawBackground(g2);
        List<PlayableEntity> playableEntities = Blackboard.entityManager.getPlayableEntities();
        for (PlayableEntity playableEntity : playableEntities) {
            
            drawEntity(g2, playableEntity);
        }
        
    }

    @Override
    public void drawEntity(Graphics2D g2, Entity e) {
        
        List<Barco> ships;
       // List<Coordinates> disparos;
        if (e instanceof BarcoPlayer) {
            if (BlackBoard2.currentPlayer.equals((BarcoPlayer) e)) {
                ships = ((BarcoPlayer) e).getShips();
                for (Barco ship : ships) {
                    g2.setColor(Settings.COLOR_SHIP);
                    for (BarcoFragmento fragment : ship.getShipFragments()) {
                        int x = Math.round(fragment.getX()) * Blackboard.cellSize;
                        int y = Math.round(fragment.getY()) * Blackboard.cellSize;
                        g2.fillRect(x + 30, y + 30, Blackboard.cellSize, Blackboard.cellSize);
                    }
                }
            }
        }
    }

    @Override
    public void drawBackground(Graphics2D g2) {
        
        // Calcula el desplazamiento para el segundo tablero
        int offset = Settings.COLS * Blackboard.cellSize + Settings.SPACE_BETWEEN_GAMEBOARDS;

        // Dibuja el fondo del primer tablero (Tablero Barcos)
        g2.setColor(backgroundColor1);
        g2.fillRect(30, 30, Settings.COLS * Blackboard.cellSize, Settings.ROWS * Blackboard.cellSize); //cambios

        // Dibuja el fondo del segundo tablero (Tablero de Disparos)
        g2.setColor(backgroundColor2);
        g2.fillRect(offset + 30, 30, Settings.COLS * Blackboard.cellSize, Settings.ROWS * Blackboard.cellSize); //cambios

        // Dibuja las líneas del primer tablero (Tablero Barcos)
        for (int row = 0; row < Settings.ROWS; row++) {
            for (int col = 0; col < Settings.COLS; col++) {
                g2.setColor(Settings.COLOR_BACKGROUND_LINES);
                g2.drawRect(col * Blackboard.cellSize + 30, row * Blackboard.cellSize + 30, Blackboard.cellSize, Blackboard.cellSize);
            }
        }

        // Dibuja las líneas del segundo tablero (Tablero de Disparos)
        for (int row = 0; row < Settings.ROWS; row++) {
            for (int col = 0; col < Settings.COLS; col++) {
                g2.setColor(Settings.COLOR_BACKGROUND_LINES);
                g2.drawRect(col * Blackboard.cellSize + 30 + offset, row * Blackboard.cellSize + 30, Blackboard.cellSize, Blackboard.cellSize);
            }
        }

        drawNumberCoordenates(g2, 30);
        drawNumberCoordenates(g2, offset + 30);

    }

    
    /**
     * Draws number coordinates around the board.
     *
     * @param g2     The Graphics2D object.
     * @param offset The offset for drawing the coordinates.
     */
    private void drawNumberCoordenates(Graphics2D g2, int offset) {
        g2.setColor(Color.BLACK);

        //Dibujar numero de filas:
        for (int row = 0; row < Settings.ROWS; row++) {
            g2.drawString(Integer.toString(row + 1), offset - 20, (row + 1) * Blackboard.cellSize + 4);
        }

        //Dibujar numero de columnas:
        for (int col = 0; col < Settings.COLS; col++) {
            g2.drawString(Integer.toString(col + 1), offset + col * Blackboard.cellSize + Blackboard.cellSize / 2, 20);
        }
    }



    public void setBackgroundColor1(Color backgroundColor1) {
        this.backgroundColor1 = backgroundColor1;
    }

    public void setBackgroundColor2(Color backgroundColor2) {
        this.backgroundColor2 = backgroundColor2;
    }

}
