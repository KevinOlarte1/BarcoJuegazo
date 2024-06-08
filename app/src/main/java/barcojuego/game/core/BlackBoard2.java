package barcojuego.game.core;

import barcojuego.game.gameentities.BarcoPlayer;

public class BlackBoard2 {
    public static BarcoPlayer currentPlayer;
    public static Mode mode;
    public static boolean buttonPressed = false;
    public static boolean beginGame = true;
    public enum Mode {
        SINGLE_PLAYER,
        MULTI_PLAYER
    }
    
}
