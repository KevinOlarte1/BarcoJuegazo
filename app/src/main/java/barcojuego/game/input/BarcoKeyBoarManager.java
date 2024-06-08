package barcojuego.game.input;

import java.awt.event.KeyEvent;

import barcojuego.engine.input.KeyboardManager;

public class BarcoKeyBoarManager extends KeyboardManager{
    private String posX;
    private String posY;
    private boolean isHorizontal;

    public BarcoKeyBoarManager(char upKey, char downKey, char leftKey, char rightKey, char fireKey, char jumpKey) {
        super(upKey, downKey, leftKey, rightKey, fireKey, jumpKey);
        posX = "";
        posY = "";
        isHorizontal = true;
    }

    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }
    @Override
    public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();
        if (isDigit(c)) {
            if (posX.length() < 2) {
                posX += c;
            } else if (posY.length() < 2) {
                posY += c;
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            isHorizontal = false;
        } else if (key == KeyEvent.VK_RIGHT) {
            isHorizontal = true;
        } else if (key == KeyEvent.VK_BACK_SPACE) {
            if (posY.length() > 0) {
                posY = posY.substring(0, posY.length() - 1);
            } else if (posX.length() > 0) {
                posX = posX.substring(0, posX.length() - 1);
            }
        }
    }

    public String getPosX() {
        return posX;
    }

    public String getPosY() {
        return posY;
    }

    public boolean isHorizontal() {
        return isHorizontal;
    }



    

}