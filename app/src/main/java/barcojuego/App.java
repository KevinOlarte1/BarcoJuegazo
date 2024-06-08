/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package barcojuego;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import barcojuego.engine.graphics.LibUI;
import barcojuego.game.config.Settings;
import barcojuego.game.core.BarcoJuego;
import barcojuego.game.core.BlackBoard2;
import barcojuego.game.graphics.BarcoSwingRenderer;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        BarcoJuego barcoGame = new BarcoJuego(Settings.WIDTH, Settings.HEIGHT, 
                                            Settings.TARGET_FPS, Settings.TARGET_UPS, 
                                            Settings.MAX_ENTITIES,Settings.ROWS, Settings.COLS,BlackBoard2.Mode.SINGLE_PLAYER);

        BarcoSwingRenderer snakeSwingRenderer = new BarcoSwingRenderer(Settings.WIDTH, Settings.HEIGHT, 
                                                                        barcoGame, Settings.COLOR_BACKGROUND, Settings.COLOR_BACKGROUND);
        barcoGame.setRenderAPI(snakeSwingRenderer);
        JFrame frame = new JFrame();
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Snake");
        frame.add(snakeSwingRenderer);
        frame.pack();
        LibUI.setMonitor(frame, 1);
        frame.setVisible(true);
        barcoGame.start();
    }
}
