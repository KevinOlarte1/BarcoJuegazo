package barcojuego.engine.entities;

import barcojuego.engine.input.KeyboardManager;
import barcojuego.game.utils.Direction;

import java.awt.image.BufferedImage;

/**
 * PlayableEntity
 * License: 🅮 Public Domain
 *
 * @author Germán Gascón <ggascon@gmail.com>
 * @version 0.1, 2024-05-14
 * @since 0.1, 2024-05-14
 **/
public abstract class PlayableEntity extends DynamicEntity {
    private final KeyboardManager keyboardManager;

    public PlayableEntity(float x, float y, float width, float height, float hp, float damage,
                  float colliderXLeft, float colliderXRight, float colliderYUp, float colliderYDown, int colliderMask,
                  BufferedImage sprite, float velocityX, float velocityY, float linearVelocity, float acceleration,
                  KeyboardManager keyboardManager) {
        super(x, y, width, height, hp, damage, colliderXLeft, colliderXRight, colliderYUp, colliderYDown, colliderMask,
                sprite, velocityX, velocityY, linearVelocity, acceleration);
        this.keyboardManager = keyboardManager;
    }

    public PlayableEntity(float x, float y, float width, float height, float hp, float damage,
                  float colliderOffset, int colliderMask, BufferedImage sprite,
                  float velocityX, float velocityY, float linearVelocity, float acceleration,
                  KeyboardManager keyboardManager) {
        this(x, y, width, height, hp, damage, colliderOffset, colliderOffset, colliderOffset, colliderOffset, colliderMask,
                sprite, velocityX, velocityY, linearVelocity, acceleration, keyboardManager);
    }

    public PlayableEntity(float x, float y, float width, float height, float hp, float damage,
                  float colliderOffsetX, float colliderOffsetY, int colliderMask, BufferedImage sprite,
                  float velocityX, float velocityY, float linearVelocity, float acceleration, KeyboardManager keyboardManager) {
        this(x, y, width, height, hp, damage, colliderOffsetX, colliderOffsetX, colliderOffsetY, colliderOffsetY, colliderMask,
                sprite, velocityX, velocityY, linearVelocity, acceleration, keyboardManager);
    }

    public PlayableEntity(float x, float y, float width, float height, float hp, float damage, BufferedImage sprite,
                          float velocityX, float velocityY, float linearVelocity, float acceleration, KeyboardManager keyboardManager) {
        super(x, y, width, height, hp, damage, sprite, velocityX, velocityY, linearVelocity, acceleration);
        this.keyboardManager = keyboardManager;
    }

    public PlayableEntity(float x, float y, float width, float height, float hp, float damage,
                          float velocityX, float velocityY, float linearVelocity, float acceleration, KeyboardManager keyboardManager) {
        super(x, y, width, height, hp, damage, null, velocityX, velocityY, linearVelocity, acceleration);
        this.keyboardManager = keyboardManager;
    }

    public KeyboardManager getKeyboardManager() {
        return keyboardManager;
    }

    public void setDirection(Direction direction) {
        setVelocity(direction.getDirection().getX(), direction.getDirection().getY());
    }

    public abstract void processInput();
}
