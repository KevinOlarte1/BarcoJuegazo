package barcojuego.game.core;

import barcojuego.engine.core.Blackboard;
import barcojuego.engine.core.EntityManager;
import barcojuego.engine.core.Game;
import barcojuego.engine.input.KeyboardManager;
import barcojuego.game.gameentities.BarcoPlayer;
import barcojuego.game.input.BarcoKeyBoarManager;

public class BarcoJuego extends Game{

    private final int rows;
    private final int cols;
    private final BarcoEntityManger entityManager;
    private BlackBoard2.Mode mode;

    private BarcoPlayer player1;
    private BarcoPlayer player2;

    private boolean principio;

    public BarcoJuego(int width, int height, float fpsLimit, float upsLimit, int maxEntities, int rows, int columns, BlackBoard2.Mode mode) {
        super(width, height, fpsLimit, upsLimit, maxEntities);
        this.rows = rows;
        this.cols = columns;
        this.entityManager = (BarcoEntityManger) Blackboard.entityManager;
        this.principio = true;
        setMode(mode);
    }

     /**
     * Allows to set the game mode tu the corresponding game.
     * @param mode Blackboard2.Mode
     */
    public void setMode(BlackBoard2.Mode mode) {
        this.mode = mode;
        if (mode == BlackBoard2.Mode.SINGLE_PLAYER) {
            initPlayers(rows, cols);
           
        } else if (mode == BlackBoard2.Mode.MULTI_PLAYER) {
            //!TODO Implementar modo multijugador
        }
    }

    /**
     * Initializes the players for the Sink Fleet game.
     *
     * @param rowsshoot The number of rows in the game board.
     * @param cols      The number of columns in the game board.
     */
    private void initPlayers(int rowsshoot, int cols) {
        KeyboardManager km1 = new BarcoKeyBoarManager('w', 's', 'a', 'd', 'f', ' '); //! Cambiar cuando Diego lo tenga
        this.player1 = entityManager.creatPlayer(0, 0, km1, rows, cols);
        
        this.player2 = entityManager.creatPlayer(0, 0, km1, rows, cols);
            //System.out.println(player1.toString() + " a");
        BlackBoard2.currentPlayer = player1;
        

    }

    
    

    @Override
    public EntityManager createEntityManager(int maxEntities) {
        return new BarcoEntityManger(maxEntities);
    }

    @Override
    public void gameResized() {
        
    }

    @Override
    public void update(double deltaTime) {
       //TODO: Implementar actualización de juego
       
    }
    
}
